package med.voll.api.domain.posto;

import med.voll.api.domain.endereco.DadosEndereco;
import med.voll.api.domain.endereco.Endereco;

public record DadosListagemPosto(Long id, String nome){

    public DadosListagemPosto(Posto posto) {
        this(posto.getId(), posto.getNome());
    }
}
