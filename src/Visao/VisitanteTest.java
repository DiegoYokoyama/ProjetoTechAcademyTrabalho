package Visao;

import Dominio.Visitante;
import servico.VisitanteSrv;

public class VisitanteTest extends AbsTest {

    private VisitanteSrv srv = new VisitanteSrv();

    @Override
    public void executar() {
        System.out.println("===== Teste Visitante =====");

        int inicial = srv.Listar().size();
        verificar("Carga inicial com registros", inicial >= 3);

        System.out.println("-- Listar");
        for (Visitante v : srv.Listar()) {
            v.exibir();
        }

        System.out.println("-- Buscar");
        Visitante achado = srv.Buscar(302);
        verificar("Buscar código 302 retorna Marcos Vieira",
            achado != null && achado.getNome().equals("Marcos Vieira"));
        verificar("Buscar código inexistente retorna null", srv.Buscar(999) == null);

        System.out.println("-- Incluir");
        Visitante novo = srv.Incluir(new Visitante(0, "Novo Visitante", "99988877711",
            "novo@email.com", "67990000000", "Rua Nova, 1", "Entrega", 99, "Portaria"));
        verificar("Incluir gera código novo (> 0)", novo.getCodigo() > 0);
        verificar("Lista cresceu em 1", srv.Listar().size() == inicial + 1);

        System.out.println("-- Alterar");
        Visitante paraAlterar = srv.Buscar(novo.getCodigo());
        paraAlterar.setSetorVisita("Financeiro");
        paraAlterar.setCrachaNumero(100);
        srv.Alterar(paraAlterar);
        Visitante conferido = srv.Buscar(novo.getCodigo());
        verificar("Setor e crachá foram alterados",
            conferido.getSetorVisita().equals("Financeiro") && conferido.getCrachaNumero() == 100);

        System.out.println("-- Excluir");
        srv.Excluir(srv.Buscar(novo.getCodigo()));
        verificar("Registro excluído não é mais encontrado", srv.Buscar(novo.getCodigo()) == null);
        verificar("Lista voltou ao tamanho inicial", srv.Listar().size() == inicial);

        resumo("VisitanteTest");
    }

    public static void main(String[] args) {
        new VisitanteTest().executar();
    }
}
