package DAO;

import Dominio.Colaborador;
import FakeDB.ColaboradorFakeDB;

public class ColaboradorDAO extends AbsGenericDAO<Colaborador>{

    @Override
    public Colaborador Read(int codigo) {
        for (Colaborador item : this.tabela) {
            if (item.getCodigo() == codigo){
                return item;
            }
        }
        return null;
    }

    @Override
    public Colaborador Edit(Colaborador alterado) {
        int codigoProcurado = alterado.getCodigo();
        if (this.Read(codigoProcurado) != null){
            int index = this.tabela.indexOf(alterado);
            this.tabela.set(index, alterado);
            return alterado;
        }
        return null;
    }

    @Override
    public Colaborador Add(Colaborador novo) {
        int ultimoCodigo = this.tabela.getLast().getCodigo();
        int novoCodigo = ultimoCodigo + 1;
        novo.setCodigo(novoCodigo);
        this.tabela.add(novo);
        return novo;
    }

    @Override
    public Colaborador Delete(Colaborador apagado) {
        int codigoProcurado = apagado.getCodigo();
        if (this.Read(codigoProcurado) != null){
            this.tabela.remove(apagado);
            return apagado;
        }
        return null;
    }
    
    public ColaboradorDAO(){
        this.repositorio = new ColaboradorFakeDB();
        this.tabela = this.repositorio.getDados();
    }
}
