package github.io.brunomosaniel.gerenciador_de_pessoas.application.api;

import github.io.brunomosaniel.gerenciador_de_pessoas.domain.Pessoa;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.UUID;

@Value
public class PessoaDetalhadoResponse {
    private UUID id;
    private String dataNascimento;
    private String email;
    private String senha;
    private String nomeCompleto;
    private LocalDateTime dataHoraDoCadastro;
    public PessoaDetalhadoResponse(Pessoa pessoa) {
        this.id = pessoa.getId();
        this.dataNascimento = pessoa.getDataNascimento();
        this.email = pessoa.getEmail();
        this.senha = pessoa.getSenha();
        this.nomeCompleto = pessoa.getNomeCompleto();
        this.dataHoraDoCadastro = LocalDateTime.now();
    }
}
