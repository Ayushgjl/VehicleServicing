package com.ayushgjl.vehicleservicing;

public class LatitudeLongitude {
    public double lat;
    public double lon;
    private String marker;

    public LatitudeLongitude(double lat, double lon, String marker) {
        this.lat = lat;
        this.lon = lon;
        this.marker = marker;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getMarker() {
        return marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }
}
