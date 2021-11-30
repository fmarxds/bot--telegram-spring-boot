package br.com.fiap.SCJ.bottelegramspringboot.command.impl;

import br.com.fiap.SCJ.bottelegramspringboot.command.ChatCommand;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Objects;

@Service
public class EncodeTextChatCommandImpl implements ChatCommand {

    private static final String COMANDO = "codificar";

    @Override
    public String comando() {
        return COMANDO;
    }

    @Override
    public String execute(Update update, String param) {

        if (Objects.isNull(param) || param.isBlank()) {
            return "Por favor informe um texto válido";
        }

        return Base64.getEncoder().encodeToString(param.getBytes(StandardCharsets.UTF_8));

    }

}
