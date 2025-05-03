package med.voll.api.domain.posto;

import med.voll.api.domain.endereco.Endereco;

public record DadosDetalhamentoPosto(Long id, String nome, Endereco endereco) {

    public DadosDetalhamentoPosto(Posto posto){
        this(posto.getId(), posto.getNome(), posto.getEndereco());

    }
}
