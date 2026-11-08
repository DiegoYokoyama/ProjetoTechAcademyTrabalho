package Dao;

import Dominio.Estagiario;
import FakeDB.EstagiarioFakeDB;

public class EstagiarioDAO extends AbsGenericDAO<Estagiario> {

    @Override
    public Estagiario Read(int codigo) {
        for (Estagiario item : this.tabela) {
            if (item.getCodigo() == codigo) {
                return item;
            }
        }
        return null;
    }

    @Override
    public Estagiario Edit(Estagiario alterado) {
        for (int i = 0; i < this.tabela.size(); i++) {
            if (this.tabela.get(i).getCodigo() == alterado.getCodigo()) {
                this.tabela.set(i, alterado);
                return alterado;
            }
        }
        return null;
    }

    @Override
    public Estagiario Add(Estagiario novo) {
        int ultimoCodigo = this.tabela.isEmpty() ? 0 : this.tabela.getLast().getCodigo();
        novo.setCodigo(ultimoCodigo + 1);
        this.tabela.add(novo);
        return novo;
    }

    @Override
    public Estagiario Delete(Estagiario apagado) {
        if (this.Read(apagado.getCodigo()) != null) {
            this.tabela.remove(apagado);
            return apagado;
        }
        return null;
    }

    public EstagiarioDAO() {
        this.repositorio = new EstagiarioFakeDB();
        this.tabela = this.repositorio.getDados();
    }
}
