package servico;

import java.util.ArrayList;

import Dao.ColaboradorDAO;
import Dominio.Colaborador;

public class ColaboradorSrv 
    extends AbsGenericSrv<Colaborador> {

    @Override
    public ArrayList<Colaborador> Listar() {
        return this.dao.Browse();
    }

    @Override
    public Colaborador Buscar(int codigo) {
        return this.dao.Read(codigo);
    }

    @Override
    public Colaborador Incluir(Colaborador novo) {
        return this.dao.Add(novo);
    }

    @Override
    public Colaborador Alterar(Colaborador alterado) {
        return this.dao.Edit(alterado);
    }

    @Override
    public Colaborador Excluir(Colaborador apagado) {
        return this.dao.Delete(apagado);
    }

    public ColaboradorSrv(){
        this.dao = new ColaboradorDAO();
    }

}
