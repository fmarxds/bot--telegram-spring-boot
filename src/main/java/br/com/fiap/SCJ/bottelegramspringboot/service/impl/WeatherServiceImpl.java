package br.com.fiap.SCJ.bottelegramspringboot.service.impl;

import br.com.fiap.SCJ.bottelegramspringboot.config.property.WeatherServiceProperties;
import br.com.fiap.SCJ.bottelegramspringboot.service.WeatherService;
import br.com.fiap.SCJ.bottelegramspringboot.service.impl.data.output.ForecastResponse;
import br.com.fiap.SCJ.bottelegramspringboot.service.impl.data.output.WeatherResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Optional;

@Service
public class WeatherServiceImpl implements WeatherService {

    private final RestTemplate restTemplate;
    private final WeatherServiceProperties properties;
    private static URL url;

    public WeatherServiceImpl(RestTemplate restTemplate, WeatherServiceProperties properties) throws MalformedURLException {
        this.restTemplate = restTemplate;
        this.properties = properties;
        if (url == null)
            url = new URL(properties.getUrl());
    }

    @Override
    public String weather(String city) {
        ResponseEntity<WeatherResponse> responseEntity = null;
        try {
            responseEntity = restTemplate.getForEntity(url.toURI().toString().
                                                       concat(properties.getFirstKey()).
                                                       concat(properties.getFields_weather()).
                                                       concat(city),
                                                       WeatherResponse.class);
        }
        catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return Optional.ofNullable(responseEntity)
                .map(ResponseEntity::getBody)
                .map(WeatherResponse::toString)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public String forecast(String city) {
        ResponseEntity<ForecastResponse> responseEntity = null;
        try {
            responseEntity = restTemplate.getForEntity(url.toURI().toString().
                                                       concat(properties.getSecondKey()).
                                                       concat(properties.getFields_forecast()).
                                                       concat(city),
                                                       ForecastResponse.class);
        }
        catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(responseEntity)
                .map(ResponseEntity::getBody)
                .map(ForecastResponse::toString)
                .orElseThrow(RuntimeException::new);
    }
}