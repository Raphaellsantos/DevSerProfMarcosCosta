
package packageLojaPrimos;


public class TesteLoja {

  
    public static void main(String[] args) {
        

// Criando o sistema de pagamento 
        SistemaPagamento caixa = new SistemaPagamento();

//Criando objetos 
        
        Produto cimento = new Produto();
        Produto prego = new Produto();
        Produto ferro = new Produto();
        
        
        cimento.setNome("Cimento  50kg");
        cimento.setMarca("Votoran");
        cimento.setPrecoBase(40.00);
        cimento.setQuantidadeEstoque(6);
        
        
        
        prego.setNome("Prego 18x27 - pct.1kg");
        prego.setMarca("FerazForte");
        prego.setPrecoBase(15.00);
        prego.calcularPrecoFinal(0);
        prego.setDesconto(0);
        prego.setQuantidadeEstoque(5);
        
        
        ferro.setNome("ferro 3/8");
        ferro.setMarca("FOrtin Metal");
        ferro.setPrecoBase(15.00);
        ferro.setQuantidadeEstoque(3);
        ferro.setDesconto(1);
        

        
        

//criando Produto Promocional com desconto de fabrica
        ProdutoPromocional tinta = new ProdutoPromocional();
        ProdutoPromocional rejunte = new ProdutoPromocional();
        ProdutoPromocional colherPedreiro = new ProdutoPromocional();
        
        
        
//produtos promocionais
        tinta.setPromocional("Produto-promocional");
        tinta.setNome("Tinta Premium");
        tinta.setMarca("Suvinil");
        tinta.setPrecoBase(200.00);
        tinta.setDescontoFabrica(30.00);
        tinta.setQuantidadeEstoque(6);
        
        
        rejunte.setPromocional("produto-Promocional");
        rejunte.setNome("Rejunte porcelanato");
        rejunte.setMarca("Quartzolit");
        rejunte.setPrecoBase(7.89);
        rejunte.setDescontoFabrica(1.89);
        rejunte.setQuantidadeEstoque(6);
        
        
        colherPedreiro.setPromocional("produto-Promocional");
        colherPedreiro.setNome("Paceta 2''");
        colherPedreiro.setMarca("ObraForte");
        colherPedreiro.setPrecoBase(13.90);
        colherPedreiro.setDescontoFabrica(3.0);
        colherPedreiro.setQuantidadeEstoque(6);
        

        
        
        
        

 // TESTE DE VENDAS 
 //reconhecendo desconto ou taxa apartir da forma de pagamento 
        
        caixa.processarVenda(tinta, "credito", 3);
        caixa.processarVenda(cimento, "pix", 3);
        caixa.processarVenda(prego, "pix", 2);
        caixa.processarVenda(prego, "Padrao", 0); //testando o cacelamento de produto mundando a forma de pagamento
        caixa.processarVenda(cimento, "PiX", 2);
        caixa.processarVenda(rejunte, "debito" , 2);
        caixa.processarVenda(ferro, "Pix", 0);
        caixa.processarVenda(colherPedreiro, "credito", 1);
        caixa.processarVenda(prego, "PiX", 1); //testando a sensibilidade da forma de pagamento
        caixa.processarVenda(cimento, "pix", 1);
        caixa.processarVenda(rejunte, "credito", 1);
        caixa.processarVenda(cimento, "debito", 1); //
        caixa.processarVenda(prego, "outro pagamento", 1); //testando outra forma de pagamento para cair no pagamento sem desconto ou taxa (padrão)
        caixa.processarVenda(rejunte, "Debito", 2); //com desconto já incluso no cadastro do produto, forma de pagamento sem desconto ou taxa
        
        
        
        
    }
    
    
    
    
    
}
