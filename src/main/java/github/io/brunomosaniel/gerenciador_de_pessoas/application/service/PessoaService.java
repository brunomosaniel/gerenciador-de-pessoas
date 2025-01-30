package github.io.brunomosaniel.gerenciador_de_pessoas.application.service;

import github.io.brunomosaniel.gerenciador_de_pessoas.application.api.*;

import java.util.List;
import java.util.UUID;

public interface PessoaService {
    PessoaResponse criaPessoa(PessoaRequest pessoaRequest);
    List<PessoaListResponse> getTodasPessoas();
    PessoaDetalhadoResponse buscaPessoaPorId(UUID idPessoa);
    void deletaPessoasAtravesId(UUID idPessoas);
    void patchAlteraPessoa(UUID idPessoas, PatchPessoaRequest patchPessoaRequest);
}
