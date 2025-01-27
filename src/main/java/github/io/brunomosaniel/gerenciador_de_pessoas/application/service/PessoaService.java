package github.io.brunomosaniel.gerenciador_de_pessoas.application.service;

import github.io.brunomosaniel.gerenciador_de_pessoas.application.PessoaDetalhadoResponse;
import github.io.brunomosaniel.gerenciador_de_pessoas.application.PessoaListResponse;
import github.io.brunomosaniel.gerenciador_de_pessoas.application.PessoaRequest;
import github.io.brunomosaniel.gerenciador_de_pessoas.application.PessoaResponse;

import java.util.List;
import java.util.UUID;

public interface PessoaService {
    PessoaResponse criaPessoa(PessoaRequest pessoaRequest);
    List<PessoaListResponse> getTodasPessoas();
    PessoaDetalhadoResponse buscaPessoaPorId(UUID idPessoa);
    void deletaPessoasAtravesId(UUID idPessoas);
}
