package com.blumm.springbootsoapproducerexample.endpoint;

import com.blumm.producing_ws.GetCountryRequest;
import com.blumm.producing_ws.GetCountryResponse;
import com.blumm.springbootsoapproducerexample.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CountryEndpoint {

    private static final String NAMESPACE_URI = "http://blumm.com/producing-ws";

    private final CountryRepository countryRepository;

    @Autowired
    public CountryEndpoint(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest getCountryRequest) {
        GetCountryResponse response = new GetCountryResponse();
        response.setCountry(countryRepository.findCountry(getCountryRequest.getName()));
        return response;
    }
}
