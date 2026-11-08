package Teste;

import Dominio.Estagiario;
import Servico.EstagiarioSrv;

public class EstagiarioTest extends AbsTest {

    private EstagiarioSrv srv = new EstagiarioSrv();

    @Override
    public void executar() {
        System.out.println("===== Teste Estagiario =====");

        int inicial = srv.Listar().size();
        verificar("Carga inicial com registros", inicial >= 3);

        System.out.println("-- Listar");
        for (Estagiario e : srv.Listar()) {
            e.exibir();
        }

        System.out.println("-- Buscar");
        Estagiario achado = srv.Buscar(402);
        verificar("Buscar código 402 retorna Camila Reis",
            achado != null && achado.getNome().equals("Camila Reis"));
        verificar("Buscar código inexistente retorna null", srv.Buscar(999) == null);

        System.out.println("-- Incluir");
        Estagiario novo = srv.Incluir(new Estagiario(0, "Novo Estagiário", "99988877722",
            "novo@email.com", "67990000001", "Rua Nova, 2", 1300.0, 25, "Redes"));
        verificar("Incluir gera código novo (> 0)", novo.getCodigo() > 0);
        verificar("Lista cresceu em 1", srv.Listar().size() == inicial + 1);

        System.out.println("-- Alterar");
        Estagiario paraAlterar = srv.Buscar(novo.getCodigo());
        paraAlterar.setValorBolsa(1500.0);
        paraAlterar.setCargaHorariaSemanal(30);
        srv.Alterar(paraAlterar);
        Estagiario conferido = srv.Buscar(novo.getCodigo());
        verificar("Bolsa e carga horária foram alteradas",
            conferido.getValorBolsa() == 1500.0 && conferido.getCargaHorariaSemanal() == 30);

        System.out.println("-- Excluir");
        srv.Excluir(srv.Buscar(novo.getCodigo()));
        verificar("Registro excluído não é mais encontrado", srv.Buscar(novo.getCodigo()) == null);
        verificar("Lista voltou ao tamanho inicial", srv.Listar().size() == inicial);

        resumo("EstagiarioTest");
    }

    public static void main(String[] args) {
        new EstagiarioTest().executar();
    }
}
