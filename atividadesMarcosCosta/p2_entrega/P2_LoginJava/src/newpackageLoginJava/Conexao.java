package newpackageLoginJava;

import java.sql.Connection; //Conexão com o banco de dados
import java.sql.DriverManager; //Driver de conexão, em nosso casso MySqL
import java.sql.ResultSet;// Resultado das operações em banco de dados
import java.sql.SQLException;
import java.sql.Statement; //Interpretação dos comandos  SQL - CRUD 


public class Conexao {
    //atributos de atributos ligadas as bibliotecas importadas
    
    public Connection con = null;
    public Statement stmt = null;
    public ResultSet resultset = null;
    
    //atributos de conexão
    
    private final String servidor =  "jdbc:mysql://127.0.0.1:3306/bd_login";
                                    //servidor de banco de dados
    private final String usuario = "root"; //Usuario de banco de dados
    private final String senha = ""; //Senha do banco de dados
    private final String driver = "com.mysql.cj.jdbc.Driver"; //Driver de conexão
    
    
    
    //Metodo de abertura da conexão com o banco de dados
    public Connection abrirConexao(){
        
        try{
            Class.forName(driver); //Driver de utilização
            
            //Atributos de conexão
            con = DriverManager.getConnection(servidor, usuario, senha);
            stmt = con.createStatement(); //fazendo conexão com o banco de dados
            
            System.out.println("Conexão aberta com sucesso"); //mensagem informando que a conexão foi realizada
            
        }catch (ClassNotFoundException | SQLException e){
            
            System.out.println("Erro ao acessar o banco, verifique! " +e.getMessage()); //mensagem de erro caso ocorra
            
        }
        return con; //retorna a conexão
     }
        
        
       //Metodo de fechamento da conexão do banco de dados 
        public void fecharConexao(){
            
            try{
                con.close ();  //fechamento da conexão com o bando de dados
                
                System.out.println("Conexão finalizada com sucesso");  //mensagem que fechou a conexão
                
            }catch (SQLException e){
                
                System.out.println("Erro ao encerrar conexão" +e.getMessage()); //mensagem de erro ao fechar a conexão
            
            
            }
            
        
    }
    
    
    
    
    
    
    
    
}
