package com.brij.vehicle.vehicle_manager.exception;

public class ResourceNotFound extends RuntimeException {
    public ResourceNotFound(String resource, Object id) {
        super(resource + " not found with id: " + id);
    }
}
