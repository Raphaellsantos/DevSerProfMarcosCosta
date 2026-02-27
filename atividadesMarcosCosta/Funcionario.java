/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packageExercicioMetodos;

/**
 *
 * @author rapha
 */
public class Funcionario {
    
    String nome;
    Double salario;
    String idade;
  
    
   void aumSalario (double valor) {
    this.salario += valor;
       
}

   void dadosFunc (){
       System.out.println ("DADOS DO FUNCIONARIO 01: " +this.nome);
       
   }
   

    
}