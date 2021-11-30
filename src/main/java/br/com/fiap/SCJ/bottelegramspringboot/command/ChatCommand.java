package br.com.fiap.SCJ.bottelegramspringboot.command;

import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.IOException;
import java.net.URISyntaxException;

public interface ChatCommand {

    String comando();

    String execute(Update update, String param) throws IOException, URISyntaxException;

}
