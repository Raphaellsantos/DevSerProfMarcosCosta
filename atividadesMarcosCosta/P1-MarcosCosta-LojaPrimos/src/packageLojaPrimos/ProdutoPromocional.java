
package packageLojaPrimos;

//Produto promocional herdando atributos de Produto
    public class ProdutoPromocional extends Produto{
    
//atributo exclusivo dessa classe
    private double descontoFabrica;
    


    public double getDescontoFabrica() { 
        return descontoFabrica;
    }
    
    public void setDescontoFabrica(double descontoFabrica) { 
        this.descontoFabrica = descontoFabrica; 
    }


    
    

// Reescrita, aplica o desconto de fábrica 
    @Override
    public double calcularPrecoFinal() {
        return getPrecoBase() - descontoFabrica;
    }

// Reescrita da Sobrecarga, desconto de fábrica + frete funcionem juntos
    @Override
    public double calcularPrecoFinal(double frete) {
        return (getPrecoBase() - descontoFabrica) + frete;
    }
    
}
