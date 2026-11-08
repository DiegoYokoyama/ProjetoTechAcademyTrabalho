package Teste;

import Dominio.Egresso;
import Servico.EgressoSrv;

public class EgressoTest extends AbsTest {

    private EgressoSrv srv = new EgressoSrv();

    @Override
    public void executar() {
        System.out.println("===== Teste Egresso =====");

        int inicial = srv.Listar().size();
        verificar("Carga inicial com no mínimo 3 registros", inicial >= 3);

        System.out.println("-- Listar");
        for (Egresso e : srv.Listar()) {
            e.exibir();
        }

        System.out.println("-- Buscar");
        Egresso achado = srv.Buscar(201);
        verificar("Buscar código 201 retorna Carla Mendes",
            achado != null && achado.getNome().equals("Carla Mendes"));
        verificar("Buscar código inexistente retorna null", srv.Buscar(999) == null);

        System.out.println("-- Incluir");
        Egresso novo = srv.Incluir(new Egresso(0, "Novo Egresso", "99988877700", 2024, "Ciência da Computação", "IA"));
        verificar("Incluir gera código novo (> 0)", novo.getCodigo() > 0);
        verificar("Lista cresceu em 1", srv.Listar().size() == inicial + 1);

        System.out.println("-- Alterar");
        Egresso paraAlterar = srv.Buscar(novo.getCodigo());
        paraAlterar.setAreaAtuacao("Ciência de Dados");
        srv.Alterar(paraAlterar);
        verificar("Área de atuação foi alterada",
            srv.Buscar(novo.getCodigo()).getAreaAtuacao().equals("Ciência de Dados"));

        System.out.println("-- Excluir");
        srv.Excluir(srv.Buscar(novo.getCodigo()));
        verificar("Registro excluído não é mais encontrado", srv.Buscar(novo.getCodigo()) == null);
        verificar("Lista voltou ao tamanho inicial", srv.Listar().size() == inicial);

        resumo("EgressoTest");
    }

    public static void main(String[] args) {
        new EgressoTest().executar();
    }
}
