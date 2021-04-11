# TINN-Challenge

* [Tecnologias necessárias](#tecnologias-utilizadas)
* [1 Votos Em relação ao total de eleitores](#exercicio-1)
* [2 Algoritimo de ordenação Bubble Sort](#exercicio-2)
 
 
 ## Tecnologias Utilizadas
 
 * Java 1.8
 * Maven 3.6.3+
 
 
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
  
  $ mvn -Dtest=CalculadoraEleitoralTest test
  
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
 
 
 $ mvn -Dtest=BubbleSortTest test
 
 Segue o link dos códigos fontes referente a esse exercíco:
 
 https://github.com/wfjneves/TINN-Challenge/blob/master/src/test/java/neves/jesus/felipe/wesley/TINNChallenge/exerccicio2/BubbleSortTest.java
 https://github.com/wfjneves/TINN-Challenge/blob/master/src/main/java/neves/jesus/felipe/wesley/TINNChallenge/exercicio2/BubbleSort.java
