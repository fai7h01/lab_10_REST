package com.cydeo.client;

import org.springframework.cloud.openfeign.FeignClient;
/*
http://api.weatherstack.com/  --> baseUrl
current? --> endpoint
access_key=159e247c26448476832ea4316551af26&  --> query param 1
query=Tbilisi --> query param 2
 */

@FeignClient(url = "http://api.weatherstack.com", name = "WEATHER-CLIENT")
public interface WeatherClient {



}
