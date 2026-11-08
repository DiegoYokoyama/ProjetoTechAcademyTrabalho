package Visao;

import java.util.Scanner;

import Dominio.Colaborador;
import servico.ColaboradorSrv;

public class ColaboradorMenu extends AbsMenu{

    private ColaboradorSrv servico;

    private Colaborador colab;

    public void executar() {
        int opcao = 0;
        while (opcao != 9) {
            System.out.println("\n\n");
            opcao = this.exibirMenuPrincipal("COLABORADOR");
            switch (opcao) {
                case 1:
                    this.exibirTabela();
                    break;
                case 2:
                    this.pesquisarPorCodigo();
                    break;
                case 3:
                    this.incluir();
                    break;
                case 4:
                    this.alterar();
                    break;
                case 5:
                    this.excluir();
                    break;
                case 9:
                    System.out.println("Tchau!!!");
                default:
                    break;
            }
        }
    }
   
    private void exibirTabela(){
        System.out.println("\n\n");
        System.out.println("***** LISTAR COLABORADOR *****");
        for (Colaborador item : this.servico.Listar()) {
            item.exibir();
        }
    }

    private void pesquisarPorCodigo(){
        System.out.println("\n\n");
        System.out.println("***** PESQUISAR COLABORADOR POR CÓDIGO *****");
        System.out.print("Informe um código: ");
        int codigo = this.scan.nextInt();
        this.scan.nextLine();
        this.colab = this.servico.Buscar(codigo);
        this.colab.exibir();
    }

    private void incluir(){
        System.out.println("\n\n");
        System.out.println("***** INCLUIR *****");
        System.out.print("Nome: ");
        String nome = this.scan.nextLine();
        System.out.print("CPF: ");
        String cpf = this.scan.nextLine();
        System.out.print("Cargo: ");
        String cargo = this.scan.nextLine();
        Colaborador novo = new Colaborador(0, nome, cpf, cargo);
        novo = this.servico.Incluir(novo);
        novo.exibir();
    }

    private void alterar(){
        System.out.println("\n\n");
        System.out.println("***** ALTERAR *****");
        this.pesquisarPorCodigo();
        int escolha = 0;
        while (escolha != 9) {
            System.out.println("1 - Trocar o nome");
            System.out.println("2 - Trocar o CPF");
            System.out.println("3 - Trocar o Cargo");
            System.out.println("9 - Salvar");
            escolha = this.scan.nextInt();
            this.scan.nextLine();
            switch (escolha) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = this.scan.nextLine();
                    this.colab.setNome(nome);
                    break;
                case 2:
                    System.out.print("CPF: ");
                    String cpf = this.scan.nextLine();
                    this.colab.setCpf(cpf);
                    break;
                case 3:
                    System.out.print("Cargo: ");
                    String cargo = this.scan.nextLine();
                    this.colab.setCargo(cargo);
                    break;
                case 9:
                    this.colab = this.servico.Alterar(this.colab);
                    this.colab.exibir();
                default:
                    break;
            }
        }
    }

    private void excluir(){
        System.out.println("\n\n");
        System.out.println("***** EXCLUIR *****");
        this.pesquisarPorCodigo();
        this.colab = this.servico.Excluir(this.colab);
        this.colab.exibir();
    }

    public ColaboradorMenu(){
        this.scan = new Scanner(System.in);
        this.servico = new ColaboradorSrv();
    }
}
