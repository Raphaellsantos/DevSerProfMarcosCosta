
package newpackageLoginJava;

/* 
importação de todas as bibliotecas utilizadas nessa classe
*/

import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;


public class TelaCadastro extends JFrame{    
    //Declaração dos atributos de tela
    
    private final JPanel tela;
    private final JTextField txtNome;
    private final JTextField txtUsuario;
    private final JPasswordField passSenha;
    private final JPasswordField passConfSenha;
    
    //Validação de cadastro e usuario corretos
    private boolean usuarioValido;
    private boolean cadastroValido;
    
    
    //String de mensagem
    private String mensagemJoption;
    private int mensagemTipo = 0;
    
    
    //Metodo construtor da classe
    
    public TelaCadastro(){
        setLocationRelativeTo (null);
        setResizable(false);
        setTitle ("CADASTRO");
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setBounds (500, 200, 426, 230);
        
        tela = new JPanel();
        tela.setBackground(SystemColor.orange);
        
        setContentPane(tela);
        tela.setLayout(null);
        
        //Adicionando elementos na tela :
        
        JLabel lblIdentificacao = new JLabel ("INFORMAR CAMPOS PARA CADASTRO");
        lblIdentificacao.setBounds(60, 0, 500, 39);
        lblIdentificacao.setFont(new Font ("Calibri", 3, 19));
        tela.add(lblIdentificacao); //adicionando o meu label no Panel
        
        JLabel lblNome = new JLabel ("NOME");
        lblNome.setBounds(24, 50, 70, 15);
        tela.add(lblNome);
        
        txtNome = new JTextField ();
        txtNome.setBounds(170, 50, 219, 19);
        tela.add(txtNome);
        txtNome.setColumns (10);
        
        JLabel lblUsuario = new JLabel ("USUARIO");
        lblUsuario.setBounds(24, 75, 70, 15);
        tela.add(lblUsuario);
        
        txtUsuario = new JTextField ();
        txtUsuario.setBounds(170, 75, 219, 19);
        tela.add(txtUsuario);
        txtUsuario.setColumns (10);
        
        JLabel lblsenha = new JLabel ("SENHA");
        lblsenha.setBounds(24, 100, 70, 15);
        tela.add(lblsenha);
        
        passSenha = new JPasswordField();
        passSenha.setBounds(170, 100, 219, 19);
        tela.add(passSenha);
        
        JLabel lblconfsenha = new JLabel ("CONFIRMAR SENHA");
        lblconfsenha.setBounds(24, 125, 100, 15);
        tela.add(lblconfsenha);
        
        passConfSenha = new JPasswordField();
        passConfSenha.setBounds(170, 125, 219, 19);
        tela.add(passConfSenha);
        
        JButton btnCadastrar = new JButton ("CADASTRAR");
        btnCadastrar.setBounds(200, 156, 117, 25);
        tela.add(btnCadastrar);
        
        //ação do botão cadastrar usuario na base de dados
        btnCadastrar.addActionListener((ActionEvent e) ->{  
            try{
                
                //Instancio o objeto usuario
                Usuario usu = new Usuario();
                
                //relizando os setters dos dados de tela
                usu.setNome (txtNome.getText());
                usu.setUsuario(txtUsuario.getText());
                usu.setSenha(passSenha.getText());
                
                //Validaçõs de preenchimento de dados
                if("".equals(usu.getNome())){
                    mensagemJoption = "Campo nome do usuario precisa ser informado!";
                    mensagemTipo = 0;
                
                }else if("".equals(usu.getUsuario())){
                    mensagemJoption = "O campo usuario precisa ser informado";
                    
                }else if ("".equals(usu.getSenha())){
                    mensagemJoption = "O campo senha precisa ser informado";
                    mensagemTipo = 0;
                    
                }else if(!usu.getSenha().equals(passConfSenha.getText())){
                    mensagemJoption = "Campo senha e confirmação de senha não coincidem";
                    mensagemTipo = 0;
                    
                }else if (usu.verificaPadraoSenha(usu.getSenha()) == false ){
                    mensagemJoption = "O campo usuario é maior que 10 caracteres!";
                    mensagemTipo = 0;
                }else{
                    //Verifico se somente o usuario consta no banco
                    //nesse campo, faremos uma sobrecarga do método
                    usuarioValido = usu.verificaUsuario(usu.getUsuario());
                    
                    if (usuarioValido == true){
                      //caso exista, não pode ser colocado na base
                      mensagemJoption = "Usuario já existe na base de dados";
                      mensagemTipo = 0;
                      
                    }else{
                        cadastroValido = usu.cadastraUsuario(usu.getNome(),
                                                             usu.getUsuario(),
                                                             usu.getSenha ());
                        
                    if (cadastroValido == true){
                      //Usuário cadastrado na base de dados
                      mensagemJoption = "Usuario cadastrado corretamente";
                      mensagemTipo= 1;
                      
                    }else{
                        //algum erro aconteceu
                        mensagemJoption = "Problemas ao inserir usuario!";
                        mensagemTipo = 0;
                    } 
                        
                        
                }     
           }    
            
            
            //mostrar a mensagem referida
            JOptionPane.showMessageDialog(null,
                    mensagemJoption, "Atenção" , mensagemTipo );
           
            if (mensagemTipo == 1){
                //Voltamos para tela login
                TelaLogin tLogin = new TelaLogin();
                tLogin.abreTela();
                
                //fecho a tela cadastro
                dispose();
                
            }
        }catch (HeadlessException ec) {
                System.out.println("Erro no cadastro do usuario"
                            + ec.getMessage());
                }        
                
        });  
        
        
        
        
        JButton btnCancelar = new JButton ("CANCELAR");
        btnCancelar.setBounds(50, 156, 117, 25);
        tela.add(btnCancelar);
        
         btnCancelar.addActionListener((ActionEvent e) -> {
            TelaLogin tLogin = new TelaLogin ();
            tLogin.abreTela();
            dispose();

         });
        
    }
    
   
        
     public void abreTela(){
         TelaCadastro PanelCadastro = new TelaCadastro();
         PanelCadastro.setVisible (true);
         
     }
        
    
        
        
        
        
}       
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
  
    
    
    
    
    
    
    
