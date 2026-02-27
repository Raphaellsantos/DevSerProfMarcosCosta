/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package packageExercicioMetodos;

/**
 *
 * @author rapha
 */
public class TestaFuncionario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //CRIANDO OS OBJETOS
        
        Funcionario f1 = new Funcionario();
        Funcionario f2 = new Funcionario();
      
        //INSERINDO VALORES
        
        f1.nome = "Raphael Guilherme";
        f1.salario = 2690.27;
        f1.idade = "30 anos";
        
        f2.nome = "Kaike Rodrigues";
        f2.salario = 2480.86;
        f2.idade = "32 anos";
        
        System.out.println ("FUNCIONARIO 01: " +f1.nome);
        System.out.println ("SALARIO: " +f1.salario);
        System.out.println ("IDADE: " +f1.idade);
        
        
        System.out.println ("FUNCIONARIO 02: " +f2.nome);
        System.out.println ("SALARIO: " +f2.salario);
        System.out.println ("IDADE: " +f2.idade);
        
        
        //AUMENTO DO SALARIO
        
       f1.aumSalario(350.54);
       
       System.out.println ("O FUNCIONARIO RAPHAEL TEVE UM AUMENTO DO SALARIO DE R$ 350,54");
       
       
       // DADOS DE UM FUNCIONARIO
       
       f1.dadosFunc();
       
       //MONSTRANDO DA TELA INFORMAÇÕES ATUALIZADAS DE UM FUNCIONARIO
       
       System.out.println ("IDADE: " +f1.idade);
       System.out.println("SALARIO POS AUMENTO: "+f1.salario);
       
        
        
        
    }
    
  
    
}
