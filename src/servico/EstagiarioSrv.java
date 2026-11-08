package servico;

import java.util.ArrayList;

import Dao.EstagiarioDAO;
import Dominio.Estagiario;

public class EstagiarioSrv extends AbsGenericSrv<Estagiario> {

    @Override
    public ArrayList<Estagiario> Listar() {
        return this.dao.Browse();
    }

    @Override
    public Estagiario Buscar(int codigo) {
        return this.dao.Read(codigo);
    }

    @Override
    public Estagiario Incluir(Estagiario novo) {
        return this.dao.Add(novo);
    }

    @Override
    public Estagiario Alterar(Estagiario alterado) {
        return this.dao.Edit(alterado);
    }

    @Override
    public Estagiario Excluir(Estagiario apagado) {
        return this.dao.Delete(apagado);
    }

    public EstagiarioSrv() {
        this.dao = new EstagiarioDAO();
    }
}
