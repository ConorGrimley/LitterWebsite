package com.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiServiceImpl implements ApiService {

    private RestTemplate restTemplate;

    private ApiRepositoryService apiRepository;

    @Autowired
    public ApiServiceImpl(RestTemplate restTemplate, ApiRepositoryService apiRepository) {
        this.restTemplate = restTemplate;
        this.apiRepository = apiRepository;
    }


    @Override
    public String retrieveData() {
        String response = restTemplate.getForObject("http://demo.ckan.org/api/3/action/group_list", String.class);
        apiRepository.saveData(response);
        return response;
    }
}
