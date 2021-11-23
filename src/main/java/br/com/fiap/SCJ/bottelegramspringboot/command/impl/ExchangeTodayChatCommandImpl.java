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
    private enum COMANDOS {
        DOLAR("dolar", "$"),
        REAL("real", "R$"),
        EURO("euro", "€");

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

        ExchangeTodayOutput exchangeTodayOutput = exchangeService.exchangeToday(new ExchangeTodayInput());

        return exchangeTodayOutput.getValue().setScale(2, RoundingMode.HALF_UP).toPlainString();

    }

}
