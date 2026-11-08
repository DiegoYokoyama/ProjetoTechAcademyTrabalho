package FakeDB;

import java.util.ArrayList;

import Dominio.Egresso;

public class EgressoFakeDB extends AbsGenericFakeDB<Egresso> {

    public EgressoFakeDB() {
        this.dados = new ArrayList<>();
        this.autoPreencher();
    }

    @Override
    protected void autoPreencher() {
        this.dados.add(new Egresso(201, "Carla Mendes", "11122233301", 2019, "Ciência da Computação", "Desenvolvimento Web"));
        this.dados.add(new Egresso(202, "Rafael Costa", "11122233302", 2021, "Sistemas de Informação", "Banco de Dados"));
        this.dados.add(new Egresso(203, "Luana Prado", "11122233303", 2020, "Engenharia de Software", "Qualidade de Software"));
        this.dados.add(new Egresso(204, "Tiago Ramos", "11122233304", 2022, "Ciência da Computação", "Redes e Segurança"));
    }
}
