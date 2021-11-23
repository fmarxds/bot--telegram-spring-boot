package br.com.fiap.SCJ.bottelegramspringboot.command;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface ChatCommand {

    boolean comando(final String comando);

    String execute(final String comando, Update update);

}
