# Sockets UDP

Trabalho proposto na disciplina de Programação em redes, desenvolvido pelo aluno Thiago Emanuel Silva Antunes Lopes, estudante do curso de Bacharelado em Ciência da Computação do IFNMG Campus Montes Claros.

## 📋 Pré-requisitos

Para executar o projeto é nescessario ter instalado a NetBeans IDE.

## 🚀 Começando

O enunciado deste trabalho é:

O trabalho consiste em praticar o uso de sockets UDP. O trabalho consiste de dois programas
que se comunicam via UDP.

### Tarefa 1

O programa mostra a todo momento para o usuário o estado de uma grade 8x8 de células..
Nesta grade as células tem dois estados: vivas ou mortas. Fica a critério do aluno a decisão da
forma de apresentar a grade para o usuário. Você pode desenhar com ASCII por exemplo.
O programa inicia com a grade com todas as células mortas. O programa fica esperando
pacotes UDP que comunicam o estado desta grade. Cada vez que o programa recebe um
estado novo pela rede ele deve atualizar o desenho apresentado ao usuário.

### Tarefa 2 - Cliente Manual

O segundo programa implementa o Conway’s Game of Life (jogo da vida de Conway) em uma
grade 8x8. Ao iniciar o usuário pode decidir quais células estão vivas e o intervalo de tempo
para cada nova geração (você pode decidir como é a interface com o usuário). A cada nova
geração o programa envia para o programa da tarefa 1 o novo estado da grade via UDP.

Dado um estado da grade a grade da nova geração é computada da seguinte forma:

1. Se uma célula viva tem menos de dois vizinhos ela morre de solidão.
2. Se uma célula viva tem mais de três vizinhos ela morre por superpopulação.
3. Se uma célula viva tem dois ou três vizinhos ela permanece viva.
4. Se uma célula morta tem três vizinhos ela se torna vivia.

Os vizinhos de uma célula incluem os vizinhos da diagonal. Por exemplo na grade a célula 1 tem vizinhos a,b,c,d,e,f,g,h. Para células que estão nas bordas da grade considere
qualquer vizinho fora da grade como morto.

![image](https://user-images.githubusercontent.com/58573768/147372714-037280b3-3d01-42d7-b323-0d76aba0c148.png)

Considere a grade

![image](https://user-images.githubusercontent.com/58573768/147372729-2babe172-e2a3-4912-a4ec-8b56f3b24693.png)

onde x representa as células vivas. Na próxima geração a grade será:

![image](https://user-images.githubusercontent.com/58573768/147372736-710f8fed-57e8-4ee9-88e0-78d5f3c0bc5e.png)

## 🛠️ Construído com

* [NetBeans](https://netbeans.apache.org/download/index.html) - NetBeans

## ✒️ Autores

* **Thiago Emanuel** - *Trabalho Inicial* - [thgemanuel](https://github.com/thgemanuel)
