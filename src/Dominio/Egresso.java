package Dominio;

public class Egresso extends AbsPessoa {
    private int anoConclusao;
    private String cursoFormacao;
    private String areaAtuacao;

    public int getAnoConclusao() {
        return anoConclusao;
    }

    public void setAnoConclusao(int anoConclusao) {
        this.anoConclusao = anoConclusao;
    }

    public String getCursoFormacao() {
        return cursoFormacao;
    }

    public void setCursoFormacao(String cursoFormacao) {
        this.cursoFormacao = cursoFormacao;
    }

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }

    @Override
    public void exibir() {
        System.out.println("[Egresso] Código: " + this.codigo);
        System.out.print("Nome: " + this.nome);
        System.out.print(" | CPF: " + this.cpf);
        System.out.print(" | Conclusão: " + this.anoConclusao);
        System.out.print(" | Curso: " + this.cursoFormacao);
        System.out.println(" | Área de atuação: " + this.areaAtuacao);
    }

    public Egresso() {}

    public Egresso(int codigo, String nome, String cpf,
        int anoConclusao, String cursoFormacao, String areaAtuacao) {
        super(codigo, nome, cpf);
        this.anoConclusao = anoConclusao;
        this.cursoFormacao = cursoFormacao;
        this.areaAtuacao = areaAtuacao;
    }
}
