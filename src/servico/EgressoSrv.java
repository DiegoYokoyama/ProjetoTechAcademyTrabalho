package servico;

import java.util.ArrayList;

import Dao.EgressoDAO;
import Dominio.Egresso;

public class EgressoSrv extends AbsGenericSrv<Egresso> {

    @Override
    public ArrayList<Egresso> Listar() {
        return this.dao.Browse();
    }

    @Override
    public Egresso Buscar(int codigo) {
        return this.dao.Read(codigo);
    }

    @Override
    public Egresso Incluir(Egresso novo) {
        return this.dao.Add(novo);
    }

    @Override
    public Egresso Alterar(Egresso alterado) {
        return this.dao.Edit(alterado);
    }

    @Override
    public Egresso Excluir(Egresso apagado) {
        return this.dao.Delete(apagado);
    }

    public EgressoSrv() {
        this.dao = new EgressoDAO();
    }
}
