package DAO;

import java.util.ArrayList;

import FakeDB.AbsGenericFakeDB;

public abstract class AbsGenericDAO<T> {

    protected AbsGenericFakeDB<T> repositorio;

    protected ArrayList<T> tabela;

    public ArrayList<T> Browse(){
        return this.repositorio.getDados();
    }

    public abstract T Read(int codigo);

    public abstract T Edit(T alterado);

    public abstract T Add(T novo);

    public abstract T Delete(T apagado);

    public AbsGenericDAO(){
        
    }
}
