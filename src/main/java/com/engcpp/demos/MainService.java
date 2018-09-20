package com.engcpp.demos;

/**
 *
 * @author engcpp
 */
public class MainService {
    
    private CacheHolder cacheHolder;
    
    public String getData(){
        String data  = cacheHolder.getCache();
        
        if (isValid(data))
            return data;
        
        return getFixedData();
    }
    
    private String getFixedData(){
        return "ABCD";
    }
    
    private boolean isValid(String data){
        return false;
    }
}
