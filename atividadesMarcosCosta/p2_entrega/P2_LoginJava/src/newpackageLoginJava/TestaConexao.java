package newpackageLoginJava;


public class TestaConexao {
    
/*
Teste para verificar se o banco conecta e desconecta
*/

    public static void main(String[] args) {
        
        Conexao c = new Conexao (); //criando objeto conexão
        c.abrirConexao();  //chamando o metodo de abertura do bando de dados
        
        try{
            Thread.sleep(4000);  //fazendo uma pausa de 4 segundos
            c.fecharConexao(); //fechando a conexão
            
        }catch (InterruptedException ex){
            //mensagem caso ocorra o erro
            System.out.println("houve algum problema com o encerramento da conexao" + ex.getMessage());
        }
        
        
    }
    
}
