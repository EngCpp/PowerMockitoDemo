package com.engcpp.demos;

import java.io.Serializable;

/**
 *
 * @author engcpp
 */
public class CacheHolder implements Serializable {
    private String cache;

    public String getCache() {
        return isEnabled()? cache: "";
    }

    public void setCache(String cache) {
        this.cache = cache;
    }
    
    private boolean isEnabled(){
        return true;
    }
}