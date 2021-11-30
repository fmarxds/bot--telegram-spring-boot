package br.com.fiap.SCJ.bottelegramspringboot.config.property;

import br.com.fiap.SCJ.bottelegramspringboot.config.property.data.CommandPropertyData;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Validated
@ConfigurationProperties
public class ChatCommandProperties {

    @NotNull(message = "O atributo 'comandos' precisa ser informado")
    private List<CommandPropertyData> comandos;

}
