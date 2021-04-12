# TINN-Challenge

* [Tecnologias necessárias](#tecnologias-utilizadas)
* [1 Votos Em relação ao total de eleitores](#exercicio-1)
* [2 Algoritimo de ordenação Bubble Sort](#exercicio-2)
* [3 Fatorial](#exercicio-3)
* [4 Soma dos múltiplos de 3 ou 5](#exercicio-4)
* [5 Cadastro de veículos](#exercicio-5)
 
 
 ## Tecnologias Utilizadas
 
 * Java 1.8
 * Maven 3.6.3+
 * Npm 6.14.11
 * Angular CLI 11.2.6
 * Node 14.16.0
 
 
 ## Exercicio 1
 

  Considerando a tabela abaixo...
  
  total de eleitores = 1000
  válidos = 800
  votos brancos = 150
  nulos = 50
  
 Faça uma classe com 3 métodos que calculam o percentual do votos váldiso em relação ao total de eleitores
  * O percentual do votos válidos em relação ao total de eleitores
  * O percentual de brancos em relação ao total de eleitores
  * O percentual de votos nulos em relação ao total de eleitores
  
  Para executar o teste unitário basta executar o código a seguir:
  
  execute em sua IDE a classe CalculadoraEleitoralTest
  
  Caso queira visualizar o código fonte estão disponiveis em 
  
  https://github.com/wfjneves/TINN-Challenge/blob/master/src/main/java/neves/jesus/felipe/wesley/TINNChallenge/exercicio1/CalculadoraEleitoral.java
  https://github.com/wfjneves/TINN-Challenge/blob/master/src/test/java/neves/jesus/felipe/wesley/TINNChallenge/exerccicio1/CalculadoraEleitoralTest.java
  
 ## Exercicio 2
 
 Algoritimo de ordenação Bubble Sort
 
 Imagine o seguinte vetor.
 
 `v = {5 . 3, 2, 4, 7, 1, 0, 6}`
 
 Faça um algoritimo que ordene o vetor acima utilizando o Buble Sort
 
 O Bubble Sort ordena de par em par.  Ele pega os dois primeiros elementos e pergunta se o primeiro é maior que o segundo. Se sim, os elementos são trocados(sswap), se não, mantidos. Vai repetindo o processo até o final do vetor.
 
 Obviamente que ele não consegue ordenar todo o vetor em uma única rodada, ele terá que passar pelo vetor um certo número de vezes.
 
 De maneira mais formal podemos destacar:
 
 Para executar o teste unitário desse exercício basta executar o código abaixo:
 
 
 execute em suas IDE a classe BubbleSortTest
 
 Segue o link dos códigos fontes referente a esse exercíco:
 
 https://github.com/wfjneves/TINN-Challenge/blob/master/src/test/java/neves/jesus/felipe/wesley/TINNChallenge/exerccicio2/BubbleSortTest.java
 https://github.com/wfjneves/TINN-Challenge/blob/master/src/main/java/neves/jesus/felipe/wesley/TINNChallenge/exercicio2/BubbleSort.java
 
 
 ## Exercicio 3
 
 Faça um programa que calcule o fatorial de um número qualquer.
 
 Para verificar execute em sua IDE a classe FatorialTest, a seguir tem os links dos códigos relacionados a esse exercício
 
 https://github.com/wfjneves/TINN-Challenge/blob/master/src/main/java/neves/jesus/felipe/wesley/TINNChallenge/exercicio3/Fatorial.java
 https://github.com/wfjneves/TINN-Challenge/blob/master/src/test/java/neves/jesus/felipe/wesley/TINNChallenge/exerccicio3/FatorialTest.java
 
 
 
 ## Exercicio 4
 
 
 Fazer uma implementação que faça a soma de todos os números sejam multiplos de 3 ou 5.
 Se listar todos os números naturais abaixo de 10 que são múltiplos de 3 ou 5, ficamos com 3, 5, 6 e 9. A soma desses múltiplos é de 23.
 
 A implementação deve ser capaz de receber por parâmetro um número X e retornar a soma de todos os númerod múltiplos de 3 ou 5.
 
 
 Para verificar esse exercicío execute em sua IDE a classe SomaMultiplosTest
 
 A seguir estão os links para os códigos associado a esse exercício.
 
 https://github.com/wfjneves/TINN-Challenge/blob/master/src/main/java/neves/jesus/felipe/wesley/TINNChallenge/exercicio4/SomaMultiplos.java 
 https://github.com/wfjneves/TINN-Challenge/blob/master/src/test/java/neves/jesus/felipe/wesley/TINNChallenge/exerccicio4/SomaMultiplosTest.java
 
 
## Exercicio 5

Criar uma aplicação back-end (Java ou NodeJS) basaada em web services usando JSON.
Deverá haver um front-end em modo Single Page Application que se comunique com os serviços criados no back-end.

## Missão

Desenvolver uma API JSON RESTful, que utilize todos os métodos (GET, POST, PUT, PATCH, DELETE). Faça o teste unitário da API

## Especificação

Monte uma base de veículo com a seguinte estrutura:

<p><code>veiculo: string</code></p>
<p><code>marca: string</code></p>
<p><code>ano: integer</code></p>
<p><code>descricao: text</code></p>
<p><code>vendido: bool</code></p>
<p><code>created: datetime</code></p>
<p><code>updated: datetime</code></p>

# Para executar esse exercício siga os passos abaixo

## Back-End

 <p> <code>$ mvn clean install</code>  </p>
 <p><code>$ java -jar ./target/TINN-Challenge-0.0.1-SNAPSHOT.jar </code> </p>
 
 ### Link para testar API
 
 http://localhost:8181/veiculos

No arquivo <strong>TINNOVA.postman_collection.json</strong> tem exemplos de requisições para os endpoint da API.

## Front-End

<p><code>$ cd  ./src/main/webapp/ </code></p>
<p><code>npm install</code></p>
<p><code>ng serve</code></p>

### Link para testar a aplicação
http://localhost:4200
