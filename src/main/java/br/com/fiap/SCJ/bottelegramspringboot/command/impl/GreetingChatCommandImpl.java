package br.com.fiap.SCJ.bottelegramspringboot.command.impl;

import br.com.fiap.SCJ.bottelegramspringboot.command.ChatCommand;
import br.com.fiap.SCJ.bottelegramspringboot.util.BotUtils;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.text.MessageFormat;

@Service
public class GreetingChatCommandImpl implements ChatCommand {

    private enum COMANDOS {
        HELLO("hello", "Olá, {0}."),
        TUDO_BEM("tudobem", "Olá, {0}. Em que posso lhe ajudar?"),
        QUEM_FALA("quemfala", "Aqui é o seu assistente pessoal, {1} ao seu dispor! :) ");

        private String mensagem;
        private String resposta;
        COMANDOS(String mensagem, String resposta) {
            this.mensagem = mensagem;
            this.resposta = resposta;
        }

        public static boolean existeComando(final String comando) {
            for (COMANDOS comandos : COMANDOS.values()) {
                if (comandos.mensagem.equalsIgnoreCase(comando))
                    return true;
            }
            return false;
        }

        public static String getMensagem(final String comando) {
            for (COMANDOS comandos : COMANDOS.values()) {
                if (comandos.mensagem.equalsIgnoreCase(comando))
                    return comandos.resposta;
            }
            return "Não entendi. Poderia escrever novamente?";
        }
    }


    @Override
    public boolean comando(final String comando) {
        return COMANDOS.existeComando(comando);
    }

    @Override
    public String execute(final String comando, Update update) {
        return MessageFormat.format(COMANDOS.getMensagem(comando), update.getMessage().getFrom().getFirstName(), BotUtils.getBotUserName());
    }
}
