/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aftarobot.datamigrator.olddata;

import java.io.Serializable;
import java.util.List;

/**
 * @author Aubrey Malabie
 */
public class RequestDTO implements Serializable {
    private Boolean zippedResponse;
    public static final int ADD_ADMIN = 1;
    public static final int ADD_ASSOCIATION = 2;
    public static final int ADD_ASSOCIATION_OWNER = 3;
    public static final int ADD_CHAIRPERSON = 4;
    public static final int ADD_CHAIRPERSON_NOTIFICATION = 5;
    public static final int ADD_MARSHAL_LOG = 6;
    public static final int ADD_MARSHAL = 7;
    public static final int ADD_MARSHAL_NOTIFICATION = 8;
    public static final int ADD_SECRETARY = 9;
    public static final int ADD_SECRETARY_NOTIFICATION = 10;
    public static final int ADMIN_LOGIN = 11;
    public static final int CHAIRPERSON_LOGIN = 12;
    public static final int GET_ADMINS_BY_ASSOCIATION = 13;
    public static final int GET_ASSOCIATION_BY_ID = 14;
    public static final int GET_ASSOCIATION_OWNERS_BY_ASSOCIATION = 15;
    public static final int GET_ASSOCIATIONS = 16;
    public static final int GET_CHAIRPERSONS_BY_ASSOCIATION = 17;
    public static final int GET_MARSHALS_BY_ASSOCIATION = 18;
    public static final int GET_MARSHALS_BY_ROUTE = 19;
    public static final int GET_SECRETARIES_BY_ASSOCIATION = 20;
    public static final int MARSHAL_LOGIN = 21;
    public static final int SECRETARY_LOGIN = 22;
    public static final int UPDATE_ADMIN = 23;
    public static final int UPDATE_ASSOCIATION = 24;
    public static final int UPDATE_ASSOCIATION_OWNER = 25;
    public static final int UPDATE_CHAIRPERSON = 26;
    public static final int UPDATE_MARSHAL_LOG = 27;
    public static final int UPDATE_MARSHAL = 28;
    public static final int UPDATE_SECRETARY = 29;
    public static final int ADD_COMMUTER = 30;
    public static final int ADD_FAVOURITE = 31;
    public static final int COMMUTER_LOGIN = 32;
    public static final int CLEAN_UP_COMMUTER_REQUESTS = 33;
    public static final int CLOSE_COMMUTER_REQUESTS = 34;
    public static final int COUNT_COMMUTER_REQUESTS_BY_RANK = 35;
    public static final int COUNT_PENDING_COMMUTER_REQUESTS_FOR_COMMUTER = 36;
    public static final int COUNT_PENDING_COMMUTER_REQUESTS_FOR_MARSHAL = 37;
    public static final int COUNT_PENDING_COMMUTER_REQUESTS_FOR_ROUTE_COMMUTERS = 38;
    public static final int CONNT_PENDING_COMMUTER_REQUESTS_FOR_ROUTE_MARSHALS = 39;
    public static final int GET_COMMUTER_REQUESTS_FOR_ROUTE = 40;
    public static final int UPDATE_COMMUTER_REQUESTS = 41;
    public static final int UPDATE_FAVOURITE = 42;
    public static final int SET_COMMUTER_REQUEST_TO_RECEIVED_OR_TIMMED_OUT = 43;
    public static final int ADD_COMMUTER_REQUEST = 44;
    public static final int ADD_DRIVER = 45;
    public static final int ADD_DRIVER_LOG = 46;
    public static final int ADD_OWNER = 47;
    public static final int ADD_VEHICLE = 48;
    public static final int DRIVER_LOGIN = 49;
    public static final int OWNER_LOGIN = 50;
    public static final int GET_DRIVER_LOGS = 51;
    public static final int GET_DRIVERS_BY_ASSOCIATIONS = 52;
    public static final int GET_OWNER_BY_VEHICLE = 53;
    public static final int UPDATE_DRIVER = 54;
    public static final int UPDATE_OWNER = 55;
    public static final int UPDATE_VEHICLE = 56;
    public static final int ADD_CITY = 57;
    public static final int ADD_COUNTRY = 58;
    public static final int ADD_LANDMARK = 59;
    public static final int ADD_PROVINCE = 60;
    public static final int ADD_ROUTE = 61;
    public static final int ADD_ROUTE_CITY = 62;
    public static final int ADD_TRIP = 63;
    public static final int GET_CITIES_BY_PROVINCE = 64;
    public static final int GET_COUTRIES = 65;
    public static final int GET_LANDMARKS_BY_ROUTE_CITY = 66;
    public static final int GET_PROVINCES_BY_COUNTRY = 67;
    public static final int GET_ROUTE_BY_ASSOCIATION = 68;
    public static final int GET_ROUTE_CITY_BY_CITY = 69;
    public static final int GET_TRIPS_BY_ASSOCIATION = 70;
    public static final int GET_TRIPS_BY_LANDMARK = 71;
    public static final int GET_TRIPS_BY_ROUTE = 72;
    public static final int GET_TRIPS_BY_MARSHAL = 73;
    public static final int GET_TRIPS_BY_VEHICLE = 74;
    public static final int UPDATE_CITY = 75;
    public static final int UPDATE_COUTNRY = 76;
    public static final int UPDATE_LANDMARK = 77;
    public static final int UPDATE_PROVINCE = 78;
    public static final int UPDATE_ROUTE = 79;
    public static final int UPDATE_ROUTE_CITY = 80;
    public static final int UPDATE_TRIP = 81;
    public static final int GET_ROUTE_CITY_BY_ROUTE = 82;
    public static final int COMMUTER_REQUESTS_NEAREST_CITIES = 83;
    public static final int GET_VEHICLE_BY_ASSOCIATION = 84;
    public static final int GET_LANDMARK_BY_ROUTE = 85;
    public static final int UPDATE_COMMUTER_GCM_ID = 86;
    public static final int UPDATE_DRIVER_GCM_ID = 87;
    public static final int UPDATE_MARSHAL_GCM_ID = 88;
    public static final int GET_TAXI_LOCATIONS = 89;
    public static final int COUNT_COMMUTER_REQUESTS_FOR_ROUTE = 90;
    public static final int ADD_ROUTE_POINT = 91;
    public static final int GET_ROUTE_POINTS_BY_ROUTE = 92;
    public static final int GET_ALL_ROUTES = 93;
    public static final int ADD_ROUTE_BY_AR_ADMIN = 94;
    public static final int RANK_MANAGER_LOGIN = 95;
    public static final int GET_TRIP_BY_LANDMARK_AND_STATUS = 96;
    public static final int GET_ALL_LANDMARKS = 97;
    public static final int GET_ALL_VEHICLES = 98;
    public static final int GET_MARSHALS_BY_LANDAMRK = 99;
    public static final int UPLOAD_PHOTO = 100;
    public static final int UPDATE_PHOTO = 101;
    public static final int GET_PHOTO_BY_URI = 102;
    public static final int GET_PHOTO_BY_DRIVER = 103;
    public static final int GET_PHOTO_BY_OWNER = 104;
    public static final int GET_PHOTO_BY_MARSHAL = 105;
    public static final int GET_PHOTO_BY_VEHICLE = 106;
    public static final int GET_PHOTO_BY_LANDMARK = 107;
    public static final int GET_PHOTO_BY_ADMIN = 109;
    public static final int GET_PHOTO_BY_COMMUTER = 110;
    public static final int GET_PHOTO_BY_RANK_MANAGER = 111;
    public static final int GET_VEHICLES_BY_OWNER = 112;

    public static final int SYNC_ROUTEBUILDER = 113;
    public static final int GET_VEHICLEINFO_BY_VEHICLE = 114;
    public static final String DRIVER = "driver";
    public static final String OWNER = "owner";
    public static final String CHAIRPERSON = "chairperson";
    public static final String SECRETARY = "secretary";
    public static final String MARSHAL = "marshal";
    public static final String COMMUTER = "commuter";
    public static final String ADMIN = "admin";
    //
    //
    private Integer marshalID, ownerID, vehicleID, commuterID, secretaryID, chairpersonID, tripID, driverID, adminID;
    private Integer associationID,
            routeID, landmarkID, commuterRequestID, provinceID, countryID, routeCityID, cityID, routePointID;
    private Integer requestType, radiusKM;
    private String status, sessionID, gcmID;
    private Double latitude, longitude;

    private AdminDTO admin;
    private AssociationDTO association;
    private AssociationOwnerDTO associationOwner;
    private ChairpersonDTO chairperson;
    private ChairpersonNotificationDTO chairpersonNotification;
    private CityDTO city;
    private CommuterDTO commuter;
    private CommuterRequestDTO commuterRequest;
    private CountryDTO country;
    private DriverDTO driver;
    private DriverLogDTO driverLog;
    private FavouriteDTO favourite;
    private LandmarkDTO landmark;
    private MarshalDTO marshal;
    private MarshalLogDTO marshalLog;
    private MarshalNotificationDTO marshalNotification;
    private OwnerDTO owner;
    private OwnerNotificationDTO ownerNotification;
    private ProvinceDTO province;
    private RouteCityDTO routeCity;
    private RouteDTO route;
    private SecretaryDTO secretary;
    private SecretaryNotificationDTO secretaryNotification;
    private TripDTO trip;
    private VehicleDTO vehicle;
    private VehicleDriverDTO vehicleDriver;
    private VehicleRouteDTO vehicleRoute;
    private RoutePointsDTO routePoint;
    private RankmanagerDTO rankManager;
    private PhotoUploadDTO photoUpload;
    private DriverProfileDTO driverProfile;
    private VehicleInfoDTO vehicleInfo;
    private VehiclePolicyDTO vehiclePolicy;

    private List<AdminDTO> admins;
    private List<AssociationDTO> associations;
    private List<AssociationOwnerDTO> associationOwners;
    private List<ChairpersonDTO> chairpersons;
    private List<ChairpersonNotificationDTO> chairpersonNotifications;
    private List<CityDTO> cities;
    private List<CommuterDTO> commuters;
    private List<CommuterRequestDTO> commuterRequests;
    private List<CountryDTO> countries;
    private List<DriverDTO> drivers;
    private List<DriverLogDTO> driverLogs;
    private List<FavouriteDTO> favourites;
    private List<LandmarkDTO> landmarks;
    private List<MarshalDTO> marshals;
    private List<MarshalLogDTO> marshalLogs;
    private List<MarshalNotificationDTO> marshalNotifications;
    private List<OwnerDTO> owners;
    private List<OwnerNotificationDTO> ownerNotifications;
    private List<ProvinceDTO> provinces;
    private List<RouteCityDTO> routeCities;
    private List<RouteDTO> routes;
    private List<SecretaryDTO> secretaries;
    private List<SecretaryNotificationDTO> secretaryNotifications;
    private List<TripDTO> trips;
    private List<VehicleDTO> vehicles;
    private List<VehicleDriverDTO> vehicleDrivers;
    private List<VehicleRouteDTO> vehicleRoutes;
    private List<RoutePointsDTO> routePoints;
    private List<RankmanagerDTO> rankManagers;
    private List<PhotoUploadDTO> photoUploads;
    private List<DriverProfileDTO> driverProfiles;
    private List<VehicleInfoDTO> vehicleInfos;
    private List<VehiclePolicyDTO> vehiclePolicies;
    private List<VehicleTripDTO> ownerVehicles;

    public int getRadiusKM() {
        return radiusKM;
    }

    public void setRadiusKM(int radiusKM) {
        this.radiusKM = radiusKM;
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public int getCityID() {
        return cityID;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    public int getRouteCityID() {
        return routeCityID;
    }

    public void setRouteCityID(int routeCityID) {
        this.routeCityID = routeCityID;
    }

    public boolean isZippedResponse() {
        return zippedResponse;
    }

    public void setZippedResponse(boolean zippedResponse) {
        this.zippedResponse = zippedResponse;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getMarshalID() {
        return marshalID;
    }

    public void setMarshalID(int marshalID) {
        this.marshalID = marshalID;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    public int getCommuterID() {
        return commuterID;
    }

    public void setCommuterID(int commuterID) {
        this.commuterID = commuterID;
    }

    public int getSecretaryID() {
        return secretaryID;
    }

    public void setSecretaryID(int secretaryID) {
        this.secretaryID = secretaryID;
    }

    public int getChairpersonID() {
        return chairpersonID;
    }

    public void setChairpersonID(int chairpersonID) {
        this.chairpersonID = chairpersonID;
    }

    public int getTripID() {
        return tripID;
    }

    public void setTripID(int tripID) {
        this.tripID = tripID;
    }

    public int getDriverID() {
        return driverID;
    }

    public void setDriverID(int driverID) {
        this.driverID = driverID;
    }

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public int getRequestType() {
        return requestType;
    }

    public void setRequestType(int requestType) {
        this.requestType = requestType;
    }

    public int getAssociationID() {
        return associationID;
    }

    public void setAssociationID(int associationID) {
        this.associationID = associationID;
    }

    public int getRouteID() {
        return routeID;
    }

    public void setRouteID(int routeID) {
        this.routeID = routeID;
    }

    public int getLandmarkID() {
        return landmarkID;
    }

    public void setLandmarkID(int landmarkID) {
        this.landmarkID = landmarkID;
    }

    public int getCommuterRequestID() {
        return commuterRequestID;
    }

    public void setCommuterRequestID(int commuterRequestID) {
        this.commuterRequestID = commuterRequestID;
    }

    public int getProvinceID() {
        return provinceID;
    }

    public void setProvinceID(int provinceID) {
        this.provinceID = provinceID;
    }

    public int getCountryID() {
        return countryID;
    }

    public void setCountryID(int countryID) {
        this.countryID = countryID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public AdminDTO getAdmin() {
        return admin;
    }

    public void setAdmin(AdminDTO admin) {
        this.admin = admin;
    }

    public AssociationDTO getAssociation() {
        return association;
    }

    public void setAssociation(AssociationDTO association) {
        this.association = association;
    }

    public AssociationOwnerDTO getAssociationOwner() {
        return associationOwner;
    }

    public void setAssociationOwner(AssociationOwnerDTO associationOwner) {
        this.associationOwner = associationOwner;
    }

    public ChairpersonDTO getChairperson() {
        return chairperson;
    }

    public void setChairperson(ChairpersonDTO chairperson) {
        this.chairperson = chairperson;
    }

    public ChairpersonNotificationDTO getChairpersonNotification() {
        return chairpersonNotification;
    }

    public void setChairpersonNotification(ChairpersonNotificationDTO chairpersonNotification) {
        this.chairpersonNotification = chairpersonNotification;
    }

    public CityDTO getCity() {
        return city;
    }

    public void setCity(CityDTO city) {
        this.city = city;
    }

    public CommuterDTO getCommuter() {
        return commuter;
    }

    public void setCommuter(CommuterDTO commuter) {
        this.commuter = commuter;
    }

    public CommuterRequestDTO getCommuterRequest() {
        return commuterRequest;
    }

    public void setCommuterRequest(CommuterRequestDTO commuterRequest) {
        this.commuterRequest = commuterRequest;
    }

    public CountryDTO getCountry() {
        return country;
    }

    public void setCountry(CountryDTO country) {
        this.country = country;
    }

    public DriverDTO getDriver() {
        return driver;
    }

    public void setDriver(DriverDTO driver) {
        this.driver = driver;
    }

    public DriverLogDTO getDriverLog() {
        return driverLog;
    }

    public void setDriverLog(DriverLogDTO driverLog) {
        this.driverLog = driverLog;
    }

    public FavouriteDTO getFavourite() {
        return favourite;
    }

    public void setFavourite(FavouriteDTO favourite) {
        this.favourite = favourite;
    }

    public LandmarkDTO getLandmark() {
        return landmark;
    }

    public void setLandmark(LandmarkDTO landmark) {
        this.landmark = landmark;
    }

    public MarshalDTO getMarshal() {
        return marshal;
    }

    public void setMarshal(MarshalDTO marshal) {
        this.marshal = marshal;
    }

    public MarshalLogDTO getMarshalLog() {
        return marshalLog;
    }

    public void setMarshalLog(MarshalLogDTO marshalLog) {
        this.marshalLog = marshalLog;
    }

    public MarshalNotificationDTO getMarshalNotification() {
        return marshalNotification;
    }

    public void setMarshalNotification(MarshalNotificationDTO marshalNotification) {
        this.marshalNotification = marshalNotification;
    }

    public OwnerDTO getOwner() {
        return owner;
    }

    public void setOwner(OwnerDTO owner) {
        this.owner = owner;
    }

    public OwnerNotificationDTO getOwnerNotification() {
        return ownerNotification;
    }

    public void setOwnerNotification(OwnerNotificationDTO ownerNotification) {
        this.ownerNotification = ownerNotification;
    }

    public ProvinceDTO getProvince() {
        return province;
    }

    public void setProvince(ProvinceDTO province) {
        this.province = province;
    }

    public RouteCityDTO getRouteCity() {
        return routeCity;
    }

    public void setRouteCity(RouteCityDTO routeCity) {
        this.routeCity = routeCity;
    }

    public RouteDTO getRoute() {
        return route;
    }

    public void setRoute(RouteDTO route) {
        this.route = route;
    }

    public SecretaryDTO getSecretary() {
        return secretary;
    }

    public void setSecretary(SecretaryDTO secretary) {
        this.secretary = secretary;
    }

    public SecretaryNotificationDTO getSecretaryNotification() {
        return secretaryNotification;
    }

    public void setSecretaryNotification(SecretaryNotificationDTO secretaryNotification) {
        this.secretaryNotification = secretaryNotification;
    }

    public TripDTO getTrip() {
        return trip;
    }

    public void setTrip(TripDTO trip) {
        this.trip = trip;
    }

    public VehicleDTO getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleDTO vehicle) {
        this.vehicle = vehicle;
    }

    public VehicleDriverDTO getVehicleDriver() {
        return vehicleDriver;
    }

    public void setVehicleDriver(VehicleDriverDTO vehicleDriver) {
        this.vehicleDriver = vehicleDriver;
    }

    public VehicleRouteDTO getVehicleRoute() {
        return vehicleRoute;
    }

    public void setVehicleRoute(VehicleRouteDTO vehicleRoute) {
        this.vehicleRoute = vehicleRoute;
    }

    public String getGcmID() {
        return gcmID;
    }

    public void setGcmID(String gcmID) {
        this.gcmID = gcmID;
    }

    public RoutePointsDTO getRoutePoint() {
        return routePoint;
    }

    public void setRoutePoint(RoutePointsDTO routePoint) {
        this.routePoint = routePoint;
    }

    public int getRoutePointID() {
        return routePointID;
    }

    public void setRoutePointID(int routePointID) {
        this.routePointID = routePointID;
    }

    public RankmanagerDTO getRankManager() {
        return rankManager;
    }

    public void setRankManager(RankmanagerDTO rankManager) {
        this.rankManager = rankManager;
    }

    public PhotoUploadDTO getPhotoUpload() {
        return photoUpload;
    }

    public void setPhotoUpload(PhotoUploadDTO photoUpload) {
        this.photoUpload = photoUpload;
    }

    public DriverProfileDTO getDriverProfile() {
        return driverProfile;
    }

    public void setDriverProfile(DriverProfileDTO driverProfile) {
        this.driverProfile = driverProfile;
    }

    public VehicleInfoDTO getVehicleInfo() {
        return vehicleInfo;
    }

    public void setVehicleInfo(VehicleInfoDTO vehicleInfo) {
        this.vehicleInfo = vehicleInfo;
    }

    public VehiclePolicyDTO getVehiclePolicy() {
        return vehiclePolicy;
    }

    public void setVehiclePolicy(VehiclePolicyDTO vehiclePolicy) {
        this.vehiclePolicy = vehiclePolicy;
    }

    public static int getAddAdmin() {
        return ADD_ADMIN;
    }

    public List<TripDTO> getTrips() {
        return trips;
    }

    public void setTrips(List<TripDTO> trips) {
        this.trips = trips;
    }

    public List<SecretaryNotificationDTO> getSecretaryNotifications() {
        return secretaryNotifications;
    }

    public void setSecretaryNotifications(List<SecretaryNotificationDTO> secretaryNotifications) {
        this.secretaryNotifications = secretaryNotifications;
    }

    public List<SecretaryDTO> getSecretaries() {
        return secretaries;
    }

    public void setSecretaries(List<SecretaryDTO> secretaries) {
        this.secretaries = secretaries;
    }

    public List<RouteDTO> getRoutes() {
        return routes;
    }

    public void setRoutes(List<RouteDTO> routes) {
        this.routes = routes;
    }

    public List<RoutePointsDTO> getRoutePoints() {
        return routePoints;
    }

    public void setRoutePoints(List<RoutePointsDTO> routePoints) {
        this.routePoints = routePoints;
    }

    public List<RouteCityDTO> getRouteCities() {
        return routeCities;
    }

    public void setRouteCities(List<RouteCityDTO> routeCities) {
        this.routeCities = routeCities;
    }

    public List<RankmanagerDTO> getRankManagers() {
        return rankManagers;
    }

    public void setRankManagers(List<RankmanagerDTO> rankManagers) {
        this.rankManagers = rankManagers;
    }

    public List<ProvinceDTO> getProvinces() {
        return provinces;
    }

    public void setProvinces(List<ProvinceDTO> provinces) {
        this.provinces = provinces;
    }

    public List<PhotoUploadDTO> getPhotoUploads() {
        return photoUploads;
    }

    public void setPhotoUploads(List<PhotoUploadDTO> photoUploads) {
        this.photoUploads = photoUploads;
    }

    public List<VehicleTripDTO> getOwnerVehicles() {
        return ownerVehicles;
    }

    public void setOwnerVehicles(List<VehicleTripDTO> ownerVehicles) {
        this.ownerVehicles = ownerVehicles;
    }

    public List<OwnerDTO> getOwners() {
        return owners;
    }

    public void setOwners(List<OwnerDTO> owners) {
        this.owners = owners;
    }

    public List<OwnerNotificationDTO> getOwnerNotifications() {
        return ownerNotifications;
    }

    public void setOwnerNotifications(List<OwnerNotificationDTO> ownerNotifications) {
        this.ownerNotifications = ownerNotifications;
    }

    public List<MarshalDTO> getMarshals() {
        return marshals;
    }

    public void setMarshals(List<MarshalDTO> marshals) {
        this.marshals = marshals;
    }

    public List<MarshalNotificationDTO> getMarshalNotifications() {
        return marshalNotifications;
    }

    public void setMarshalNotifications(List<MarshalNotificationDTO> marshalNotifications) {
        this.marshalNotifications = marshalNotifications;
    }

    public List<MarshalLogDTO> getMarshalLogs() {
        return marshalLogs;
    }

    public void setMarshalLogs(List<MarshalLogDTO> marshalLogs) {
        this.marshalLogs = marshalLogs;
    }

    public List<LandmarkDTO> getLandmarks() {
        return landmarks;
    }

    public void setLandmarks(List<LandmarkDTO> landmarks) {
        this.landmarks = landmarks;
    }

    public List<FavouriteDTO> getFavourites() {
        return favourites;
    }

    public void setFavourites(List<FavouriteDTO> favourites) {
        this.favourites = favourites;
    }

    public List<DriverDTO> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<DriverDTO> drivers) {
        this.drivers = drivers;
    }

    public List<DriverProfileDTO> getDriverProfiles() {
        return driverProfiles;
    }

    public void setDriverProfiles(List<DriverProfileDTO> driverProfiles) {
        this.driverProfiles = driverProfiles;
    }

    public List<DriverLogDTO> getDriverLogs() {
        return driverLogs;
    }

    public void setDriverLogs(List<DriverLogDTO> driverLogs) {
        this.driverLogs = driverLogs;
    }

    public List<CountryDTO> getCountries() {
        return countries;
    }

    public void setCountries(List<CountryDTO> countries) {
        this.countries = countries;
    }

    public List<CommuterDTO> getCommuters() {
        return commuters;
    }

    public void setCommuters(List<CommuterDTO> commuters) {
        this.commuters = commuters;
    }

    public List<CommuterRequestDTO> getCommuterRequests() {
        return commuterRequests;
    }

    public void setCommuterRequests(List<CommuterRequestDTO> commuterRequests) {
        this.commuterRequests = commuterRequests;
    }

    public List<CityDTO> getCities() {
        return cities;
    }

    public void setCities(List<CityDTO> cities) {
        this.cities = cities;
    }

    public List<ChairpersonDTO> getChairpersons() {
        return chairpersons;
    }

    public void setChairpersons(List<ChairpersonDTO> chairpersons) {
        this.chairpersons = chairpersons;
    }

    public List<ChairpersonNotificationDTO> getChairpersonNotifications() {
        return chairpersonNotifications;
    }

    public void setChairpersonNotifications(List<ChairpersonNotificationDTO> chairpersonNotifications) {
        this.chairpersonNotifications = chairpersonNotifications;
    }

    public List<AssociationDTO> getAssociations() {
        return associations;
    }

    public void setAssociations(List<AssociationDTO> associations) {
        this.associations = associations;
    }

    public List<AssociationOwnerDTO> getAssociationOwners() {
        return associationOwners;
    }

    public void setAssociationOwners(List<AssociationOwnerDTO> associationOwners) {
        this.associationOwners = associationOwners;
    }

    public List<AdminDTO> getAdmins() {
        return admins;
    }

    public void setAdmins(List<AdminDTO> admins) {
        this.admins = admins;
    }

    public List<VehicleDriverDTO> getVehicleDrivers() {
        return vehicleDrivers;
    }

    public void setVehicleDrivers(List<VehicleDriverDTO> vehicleDrivers) {
        this.vehicleDrivers = vehicleDrivers;
    }

    public List<VehicleInfoDTO> getVehicleInfos() {
        return vehicleInfos;
    }

    public void setVehicleInfos(List<VehicleInfoDTO> vehicleInfos) {
        this.vehicleInfos = vehicleInfos;
    }

    public List<VehiclePolicyDTO> getVehiclePolicies() {
        return vehiclePolicies;
    }

    public void setVehiclePolicies(List<VehiclePolicyDTO> vehiclePolicies) {
        this.vehiclePolicies = vehiclePolicies;
    }

    public List<VehicleRouteDTO> getVehicleRoutes() {
        return vehicleRoutes;
    }

    public void setVehicleRoutes(List<VehicleRouteDTO> vehicleRoutes) {
        this.vehicleRoutes = vehicleRoutes;
    }

    public List<VehicleDTO> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<VehicleDTO> vehicles) {
        this.vehicles = vehicles;
    }
}
