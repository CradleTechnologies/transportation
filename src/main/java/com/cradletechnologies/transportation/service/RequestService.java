package com.cradletechnologies.transportation.service;

import jakarta.servlet.http.HttpServletRequest;

public interface RequestService {

    String getClientIp(HttpServletRequest request);
}