package br.com.fiap.SCJ.bottelegramspringboot.command.impl;

import br.com.fiap.SCJ.bottelegramspringboot.command.ChatCommand;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class GreetingChatCommandImpl implements ChatCommand {

    private static final String COMANDO = "hello";

    @Override
    public String comando() {
        return COMANDO;
    }

    @Override
    public String execute(Update update, String param) {

        return String.format("Olá %s!", update.getMessage().getFrom().getFirstName());

    }

}
