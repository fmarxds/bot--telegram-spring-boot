package br.com.fiap.SCJ.bottelegramspringboot.config;

import br.com.fiap.SCJ.bottelegramspringboot.config.property.BotProperties;
import br.com.fiap.SCJ.bottelegramspringboot.config.property.ChatCommandProperties;
import br.com.fiap.SCJ.bottelegramspringboot.config.property.ExchangeServiceProperties;
import br.com.fiap.SCJ.bottelegramspringboot.config.property.WeatherServiceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({
        BotProperties.class,
        ExchangeServiceProperties.class,
<<<<<<< HEAD
        WeatherServiceProperties.class
=======
        ChatCommandProperties.class,
>>>>>>> e719aa8ab56ff8e075de55bf50d31fa7725ffa2a
})
public class PropertyConfig {
}
