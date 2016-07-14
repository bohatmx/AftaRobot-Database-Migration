package com.aftarobot.datamigrator.olddata;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.util.List;

/**
 * @author Sipho
 */
public class ResponseDTO implements Serializable {

    private int statusCode;
    private String message, sessionID;
    private String requestStatus;
    private long commuterCount = 0;
    public static final int OK = 0;
    public static final int SERVER_ERROR = 100;
    public static final int DATABASE_ERROR = 101;
    public static final int DATA_NOT_FOUND = 102;
    public static final int UNKNOWN_REQUEST = 103;

    private AdminDTO admin;
    private List<AdminDTO> admins;
    private AssociationDTO association;
    private List<AssociationDTO> associations;
    private AssociationOwnerDTO associationOwner;
    private List<AssociationOwnerDTO> associationOwners;
    private ChairpersonDTO chairperson;
    private List<ChairpersonDTO> chairpersons;
    private ChairpersonNotificationDTO chairpersonNotification;
    private List<ChairpersonNotificationDTO> chairpersonNotifications;
    private CityDTO city;
    private List<CityDTO> cities;
    private CommuterDTO commuter;
    private List<CommuterDTO> commuters;
    private CommuterRequestDTO commuterRequest;
    private List<CommuterRequestDTO> commuterRequests;
    private CountryDTO country;
    private List<CountryDTO> countries;
    private DriverDTO driver;
    private List<DriverDTO> drivers;
    private DriverLogDTO driverLog;
    private List<DriverLogDTO> driverLogs;
    private FavouriteDTO favourite;
    private List<FavouriteDTO> favourites;
    private LandmarkDTO landmark;
    private List<LandmarkDTO> landmarks;
    private MarshalDTO marshal;
    private List<MarshalDTO> marshals;
    private MarshalLogDTO marshalLog;
    private List<MarshalLogDTO> marshalLogs;
    private MarshalNotificationDTO marshalNotification;
    private List<MarshalNotificationDTO> marshalNotifications;
    private OwnerDTO owner;
    private List<OwnerDTO> owners;
    private OwnerNotificationDTO ownerNotification;
    private List<OwnerNotificationDTO> ownerNotifications;
    private ProvinceDTO province;
    private List<ProvinceDTO> provinces;
    private RouteCityDTO routeCity;
    private List<RouteCityDTO> routeCities;
    private RouteDTO route;
    private List<RouteDTO> routes;
    private SecretaryDTO secretary;
    private List<SecretaryDTO> secretaries;
    private SecretaryNotificationDTO secretaryNotification;
    private List<SecretaryNotificationDTO> secretaryNotifications;
    private TripDTO trip;
    private List<TripDTO> trips;
    private VehicleDTO vehicle;
    private List<VehicleDTO> vehicles;
    private VehicleDriverDTO vehicleDriver;
    private List<VehicleDriverDTO> vehicleDrivers;
    private VehicleRouteDTO vehicleRoute;
    private List<VehicleRouteDTO> vehicleRoutes;
    private RoutePointsDTO routePoint;
    private List<RoutePointsDTO> routePoints;
    private RankmanagerDTO rankManager;
    private List<RankmanagerDTO> rankManagers;
    private PhotoUploadDTO photoUpload;
    private DriverProfileDTO driverProfile;
    private VehicleInfoDTO vehicleInfo;
    private VehiclePolicyDTO vehiclePolicy;
    private List<PhotoUploadDTO> photoUploads;
    private List<DriverProfileDTO> driverProfiles;
    private List<VehicleInfoDTO> vehicleInfos;
    private List<VehiclePolicyDTO> vehiclePolicies;
    private List<VehicleTripDTO> ownerVehicles;
    private VehicleTripDTO vehicleTrip;
    private List<TripAdapterDTO> vehicleTrips;

    public List<VehicleTripDTO> getOwnerVehicles() {
        return ownerVehicles;
    }

    public void setOwnerVehicles(List<VehicleTripDTO> vehicleTrips) {
        this.ownerVehicles = vehicleTrips;
    }

    public long getCommuterCount() {
        return commuterCount;
    }

    public void setCommuterCount(long commuterCount) {
        this.commuterCount = commuterCount;
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    public AdminDTO getAdmin() {
        return admin;
    }

    public void setAdmin(AdminDTO admin) {
        this.admin = admin;
    }

    public List<AdminDTO> getAdmins() {
        return admins;
    }

    public void setAdmins(List<AdminDTO> admins) {
        this.admins = admins;
    }

    public AssociationDTO getAssociation() {
        return association;
    }

    public void setAssociation(AssociationDTO association) {
        this.association = association;
    }

    public List<AssociationDTO> getAssociations() {
        return associations;
    }

    public void setAssociations(List<AssociationDTO> associations) {
        this.associations = associations;
    }

    public AssociationOwnerDTO getAssociationOwner() {
        return associationOwner;
    }

    public void setAssociationOwner(AssociationOwnerDTO associationOwner) {
        this.associationOwner = associationOwner;
    }

    public List<AssociationOwnerDTO> getAssociationOwners() {
        return associationOwners;
    }

    public void setAssociationOwners(List<AssociationOwnerDTO> associationOwners) {
        this.associationOwners = associationOwners;
    }

    public ChairpersonDTO getChairperson() {
        return chairperson;
    }

    public void setChairperson(ChairpersonDTO chairperson) {
        this.chairperson = chairperson;
    }

    public List<ChairpersonDTO> getChairpersons() {
        return chairpersons;
    }

    public void setChairpersons(List<ChairpersonDTO> chairpersons) {
        this.chairpersons = chairpersons;
    }

    public ChairpersonNotificationDTO getChairpersonNotification() {
        return chairpersonNotification;
    }

    public void setChairpersonNotification(ChairpersonNotificationDTO chairpersonNotification) {
        this.chairpersonNotification = chairpersonNotification;
    }

    public List<ChairpersonNotificationDTO> getChairpersonNotifications() {
        return chairpersonNotifications;
    }

    public void setChairpersonNotifications(List<ChairpersonNotificationDTO> chairpersonNotifications) {
        this.chairpersonNotifications = chairpersonNotifications;
    }

    public CityDTO getCity() {
        return city;
    }

    public void setCity(CityDTO city) {
        this.city = city;
    }

    public List<CityDTO> getCities() {
        return cities;
    }

    public void setCities(List<CityDTO> cities) {
        this.cities = cities;
    }

    public CommuterDTO getCommuter() {
        return commuter;
    }

    public void setCommuter(CommuterDTO commuter) {
        this.commuter = commuter;
    }

    public List<CommuterDTO> getCommuters() {
        return commuters;
    }

    public void setCommuters(List<CommuterDTO> commuters) {
        this.commuters = commuters;
    }

    public CommuterRequestDTO getCommuterRequest() {
        return commuterRequest;
    }

    public void setCommuterRequest(CommuterRequestDTO commuterRequest) {
        this.commuterRequest = commuterRequest;
    }

    public List<CommuterRequestDTO> getCommuterRequests() {
        return commuterRequests;
    }

    public void setCommuterRequests(List<CommuterRequestDTO> commuterRequests) {
        this.commuterRequests = commuterRequests;
    }

    public CountryDTO getCountry() {
        return country;
    }

    public void setCountry(CountryDTO country) {
        this.country = country;
    }

    public List<CountryDTO> getCountries() {
        return countries;
    }

    public void setCountries(List<CountryDTO> countries) {
        this.countries = countries;
    }

    public DriverDTO getDriver() {
        return driver;
    }

    public void setDriver(DriverDTO driver) {
        this.driver = driver;
    }

    public List<DriverDTO> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<DriverDTO> drivers) {
        this.drivers = drivers;
    }

    public DriverLogDTO getDriverLog() {
        return driverLog;
    }

    public void setDriverLog(DriverLogDTO driverLog) {
        this.driverLog = driverLog;
    }

    public List<DriverLogDTO> getDriverLogs() {
        return driverLogs;
    }

    public void setDriverLogs(List<DriverLogDTO> driverLogs) {
        this.driverLogs = driverLogs;
    }

    public FavouriteDTO getFavourite() {
        return favourite;
    }

    public void setFavourite(FavouriteDTO favourite) {
        this.favourite = favourite;
    }

    public List<FavouriteDTO> getFavourites() {
        return favourites;
    }

    public void setFavourites(List<FavouriteDTO> favourites) {
        this.favourites = favourites;
    }

    public LandmarkDTO getLandmark() {
        return landmark;
    }

    public void setLandmark(LandmarkDTO landmark) {
        this.landmark = landmark;
    }

    public List<LandmarkDTO> getLandmarks() {
        return landmarks;
    }

    public void setLandmarks(List<LandmarkDTO> landmarks) {
        this.landmarks = landmarks;
    }

    public MarshalDTO getMarshal() {
        return marshal;
    }

    public void setMarshal(MarshalDTO marshal) {
        this.marshal = marshal;
    }

    public List<MarshalDTO> getMarshals() {
        return marshals;
    }

    public void setMarshals(List<MarshalDTO> marshals) {
        this.marshals = marshals;
    }

    public MarshalLogDTO getMarshalLog() {
        return marshalLog;
    }

    public void setMarshalLog(MarshalLogDTO marshalLog) {
        this.marshalLog = marshalLog;
    }

    public List<MarshalLogDTO> getMarshalLogs() {
        return marshalLogs;
    }

    public void setMarshalLogs(List<MarshalLogDTO> marshalLogs) {
        this.marshalLogs = marshalLogs;
    }

    public MarshalNotificationDTO getMarshalNotification() {
        return marshalNotification;
    }

    public void setMarshalNotification(MarshalNotificationDTO marshalNotification) {
        this.marshalNotification = marshalNotification;
    }

    public List<MarshalNotificationDTO> getMarshalNotifications() {
        return marshalNotifications;
    }

    public void setMarshalNotifications(List<MarshalNotificationDTO> marshalNotifications) {
        this.marshalNotifications = marshalNotifications;
    }

    public OwnerDTO getOwner() {
        return owner;
    }

    public void setOwner(OwnerDTO owner) {
        this.owner = owner;
    }

    public List<OwnerDTO> getOwners() {
        return owners;
    }

    public void setOwners(List<OwnerDTO> owners) {
        this.owners = owners;
    }

    public OwnerNotificationDTO getOwnerNotification() {
        return ownerNotification;
    }

    public void setOwnerNotification(OwnerNotificationDTO ownerNotification) {
        this.ownerNotification = ownerNotification;
    }

    public List<OwnerNotificationDTO> getOwnerNotifications() {
        return ownerNotifications;
    }

    public void setOwnerNotifications(List<OwnerNotificationDTO> ownerNotifications) {
        this.ownerNotifications = ownerNotifications;
    }

    public ProvinceDTO getProvince() {
        return province;
    }

    public void setProvince(ProvinceDTO province) {
        this.province = province;
    }

    public List<ProvinceDTO> getProvinces() {
        return provinces;
    }

    public void setProvinces(List<ProvinceDTO> provinces) {
        this.provinces = provinces;
    }

    public RouteCityDTO getRouteCity() {
        return routeCity;
    }

    public void setRouteCity(RouteCityDTO routeCity) {
        this.routeCity = routeCity;
    }

    public List<RouteCityDTO> getRouteCities() {
        return routeCities;
    }

    public void setRouteCities(List<RouteCityDTO> routeCities) {
        this.routeCities = routeCities;
    }

    public RouteDTO getRoute() {
        return route;
    }

    public void setRoute(RouteDTO route) {
        this.route = route;
    }

    public List<RouteDTO> getRoutes() {
        return routes;
    }

    public void setRoutes(List<RouteDTO> routes) {
        this.routes = routes;
    }

    public SecretaryDTO getSecretary() {
        return secretary;
    }

    public void setSecretary(SecretaryDTO secretary) {
        this.secretary = secretary;
    }

    public List<SecretaryDTO> getSecretaries() {
        return secretaries;
    }

    public void setSecretaries(List<SecretaryDTO> secretaries) {
        this.secretaries = secretaries;
    }

    public SecretaryNotificationDTO getSecretaryNotification() {
        return secretaryNotification;
    }

    public void setSecretaryNotification(SecretaryNotificationDTO secretaryNotification) {
        this.secretaryNotification = secretaryNotification;
    }

    public List<SecretaryNotificationDTO> getSecretaryNotifications() {
        return secretaryNotifications;
    }

    public void setSecretaryNotifications(List<SecretaryNotificationDTO> secretaryNotifications) {
        this.secretaryNotifications = secretaryNotifications;
    }

    public TripDTO getTrip() {
        return trip;
    }

    public void setTrip(TripDTO trip) {
        this.trip = trip;
    }

    public List<TripDTO> getTrips() {
        return trips;
    }

    public void setTrips(List<TripDTO> trips) {
        this.trips = trips;
    }

    public VehicleDTO getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleDTO vehicle) {
        this.vehicle = vehicle;
    }

    public List<VehicleDTO> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<VehicleDTO> vehicles) {
        this.vehicles = vehicles;
    }

    public VehicleDriverDTO getVehicleDriver() {
        return vehicleDriver;
    }

    public void setVehicleDriver(VehicleDriverDTO vehicleDriver) {
        this.vehicleDriver = vehicleDriver;
    }

    public List<VehicleDriverDTO> getVehicleDrivers() {
        return vehicleDrivers;
    }

    public void setVehicleDrivers(List<VehicleDriverDTO> vehicleDrivers) {
        this.vehicleDrivers = vehicleDrivers;
    }

    public VehicleRouteDTO getVehicleRoute() {
        return vehicleRoute;
    }

    public void setVehicleRoute(VehicleRouteDTO vehicleRoute) {
        this.vehicleRoute = vehicleRoute;
    }

    public List<VehicleRouteDTO> getVehicleRoutes() {
        return vehicleRoutes;
    }

    public void setVehicleRoutes(List<VehicleRouteDTO> vehicleRoutes) {
        this.vehicleRoutes = vehicleRoutes;
    }

    public RoutePointsDTO getRoutePoint() {
        return routePoint;
    }

    public void setRoutePoint(RoutePointsDTO routePoint) {
        this.routePoint = routePoint;
    }

    public List<RoutePointsDTO> getRoutePoints() {
        return routePoints;
    }

    public void setRoutePoints(List<RoutePointsDTO> routePoints) {
        this.routePoints = routePoints;
    }

    public RankmanagerDTO getRankManager() {
        return rankManager;
    }

    public void setRankManager(RankmanagerDTO rankManager) {
        this.rankManager = rankManager;
    }

    public List<RankmanagerDTO> getRankManagers() {
        return rankManagers;
    }

    public void setRankManagers(List<RankmanagerDTO> rankManagers) {
        this.rankManagers = rankManagers;
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

    public List<PhotoUploadDTO> getPhotoUploads() {
        return photoUploads;
    }

    public void setPhotoUploads(List<PhotoUploadDTO> photoUploads) {
        this.photoUploads = photoUploads;
    }

    public List<DriverProfileDTO> getDriverProfiles() {
        return driverProfiles;
    }

    public void setDriverProfiles(List<DriverProfileDTO> driverProfiles) {
        this.driverProfiles = driverProfiles;
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

    public List<TripAdapterDTO> getVehicleTrips() {
        return vehicleTrips;
    }

    public void setVehicleTrips(List<TripAdapterDTO> vehicleTrips) {
        this.vehicleTrips = vehicleTrips;
    }

    public VehicleTripDTO getVehicleTrip() {
        return vehicleTrip;
    }

    public void setVehicleTrip(VehicleTripDTO vehicleTrip) {
        this.vehicleTrip = vehicleTrip;
    }
}
