package br.com.fiap.SCJ.bottelegramspringboot.util;

import br.com.fiap.SCJ.bottelegramspringboot.exception.ChatNotFoundException;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Objects;
import java.util.Optional;

public class BotUtils {

    private BotUtils() {
        // utils class
    }

    public static String getChatID(Update update) {
        return Optional.ofNullable(update)
                .map(Update::getMessage)
                .map(Message::getChatId)
                .map(Objects::toString)
                .orElseThrow(() -> new ChatNotFoundException("Chat nao encontrado no 'update' message"));
    }

}
