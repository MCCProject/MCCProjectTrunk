package com.map;

/**
 * represents a geometry in the API result
 * @author josephpr
 *
 */
public class Geometry {
    Location location;

    public Geometry(Location location) {
        super();
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
    
    
}
