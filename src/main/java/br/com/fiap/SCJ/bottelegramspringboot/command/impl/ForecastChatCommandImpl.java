package br.com.fiap.SCJ.bottelegramspringboot.command.impl;

import br.com.fiap.SCJ.bottelegramspringboot.command.ChatCommand;
import br.com.fiap.SCJ.bottelegramspringboot.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
@RequiredArgsConstructor
public class ForecastChatCommandImpl implements ChatCommand {

    private final WeatherService weatherAPIService;
    private static final String COMANDO = "previsao_tempo";

    @Override
    public String comando() {
        return COMANDO;
    }

    @Override
    public String execute(Update update, final String city) {
        return weatherAPIService.forecast(city);
    }
}
