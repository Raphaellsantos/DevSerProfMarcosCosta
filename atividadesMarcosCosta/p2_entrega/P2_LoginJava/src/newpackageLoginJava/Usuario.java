
package newpackageLoginJava;

import java.sql.SQLException; //Tratar a exceções no banco de dados


public class Usuario {
    
    //criação dos atributos privados da classe
    
    private String usuario;
    private String nome;
    private String senha;
    
    
   //Atributo que armazenrá o retorno do banco de dados
    private boolean resultUsuario;
    private boolean resultCadastro;
    
    private boolean resultadoPadraoSenha;
    
    static String nomeUsuario;
    static String usuarioSistema;
    
    private boolean resultAlteracao;
    private boolean resultExclusao;
    

    
    //criação dos getter e setters

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
      public boolean verificaPadraoSenha(String senha){
          
        //verifica o tamaho da senha 
          if (senha.length() < 10){
             resultadoPadraoSenha = true;
          }else{
             resultadoPadraoSenha = false;
          }

          return resultadoPadraoSenha;
      }
    
      
      
    //metodo de verificação da autenticidade do usuario
    public boolean verificaUsuario (String Usuario, String Senha) {
      //Fazer instância da conexão com o banco de dados;
        Conexao banco = new Conexao();
        
        try{
        
        //abrir conexao com o banco
        banco.abrirConexao();
        
        
        //criando parâmetro de retorno
        banco.stmt= banco.con.createStatement();
        
        //executando a consulta no banco de dados
        banco.resultset = 
                banco.stmt.executeQuery( " SELECT * FROM usuario"
                                        + " WHERE usuario = '" + usuario + "'"
                                        + " AND senha = md5 ('" + senha + "')");

        //Verificando se existe retorno do banco de dados   
        if (banco.resultset.next()) {
            //caso tenha
            resultUsuario = true;
            
            //setters em nome e usuario
            setNome(banco.resultset.getString(1));
            setUsuario(banco.resultset.getString(2));
            
            //nos atributos estaticos realizo atribuições
            nomeUsuario = getNome();
            usuarioSistema = getUsuario();

        }else{
            //Caso não tenha
            resultUsuario = false;
            
        }
        
        
        banco.fecharConexao();  //fecha a nossa conexão com o banco de dados
        
        }catch (SQLException ec)  {
            System.out.println (" ERRO AO CONSULTAR USUÁRIO " + ec.getMessage());
            
        }
        
        return  resultUsuario;
        
    }   
        
    
    
        //metodo de verificação do usuario, estamos aqui fazendo
        //uma sobrecarga de metodo

        public boolean verificaUsuario(String usuario){
            
            //Fazendo a instancia da conexão  com o banco de dados
            
            boolean resultUsuario = false;
            
            Conexao banco = new Conexao();
            
            try{
                
                banco.abrirConexao();
                
                //criando o parâmetro de retorno
                banco.stmt = banco.con.createStatement();
                
                //Executando a consulta do banco de dados
                banco.resultset = 
                        banco.stmt.executeQuery( " SELECT * FROM usuario "
                                                + " WHERE usuario = '" + usuario + "'");
                
                if(banco.resultset.next()){
                    //caso tenha
                    resultUsuario = true;

                }else{
                    //caso não tenha

                    resultUsuario = false;
                }

                    banco.fecharConexao(); // fecha nossa conexão com o banco de dados

            }catch (SQLException ec){
                System.out.println("Erro ao consulta usuario" + ec.getMessage());
            }
            
            
          return resultUsuario; 
          
        }
        
        //metodo para cadastro de usuario em nosso sistema
      public boolean cadastraUsuario (String nome, String usuario, String senha){
          
        Conexao banco = new Conexao ();
        
        try{
            //abertura da conexão no banco de dados
            banco.abrirConexao();

            
            //criando parametro de retorno
            banco.stmt = banco.con.createStatement();
            
            
            
            //executando as inserções de dados
            banco.stmt.execute(" INSERT INTO usuario (nome, usuario, senha)"
                    + " VALUES ('" + nome + "','" + usuario + "', md5('"
                    + senha + "'))");
            
            resultCadastro = true;
                                            
        }catch(SQLException ec){
            System.out.println("Erro ao inserir usuario" + ec.getMessage());
            resultCadastro = false;
            
        }
        
        return resultCadastro;
          
   
      }
      
      
    //metodo para alteração dos dados no nosso sistema
      public boolean alteraUsuario (String nome, String usuario, String senha){
          //fazer instancia da conexão com o banco de dados
          Conexao banco = new Conexao ();
          
          try{
              //abre a conexao com o banco de dados
              banco.abrirConexao();
              
             //criando o parâmetro de retorno
             banco.stmt = banco.con.createStatement();
             
            //Executando a alteração no banco de dados
            banco.stmt.execute (" UPDATE usuario SET nome = '" + nome +
                                "', senha = md5 ('" + senha + 
                                "') WHERE usuario = '" + usuario + "'");
            resultAlteracao = true;
            
          }catch (SQLException ec) {
              System.out.println("Erro ao atualizar o usuario" + ec.getMessage());
              resultAlteracao = false;
          }
          
          banco.fecharConexao();
          
          return resultAlteracao;
          
      }
      

      
    public boolean excluirUsuario (String usuario){
        //Fazer a instancia da conexão com o banco de dados
        
        Conexao banco = new Conexao();
        
        try{
            
            //Abro a conexão com o banco de dados
            banco.abrirConexao();
            
            //Criando parametro de retorno
            banco.stmt = banco.con.createStatement();
            
            //Executando a alteração no banco de dados
            banco.stmt.execute (" DELETE FROM usuario WHERE usuario = '"
                                + usuario + "'");
            
            //caso exclua
            resultExclusao = true;
            
        }catch (SQLException ec){
            System.out.println("Erro ao excluir usuario" + ec.getMessage());
            resultExclusao = false;
        }
        
        banco.fecharConexao();
        
        return resultExclusao;
        
    }  

    }

   

        
    


    