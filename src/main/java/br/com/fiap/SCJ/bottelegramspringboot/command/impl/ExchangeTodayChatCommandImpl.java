package br.com.fiap.SCJ.bottelegramspringboot.command.impl;

import br.com.fiap.SCJ.bottelegramspringboot.command.ChatCommand;
import br.com.fiap.SCJ.bottelegramspringboot.service.ExchangeService;
import br.com.fiap.SCJ.bottelegramspringboot.service.data.input.ExchangeTodayInput;
import br.com.fiap.SCJ.bottelegramspringboot.service.data.output.ExchangeTodayOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.math.RoundingMode;

@Service
@RequiredArgsConstructor
public class ExchangeTodayChatCommandImpl implements ChatCommand {

    private final ExchangeService exchangeService;
    private static final String COMANDO = "dolar";

    @Override
    public String comando() {
        return COMANDO;
    }

    @Override
    public String execute(Update update, String param) {

        ExchangeTodayOutput exchangeTodayOutput = exchangeService.exchangeToday(new ExchangeTodayInput());

        String exchangeFormatted = exchangeTodayOutput
                .getValue()
                .setScale(2, RoundingMode.HALF_UP)
                .toPlainString();

        return String.format("1.00 USD\n%s BRL", exchangeFormatted);

    }

}
