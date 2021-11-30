package br.com.fiap.SCJ.bottelegramspringboot.service.impl.data.output;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.MessageFormat;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ForecastResponse {

    @JsonProperty("date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private String date;

    @JsonProperty("description")
    private String descriptionCondition;

    @JsonProperty("city")
    private String city;

    @JsonProperty("forecast")
    private List<ForecastResponse> forecast;

    @JsonProperty("weekday")
    private String weekday;

    @JsonProperty("max")
    private Integer max;

    @JsonProperty("min")
    private Integer min;

    @JsonProperty("condition")
    private String condition;

    public String toString() {
        StringBuilder outputReturn = new StringBuilder();
        outputReturn.append("Cidade: {0} \n");
        outputReturn.append("Data: {1} \n");
        outputReturn.append("Clima: {2} \n \n");
        outputReturn = new StringBuilder(MessageFormat.format(outputReturn.toString(), city, date, descriptionCondition));

        outputReturn.append(" **--------- Previsão ---------** \n ");
        for (ForecastResponse forecastResponse : forecast) {
            StringBuilder forecastOutput = new StringBuilder();
            forecastOutput.append("Dia: {0} \n");
            forecastOutput.append("Data: {1} \n");
            forecastOutput.append("Máxima Temperatura: {2}º C \n");
            forecastOutput.append("Mínima Temperatura: {3}º C \n");
            forecastOutput.append("Condição {4} \n");
            forecastOutput.append("------------- \n \n");
            outputReturn.append(MessageFormat.format(forecastOutput.toString(),
                                                                    forecastResponse.getWeekday(),
                                                                    forecastResponse.getDate(),
                                                                    forecastResponse.getMax(),
                                                                    forecastResponse.getMin(),
                                                                    WeatherResponse.CONDITION.from(forecastResponse.getCondition())));
        }

        return outputReturn.toString();
    }
}