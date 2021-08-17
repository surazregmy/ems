package com.edigitalnepal.ems.exception;

public class DesignationNotFoundException extends RuntimeException {
    public DesignationNotFoundException(Long id) {
        super("Could not find Designation " + id);
    }
}
