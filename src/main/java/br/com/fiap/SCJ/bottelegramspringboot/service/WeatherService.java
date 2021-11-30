package br.com.fiap.SCJ.bottelegramspringboot.service;

public interface WeatherService {
    String weather(String city);

    String forecast(String city);
}
