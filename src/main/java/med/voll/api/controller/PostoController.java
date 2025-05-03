package med.voll.api.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import med.voll.api.domain.posto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@RestController
@RequestMapping("postos")
public class PostoController {

    @Autowired
    private PostoRepository postoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroPosto dados, UriComponentsBuilder uriBuilder) {
        var posto = new Posto(dados);
        postoRepository.save(posto);

        var uri = uriBuilder.path("/postos/{id}").buildAndExpand(posto.getId()).toUri();

        log.info("Cadastrando posto: {}", dados);
        return ResponseEntity.created(uri).body(new DadosDetalhamentoPosto(posto));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemPosto>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        var page = postoRepository.findAllByAtivoTrue(paginacao).map(DadosListagemPosto::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoPosto dados) {
        var posto = postoRepository.getReferenceById(dados.id());
        posto.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoPosto(posto));
    }

}