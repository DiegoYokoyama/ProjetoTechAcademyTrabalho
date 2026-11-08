package Teste;

public abstract class AbsTest {

    private int falhas = 0;

    protected void verificar(String descricao, boolean condicao) {
        if (condicao) {
            System.out.println("  [OK]     " + descricao);
        } else {
            System.out.println("  [FALHOU] " + descricao);
            this.falhas++;
        }
    }

    protected void resumo(String nome) {
        if (this.falhas == 0) {
            System.out.println(nome + ": todos os testes passaram.\n");
        } else {
            System.out.println(nome + ": " + this.falhas + " teste(s) falharam.\n");
        }
    }

    public abstract void executar();
}
