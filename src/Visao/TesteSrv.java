package Visao;

import Dominio.Colaborador;
import servico.ColaboradorSrv;

public class TesteSrv extends AbsVisao {

    private ColaboradorSrv srv;

    @Override
    public void executar(){
        this.mostrar();
    }

    private void mostrar(){
        for (Colaborador item : this.srv.Listar()) {
            item.exibir();
        }
    }

    public TesteSrv(){
        this.srv = new ColaboradorSrv();
    }

}
