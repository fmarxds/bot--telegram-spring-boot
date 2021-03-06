package br.com.fiap.SCJ.bottelegramspringboot.config.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Data
@Validated
@ConfigurationProperties("bot")
public class BotProperties {

    @NotBlank(message = "O atributo 'bot.username' precisa ser informado")
    private String username;

    @NotBlank(message = "O atributo 'bot.token' precisa ser informado")
    private String token;

}
