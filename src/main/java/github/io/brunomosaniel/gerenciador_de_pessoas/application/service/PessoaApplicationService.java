package github.io.brunomosaniel.gerenciador_de_pessoas.application.service;

import github.io.brunomosaniel.gerenciador_de_pessoas.application.api.*;
import github.io.brunomosaniel.gerenciador_de_pessoas.application.repository.PessoaRepository;
import github.io.brunomosaniel.gerenciador_de_pessoas.domain.Pessoa;
import github.io.brunomosaniel.gerenciador_de_pessoas.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class PessoaApplicationService implements PessoaService {
    private final PessoaRepository pessoaRepository;

    @Override
    public PessoaResponse criaPessoa(PessoaRequest pessoaRequest) {
        log.info("[start] PessoaApplicationService - criaPessoa");
        Pessoa pessoa = pessoaRepository.salva(toPessoa(pessoaRequest));
        PessoaResponse response = Optional.ofNullable(pessoa)
                .map(p -> PessoaResponse.builder()
                        .id(p.getId())
                        .build())
                .orElseThrow(() -> new IllegalStateException("Erro ao salvar pessoa"));
        log.info("[finish] PessoaApplicationService - criaPessoa");
        return response;
    }
    private Pessoa toPessoa(PessoaRequest pessoaRequest) {
        return new Pessoa(pessoaRequest);
    }

    @Override
    public List<PessoaListResponse> getTodasPessoas() {
        log.info("[start] PessoaApplicationService - getTodasPessoas");
       List<Pessoa> pessoa = pessoaRepository.getTodasPessoas();
        log.info("[finish] PessoaApplicationService - getTodasPessoas");
        return PessoaListResponse.converte(pessoa);
    }

    @Override
    public PessoaDetalhadoResponse buscaPessoaPorId(UUID idPessoa) {
        log.info("[start] PessoaApplicationService - buscaPessoaPorId");
        log.info("[idPessoa] {}", idPessoa);
        var pessoa = pessoaRepository.buscaPessoaPorId(idPessoa);
        log.info("[finish] PessoaApplicationService - buscaPessoaPorId");
        return new PessoaDetalhadoResponse(pessoa);
    }

    @Override
    public void deletaPessoasAtravesId(UUID idPessoa) {
        log.info("[start] PessoaApplicationService - deletaPessoasAtravesId");
        log.info("[idPessoa] {}" , idPessoa);
        var pessoa = pessoaRepository.buscaPessoaPorId(idPessoa);
        log.info("[start] PessoaApplicationService - deletaPessoasAtravesId");
    }

    @Override
    public void patchAlteraPessoa(UUID idPessoa, PatchPessoaRequest patchPessoaRequest) {
        log.info("[start] PessoaApplicationService - patchAlteraPessoa");
        log.info("[idPessoa] {}" , idPessoa);
        var pessoa = pessoaRepository.buscaPessoaPorId(idPessoa);
        pessoa.altera(patchPessoaRequest);
        pessoaRepository.salva(pessoa);
        log.info("[finish] PessoaApplicationService - patchAlteraPessoa");
    }
}
