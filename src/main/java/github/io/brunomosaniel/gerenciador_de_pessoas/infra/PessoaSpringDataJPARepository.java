package github.io.brunomosaniel.gerenciador_de_pessoas.infra;

import github.io.brunomosaniel.gerenciador_de_pessoas.domain.Pessoa;
import org.hibernate.validator.constraints.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PessoaSpringDataJPARepository extends JpaRepository<Pessoa, UUID>{
    Optional<Object> findById(java.util.UUID idPessoa);
}
