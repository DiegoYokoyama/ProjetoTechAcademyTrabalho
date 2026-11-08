package FakeDB;

import java.util.ArrayList;

import Dominio.Estagiario;

public class EstagiarioFakeDB extends AbsGenericFakeDB<Estagiario> {

    public EstagiarioFakeDB() {
        this.dados = new ArrayList<>();
        this.autoPreencher();
    }

    @Override
    protected void autoPreencher() {
        this.dados.add(new Estagiario(401, "Bruno Farias", "33344455501", "bruno@email.com", "67992220001", "Rua Goiás, 12", 1200.0, 20, "Suporte de TI"));
        this.dados.add(new Estagiario(402, "Camila Reis", "33344455502", "camila@email.com", "67992220002", "Rua Pará, 78", 1400.0, 30, "Desenvolvimento"));
        this.dados.add(new Estagiario(403, "Igor Teixeira", "33344455503", "igor@email.com", "67992220003", "Av. Mato Grosso, 300", 1100.0, 20, "Biblioteca"));
    }
}
