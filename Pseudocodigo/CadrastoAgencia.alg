algoritmo "Cadastro"
// Função :   Cadastro Agencia de Viagem
// Autor : Erick Mauricio Tavares
// Squad: 16
// Data : 05/08/2023

var
cliente: vetor[0..2, 0..3] de caracter
i,j : inteiro
dados: vetor[0..3] de caracter


inicio
escreval("============ Area de Cadastros Para Viagem ============")
escreval(" ")
escreval(" ")
dados[0] <- "Nome: "
dados[1] <- "CPF: "
dados[2] <- "Data da viagem: "
dados[3] <- "Destino: "

escreval("[Digite os dados do cliente]")
escreval(" ")

para i de 0 ate 2 faca
   escreval("          Cliente:" , i+1)

   para j de 0 ate 3 faca
      escreva(dados[j])
      leia (cliente[i,j])

   fimpara
   escreval()
fimpara


limpatela
escreval("Dados digitados")

para i de 0 ate 2 faca
   para j de 0 ate 3 faca
      escreval(dados[j])
      escreval(cliente[i,j])

   fimpara
   escreval(" ")
   escreval ("*    Cadastro realizado com sucesso!   ")
   escreval (" ")

fimpara
escreval("============ Obrigado e Boa Viagem ============")
fimalgoritmo
