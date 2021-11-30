package br.com.fiap.SCJ.bottelegramspringboot.command;

import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.IOException;
import java.net.URISyntaxException;

public interface ChatCommand {

    String comando();

<<<<<<< HEAD
    String execute(Update update, String param) throws IOException, URISyntaxException;
=======
    String execute(Update update, String param);
>>>>>>> e719aa8ab56ff8e075de55bf50d31fa7725ffa2a

}
