package com.starter.project.service.CatalogService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/***
 * Factory design pattern to create service
 * @Author Pichayut.pee
 */
@Service
public class CatalogServiceFactory {

    @Autowired
    List <CatalogService> services = null;

    static final Map<String, CatalogService> serviceCache = new HashMap<>();

    @Autowired
    public CatalogServiceFactory(List<CatalogService> services) {
        for(CatalogService service : services) {
            serviceCache.put(service.getType(), service);
        }
    }

    public CatalogService getService(String type) {
        CatalogService service = serviceCache.get(type);
        if(service == null) throw new RuntimeException("Unknown service type: " + type);
        return service;
    }
}