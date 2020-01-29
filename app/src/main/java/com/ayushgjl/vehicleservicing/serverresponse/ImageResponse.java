package com.ayushgjl.vehicleservicing.serverresponse;

public class ImageResponse {
    private String filename;

    public ImageResponse(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
