package github.io.brunomosaniel.gerenciador_de_pessoas.application.repository;

import github.io.brunomosaniel.gerenciador_de_pessoas.domain.Pessoa;

import java.util.List;
import java.util.UUID;

public interface PessoaRepository {
    Pessoa salva(Pessoa pessoa);
    List<Pessoa> getTodasPessoas();
    Pessoa buscaPessoaPorId(UUID idPessoa);
}
