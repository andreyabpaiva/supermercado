package identidades;

public final class Caixa extends Funcionario  {

    public Caixa() {
        super();
    }

    public Caixa(String nome, double salario,double proventos , double descontos) {
        super(nome, salario);
        this.proventos=proventos;
        this.descontos=descontos;
    }


    @Override
    public String toString() {
        StringBuilder bd = new StringBuilder();
        bd.append("---------------------------\n");
        bd.append("DADOS DO CAIXA\n");
        bd.append("---------------------------\n");
        bd.append("Nome: "+getNome()+"\n");
        bd.append("Salário base: "+getSalario()+"\n");
        bd.append("Salário final: "+calcularSalario()+"\n");
        bd.append("--------------------------------------\n");
        return bd.toString();
}
}

