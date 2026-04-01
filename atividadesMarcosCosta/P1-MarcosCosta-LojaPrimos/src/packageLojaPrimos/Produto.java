
package packageLojaPrimos;


//sistema de reconhecimento de forma de pagamento e adição de frete se aplicavel,

public class Produto {
    
// Atributos Privados (Encapsulamento e Visibilidade)
    private String nome;
    private String marca;
    private double precoBase;
    private String promocional;
    private double desconto;
    private int estoque;
    
 
//metodo construtor
    public Produto() {
    promocional = "Produto comum";
    
}    
    
    
    

// Encapsulamento getters e setters
    public String getNome() { 
        return nome; 
    }
    
    public void setNome(String nome) { 
        this.nome = nome; 
    }

    public double getPrecoBase() { 
        return precoBase; 
    }
    
    public void setPrecoBase(double precoBase) {
        this.precoBase = precoBase; 
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

        public String getPromocional() {
        return promocional;
    }

    public void setPromocional(String promocional) {
        this.promocional = promocional;
    }

    public double getDesconto() {
        return  desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto =  desconto;
    }
    
    
    
    
//metodo para controlar o estoque
    public double getQuantidadeEstoque() {
        return estoque;
    }

    public void setQuantidadeEstoque(int estoque) {
        if(estoque >= 0) this.estoque = estoque;
        this.estoque = estoque;
    }
    
    
    
// Método para diminuir o estoque
    public void baixarEstoque() {
        if (this.estoque > 0) {
            this.estoque--;
        }
        
        
    
    }
    
    
    
// Método Simples
    public double calcularPrecoFinal() {
        return this.precoBase;
    }
    
// Sobrecarga do Método
    public double calcularPrecoFinal(double frete) {
        return this.precoBase + frete -desconto; 
    }
}
