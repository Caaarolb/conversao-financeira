# Conversor de Moeda - Dólar para Real

Este projeto implementa um conversor de moeda que converte valores em dólares para reais, utilizando uma taxa de câmbio dinâmica obtida de uma API pública. A taxa de câmbio é consultada a cada execução do programa e pode ser usada para converter qualquer valor em dólares para reais.

## Funcionalidades

- **Conversão de Moeda**: O programa converte valores em dólares para reais, utilizando a taxa de câmbio atual.
- **API para Taxa de Câmbio**: A taxa de câmbio é obtida automaticamente através de uma API pública de taxas de câmbio.
- **Valor Padrão de Taxa**: Caso não seja possível obter a taxa de câmbio da API, o programa utiliza um valor padrão para conversão.
- **Entrada Interativa**: O usuário fornece o valor em dólares, e o programa retorna o valor correspondente em reais.

## Estrutura do Projeto

O projeto é composto por duas principais classes:

- **ConversorMoeda**: Classe responsável por implementar a interface `ConversaoFinanceira` e realizar a conversão de dólar para real, além de obter a taxa de câmbio atual.
- **ConversaoFinanceira**: Interface que define o contrato para a conversão financeira, garantindo que o método de conversão esteja presente em qualquer classe que implemente a interface.

## Como Executar

1. Clone este repositório.
2. Compile os arquivos Java:
   ```bash
   javac ConversorMoeda.java ConversaoFinanceira.java
3. Execute o programa:
     ```bash
    java ConversorMoeda
4. O programa solicitará que você insira um valor em dólares, e retornará o valor convertido para reais, de acordo com a taxa de câmbio atual.
