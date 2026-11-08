package FakeDB;

import java.util.ArrayList;

import Dominio.Visitante;

public class VisitanteFakeDB extends AbsGenericFakeDB<Visitante> {

    public VisitanteFakeDB() {
        this.dados = new ArrayList<>();
        this.autoPreencher();
    }

    @Override
    protected void autoPreencher() {
        this.dados.add(new Visitante(301, "Helena Duarte", "22233344401", "helena@email.com", "67991110001", "Rua das Flores, 100", "Reunião com coordenação", 11, "Secretaria"));
        this.dados.add(new Visitante(302, "Marcos Vieira", "22233344402", "marcos@email.com", "67991110002", "Av. Brasil, 250", "Manutenção de equipamentos", 12, "Laboratório de Informática"));
        this.dados.add(new Visitante(303, "Sofia Almeida", "22233344403", "sofia@email.com", "67991110003", "Rua Bahia, 45", "Palestra", 13, "Auditório"));
    }
}
