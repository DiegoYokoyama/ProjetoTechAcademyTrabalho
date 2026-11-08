package DAO;

import Dominio.Egresso;
import FakeDB.EgressoFakeDB;

public class EgressoDAO extends AbsGenericDAO<Egresso> {

    @Override
    public Egresso Read(int codigo) {
        for (Egresso item : this.tabela) {
            if (item.getCodigo() == codigo) {
                return item;
            }
        }
        return null;
    }

    @Override
    public Egresso Edit(Egresso alterado) {
        for (int i = 0; i < this.tabela.size(); i++) {
            if (this.tabela.get(i).getCodigo() == alterado.getCodigo()) {
                this.tabela.set(i, alterado);
                return alterado;
            }
        }
        return null;
    }

    @Override
    public Egresso Add(Egresso novo) {
        int ultimoCodigo = this.tabela.isEmpty() ? 0 : this.tabela.getLast().getCodigo();
        novo.setCodigo(ultimoCodigo + 1);
        this.tabela.add(novo);
        return novo;
    }

    @Override
    public Egresso Delete(Egresso apagado) {
        if (this.Read(apagado.getCodigo()) != null) {
            this.tabela.remove(apagado);
            return apagado;
        }
        return null;
    }

    public EgressoDAO() {
        this.repositorio = new EgressoFakeDB();
        this.tabela = this.repositorio.getDados();
    }
}
