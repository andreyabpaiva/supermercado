package identidades;

import enumerados.Status;
import enumerados.TipoPagamento;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Venda {

  private int numero;
  private Date data;
  private TipoPagamento formaPagamento;

  public TipoPagamento getFormaPagamento() {
    return formaPagamento;
  }

  public void setFormPagament(TipoPagamento formaPagamento) {
    this.formaPagamento = formaPagamento;
  }

  SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
  private List<Produto> produtos = new ArrayList<>();
  Status status;

  public Venda() {
    this.numero = 0;
    this.data = null;
    this.formaPagamento = null;
    this.status = null;
  }

  public int getNumero() {
    return numero;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public SimpleDateFormat getSdf() {
    return sdf;
  }

  public void setSdf(SimpleDateFormat sdf) {
    this.sdf = sdf;
  }

  public List<Produto> getProdutos() {
    return produtos;
  }

  public void setItens(List<Produto> produtos) {
    this.produtos = produtos;
  }

  public Venda(
    Integer numero,
    Date data,
    TipoPagamento formaPagamento,
    Status status
  ) {
    this.numero = numero;
    this.data = data;
    this.formaPagamento = formaPagamento;
    this.status = status;
  }

  public void setNumero(Integer numero) {
    this.numero = numero;
  }

  public Date getData() {
    return data;
  }

  public void setData(Date data) {
    this.data = data;
  }

  public void adicionarItem(Produto produto) {
    produtos.add(produto);
  }

  public void removerItem(Produto produto) {
    produtos.remove(produto);
  }

  public double total() {
    double soma = 0;
    for (Produto item : produtos) {
      soma += item.subTotal();
    }

    return soma;
  }

  @Override
  public String toString() {
    StringBuilder bd = new StringBuilder();
    bd.append("======================\n");
    bd.append("DADOS DA VENDA : \n");
    bd.append("======================\n");
    bd.append("Número do pedido : " + numero + "\n");
    bd.append("Data do pedido : " + sdf.format(data) + "\n");
    bd.append("Status do pedido : " + Status.valueOf("IMPRIMINDO") + "\n");
    setStatus(Status.IMPRIMINDO);
    bd.append("Forma de pagamento : " + formaPagamento + "\n");
    bd.append("======================\n");
    bd.append("ITENS DA VENDA \n");
    bd.append("====================== \n");

    for (Produto item : produtos) {
      bd.append(item + "\n");
    }

    bd.append("======================\n");
    bd.append("Total da Venda : R$" + total() + "\n");
    bd.append("======================\n");
    status = Status.valueOf("FINALIZANDO");

    return bd.toString();
  }
}
