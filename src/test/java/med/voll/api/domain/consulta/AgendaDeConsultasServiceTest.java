package med.voll.api.domain.consulta;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


@Disabled
class AgendaDeConsultasServiceTest {


    @Autowired
    private AgendaDeConsultasService agendaDeConsultasService;

    @Nested
    class Dado {
        @BeforeEach
        void setup () {
            //DadosAgendamentoConsulta consultaAgendada = agendaDeConsultasService.agendar(new DadosAgendamentoConsulta(9L, 1L, LocalDateTime.now(), Especialidade.CARDIOLOGIA));
        }

        @Nested
        class Quando {
            @BeforeEach
            void setup () {

            }

            @Test
            void Entao () {

            }
        }



    }


}