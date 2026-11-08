package Visao;

import java.util.Scanner;

import Dominio.Estagiario;
import servico.EstagiarioSrv;

public class EstagiarioMenu extends AbsMenu {

    private EstagiarioSrv servico;

    public void executar() {
        int opcao = 0;
        while (opcao != 6) {
            System.out.println("\n----- Menu [ESTAGIÁRIO] -----");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar todos");
            System.out.println("3 - Buscar por código");
            System.out.println("4 - Editar");
            System.out.println("5 - Excluir");
            System.out.println("6 - Sair");
            opcao = this.lerInt("Selecione uma opção: ");
            switch (opcao) {
                case 1:
                    this.cadastrar();
                    break;
                case 2:
                    this.listar();
                    break;
                case 3:
                    this.buscar();
                    break;
                case 4:
                    this.editar();
                    break;
                case 5:
                    this.excluir();
                    break;
                case 6:
                    System.out.println("Tchau!!!");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

    private void cadastrar() {
        System.out.println("\n***** CADASTRAR ESTAGIÁRIO *****");
        System.out.print("Nome: ");
        String nome = this.scan.nextLine();
        System.out.print("CPF: ");
        String cpf = this.scan.nextLine();
        System.out.print("E-mail: ");
        String email = this.scan.nextLine();
        System.out.print("Telefone: ");
        String telefone = this.scan.nextLine();
        System.out.print("Endereço: ");
        String endereco = this.scan.nextLine();
        double bolsa = this.lerDouble("Valor da bolsa: ");
        int carga = this.lerInt("Carga horária semanal: ");
        System.out.print("Área de estágio: ");
        String area = this.scan.nextLine();

        Estagiario novo = new Estagiario(0, nome, cpf, email, telefone, endereco, bolsa, carga, area);
        novo = this.servico.Incluir(novo);
        System.out.println("Cadastrado com sucesso:");
        novo.exibir();
    }

    private void listar() {
        System.out.println("\n***** LISTAR ESTAGIÁRIOS *****");
        if (this.servico.Listar().isEmpty()) {
            System.out.println("Nenhum estagiário cadastrado.");
            return;
        }
        for (Estagiario item : this.servico.Listar()) {
            item.exibir();
            System.out.println();
        }
    }

    private Estagiario pedirEBuscar() {
        int codigo = this.lerInt("Informe o código: ");
        Estagiario achado = this.servico.Buscar(codigo);
        if (achado == null) {
            System.out.println("Estagiário não encontrado.");
        }
        return achado;
    }

    private void buscar() {
        System.out.println("\n***** BUSCAR ESTAGIÁRIO POR CÓDIGO *****");
        Estagiario achado = this.pedirEBuscar();
        if (achado != null) {
            achado.exibir();
        }
    }

    private void editar() {
        System.out.println("\n***** EDITAR ESTAGIÁRIO *****");
        Estagiario atual = this.pedirEBuscar();
        if (atual == null) {
            return;
        }
        System.out.println("Dados atuais:");
        atual.exibir();

        int escolha = 0;
        while (escolha != 9) {
            System.out.println("\n1 - Nome");
            System.out.println("2 - CPF");
            System.out.println("3 - E-mail");
            System.out.println("4 - Telefone");
            System.out.println("5 - Endereço");
            System.out.println("6 - Valor da bolsa");
            System.out.println("7 - Carga horária semanal");
            System.out.println("8 - Área de estágio");
            System.out.println("9 - Salvar");
            escolha = this.lerInt("O que deseja alterar? ");
            switch (escolha) {
                case 1:
                    System.out.print("Nome: ");
                    atual.setNome(this.scan.nextLine());
                    break;
                case 2:
                    System.out.print("CPF: ");
                    atual.setCpf(this.scan.nextLine());
                    break;
                case 3:
                    System.out.print("E-mail: ");
                    atual.setEmail(this.scan.nextLine());
                    break;
                case 4:
                    System.out.print("Telefone: ");
                    atual.setTelefone(this.scan.nextLine());
                    break;
                case 5:
                    System.out.print("Endereço: ");
                    atual.setEndereco(this.scan.nextLine());
                    break;
                case 6:
                    atual.setValorBolsa(this.lerDouble("Valor da bolsa: "));
                    break;
                case 7:
                    atual.setCargaHorariaSemanal(this.lerInt("Carga horária semanal: "));
                    break;
                case 8:
                    System.out.print("Área de estágio: ");
                    atual.setAreaEstagio(this.scan.nextLine());
                    break;
                case 9:
                    Estagiario salvo = this.servico.Alterar(atual);
                    System.out.println("Alterado com sucesso:");
                    salvo.exibir();
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

    private void excluir() {
        System.out.println("\n***** EXCLUIR ESTAGIÁRIO *****");
        Estagiario atual = this.pedirEBuscar();
        if (atual == null) {
            return;
        }
        atual.exibir();
        System.out.print("Confirma a exclusão? (S/N): ");
        String resposta = this.scan.nextLine().trim();
        if (resposta.equalsIgnoreCase("S")) {
            this.servico.Excluir(atual);
            System.out.println("Estagiário excluído.");
        } else {
            System.out.println("Exclusão cancelada.");
        }
    }

    private int lerInt(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                return Integer.parseInt(this.scan.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido, digite um número inteiro.");
            }
        }
    }

    private double lerDouble(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                return Double.parseDouble(this.scan.nextLine().trim().replace(',', '.'));
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido, digite um número (ex: 1200.50).");
            }
        }
    }

    public EstagiarioMenu() {
        this.scan = new Scanner(System.in);
        this.servico = new EstagiarioSrv();
    }
}
