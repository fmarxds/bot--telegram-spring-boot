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

### /clima

Obtém o clima da cidade de origem da requisição
> /clima<br>
**--------- Clima ---------**<br>
Cidade: São Paulo, SP<br>
Data: 30/11/2021<br>
Temperatura: 21º C<br>
Clima: Tempo nublado<br>
Umidade atual: 88%<br>
Velocidade do vento em: 2.24 km/h<br>
Nascer do sol: 05:11 am<br>
Pôr do sol: 06:39 pm<br>
Tempo atual: Nublado de noite<br>

### /clima {cidade}

Obtém o clima da cidade informada
> /clima Rio de Janeiro<br>
> **--------- Clima ---------**<br>
> Cidade: Rio de Janeiro, RJ<br>
> Data: 30/11/2021<br>
> Temperatura: 25º C<br>
> Clima: Tempo limpo<br>
> Umidade atual: 88%<br>
> Velocidade do vento em: 1.54 km/h<br>
> Nascer do sol: 04:59 am<br>
> Pôr do sol: 06:24 pm<br>
> Tempo atual: Noite limpa<br>

### /previsao_tempo

Obtém o previsão do tempo da cidade de origem da requisição
> /previsao_tempo<br>
> Cidade: São Paulo, SP<br>
> Data: 30/11/2021<br>
> Clima: Tempo nublado<br>
> <br>
> **--------- Previsão ---------**<br>
> Dia: Ter<br>
> Data: 30/11<br>
> Máxima Temperatura: 25º C<br>
> Mínima Temperatura: 19º C<br>
> Condição Chuva<br>
> -------------<br>
> <br>
> Dia: Qua<br>
> Data: 01/12<br>
> Máxima Temperatura: 28º C<br>
> Mínima Temperatura: 18º C<br>
> Condição Chuva<br>
> -------------<br>
> <br>
> Dia: Qui<br>
> Data: 02/12<br>
> Máxima Temperatura: 22º C<br>
> Mínima Temperatura: 17º C<br>
> Condição Nublado de dia<br>
> -------------<br>
> <br>
> Dia: Sex<br>
> Data: 03/12<br>
> Máxima Temperatura: 23º C<br>
> Mínima Temperatura: 16º C<br>
> Condição Nublado de dia<br>
> -------------<br>
> <br>
> Dia: Sáb<br>
> Data: 04/12<br>
> Máxima Temperatura: 26º C<br>
> Mínima Temperatura: 16º C<br>
> Condição Nublado de dia<br>
> -------------<br>
> <br>
> Dia: Dom<br>
> Data: 05/12<br>
> Máxima Temperatura: 30º C<br>
> Mínima Temperatura: 17º C<br>
> Condição Nublado de dia<br>
> -------------<br>
> <br>
> Dia: Seg<br>
> Data: 06/12<br>
> Máxima Temperatura: 31º C<br>
> Mínima Temperatura: 19º C<br>
> Condição Chuva<br>
> -------------<br>

### /previsao_tempo {cidade}

Obtém o previsão do tempo da cidade informada
> /previsao_tempo Rio de Janeiro<br>
> Cidade: Rio de Janeiro, RJ<br>
> Data: 30/11/2021<br>
> Clima: Parcialmente nublado<br>
> <br>
> **--------- Previsão ---------**<br>
> Dia: Ter<br>
> Data: 30/11<br>
> Máxima Temperatura: 26º C<br>
> Mínima Temperatura: 22º C<br>
> Condição Chuva<br>
> -------------<br>
> <br>
> Dia: Qua<br>
> Data: 01/12<br>
> Máxima Temperatura: 27º C<br>
> Mínima Temperatura: 22º C<br>
> Condição Chuva<br>
> -------------<br>
> <br>
> Dia: Qui<br>
> Data: 02/12<br>
> Máxima Temperatura: 25º C<br>
> Mínima Temperatura: 22º C<br>
> Condição Chuva<br>
> -------------<br>
> <br>
> Dia: Sex<br>
> Data: 03/12<br>
> Máxima Temperatura: 24º C<br>
> Mínima Temperatura: 21º C<br>
> Condição Chuva<br>
> -------------<br>
> <br>
> Dia: Sáb<br>
> Data: 04/12<br>
> Máxima Temperatura: 26º C<br>
> Mínima Temperatura: 21º C<br>
> Condição Dia limpo<br>
> -------------<br>
> <br>
> Dia: Dom<br>
> Data: 05/12<br>
> Máxima Temperatura: 28º C<br>
> Mínima Temperatura: 21º C<br>
> Condição Chuva<br>
> -------------<br>
> <br>
> Dia: Seg<br>
> Data: 06/12<br>
> Máxima Temperatura: 30º C<br>
> Mínima Temperatura: 21º C<br>
> Condição Chuva<br>
> -------------<br>

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