package github.io.brunomosaniel.gerenciador_de_pessoas.domain;

import github.io.brunomosaniel.gerenciador_de_pessoas.application.api.PatchPessoaRequest;
import github.io.brunomosaniel.gerenciador_de_pessoas.application.api.PessoaRequest;
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
   private String email;
   private String senha;
   private String nomeCompleto;

   private LocalDateTime dataHoraDoCadastro;
   private LocalDateTime getDataHoraUltimaAlteracao;

    public Pessoa(PessoaRequest pessoaRequest) {
        this.dataNascimento =  pessoaRequest.getDataNascimento();
        this.nomeCompleto = pessoaRequest.getNomeCompleto();
        this.senha = pessoaRequest.getSenha();
        this.email = pessoaRequest.getEmail();
        this.dataHoraDoCadastro = LocalDateTime.now();
    }

    public void altera(PatchPessoaRequest patchPessoaRequest) {
        this.dataNascimento = patchPessoaRequest.getDataNascimento();
        this.nomeCompleto = patchPessoaRequest.getNomeCompleto();
        this.email = patchPessoaRequest.getEmail();
        this.senha = patchPessoaRequest.getSenha();
        this.getDataHoraUltimaAlteracao = LocalDateTime.now();

    }
}
