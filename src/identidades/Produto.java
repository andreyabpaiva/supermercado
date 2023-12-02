package identidades;
public class Produto {
    private int numero;
    private String nome;
    private int quantidade;
    private  Double precoUnitario;

    public Produto(int numero, String nome, int quantidade, Double precoUnitario) {
        this.numero = numero;
        this.nome = nome;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    public Produto() {
        this.numero=0;
        this.nome="";
        this.quantidade=0;
        this.precoUnitario=0.0;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(Double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public double subTotal () {
    return precoUnitario * quantidade;
    }
    
    @Override
    public String toString() {
        StringBuilder bd = new StringBuilder();
        bd.append(numero+" - "+nome+" R$"+precoUnitario+" x " +quantidade+ " = R$"+subTotal());
        return bd.toString();
    }  
}
