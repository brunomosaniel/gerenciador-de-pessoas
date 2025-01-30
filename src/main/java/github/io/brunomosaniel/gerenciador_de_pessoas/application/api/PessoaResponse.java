package github.io.brunomosaniel.gerenciador_de_pessoas.application.api;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class PessoaResponse {
    private UUID id;
}
