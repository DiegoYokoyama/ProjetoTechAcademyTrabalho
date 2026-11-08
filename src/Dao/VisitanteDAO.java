package DAO;

import Dominio.Visitante;
import FakeDB.VisitanteFakeDB;

public class VisitanteDAO extends AbsGenericDAO<Visitante> {

    @Override
    public Visitante Read(int codigo) {
        for (Visitante item : this.tabela) {
            if (item.getCodigo() == codigo) {
                return item;
            }
        }
        return null;
    }

    @Override
    public Visitante Edit(Visitante alterado) {
        for (int i = 0; i < this.tabela.size(); i++) {
            if (this.tabela.get(i).getCodigo() == alterado.getCodigo()) {
                this.tabela.set(i, alterado);
                return alterado;
            }
        }
        return null;
    }

    @Override
    public Visitante Add(Visitante novo) {
        int ultimoCodigo = this.tabela.isEmpty() ? 0 : this.tabela.getLast().getCodigo();
        novo.setCodigo(ultimoCodigo + 1);
        this.tabela.add(novo);
        return novo;
    }

    @Override
    public Visitante Delete(Visitante apagado) {
        if (this.Read(apagado.getCodigo()) != null) {
            this.tabela.remove(apagado);
            return apagado;
        }
        return null;
    }

    public VisitanteDAO() {
        this.repositorio = new VisitanteFakeDB();
        this.tabela = this.repositorio.getDados();
    }
}
