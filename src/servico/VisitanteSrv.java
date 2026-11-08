package Servico;

import java.util.ArrayList;

import DAO.VisitanteDAO;
import Dominio.Visitante;

public class VisitanteSrv extends AbsGenericSrv<Visitante> {

    @Override
    public ArrayList<Visitante> Listar() {
        return this.dao.Browse();
    }

    @Override
    public Visitante Buscar(int codigo) {
        return this.dao.Read(codigo);
    }

    @Override
    public Visitante Incluir(Visitante novo) {
        return this.dao.Add(novo);
    }

    @Override
    public Visitante Alterar(Visitante alterado) {
        return this.dao.Edit(alterado);
    }

    @Override
    public Visitante Excluir(Visitante apagado) {
        return this.dao.Delete(apagado);
    }

    public VisitanteSrv() {
        this.dao = new VisitanteDAO();
    }
}
