
package packageLojaPrimos;


public class SistemaPagamento extends Produto {
    
    
    
    
// método para vender
    public void processarVenda(Produto p, String formaPagamento, double valorFrete) {
        
        //subtrai um produto do estoque assim que realizar a venda 
        p.baixarEstoque();
        
            String detalhe = "Pagamento debito";
        
        
//metodo para calcular frete. 
        double valorComFrete = p.calcularPrecoFinal(valorFrete);
        
         
 
// regra para o estoque, controlando a possibilidade de venda 

        if (p.getQuantidadeEstoque() <=0){
            System.out.println("!! VENDA CANCELADA !!");
            System.out.println("" +p.getNome() + "  Esgotou em estoque\n");
            return;
        }
        
        
         
        

// regra para Pix (Desconto de 10% sobre o valor total com frete)
        if (formaPagamento.equalsIgnoreCase("pix")) {
            double desconto = valorComFrete * 0.10;
            valorComFrete = valorComFrete - desconto;
            detalhe = "Desconto PIX (10%): -R$ " + desconto;
            
        } 
// regra para Cartão (Taxa de 2% sobre o valor total com frete)
        else if (formaPagamento.equalsIgnoreCase("credito")) {
            double taxa = valorComFrete * 0.02 ;
            valorComFrete = valorComFrete + taxa ;
            detalhe = "Taxa Credito (2%): +R$ " + taxa;
        }
        
        

        
// imprimindo os dados da compra na tela 
        
        System.out.println("======== CUPOM FISCAL ========");
        
        System.out.println("STATUS: " +p.getPromocional());
        System.out.println("PRODUTO: " + p.getNome());
        System.out.println("MARCA: " +p.getMarca());
        System.out.println("PRECO BASE: R$ " +p.getPrecoBase());
        System.out.println("DESCONTO:  " +p.getDesconto());
        System.out.println("ESTOQUE : " +p.getQuantidadeEstoque());
        System.out.println("FRETE: R$ " +valorFrete);
        System.out.println("SITUACAO: " +detalhe);
        System.out.println("TOTAL A PAGAR: R$ " + valorComFrete );
        System.out.println("==============================\n");
    }
    
    
    
    
    
    }


    
    
   
    

