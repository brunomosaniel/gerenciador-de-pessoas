package github.io.brunomosaniel.gerenciador_de_pessoas.infra;

import github.io.brunomosaniel.gerenciador_de_pessoas.application.repository.PessoaRepository;
import github.io.brunomosaniel.gerenciador_de_pessoas.domain.Pessoa;
import github.io.brunomosaniel.gerenciador_de_pessoas.handler.APIException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class PessoaInfraRepository implements PessoaRepository {
    private final PessoaSpringDataJPARepository pessoaSpringDataJPARepository;

    @Override
    public Pessoa salva(Pessoa pessoa) {
        pessoaSpringDataJPARepository.save(pessoa);
        return pessoa;
    }

    @Override
    public List<Pessoa> getTodasPessoas() {
       List<Pessoa> todasPessoas = pessoaSpringDataJPARepository.findAll();
        return todasPessoas;
    }

    @Override
    public Pessoa buscaPessoaPorId(UUID idPessoa) {
     var pessoa = (Pessoa) pessoaSpringDataJPARepository.findById(idPessoa)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Pessoa não encontrada!"));
    return pessoa;
    }
}
