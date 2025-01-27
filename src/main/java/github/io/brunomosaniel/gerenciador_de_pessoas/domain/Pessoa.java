package github.io.brunomosaniel.gerenciador_de_pessoas.domain;

import github.io.brunomosaniel.gerenciador_de_pessoas.application.PessoaRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "idPessoas", updatable = false, unique = true, nullable = false)
   private UUID id;
   private String dataNascimento;
   private String nomeCompleto;

   private LocalDateTime dataHoraDoCadastro;

    public Pessoa(PessoaRequest pessoaRequest) {
        this.dataNascimento =  pessoaRequest.getDataNascimento();
        this.nomeCompleto = pessoaRequest.getNomeCompleto();
        this.dataHoraDoCadastro = LocalDateTime.now();
    }
}
