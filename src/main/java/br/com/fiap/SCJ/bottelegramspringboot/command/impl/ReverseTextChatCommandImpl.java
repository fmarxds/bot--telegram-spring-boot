package br.com.fiap.SCJ.bottelegramspringboot.command.impl;

import br.com.fiap.SCJ.bottelegramspringboot.command.ChatCommand;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Objects;

@Service
public class ReverseTextChatCommandImpl implements ChatCommand {

    private static final String COMANDO = "reverso";

    @Override
    public String comando() {
        return COMANDO;
    }

    @Override
    public String execute(Update update, String param) {

        if (Objects.isNull(param) || param.isBlank()) {
            return "Por favor informe um texto válido";
        }

        StringBuilder sb = new StringBuilder(param);
        sb.reverse();
        return sb.toString();

    }

}
