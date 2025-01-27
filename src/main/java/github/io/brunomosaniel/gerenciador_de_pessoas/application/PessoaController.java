package github.io.brunomosaniel.gerenciador_de_pessoas.application;

import github.io.brunomosaniel.gerenciador_de_pessoas.application.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class PessoaController implements PessoaAPI {
    private final PessoaService pessoaService;

    @Override
    public PessoaResponse criaPessoa(PessoaRequest pessoaRequest) {
     PessoaResponse pessoaCriada = pessoaService.criaPessoa(pessoaRequest);
        return pessoaCriada;
    }

    @Override
    public List<PessoaListResponse> getTodasPessoas() {
      List<PessoaListResponse> pessoas = pessoaService.getTodasPessoas();
        return pessoas;
    }

    @Override
    public PessoaDetalhadoResponse getPessoaAtravesId(UUID idPessoa) {
       PessoaDetalhadoResponse pessoaDetalhada = pessoaService.buscaPessoaPorId(idPessoa);
        return pessoaDetalhada;
    }

    @Override
    public void deletaPessoasAtravesId(UUID idPessoas) {
        pessoaService.deletaPessoasAtravesId(idPessoas);
    }

}
