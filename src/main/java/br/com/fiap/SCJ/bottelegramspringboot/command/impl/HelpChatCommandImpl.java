package br.com.fiap.SCJ.bottelegramspringboot.command.impl;

import br.com.fiap.SCJ.bottelegramspringboot.command.ChatCommand;
import br.com.fiap.SCJ.bottelegramspringboot.config.property.ChatCommandProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
@RequiredArgsConstructor
public class HelpChatCommandImpl implements ChatCommand {

    private final ChatCommandProperties chatCommandProperties;
    private static final String COMANDO = "help";

    @Override
    public String comando() {
        return COMANDO;
    }

    @Override
    public String execute(Update update, String param) {

        StringBuilder sb = new StringBuilder();

        chatCommandProperties.getComandos()
                .forEach(it -> sb.append(String.format("%s: %s\n", it.getNome(), it.getDescricao())));

        return sb.toString();

    }

}
