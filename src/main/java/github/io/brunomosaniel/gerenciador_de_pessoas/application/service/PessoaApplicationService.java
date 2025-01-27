package github.io.brunomosaniel.gerenciador_de_pessoas.application.service;

import github.io.brunomosaniel.gerenciador_de_pessoas.application.PessoaDetalhadoResponse;
import github.io.brunomosaniel.gerenciador_de_pessoas.application.PessoaListResponse;
import github.io.brunomosaniel.gerenciador_de_pessoas.application.PessoaRequest;
import github.io.brunomosaniel.gerenciador_de_pessoas.application.PessoaResponse;
import github.io.brunomosaniel.gerenciador_de_pessoas.application.repository.PessoaRepository;
import github.io.brunomosaniel.gerenciador_de_pessoas.domain.Pessoa;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class PessoaApplicationService implements PessoaService {
    private final PessoaRepository pessoaRepository;

    @Override
    public PessoaResponse criaPessoa(PessoaRequest pessoaRequest) {
        log.info("[start] PessoaApplicationService - criaPessoa");
      Pessoa pessoa = pessoaRepository.salva(new Pessoa(pessoaRequest));
        log.info("[finish] PessoaApplicationService - criaPessoa");
        return PessoaResponse.builder()
                .id(pessoa.getId())
                .build();
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
        log.info("[idPessoa]", idPessoa);
        var pessoa = pessoaRepository.buscaPessoaPorId(idPessoa);
        log.info("[finish] PessoaApplicationService - buscaPessoaPorId");
        return new PessoaDetalhadoResponse(pessoa);
    }

    @Override
    public void deletaPessoasAtravesId(UUID idPessoa) {
        log.info("[start] PessoaApplicationService - deletaPessoasAtravesId");
        log.info("[idPessoa]", idPessoa);
        var pessoa = pessoaRepository.buscaPessoaPorId(idPessoa);
        log.info("[start] PessoaApplicationService - deletaPessoasAtravesId");
    }
}
