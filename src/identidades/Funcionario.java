package identidades;

public abstract class Funcionario {
    protected String nome;
    protected double salario;
    protected double proventos;
    protected double descontos;
   
    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public double calcularSalario() {
        return salario+proventos-descontos;
    }
    public Funcionario(){
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getSalario() {
        return salario;
    }
    public void setSalario(int salario) {
        this.salario = salario;
    }
}