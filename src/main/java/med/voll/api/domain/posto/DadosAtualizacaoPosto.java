package med.voll.api.domain.posto;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.endereco.DadosEndereco;

public record DadosAtualizacaoPosto(@NotNull Long id, String nome, DadosEndereco endereco) {
}
