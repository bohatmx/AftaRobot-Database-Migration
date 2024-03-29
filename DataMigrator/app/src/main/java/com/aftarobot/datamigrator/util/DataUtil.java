package com.aftarobot.datamigrator.util;

import android.support.annotation.NonNull;
import android.util.Log;

import com.aftarobot.library.data.AdminDTO;
import com.aftarobot.library.data.AssociationDTO;
import com.aftarobot.library.data.BeaconDTO;
import com.aftarobot.library.data.CityDTO;
import com.aftarobot.library.data.CountryDTO;
import com.aftarobot.library.data.DriverDTO;
import com.aftarobot.library.data.DriverProfileDTO;
import com.aftarobot.library.data.LandmarkDTO;
import com.aftarobot.library.data.MarshalDTO;
import com.aftarobot.library.data.ProvinceDTO;
import com.aftarobot.library.data.RouteDTO;
import com.aftarobot.library.data.RoutePointsDTO;
import com.aftarobot.library.data.TripDTO;
import com.aftarobot.library.data.UserDTO;
import com.aftarobot.library.data.VehicleDTO;
import com.aftarobot.library.signin.SignInContract;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.crash.FirebaseCrash;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by aubreymalabie on 6/3/16.
 */
public class DataUtil {

    public interface DataAddedListener {
        void onResponse(String key);

        void onError(String message);
    }

    static FirebaseDatabase db;
    public static final String AFTAROBOT_DB = "AftaRobotDB", COUNTRIES = "countries", ASSOC_ROUTES = "associationRoutes", DRIVERS = "drivers",
            VEHICLES = "vehicles", ADMINS = "admins", TRIPS = "trips", USERS = "users",
            BEACONS = "beacons", ARRIVALS = "arrivals", DEPARTURES = "departures",
            PROVINCES = "provinces", CITIES = "cities", ROUTES = "routes", MARSHALS = "marshals",
            LANDMARKS = "landmarks", ROUTE_POUNTS = "routePoints", ASSOCS = "associations", DRIVER_PROFILES = "driverProfiles";
    static final String TAG = DataUtil.class.getSimpleName();

    public static void deleteDatabase(final DataAddedListener listener) {
        if (db == null) {
            db = FirebaseDatabase.getInstance();
        }
        DatabaseReference dbRef = db.getReference(AFTAROBOT_DB);
        dbRef.removeValue(new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseError != null) {
                    listener.onError(databaseError.getMessage());
                    return;
                }
                listener.onResponse(databaseReference.getKey());

            }
        });
    }

    //    public static void removeUser(UserDTO user, final DataAddedListener listener) {
//        FirebaseAuth auth = FirebaseAuth.getInstance();
//        auth.addAuthStateListener(new FirebaseAuth.AuthStateListener() {
//            @Override
//            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
//                FirebaseUser fbUser = firebaseAuth.getCurrentUser();
//                if (fbUser != null) {
//                    fbUser.delete();
//                    System.out.println(fbUser.getEmail() + " removed from auth database");
//                    listener.onResponse("koolio");
//                } else {
//                    System.out.println("User not removed from db");
//                    listener.onError("ERROR: User cannot be removed");
//                }
//
//            }
//        });
//        auth.signInWithEmailAndPassword(user.getEmail(),user.getPassword());
//    }
    public static void addCity(final CityDTO c, final DataAddedListener listener) {
        if (db == null) {
            db = FirebaseDatabase.getInstance();
        }
        DatabaseReference citiesRef = db.getReference(AFTAROBOT_DB)
                .child(CITIES);

        final CityDTO x = new CityDTO();
        x.setProvinceID(c.getProvinceID());
        x.setName(c.getName());
        x.setCountryID(c.getCountryID());
        x.setLatitude(c.getLatitude());
        x.setLongitude(c.getLongitude());
        x.setStatus(c.getStatus());
        x.setDate(c.getDate());
        x.setCountryName(c.getCountryName());
        x.setProvinceName(c.getProvinceName());
        citiesRef.push().setValue(x, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseError == null) {
                    databaseReference.child("cityID").setValue(databaseReference.getKey());
                    Log.i(TAG, "***************** onComplete: route added: " + c.getName());

                    x.setCityID(databaseReference.getKey());
                    GeoFireUtil.addCity(x, null);
                    if (!c.getAssociationList().isEmpty()) {
                        for (final AssociationDTO m : c.getAssociationList()) {
                            m.setCityID(databaseReference.getKey());
                            m.setCountryID(c.getCountryID());
                            m.setProvinceID(c.getProvinceID());

                            addAssoc(m, new DataAddedListener() {
                                @Override
                                public void onResponse(String key) {

                                }

                                @Override
                                public void onError(String message) {

                                }
                            });
                        }
                    }

                    listener.onResponse(databaseReference.getKey());
                } else {
                    listener.onError(databaseError.getMessage());
                }

            }
        });
    }


    public static void addVehicle(final VehicleDTO vehicle, DatabaseReference parent, final DataAddedListener listener) {
        if (db == null) {
            db = FirebaseDatabase.getInstance();
        }
        DatabaseReference vehicles = parent.child(VEHICLES);
        vehicles.push().setValue(vehicle, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseError == null) {
                    databaseReference.child("vehicleID").setValue(databaseReference.getKey());
                    Log.i(TAG, "onComplete: vehicle added: " + vehicle.getMake() + " " + vehicle.getModel());
                    listener.onResponse(databaseReference.getKey());
                } else {
                    listener.onError(databaseError.getMessage());
                }
            }
        });

    }

    public static void addLandmark(final LandmarkDTO landmark, DatabaseReference parent, final DataAddedListener listener) {
        if (db == null) {
            db = FirebaseDatabase.getInstance();
        }
        DatabaseReference landmarks = parent.child(LANDMARKS);

        landmarks.push().setValue(landmark, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseError == null) {
                    databaseReference.child("landmarkID").setValue(databaseReference.getKey());
                    Log.i(TAG, "onComplete: landmark added: " + landmark.getLandmarkName());
                    landmark.setLandmarkID(databaseReference.getKey());
                    GeoFireUtil.addLandmark(landmark, null);
                    if (listener != null)
                        listener.onResponse(databaseReference.getKey());
                } else {
                    if (listener != null)
                        listener.onError(databaseError.getMessage());
                }
            }
        });

    }

    public static void addTrip(final TripDTO trip, final DataAddedListener listener) {
        if (db == null) {
            db = FirebaseDatabase.getInstance();
        }
        DatabaseReference tripsRef = db.getReference(AFTAROBOT_DB)
                .child(TRIPS)
                .child(trip.getLandmarkID())
                .child(TRIPS);

        Log.d(TAG, "addTrip: trip marshal: " + trip.getMarshalName());
        tripsRef.push().setValue(trip, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseError == null) {
                    databaseReference.child("tripID").setValue(databaseReference.getKey());
                    Log.e(TAG, "onComplete: trip added: " + trip.getLandmarkName() + " " + trip.getMarshalName() + " passengers: " + trip.getNumberOfPassengers()
                            + " - " + trip.getVehicleReg());
                    if (listener != null)
                        listener.onResponse(databaseReference.getKey());
                } else {
                    if (listener != null)
                        listener.onError(databaseError.getMessage());
                }
            }
        });

    }

    public static void addBeacon(final BeaconDTO beacon, final DataAddedListener listener) {
        if (db == null) {
            db = FirebaseDatabase.getInstance();
        }
        DatabaseReference beaconsRef = db.getReference(AFTAROBOT_DB)
                .child(BEACONS);

        Log.d(TAG, "addBeacon: beacon: " + beacon.getLandmarkName());
        beaconsRef.push().setValue(beacon, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseError == null) {
                    databaseReference.child("beaconID").setValue(databaseReference.getKey());
                    Log.e(TAG, "onComplete: beacon added: " + beacon.getLandmarkName());
                    if (listener != null)
                        listener.onResponse(databaseReference.getKey());
                } else {
                    if (listener != null)
                        listener.onError(databaseError.getMessage());
                }
            }
        });
    }

    public static void getBeacon(String UUID, String major, String minor) {
        if (db == null) {
            db = FirebaseDatabase.getInstance();
        }
        DatabaseReference beaconsRef = db.getReference(AFTAROBOT_DB)
                .child(BEACONS);
    }

    public static void addProvince(final ProvinceDTO prov, DatabaseReference parent, final DataAddedListener listener) {
        if (db == null) {
            db = FirebaseDatabase.getInstance();
        }
        DatabaseReference provsRef = parent.child(PROVINCES);

        ProvinceDTO x = new ProvinceDTO();
        x.setCountryID(prov.getCountryID());
        x.setName(prov.getName());
        //x.setCountryName(prov.getCountryName());
        x.setDate(prov.getDate());
        x.setLatitude(prov.getLatitude());
        x.setLongitude(prov.getLongitude());
        x.setStatus(prov.getStatus());

        provsRef.push().setValue(x, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseError == null) {
                    databaseReference.child("provinceID").setValue(databaseReference.getKey());
                    Log.i(TAG, "+++++++++++++++++ onComplete: province added: " + prov.getName());
                    if (!prov.getCityList().isEmpty()) {
                        for (CityDTO c : prov.getCityList()) {
                            c.setCountryID(prov.getCountryID());
                            c.setProvinceID(databaseReference.getKey());
                            c.setProvinceName(prov.getName());
                            c.setCountryName(prov.getCountryName());


                            addCity(c,  new DataAddedListener() {
                                @Override
                                public void onResponse(String key) {

                                }

                                @Override
                                public void onError(String message) {

                                }
                            });
                        }
                        Log.e(TAG, "++++++++++++++++++ onResponse: country data loaded into Firebase DB");
                    }

                    if (listener != null)
                        listener.onResponse(databaseReference.getKey());
                } else {
                    if (listener != null)
                        listener.onError(databaseError.getMessage());
                }

            }
        });
    }

    public static void addAssoc(final AssociationDTO ass, final DataAddedListener listener) {
        if (db == null) {
            db = FirebaseDatabase.getInstance();
        }
        DatabaseReference associationsRef = db.getReference(AFTAROBOT_DB)
                .child(COUNTRIES)
                .child(ass.getCountryID())
                .child(ASSOCS);

        AssociationDTO a = new AssociationDTO();
        a.setCountryID(ass.getCountryID());
        a.setCityID(ass.getCityID());
        a.setProvinceID(ass.getProvinceID());
        a.setDate(ass.getDate());
        a.setPhone(ass.getPhone());
        a.setDescription(ass.getDescription());

        associationsRef.push().setValue(a, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseError == null) {
                    databaseReference.child("associationID").setValue(databaseReference.getKey());
                    Log.i(TAG, "onComplete: assoc added: " + ass.getDescription());

                    if (!ass.getAdminList().isEmpty()) {
                        for (AdminDTO a : ass.getAdminList()) {
                            a.setAssociationID(databaseReference.getKey());
                            a.setCountryID(ass.getCountryID());

                            addAdmin(a, databaseReference, new DataAddedListener() {
                                @Override
                                public void onResponse(String key) {

                                }

                                @Override
                                public void onError(String message) {

                                }
                            });
                        }
                    }
                    if (!ass.getDriverList().isEmpty()) {
                        for (DriverDTO a : ass.getDriverList()) {
                            a.setAssociationID(databaseReference.getKey());
                            a.setCountryID(ass.getCountryID());

                            addDriver(a, databaseReference, new DataAddedListener() {
                                @Override
                                public void onResponse(String key) {

                                }

                                @Override
                                public void onError(String message) {

                                }
                            });
                        }
                    }
                    if (!ass.getMarshalList().isEmpty()) {
                        for (MarshalDTO a : ass.getMarshalList()) {
                            a.setAssociationID(databaseReference.getKey());
                            a.setCountryID(ass.getCountryID());

                            addMarshal(a, databaseReference, new DataAddedListener() {
                                @Override
                                public void onResponse(String key) {

                                }

                                @Override
                                public void onError(String message) {

                                }
                            });
                        }
                    }
                    if (!ass.getRouteList().isEmpty()) {
                        for (RouteDTO a : ass.getRouteList()) {
                            a.setAssociationID(databaseReference.getKey());
                            a.setCountryID(ass.getCountryID());
                            a.setProvinceID(ass.getProvinceID());
                            a.setCityID(ass.getCityID());
                            addRoute(a, new DataAddedListener() {
                                @Override
                                public void onResponse(String key) {

                                }

                                @Override
                                public void onError(String message) {

                                }
                            });
                        }
                    }
                    if (!ass.getVehicleList().isEmpty()) {
                        for (VehicleDTO v : ass.getVehicleList()) {
                            v.setAssociationID(databaseReference.getKey());
                            addVehicle(v, databaseReference, new DataAddedListener() {
                                @Override
                                public void onResponse(String key) {

                                }

                                @Override
                                public void onError(String message) {

                                }
                            });
                        }
                    }

                    Log.e(TAG, "#################### onComplete: done with association: " + ass.getDescription());
                    if (listener != null)
                        listener.onResponse(databaseReference.getKey());
                } else {
                    if (listener != null)
                        listener.onError(databaseError.getMessage());
                }

            }
        });
    }

    public static void addAdmin(final AdminDTO admin, final DatabaseReference parent, final DataAddedListener listener) {
        if (db == null) {
            db = FirebaseDatabase.getInstance();
        }
        DatabaseReference provsRef = parent.child(ADMINS);

        provsRef.push().setValue(admin, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseError == null) {
                    databaseReference.child("adminID").setValue(databaseReference.getKey());
                    Log.i(TAG, "++++++++++++++++++++++++++++++ onComplete: admin added: " + admin.getEmail());

                    UserDTO u = new UserDTO();
                    u.setUserType(SignInContract.ADMIN);
                    u.setEmail(admin.getEmail());
                    u.setName(admin.getFullName());
                    u.setCountryID(admin.getCountryID());
                    u.setAssociationID(admin.getAssociationID());

                    createUser(u, new DataAddedListener() {
                        @Override
                        public void onResponse(String key) {
                            listener.onResponse(key);
                        }

                        @Override
                        public void onError(String message) {
                            listener.onError(message);
                        }
                    });

                } else {
                    listener.onError(databaseError.getMessage());
                }
            }
        });

    }

    static Random random = new Random(System.currentTimeMillis());

    private static String getRandomPassword() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            sb.append(random.nextInt(9));
        }

        return sb.toString();
    }

    public static void createUser(final UserDTO user,
                                  final DataAddedListener listener) {
        try {
            user.setPassword(getRandomPassword());
            if (mAuth == null)
                mAuth = FirebaseAuth.getInstance();

            Log.d(TAG, "-------------------> createUser: email: " + user.getEmail() + " " + user.getPassword());

            Task<AuthResult> authResultTask = mAuth.createUserWithEmailAndPassword(user.getEmail(), user.getPassword());
            authResultTask.addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    FirebaseUser fbUser = authResult.getUser();
                    Log.i(TAG, "********************** onSuccess: user added to AftaRobot Platform: " + fbUser.getEmail() + " "
                            + fbUser.getUid());
                    user.setUid(fbUser.getUid());
                    //add user to MPS
                    addUser(user, new DataAddedListener() {
                        @Override
                        public void onResponse(String key) {
                            Log.i(TAG, "+++++++" +
                                    "++ onResponse: user added");
                            listener.onResponse(key);
                        }

                        @Override
                        public void onError(String message) {
                            listener.onError(message);
                        }
                    });


                }
            });
            authResultTask.addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    if (e instanceof FirebaseAuthUserCollisionException) {
                        return;
                    }
                    FirebaseCrash.report(e);
                    Log.e(TAG, "================ onFailure: ", e);
                    listener.onError("Unable to create user");
                }
            });
        } catch (Exception e) {
            Log.e(TAG, "createUser fucked!: ", e);
        }
    }


    static FirebaseAuth.AuthStateListener authStateListener;
    static FirebaseAuth mAuth;

    public interface UserProfileListener {
        void onProfileUpdated();

        void onError(String message);
    }

    //    public  static void updateUserProfile(final UserDTO user, final UserProfileListener listener) {
//        if (mAuth == null)
//            mAuth = FirebaseAuth.getInstance();
//        mAuth.signInWithEmailAndPassword(user.getEmail(), user.getPassword());
//        authStateListener = new FirebaseAuth.AuthStateListener() {
//            @Override
//            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
//                FirebaseUser fbUser = firebaseAuth.getCurrentUser();
//                //update user profile set display name + photo
//                UserProfileChangeRequest.Builder b;
//                if (user.getName() == null) {
//                    b = new UserProfileChangeRequest.Builder()
//                            .setDisplayName("No name available");
//                } else {
//                    b = new UserProfileChangeRequest.Builder()
//                            .setDisplayName(user.getName());
//                }
//                Task<Void> task = fbUser.updateProfile(b.build());
//                task.addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        FirebaseCrash.report(e);
//                        Log.e(TAG, "--------- onFailure: unable to update profile", e);
//                        if (listener != null)
//                            listener.onError(e.getMessage());
//                    }
//                });
//
//                task.addOnSuccessListener(new OnSuccessListener<Void>() {
//                    @Override
//                    public void onSuccess(Void aVoid) {
//                        Log.i(TAG, "++++++++++ onSuccess: user display name updated");
//
//                        mAuth.removeAuthStateListener(authStateListener);
//                        if (listener != null)
//                            listener.onProfileUpdated();
//
//                    }
//                });
//            }
//        };
//
//        mAuth.addAuthStateListener(authStateListener);
//
//    }
    private static FirebaseAnalytics analytics;

    private static void addUser(final UserDTO user, final DataAddedListener listener) {
        if (db == null)
            db = FirebaseDatabase.getInstance();

        final DatabaseReference users = db.getReference(AFTAROBOT_DB)
                .child(USERS);

        users.push().setValue(user, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseError == null) {
                    Log.i(TAG, "********** onComplete: user added to Aftarobot PS, " + user.getName() +
                            " key: " + databaseReference.getKey());
                    //set userID
                    DatabaseReference userID = users.child(databaseReference.getKey())
                            .child("userID");
                    userID.setValue(databaseReference.getKey());

                    listener.onResponse(databaseReference.getKey());
                } else {
                    listener.onError("Unable to add user");
                    FirebaseCrash.log("Unable to add authenticated user to APS platform: " + user.getEmail());
                }
            }
        });
    }

    public static void addDriver(final DriverDTO driver, DatabaseReference parent, final DataAddedListener listener) {
        if (db == null) {
            db = FirebaseDatabase.getInstance();
        }
        DatabaseReference provsRef = parent.child(DRIVERS);

        DriverDTO d = new DriverDTO();
        d.setDate(driver.getDate());
        d.setSurname(driver.getSurname());
        d.setName(driver.getName());
        d.setPhone(driver.getPhone());
        d.setStatus(driver.getStatus());
        d.setEmail(driver.getEmail());
        d.setPassword(driver.getPassword());
        d.setAssociationID(driver.getAssociationID());


        provsRef.push().setValue(d, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseError == null) {
                    databaseReference.child("driverID").setValue(databaseReference.getKey());
                    Log.i(TAG, "onComplete: driver added: " + driver.getName());
                    if (!driver.getDriverProfileList().isEmpty()) {
                        for (DriverProfileDTO dp : driver.getDriverProfileList()) {
                            databaseReference.child(DRIVER_PROFILES).push().setValue(dp, new DatabaseReference.CompletionListener() {
                                @Override
                                public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                                    if (databaseError == null) {
                                        databaseReference.child("driverProfileID").setValue(databaseReference.getKey());
                                        Log.e(TAG, "onComplete: driverProfile added: " + driver.getName() + " " + driver.getSurname());
                                    }

                                }
                            });
                        }
                    }
                    UserDTO u = new UserDTO();
                    u.setUserType(SignInContract.DRIVER);
                    u.setEmail(driver.getEmail());
                    StringBuilder sb = new StringBuilder();
                    sb.append(driver.getName());
                    if (driver.getSurname() != null) {
                        sb.append(" ").append(driver.getSurname());
                    }

                    u.setName(sb.toString());
                    u.setCountryID(driver.getCountryID());
                    u.setAssociationID(driver.getAssociationID());
                    createUser(u, new DataAddedListener() {
                        @Override
                        public void onResponse(String key) {
                            listener.onResponse(key);
                        }

                        @Override
                        public void onError(String message) {
                            listener.onError(message);
                        }
                    });

                    listener.onResponse(databaseReference.getKey());
                } else {
                    listener.onError(databaseError.getMessage());
                }
            }
        });

    }

    public static void addMarshal(final MarshalDTO marsh, DatabaseReference parent, final DataAddedListener listener) {
        if (db == null) {
            db = FirebaseDatabase.getInstance();
        }
        DatabaseReference provsRef = parent.child(MARSHALS);

        provsRef.push().setValue(marsh, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseError == null) {
                    databaseReference.child("marshalID").setValue(databaseReference.getKey());
                    Log.i(TAG, "onComplete: marshal added: " + marsh.getName());
                    UserDTO u = new UserDTO();
                    u.setUserType(SignInContract.MARSHAL);
                    u.setEmail(marsh.getEmail());
                    StringBuilder sb = new StringBuilder();
                    sb.append(marsh.getName());
                    if (marsh.getSurname() != null) {
                        sb.append(" ").append(marsh.getSurname());
                    }

                    u.setName(sb.toString());
                    u.setCountryID(marsh.getCountryID());
                    u.setAssociationID(marsh.getAssociationID());
                    createUser(u, new DataAddedListener() {
                        @Override
                        public void onResponse(String key) {
                            listener.onResponse(key);
                        }

                        @Override
                        public void onError(String message) {
                            listener.onError(message);
                        }
                    });
                } else {
                    listener.onError(databaseError.getMessage());
                }
            }
        });

    }

    public static void addRoute(final RouteDTO route, final DataAddedListener listener) {
        if (db == null) {
            db = FirebaseDatabase.getInstance();
        }

        final DatabaseReference assocRoutes = db.getReference(AFTAROBOT_DB)
                .child(COUNTRIES)
                .child(route.getCountryID())
                .child(ASSOCS)
                .child(route.getAssociationID())
                .child(ASSOC_ROUTES);

        final DatabaseReference cityRoutes = db.getReference(AFTAROBOT_DB)
                .child(CITIES)
                .child(route.getCityID())
                .child(ROUTES);


        final RouteDTO r = new RouteDTO();
        r.setCountryID(route.getCountryID());
        r.setProvinceID(route.getProvinceID());
        r.setCityID(route.getCityID());
        r.setAssociationID(route.getAssociationID());
        r.setName(route.getName());

        r.setStatus(route.getStatus());

        //collect route landmarks --
        final List<LandmarkDTO> landmarks = route.getLandmarkList();
        Collections.sort(landmarks);

        cityRoutes.push().setValue(r, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference routeRef) {
                if (databaseError == null) {
                    routeRef.child("routeID").setValue(routeRef.getKey());
                    Log.i(TAG, "------------- onComplete: route added: " + route.getName());
                    route.setRouteID(routeRef.getKey());
                    routeRef.child("routeID").setValue(routeRef.getKey());
                    assocRoutes.push().setValue(r, new DatabaseReference.CompletionListener() {
                        @Override
                        public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                            if (databaseError == null) {
                                databaseReference.child("routeID").setValue(route.getRouteID());
                            }
                        }
                    });

                    for (LandmarkDTO m : landmarks) {
                        m.setCityID(route.getCityID());
                        m.setRouteID(routeRef.getKey());
                        addLandmark(m, routeRef, null);
                    }
                    if (!route.getRoutePointList().isEmpty()) {
                        for (final RoutePointsDTO m : route.getRoutePointList()) {
                            m.setRoutePointID(routeRef.getKey());
                            routeRef.child(ROUTE_POUNTS).push().setValue(m, new DatabaseReference.CompletionListener() {
                                @Override
                                public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                                    databaseReference.child("routePointID").setValue(databaseReference.getKey());
                                }
                            });
                        }
                    }
                    Log.d(TAG, "++++ onComplete: done with this route: " + route.getName());
                    if (listener != null)
                        listener.onResponse(routeRef.getKey());
                } else {
                    if (listener != null)
                        listener.onError(databaseError.getMessage());
                }

            }
        });
    }


    public static void addCountry(final CountryDTO country, final DataAddedListener listener) {
        if (db == null) {
            db = FirebaseDatabase.getInstance();
        }
        DatabaseReference countriesRef = db.getReference(AFTAROBOT_DB)
                .child(COUNTRIES);

        CountryDTO addThis = new CountryDTO();
        addThis.setName(country.getName());
        addThis.setLatitude(country.getLatitude());
        addThis.setLongitude(country.getLongitude());
        addThis.setDate(country.getDate());
        countriesRef.push().setValue(addThis, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, final DatabaseReference databaseReference) {
                if (databaseError == null) {
                    databaseReference.child("countryID").setValue(databaseReference.getKey());
                    Log.i(TAG, "++++++++++++++++++ onComplete: country added: " + country.getName());

                    if (!country.getProvinceList().isEmpty()) {
                        for (final com.aftarobot.library.data.ProvinceDTO p : country.getProvinceList()) {
                            p.setCountryID(databaseReference.getKey());
                            p.setCountryName(country.getName());
                            addProvince(p, databaseReference, new DataAddedListener() {
                                @Override
                                public void onResponse(String key) {


                                }

                                @Override
                                public void onError(String message) {

                                }
                            });
                        }
                    }

                    listener.onResponse(databaseReference.getKey());
                } else {
                    listener.onError(databaseError.getMessage());
                }

            }
        });
    }
}
