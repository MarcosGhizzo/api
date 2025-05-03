package med.voll.api.domain.posto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.endereco.DadosEndereco;



public record DadosCadastroPosto(

        @NotNull String nome,

        @NotNull @Valid DadosEndereco endereco) {

}
