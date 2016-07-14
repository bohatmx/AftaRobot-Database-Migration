package com.aftarobot.library.util;

import android.support.annotation.NonNull;
import android.util.Log;

import com.aftarobot.library.data.AdminDTO;
import com.aftarobot.library.data.AssociationDTO;
import com.aftarobot.library.data.AttachmentDTO;
import com.aftarobot.library.data.Bag;
import com.aftarobot.library.data.BeaconDTO;
import com.aftarobot.library.data.CityDTO;
import com.aftarobot.library.data.CountryDTO;
import com.aftarobot.library.data.DriverDTO;
import com.aftarobot.library.data.DriverProfileDTO;
import com.aftarobot.library.data.LandmarkArrivalDTO;
import com.aftarobot.library.data.LandmarkDTO;
import com.aftarobot.library.data.LandmarkDepartureDTO;
import com.aftarobot.library.data.MarshalDTO;
import com.aftarobot.library.data.ProvinceDTO;
import com.aftarobot.library.data.RouteCityDTO;
import com.aftarobot.library.data.RouteDTO;
import com.aftarobot.library.data.TripDTO;
import com.aftarobot.library.data.UserDTO;
import com.aftarobot.library.data.VehicleDTO;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Date;

/**
 * Class to handle firebase data
 * Created by aubreymalabie on 6/3/16.
 */
public class DataAPI {
    public static final String AFTAROBOT_DB = "aftaRobot-2016", COUNTRIES = "countries", ASSOC_ROUTES = "associationRoutes", DRIVERS = "drivers",
            VEHICLES = "vehicles", ADMINS = "admins", TRIPS = "trips", USERS = "users",
            BEACONS = "beacons", ARRIVALS = "arrivals", DEPARTURES = "departures",
            PROVINCES = "provinces", CITIES = "cities", ROUTES = "routes", ROUTE_CITIES = "routeCities", MARSHALS = "marshals",
            LANDMARKS = "landmarks", ROUTE_POUNTS = "routePoints", ASSOCS = "associations", DRIVER_PROFILES = "driverProfiles";
    static final String TAG = DataAPI.class.getSimpleName();

    public interface OnDataAdded {
        void onResponse(String key);
        void onError(String message);
    }
    public interface OnSignedIn {
        void onResponse(UserDTO user);
        void onError();
    }
    public interface OnDataRead {
        void onResponse(Bag bag);
        void onError();
    }

    FirebaseDatabase db;
    FirebaseAuth.AuthStateListener authStateListener;

    public void signIn(final String email, final String password, final OnSignedIn onSignedIn) {
        Log.d(TAG, "signIn: email: " + email);

        final FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.i(TAG, "####### signIn: onComplete: " + task.isSuccessful());
                        if (task.isSuccessful()) {
                            FirebaseUser fbUser = task.getResult().getUser();
                            Log.i(TAG, "####### onComplete: we cool, name: "
                                    + fbUser.getDisplayName() + " email: " + fbUser.getEmail()
                                    + " uid: " + fbUser.getUid() + " \ntoken: " + fbUser.getToken(true));
                            getUser(fbUser.getUid(), new OnDataRead() {
                                @Override
                                public void onResponse(Bag bag) {
                                    onSignedIn.onResponse(bag.getUsers().get(0));
                                }

                                @Override
                                public void onError() {
                                    onSignedIn.onError();
                                }
                            });

                        } else {
                            Log.e(TAG, "------------ sign in FAILED");
                            onSignedIn.onError();
                        }
                    }
                });
    }

    public void getUser(String key, final OnDataRead listener) {
        if (db == null) {
            db = FirebaseDatabase.getInstance();
        }
        DatabaseReference usersRef = db.getReference(AFTAROBOT_DB)
                .child(USERS);
        Query q = usersRef.orderByChild("uid").equalTo(key);
        q.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Bag b = new Bag();
                b.setUsers(new ArrayList<UserDTO>());
                for (DataSnapshot shot: dataSnapshot.getChildren()) {
                    UserDTO u = shot.getValue(UserDTO.class);
                    b.getUsers().add(u);
                    listener.onResponse(b);
                    return;
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                listener.onError();
            }
        });

    }
    public  void addUser(final UserDTO c, final OnDataAdded listener) {
        if (db == null) {
            db = FirebaseDatabase.getInstance();
        }
        DatabaseReference userRef = db.getReference(AFTAROBOT_DB)
                .child(USERS);


        userRef.push().setValue(c, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseError == null) {
                    databaseReference.child("userID").setValue(databaseReference.getKey());
                    Log.i(TAG, "***************** onComplete: user added: " + c.getName());
                    c.setUserID(databaseReference.getKey());
                    listener.onResponse(databaseReference.getKey());
                } else {
                    listener.onError(databaseError.getMessage());
                }

            }
        });
    }
    public  void addCity(final CityDTO c, final OnDataAdded listener) {
        if (db == null) {
            db = FirebaseDatabase.getInstance();
        }
        DatabaseReference citiesRef = db.getReference(AFTAROBOT_DB)
                .child(CITIES);


        citiesRef.push().setValue(c, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseError == null) {
                    databaseReference.child("cityID").setValue(databaseReference.getKey());
                    Log.i(TAG, "***************** onComplete: city added: " + c.getName());
                    c.setCityID(databaseReference.getKey());
                    GeoFireAPI.addCity(c, null);
                    listener.onResponse(databaseReference.getKey());
                } else {
                    listener.onError(databaseError.getMessage());
                }

            }
        });
    }
    public  void addRoute(final RouteDTO route, final OnDataAdded listener) {
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

                    if (listener != null)
                        listener.onResponse(routeRef.getKey());
                } else {
                    if (listener != null)
                        listener.onError(databaseError.getMessage());
                }

            }
        });
    }

    public  void addRouteCity(final RouteCityDTO routeCity, final OnDataAdded listener) {
        if (db == null) {
            db = FirebaseDatabase.getInstance();
        }
        DatabaseReference citiesRef = db.getReference(AFTAROBOT_DB)
                .child(CITIES)
                .child(routeCity.getCityID())
                .child(ROUTES)
                .child(routeCity.getRouteID())
                .child(ROUTE_CITIES);


        citiesRef.push().setValue(routeCity, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference routeCityRef) {
                if (databaseError == null) {
                    routeCityRef.child("routeCityID").setValue(routeCityRef.getKey());
                    Log.i(TAG, "onComplete: routeCity added, city: " + routeCity.getCityName() + " routeName: " + routeCity.getRouteName());

                    listener.onResponse(routeCityRef.getKey());
                } else {
                    listener.onError(databaseError.getMessage());
                }

            }
        });
    }

    public  void addVehicle(final VehicleDTO vehicle, final OnDataAdded listener) {
        if (db == null) {
            db = FirebaseDatabase.getInstance();
        }
        final DatabaseReference vehicleRef = db.getReference(AFTAROBOT_DB)
                .child(COUNTRIES)
                .child(vehicle.getCountryID())
                .child(ASSOCS)
                .child(vehicle.getAssociationID())
                .child(VEHICLES);
        vehicleRef.push().setValue(vehicle, new DatabaseReference.CompletionListener() {
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

    public  void addLandmark(final LandmarkDTO landmark, final OnDataAdded listener) {
        if (db == null) {
            db = FirebaseDatabase.getInstance();
        }
        DatabaseReference landmarkRef = db.getReference(AFTAROBOT_DB)
                .child(CITIES)
                .child(landmark.getCityID())
                .child(ROUTES)
                .child(landmark.getRouteID())
                .child(ROUTE_CITIES)
                .child(landmark.getRouteCityID())
                .child(LANDMARKS);


        landmarkRef.push().setValue(landmark, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseError == null) {
                    databaseReference.child("landmarkID").setValue(databaseReference.getKey());
                    Log.i(TAG, "onComplete: landmark added: " + landmark.getLandmarkName());
                    landmark.setLandmarkID(databaseReference.getKey());
                    GeoFireAPI.addLandmark(landmark, null);
                    listener.onResponse(databaseReference.getKey());
                } else {
                    listener.onError(databaseError.getMessage());
                }
            }
        });

    }

    public  void addTrip(final TripDTO trip, final OnDataAdded listener) {
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

    public  void addBeacon(final BeaconDTO beacon, final OnDataAdded listener) {
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

    public  void getBeacon(String UUID, String major, String minor) {
        if (db == null) {
            db = FirebaseDatabase.getInstance();
        }
        DatabaseReference beaconsRef = db.getReference(AFTAROBOT_DB)
                .child(BEACONS);
    }

    public  void addProvince(final ProvinceDTO prov, final OnDataAdded listener) {
        if (db == null) {
            db = FirebaseDatabase.getInstance();
        }

        DatabaseReference provsRef = db.getReference(AFTAROBOT_DB)
                .child(COUNTRIES)
                .child(prov.getCountryID())
                .child(PROVINCES);


        provsRef.push().setValue(prov, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseError == null) {
                    databaseReference.child("provinceID").setValue(databaseReference.getKey());
                    Log.i(TAG, "+++++++++++++++++ onComplete: province added: " + prov.getName());

                    if (listener != null)
                        listener.onResponse(databaseReference.getKey());
                } else {
                    if (listener != null)
                        listener.onError(databaseError.getMessage());
                }

            }
        });
    }

    public  void addAssoc(final AssociationDTO ass, final OnDataAdded listener) {
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

                    if (listener != null)
                        listener.onResponse(databaseReference.getKey());
                } else {
                    if (listener != null)
                        listener.onError(databaseError.getMessage());
                }

            }
        });
    }

    public  void addAdmin(final AdminDTO admin, final OnDataAdded listener) {
        if (db == null) {
            db = FirebaseDatabase.getInstance();
        }
        DatabaseReference adminRef = db.getReference(AFTAROBOT_DB)
                .child(COUNTRIES)
                .child(admin.getCountryID())
                .child(ASSOCS)
                .child(admin.getAssociationID())
                .child(ADMINS);

        adminRef.push().setValue(admin, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseError == null) {
                    databaseReference.child("adminID").setValue(databaseReference.getKey());
                    Log.i(TAG, "onComplete: admin added: " + admin.getEmail());
                    listener.onResponse(databaseReference.getKey());
                } else {
                    listener.onError(databaseError.getMessage());
                }
            }
        });

    }

    public  void addDriver(final DriverDTO driver, final OnDataAdded listener) {
        if (db == null) {
            db = FirebaseDatabase.getInstance();
        }
        DatabaseReference adminRef = db.getReference(AFTAROBOT_DB)
                .child(COUNTRIES)
                .child(driver.getCountryID())
                .child(ASSOCS)
                .child(driver.getAssociationID())
                .child(DRIVERS);


        adminRef.push().setValue(driver, new DatabaseReference.CompletionListener() {
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

                    listener.onResponse(databaseReference.getKey());
                } else {
                    listener.onError(databaseError.getMessage());
                }
            }
        });

    }

    public  void addMarshall(final MarshalDTO marshal, DatabaseReference parent, final OnDataAdded listener) {
        if (db == null) {
            db = FirebaseDatabase.getInstance();
        }
        DatabaseReference marshalRef = db.getReference(AFTAROBOT_DB)
                .child(COUNTRIES)
                .child(marshal.getCountryID())
                .child(ASSOCS)
                .child(marshal.getAssociationID())
                .child(MARSHALS);

        marshalRef.push().setValue(marshal, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseError == null) {
                    databaseReference.child("marshalID").setValue(databaseReference.getKey());
                    Log.i(TAG, "onComplete: marshal added: " + marshal.getName());
                    listener.onResponse(databaseReference.getKey());
                } else {
                    listener.onError(databaseError.getMessage());
                }
            }
        });

    }


    public  void addArrivalRecord(final AttachmentDTO attachment, final OnDataAdded listener) {
        if (db == null) {
            db = FirebaseDatabase.getInstance();
        }
        LandmarkArrivalDTO arr = new LandmarkArrivalDTO();
        arr.setDateArrived(new Date().getTime());
        arr.setLandmarkName(attachment.getLandmarkName());
        arr.setLandmarkID(attachment.getLandmarkID());


        DatabaseReference arrivalsRef = db.getReference(AFTAROBOT_DB)
                .child(ARRIVALS);
        arrivalsRef.push().setValue(arr, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseError == null) {
                    Log.i(TAG, "onComplete: arrival record added to Firebase");
                    databaseReference.child("arrivalID").setValue(databaseReference.getKey());
                    if (listener != null)
                        listener.onResponse(databaseReference.getKey());
                } else {
                    Log.e(TAG, "onComplete: Firebase call failed: " + databaseError.getMessage() +
                            " - " + databaseError.getDetails());
                    if (listener != null)
                        listener.onError(databaseError.getMessage());
                }
            }
        });
    }

    public  void addDepartureRecord(final AttachmentDTO attachment, final OnDataAdded listener) {
        if (db == null) {
            db = FirebaseDatabase.getInstance();
        }
        LandmarkDepartureDTO departure = new LandmarkDepartureDTO();
        departure.setDateDeparted(new Date().getTime());
        departure.setLandmarkName(attachment.getLandmarkName());
        departure.setLandmarkID(attachment.getLandmarkID());

        DatabaseReference arrivalsRef = db.getReference(AFTAROBOT_DB)
                .child(DEPARTURES);
        arrivalsRef.push().setValue(departure, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseError == null) {
                    Log.i(TAG, "onComplete: departure record added to Firebase");
                    databaseReference.child("departureID").setValue(databaseReference.getKey());
                    if (listener != null)
                        listener.onResponse(databaseReference.getKey());
                } else {
                    Log.e(TAG, "onComplete: Firebase call failed: " + databaseError.getMessage() +
                            " - " + databaseError.getDetails());
                    if (listener != null)
                        listener.onError(databaseError.getMessage());
                }
            }
        });
    }

    public  void addCountry(final CountryDTO country, final OnDataAdded listener) {
        if (db == null) {
            db = FirebaseDatabase.getInstance();
        }
        DatabaseReference countriesRef = db.getReference(AFTAROBOT_DB)
                .child(COUNTRIES);

        countriesRef.push().setValue(country, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, final DatabaseReference databaseReference) {
                if (databaseError == null) {
                    databaseReference.child("countryID").setValue(databaseReference.getKey());
                    Log.i(TAG, "++++++++++++++++++ onComplete: country added: " + country.getName());

                    if (!country.getProvinceList().isEmpty()) {
                        for (final ProvinceDTO p : country.getProvinceList()) {
                            p.setCountryID(databaseReference.getKey());
                            p.setCountryName(country.getName());
                            addProvince(p, new OnDataAdded() {
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
