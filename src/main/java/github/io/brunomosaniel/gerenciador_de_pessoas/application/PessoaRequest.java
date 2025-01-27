package github.io.brunomosaniel.gerenciador_de_pessoas.application;


import jakarta.validation.Valid;
import lombok.Value;

@Value
public class PessoaRequest {
    private String dataNascimento;
    private String nomeCompleto;
}
