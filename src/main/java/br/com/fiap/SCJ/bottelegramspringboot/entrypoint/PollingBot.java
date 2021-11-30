package br.com.fiap.SCJ.bottelegramspringboot.entrypoint;

import br.com.fiap.SCJ.bottelegramspringboot.command.ChatCommand;
import br.com.fiap.SCJ.bottelegramspringboot.config.property.BotProperties;
import br.com.fiap.SCJ.bottelegramspringboot.exception.ActionNotSentException;
import br.com.fiap.SCJ.bottelegramspringboot.exception.MessageNotSentException;
import br.com.fiap.SCJ.bottelegramspringboot.logger.BotMessagesLogger;
import br.com.fiap.SCJ.bottelegramspringboot.util.BotUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.ActionType;
import org.telegram.telegrambots.meta.api.methods.send.SendChatAction;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Service
@Profile("local")
@RequiredArgsConstructor
public class PollingBot extends TelegramLongPollingBot {

    private final BotProperties botProperties;
    private final BotMessagesLogger botMessagesLogger;
    private final List<ChatCommand> chatCommands;
    private static final int REGEX_GROUP_COMMAND = 1;
    private static final int REGEX_GROUP_PARAM = 2;
    private static final Pattern COMMAND_PATTERN = Pattern.compile("/(\\w*)\\s*(.*)");

    @Override
    public String getBotUsername() {
        return botProperties.getUsername();
    }

    @Override
    public String getBotToken() {
        return botProperties.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {

        try {

            botMessagesLogger.logIncomingMessage(update);

            String chatId = BotUtils.getChatID(update);
            sendTypingAction(chatId);

            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(chatId);

            Matcher commandPatternMatcher = COMMAND_PATTERN.matcher(update.getMessage().getText());

            if (commandPatternMatcher.matches()) {

                String comando = getRegexGroup(commandPatternMatcher, REGEX_GROUP_COMMAND);
                String param = getRegexGroup(commandPatternMatcher, REGEX_GROUP_PARAM);

                chatCommands.stream()
                        .filter(it -> it.comando().equals(comando))
                        .findFirst()
                        .ifPresentOrElse(it -> {
                            try {
                                sendMessage.setText(it.execute(update, param));
                            } catch (IOException e) {
                                e.printStackTrace();
                            } catch (URISyntaxException e) {
                                e.printStackTrace();
                            }
                        }, () -> sendMessage.setText("Desculpe, comando não cadastrado..."));

            } else {
                sendMessage.setText("Desculpe, não entendi...");
            }

            Message sentMessage = execute(sendMessage);

            botMessagesLogger.logSendingMessage(sentMessage);

        } catch (TelegramApiException e) {
            log.error("An error ocurred during sending response message", e);
            throw new MessageNotSentException(e.getLocalizedMessage());
        }

    }

    private void sendTypingAction(String chatId) {
        try {
            execute(new SendChatAction(chatId, ActionType.TYPING.name()));
        } catch (TelegramApiException e) {
            log.error("An error ocurred during sending typing action", e);
            throw new ActionNotSentException(e.getLocalizedMessage());
        }
    }

    private String getRegexGroup(Matcher commandPatternMatcher, int group) {
        try {
            return commandPatternMatcher.group(group).toLowerCase();
        } catch (Exception e) {
            return "";
        }
    }

}
