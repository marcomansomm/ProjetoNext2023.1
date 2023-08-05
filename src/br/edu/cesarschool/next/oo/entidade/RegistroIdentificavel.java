package br.edu.cesarschool.next.oo.entidade;

import java.io.Serializable;
import java.time.LocalDateTime;

/*
 * Atributos:
   dataHoraCriacao, do tipo LocalDateTime (tipo do JAVA que representa uma data e está no
   pacote java.time)

   Métodos:
   int obterTempoDeCriacao() – este método deve calcular, EM DIAS, a diferença entre a
   dataHoraCriacao (o atributo recém criado) e a data atual. Pesquisar como obter esta
   diferença e como obter a data atual. ATENÇÃO! A solução pode estar dentro do próprio tipo
   ocalDateTime, que já é o tipo do atributo dataHoraCriacao.
 */
public abstract class RegistroIdentificavel implements Serializable{

   private LocalDateTime dataHoraCriacao;
   // 04/08/2023 21:04
    
   public abstract String obterChave();
   
   public RegistroIdentificavel(LocalDateTime dataHoraCriacao) {
      this.dataHoraCriacao = dataHoraCriacao;
   }

   public RegistroIdentificavel() {
   }

   public LocalDateTime getDataHoraCriacao() {
      return dataHoraCriacao;
   }

   public void setDataHoraCriacao(LocalDateTime dataHoraCriacao) {
      this.dataHoraCriacao = dataHoraCriacao;
   }

   public int obterTempoDeCriacao(){
      LocalDateTime dataAtual = LocalDateTime.now();
      //    217
      int dataAtualEmDia = dataAtual.getDayOfYear();
      //    216
      int dataHoraCriacaoEmDia = dataHoraCriacao.getDayOfYear();
      return dataAtualEmDia - dataHoraCriacaoEmDia;
      //data de criação - data atual;
   }
}
