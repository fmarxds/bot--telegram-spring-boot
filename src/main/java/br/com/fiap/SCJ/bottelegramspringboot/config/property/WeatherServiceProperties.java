package br.com.fiap.SCJ.bottelegramspringboot.config.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Data
@Validated
@ConfigurationProperties("service.weather")
public class WeatherServiceProperties {

    @NotBlank(message = "O atributo 'service.weather.url' precisa ser informado")
    private String url;

    @NotBlank(message = "O atributo 'service.weather.firstKey' precisa ser informado")
    private String firstKey;

    @NotBlank(message = "O atributo 'service.weather.secondKey' precisa ser informado")
    private String secondKey;

    @NotBlank(message = "O atributo 'service.weather.fields_weather' precisa ser informado")
    private String fields_weather;

    @NotBlank(message = "O atributo 'service.weather.fields_forecast' precisa ser informado")
    private String fields_forecast;

}
