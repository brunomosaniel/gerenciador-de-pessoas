package github.io.brunomosaniel.gerenciador_de_pessoas.application.api;

import lombok.Value;

@Value
public class PatchPessoaRequest {
    private String email;
    private String senha;
    private String dataNascimento;
    private String nomeCompleto;
}
