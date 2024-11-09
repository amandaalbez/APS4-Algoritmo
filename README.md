# Comparação de Desempenho e Análise de Performance de Algoritmos de Ordenação

Projeto desenvolvido como parte das Atividades Práticas Supervisionadas (APS) do curso de Ciência da Computação da Universidade Paulista - UNIP.

## Resumo
Este projeto visa analisar e comparar o desempenho de três algoritmos de ordenação: **InsertionSort**, **MergeSort** e **BucketSort**. A implementação é realizada em Java, com uma aplicação que permite ao usuário selecionar um algoritmo e visualizar o tempo de execução em diferentes cenários de ordenação. O objetivo é fornecer insights sobre a eficiência e aplicabilidade de cada algoritmo em contextos variados.

## Tecnologias Utilizadas
- **Java**: Linguagem principal de implementação dos algoritmos.
- **IntelliJ IDEA**: Ambiente de Desenvolvimento Integrado (IDE) utilizado para o desenvolvimento do projeto.

## Estrutura do Projeto
- `src`: Contém os arquivos Java com a implementação dos algoritmos e a lógica de comparação de tempo.
- `input_files`: Diretório para arquivos de números a serem ordenados.
- `README.md`: Instruções e documentação do projeto.
- `LICENSE`: Licença do projeto.

## Algoritmos Implementados
1. **InsertionSort**: Algoritmo simples e eficaz para pequenas listas ou listas quase ordenadas, com complexidade de tempo O(n²).
2. **MergeSort**: Algoritmo baseado em divisão e conquista, ideal para grandes volumes de dados, com complexidade O(n log n).
3. **BucketSort**: Algoritmo eficiente para dados uniformemente distribuídos, com complexidade média O(n).
## Executando o Projeto
1. **Clone o repositório**:
   ```bash
   git clone https://github.com/amandaalbez/APS4-Algoritmo.git

## Resultados
O projeto apresenta os tempos de execução em milissegundos para cada algoritmo. Os resultados são discutidos no relatório, e o desempenho de cada algoritmo é visualizado em uma tabela e gráfico comparativo.

Exemplo de Saída
Ao executar o programa, você verá um menu interativo que permite escolher entre os algoritmos de ordenação e arquivos de diferentes tamanhos para testar. O resultado incluirá o tempo de execução do algoritmo escolhido. Exemplo:

```bash
Escolha o algoritmo de ordenação:
1 - InsertionSort
2 - MergeSort
3 - BucketSort
4 - Sair

Escolha o arquivo de entrada:
1 - 1000 números
2 - 5000 números
3 - 10000 números

```
Após selecionar, o programa ordenará o arquivo selecionado e exibirá o tempo de execução para o algoritmo escolhido.  
