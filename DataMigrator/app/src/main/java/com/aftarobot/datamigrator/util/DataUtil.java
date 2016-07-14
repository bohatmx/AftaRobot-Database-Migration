package com.aftarobot.datamigrator.util;

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
import com.aftarobot.library.data.RouteCityDTO;
import com.aftarobot.library.data.RouteDTO;
import com.aftarobot.library.data.RoutePointsDTO;
import com.aftarobot.library.data.TripDTO;
import com.aftarobot.library.data.VehicleDTO;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by aubreymalabie on 6/3/16.
 */
public class DataUtil {

    public interface DataAddedListener {
        void onResponse(String key);

        void onError(String message);
    }

    static FirebaseDatabase db;
    public static final String AFTAROBOT_DB = "AftaRobotDB-04", COUNTRIES = "countries", ASSOC_ROUTES = "associationRoutes", DRIVERS = "drivers",
            VEHICLES = "vehicles", ADMINS = "admins", TRIPS = "trips",
            BEACONS = "beacons", ARRIVALS = "arrivals", DEPARTURES = "departures",
            PROVINCES = "provinces", CITIES = "cities", ROUTES = "routes", ROUTE_CITIES = "routeCities", MARSHALS = "marshals",
            LANDMARKS = "landmarks", ROUTE_POUNTS = "routePoints", ASSOCS = "associations", DRIVER_PROFILES = "driverProfiles";
    static final String TAG = DataUtil.class.getSimpleName();

    public static void addCity(final CityDTO c, DatabaseReference parent, final DataAddedListener listener) {
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

    public static void addRouteCity(final RouteCityDTO routeCity, DatabaseReference parent, final DataAddedListener listener) {
        if (db == null) {
            db = FirebaseDatabase.getInstance();
        }
        DatabaseReference routeCitiesRef = parent.child(ROUTE_CITIES);

        final RouteCityDTO x = new RouteCityDTO();
        x.setRouteName(routeCity.getRouteName());
        x.setCityName(routeCity.getCityName());
        x.setStatus(routeCity.getStatus());
        x.setCountryID(routeCity.getCountryID());
        x.setCityID(routeCity.getCityID());
        x.setProvinceID(routeCity.getProvinceID());

        routeCitiesRef.push().setValue(x, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference routeCityRef) {
                if (databaseError == null) {
                    routeCityRef.child("routeCityID").setValue(routeCityRef.getKey());
                    Log.i(TAG, "onComplete: routeCity added, route: " + x.getCityName() + " routeName: " + x.getRouteName());

                    if (!routeCity.getLandmarkList().isEmpty()) {
                        for (final LandmarkDTO m : routeCity.getLandmarkList()) {
                            m.setCityID(routeCity.getCityID());
                            m.setProvinceID(routeCity.getProvinceID());
                            m.setRouteCityID(routeCityRef.getKey());
                            m.setCountryID(routeCity.getCountryID());
                            m.setRouteID(routeCity.getRouteID());
                            m.setCityName(routeCity.getCityName());
                            m.setRouteName(routeCity.getRouteName());

                            addLandmark(m, routeCityRef, new DataAddedListener() {
                                @Override
                                public void onResponse(String key) {

                                }

                                @Override
                                public void onError(String message) {

                                }
                            });
                        }
                    }


                    listener.onResponse(routeCityRef.getKey());
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
        final LandmarkDTO x = new LandmarkDTO();
        x.setRouteName(landmark.getRouteName());
        x.setLandmarkName(landmark.getLandmarkName());
        x.setCityID(landmark.getCityID());
        x.setDate(landmark.getDate());
        x.setCityName(landmark.getCityName());
        x.setRouteName(landmark.getRouteName());
        x.setRouteCityName(landmark.getRouteCityName());
        x.setRouteID(landmark.getRouteID());
        x.setRouteCityID(landmark.getRouteCityID());
        x.setRankSequenceNumber(landmark.getRankSequenceNumber());
        x.setDistanceInbound(landmark.getDistanceInbound());
        x.setDistanceOutbound(landmark.getDistanceOutbound());
        x.setEstimatedTimeInbound(landmark.getEstimatedTimeInbound());
        x.setEstimatedTimeOutbound(landmark.getEstimatedTimeOutbound());
        x.setLatitude(landmark.getLatitude());
        x.setLongitude(landmark.getLongitude());

        landmarks.push().setValue(x, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseError == null) {
                    databaseReference.child("landmarkID").setValue(databaseReference.getKey());
                    Log.i(TAG, "onComplete: landmark added: " + landmark.getLandmarkName());
                    x.setLandmarkID(databaseReference.getKey());
                    GeoFireUtil.addLandmark(x, null);
                    listener.onResponse(databaseReference.getKey());
                } else {
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


                            addCity(c, databaseReference, new DataAddedListener() {
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
                            addMarsnall(a, databaseReference, new DataAddedListener() {
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

    public static void addAdmin(final AdminDTO admin, DatabaseReference parent, final DataAddedListener listener) {
        if (db == null) {
            db = FirebaseDatabase.getInstance();
        }
        DatabaseReference provsRef = parent.child(ADMINS);

        provsRef.push().setValue(admin, new DatabaseReference.CompletionListener() {
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

                    listener.onResponse(databaseReference.getKey());
                } else {
                    listener.onError(databaseError.getMessage());
                }
            }
        });

    }

    public static void addMarsnall(final MarshalDTO marsh, DatabaseReference parent, final DataAddedListener listener) {
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
                    listener.onResponse(databaseReference.getKey());
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

                    if (!route.getRouteCityList().isEmpty()) {
                        for (final RouteCityDTO m : route.getRouteCityList()) {
                            m.setRouteID(routeRef.getKey());
                            m.setCityID(route.getCityID());
                            addRouteCity(m, routeRef, new DataAddedListener() {
                                @Override
                                public void onResponse(String key) {

                                }

                                @Override
                                public void onError(String message) {

                                }
                            });
                        }
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
                    Log.d(TAG, "+++++ onComplete: done with this route: " + route.getName());
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
