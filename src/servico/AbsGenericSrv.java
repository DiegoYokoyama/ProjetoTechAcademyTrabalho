package Servico;

import java.util.ArrayList;

import DAO.AbsGenericDAO;

public abstract class AbsGenericSrv<T> {

    protected AbsGenericDAO<T> dao;

    public abstract ArrayList<T> Listar();
    public abstract T Buscar(int codigo);
    public abstract T Incluir(T novo);
    public abstract T Alterar(T alterado);
    public abstract T Excluir(T apagado);

}
