package com.map;

/**
 * Result part of API response
 * @author josephpr
 *
 */
public class Result {
    Geometry geometry;
    String icon;
    String[] types;
    String name;
    
    public Result(){
        
    }

    public Result(Geometry geometry, String icon, String[] types, String name) {
        super();
        this.geometry = geometry;
        this.icon = icon;
        this.types = types;
        this.name = name;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String[] getTypes() {
        return types;
    }

    public void setTypes(String[] types) {
        this.types = types;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
