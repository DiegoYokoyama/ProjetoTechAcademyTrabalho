package Visao;

import java.util.Scanner;

public abstract class AbsMenu {

    protected Scanner scan;

    protected int exibirMenuPrincipal(String dominio){
        System.out.println("----- Menu [" + dominio + "] -----");
        System.out.println("1 - Listar");
        System.out.println("2 - Pesquisar por Código");
        System.out.println("3 - Incluir");
        System.out.println("4 - Alterar");
        System.out.println("5 - Excluir");
        System.out.println("9 - Voltar");
        System.out.print("Selecione uma opção: ");
        int opcao = this.scan.nextInt();
        this.scan.nextLine();
        return opcao;
    }    
}
