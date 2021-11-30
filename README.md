# JarvisFIAP Telegram Bot

![](https://img.shields.io/badge/version-1.0.0-blue.svg)

Assistente pessoal para Telegram.

## Como utilizar

- Criar a variável de ambiente BOT_TOKEN com o token do bot do Telegram
- Executar o método main em BotTelegramSpringBootApplication

## Dependências

- Java 11
- Gradle

## Changelog

- 1.0.0
  - comando olá mundo
  - comando cotação do dólar
  - comando clima atual
  - comando previsão do tempo
  - comando calculo de expressão matemática
  - comando reverte texto
  - comando codifica texto

## Comandos disponíveis

### /hello

Você irá receber um olá do seu assistente pessoal :)
> /hello<br>
> Olá {user}!

### /dolar

Obtém a cotação atual do dólar
> /dolar<br>
> 1.00 USD<br>
> 5.61 BRL

### /clima {cidade}

TODO
> /clima<br>
> TODO

### /previsao-tempo {cidade}

TODO
> /clima<br>
> TODO

### /calc {expressao}

Obtém o resultado de uma expressão matemática
> /calc 5*5+5-1<br>
> Resultado: 29.00

### /reverso {texto}

Inverte o texto
> /reverso elefante<br>
> etnafele

### /codificar {texto}

Codifica em base 64 o texto
> /codificar texto<br>
> dGV4dG8=