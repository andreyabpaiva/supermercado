package desenvolvimento;

import identidades.Caixa;
import identidades.Funcionario;
import identidades.Gerente;
import identidades.Produto;
import identidades.Venda;
import enumerados.Status;
import enumerados.TipoPagamento;
import repositories.implementations.FakeVendaRepository;
import serviços.Bandeira;
import serviços.Visa;
import serviços.MasterCard;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private static final Scanner sc = new Scanner(System.in);
    static int opcao = 0;
    static int numeroVenda = 0;
    static char subMenu;
    static String nomeCaixa = "";
    static double salariobaseCaixa = 0;
    static double salariobaseGerente = 0;
    static double proventosCaixa = 0;
    static double descontosCaixa = 0;
    static String nomeGerente = "";
    static double proventosGerente = 0;
    static double descontosGerente = 0;
    static double comissaoGerente = 0;
    static double funcionario = 0;
    static int quantidadeProduto = 0;
    static double preçoUnitario = 0;
    static String nomeProduto = "";
    static int formaPagamento = 0;
    static int setor;
    static int repeticao = 0;
    static int contador = 1;
    static String Log = "";

    public static void sobre() {
        System.out.println("\n+--------------------------------------------------------+\n");
        System.out.println("|SUPERMERCADO LTDA                                         |\n");
        System.out.println("+----------------------------------------------------------+\n");
    }

    public static void menu() {
        System.out.println("MENU DE OPÇÕES ");
        System.out.println("");
        System.out.println("1 - Realizar Venda, emitir cupom fiscal  " +
                "\n2 - Mostrar Salários dos Funcionários  " +
                "\n3 - Histórico de vendas " +
                "\n4 - Sobre o Programa " +
                "\n5 - Sair");

    }

    public static void main(String[] args) throws ParseException {
        do {
            while (repeticao != -1) {
                menu();
                System.out.println("Informe a opção: ");
                opcao = sc.nextInt();

                switch (opcao) {
                    case 1:
                        realizarVendaCupom();
                        break;
                    case 2:                   // Mostrar Salários dos Funcionários
                        mostrarSalarioDosFuncionarios();
                        break;
                    case 3:
                        mostrarHistoricoDeVendas();
                        break;
                    case 4:
                        sobre();
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("Opção Inválida\n");
                        break;
                }

                if (opcao == 5) break;

                System.out.println("Deseja abrir o Menu de Opções Novamente ? ");
                System.out.println("(1) Sim (-1)Não");

                repeticao = sc.nextInt();

                if (repeticao == -1) break;
            }

            if (repeticao == -1) break;
        } while (opcao != 5);

        System.out.println("Programa Finalizado");

    }

    public static void mostrarHistoricoDeVendas() {
        List<Venda> vendaList = FakeVendaRepository.I.findAll();

        for (Venda venda : vendaList) {
            System.out.println(venda);
            System.out.println("----------------------------------------------------\n");
        }
    }

    public static void mostrarSalarioDosFuncionarios() {
        System.out.println("Deseja acessar Informações do Caixa(1) ou Gerente(2)? ");
        funcionario = sc.nextInt();

        if (funcionario == 1) {
            System.out.println("Informe a matricula do Caixa: ");
            System.out.println("Informe o nome do Caixa: ");
            nomeCaixa = sc.next();
            System.out.println("Informe o salário base do Caixa: ");
            salariobaseCaixa = sc.nextDouble();
            System.out.println("Informe o valor dos Proventos para o Caixa: ");
            proventosCaixa = sc.nextDouble();
            System.out.println("Informe o valor dos Descontos para o Caixa: ");
            descontosCaixa = sc.nextDouble();
            Funcionario caixa = new Caixa(nomeCaixa, salariobaseCaixa, proventosCaixa, descontosCaixa);
            System.out.println(caixa);
        } else if (funcionario == 2) {
            System.out.println("Informe a matricula do Gerente: ");
            System.out.println("Informe o nome do Gerente: ");
            nomeGerente = sc.next();
            System.out.println("Informe o salário base do Gerente: ");
            salariobaseGerente = sc.nextDouble();
            System.out.println("Informe o valor dos Proventos para o Gerente: ");
            proventosGerente = sc.nextDouble();
            System.out.println("Informe o valor dos Descontos para o Gerente: ");
            descontosGerente = sc.nextDouble();
            System.out.println("Informe o valor da Comissão do gerente: ");
            comissaoGerente = sc.nextDouble();
            Funcionario gerente = new Gerente(nomeGerente, salariobaseGerente, comissaoGerente, proventosGerente, descontosGerente);
            System.out.println(gerente);
        } else {
            System.out.println("Opção Inválida");
        }
    }

    public static void verificarBandeira() {
        Bandeira visa = new Visa();
        Bandeira masterCard = new MasterCard();

        do {
            System.out.println("Selecione o cartão : \n[v]Visa.  \n[m]MasterCard.");
            subMenu = sc.next().toLowerCase().charAt(0);

            if (subMenu == 'v') {
                System.out.println("Informe o setor para o cartão visa: ");
                setor = sc.nextInt();
                System.out.println(visa.verificarBandeira(setor));
                break;
            } else if (subMenu == 'm') {
                System.out.println("Informe o setor para o cartão MasterCard: ");
                setor = sc.nextInt();
                System.out.println(masterCard.verificarBandeira(setor));
                break;
            } else {
                System.out.println("Opção Inválida");
            }
        } while (true);
    }

    public static void realizarVendaCupom() throws ParseException {
        System.out.println("Número da Venda: ");
        numeroVenda = sc.nextInt();

        System.out.println("Data da Venda: ");
        String datar = sc.next();

        TipoPagamento tipo = null;
        Date data = sdf.parse(datar);

        do {
            System.out.println("Tipo de Pagamento (1) DINHEIRO, (2) VISTA, (3)CREDITO, (4)DEBITO, (5)CHEQUE : ");
            formaPagamento = sc.nextInt();

            if (formaPagamento == 1) {
                tipo = TipoPagamento.valueOf("DINHEIRO");
            }
            if (formaPagamento == 2) {
                tipo = TipoPagamento.valueOf("ÀVISTA");
            }
            if (formaPagamento == 3) {
                tipo = TipoPagamento.valueOf("CRÉDITO");
                verificarBandeira();
            }
            if (formaPagamento == 4) {
                tipo = TipoPagamento.valueOf("DÉBITO");
            }
            if (formaPagamento == 5) {
                tipo = TipoPagamento.valueOf("CHEQUE");
            }
            if (formaPagamento == 0 || formaPagamento >= 6) {
                System.out.println("Digito inválido");
            }

        } while (formaPagamento <= 0 || formaPagamento >= 6);

        Venda venda = new Venda(numeroVenda, data, tipo, Status.INICIANDO);

        do {
            System.out.println("Produto Número: " + contador);
            System.out.println("Quantidade: (Digite -1 para Finalizar)");
            quantidadeProduto = sc.nextInt();

            if (quantidadeProduto == -1) {
                break;
            }

            System.out.println("Preço Unitário: ");
            preçoUnitario = sc.nextDouble();
            System.out.println("Nome do Produto: ");
            nomeProduto = sc.next();

            Produto Produto = new Produto(contador, nomeProduto, quantidadeProduto, preçoUnitario);
            venda.adicionarItem(Produto);
            venda.setStatus(Status.PROCESSANDO);
            contador++;
        }
        while (quantidadeProduto != -1);

        System.out.println(venda);

        venda.setStatus(Status.FINALIZANDO);

        FakeVendaRepository.I.create(venda);

    }
}
