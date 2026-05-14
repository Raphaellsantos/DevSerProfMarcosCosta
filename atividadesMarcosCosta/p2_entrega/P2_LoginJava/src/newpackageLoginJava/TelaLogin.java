
package newpackageLoginJava;

/*
importação de todas as bicliotecas que estou utilizando na classe
*/ 

import java.awt.Font; //  Trabalhar com fontes
import java.awt.SystemColor; //Trabalhar com cores
import javax.swing.JButton; //Trabalhar com botões
import javax.swing.JFrame; //Trabalhar com frames
import javax.swing.JLabel; //Trabalhar com labels (rotulos)
import javax.swing.JPanel; //Trabalhar com painéis
import javax.swing.JPasswordField; //Trabalhar com campos de senha
import javax.swing.JTextField; //Trabalhar com campos de texto

import java.awt.event.ActionEvent; //trabalhar com evento
import javax.swing.JOptionPane; //trabalhar com mensagens




public class TelaLogin extends JFrame {
    
    //tela obeto Jpanel (tela em si)
    private final JPanel panelTela;
    
    //txtusuario obeto JtextField (campo na tela)
    private final JTextField txtUsuario;
    
    //psSenha Objeto PasswordField (campo de tela)
    private final JPasswordField pswSenha;
    
    
    //validar se o usuario é correto
    private boolean usuarioValido;
    
    //Metodo construtor
    public TelaLogin(){
            
    //coloca o objeto na referencia do centro da tela
    setLocationRelativeTo (null);
   
    //não permite que o obeto seja expandido
    setResizable(false);
    
    //coloca titulo na caixa JFrame
    setTitle ("IDENTIFICAÇÃO");
    
    //quando clicado no X eu encerro todo o programa
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    //define o posicionamento e tamanho
    //         x    y   width  height
    setBounds(500, 200, 426, 212);
    
    //crio um objeto JPanel e atribuo ele a variavel tela
    panelTela = new JPanel();
    
    //define a cor de fundo do JPanel (tela)
    panelTela.setBackground(SystemColor.orange);
    setContentPane(panelTela);
    
    //vou utilizar meu panel sem utilizar o padrão
    panelTela.setLayout(null);
    
    //adicionando elementos na tela:
    //criando um objeto do tipo JLabel e atribuindo o valor ao atributo
    JLabel lblIdentificacao = new JLabel("IDENTIFICAÇÃO");
    
    //localização na tela
    lblIdentificacao.setBounds (144, 0, 160,39);
    
    //Definindo a fonta
    lblIdentificacao.setFont (new Font("Calibri", 4, 19));
    
    //Adicionando o meu label ao meu Panel
    panelTela.add(lblIdentificacao);
    
    //identificação e posicionamento dos labels
    JLabel lblUsuario = new JLabel ("USUARIO");
    lblUsuario.setBounds(24, 65, 70, 15);
    panelTela.add(lblUsuario);
    
    JLabel lblSenha = new JLabel ("SENHA");
    lblSenha.setBounds(24, 92, 70, 15);
    panelTela.add(lblSenha);
    
    //Identificação e Posicionamento doss texts fields
    txtUsuario = new JTextField();
    txtUsuario.setBounds(112, 63, 219, 19);
    panelTela.add(txtUsuario);
    txtUsuario.setColumns(10);
    
    pswSenha = new JPasswordField();
    pswSenha.setBounds(112, 90, 219, 19);
    panelTela.add(pswSenha);
    
    //Identificação e posicionamento dos botões
    JButton btnEntrar = new JButton("ENTRAR");
    btnEntrar.setBounds(200, 136, 117, 25);
    panelTela.add(btnEntrar);
     
    JButton btnCadastrar = new JButton("CADASTRAR");
    btnCadastrar.setBounds(60, 136, 117, 25);
    panelTela.add(btnCadastrar);
    
    //ação no botão para cadastrar usuario
    btnCadastrar.addActionListener((ActionEvent e) ->{
        //Instancio a classe tela cadastro
        TelaCadastro tCadastro = new TelaCadastro();
        tCadastro.abreTela();
        dispose();
        
        
    });
    
    
    
    //ação no botão entrar no sistema
    btnEntrar.addActionListener((ActionEvent e) ->{
        
        //instancio a classe a classe usuario
        Usuario usu = new Usuario();
        
        // Utilizo o setter do usuario e senha
        usu.setUsuario (txtUsuario.getText());
        usu.setSenha(pswSenha.getText());
        
        if ("".equals(txtUsuario.getText())){
        
        //Vamos dar uma mensagem na tela
        JOptionPane.showMessageDialog(null,
                "CAMPO USUARIO PRECISA SER INFORMADO !!",
                "ATENÇÃO",
                JOptionPane.ERROR_MESSAGE);
        
        //Voltar o cursor para o campo txtUsuario
        txtUsuario.grabFocus();
        
        }else if ("".equals(pswSenha.getText())){
        //vamos dar uma mensagem na tela
        JOptionPane.showMessageDialog(null,
            "CAMPO SENHA PRECISA SER INFORMADO !!",
            "ATENÇÃO",
        JOptionPane.ERROR_MESSAGE);
        //voltar o cursor para o campo txtSenha
        pswSenha.grabFocus();
        
        
    }else{
           
        //Verifico se o usuário consta no banco de dados
                usuarioValido = usu.verificaUsuario(usu.getUsuario(),
                        usu.getSenha());
        if (usuarioValido == true){
        //Usuario e senha bateram no banco e estão corretos
            JOptionPane.showMessageDialog(null,
                    "USUARIO VALIDO EM NOSSA BASE DE DADOS",
                    "ATENÇÃO",
                    JOptionPane.INFORMATION_MESSAGE);
            
            TelaInicio telaInicio = new TelaInicio ();
            telaInicio.AbreTela();
            
            dispose ();
            
        }else{
        //usuario e senha bateram no banco e estão incorretos
            JOptionPane.showMessageDialog(null,
                    "USUARIO INVALIDO OU INEXISTENTE",
                    "ATENÇÃO",
                    JOptionPane.ERROR_MESSAGE);
            
        
            
        //metodo para limpar o texto
        limpaText();
        
        //mando o foco para o campo usuario
        
        txtUsuario.grabFocus();
        }}});
                   
        
    } 
        
    
    public void abreTela(){
        TelaLogin tela = new TelaLogin ();
        tela.setVisible(true); 
        
    }
    
    public void limpaText(){
       txtUsuario.setText("");
       pswSenha.setText("");
    
    }
}





    
 
   
   
    
    
    
    
    
    
    
    
    
    
    
    
    
        
        
            
            
        

 
  
    
    
    
    
    
    

