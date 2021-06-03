package com.wust.spring.boot.standard.demo.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.wust.spring.boot.standard.demo.model.Tenant;

public interface TenantService {
    Tenant addTenant(Tenant tenant);

    Tenant getTenant(String tenantName);
}
