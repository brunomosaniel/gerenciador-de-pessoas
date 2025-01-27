package github.io.brunomosaniel.gerenciador_de_pessoas.application;

import github.io.brunomosaniel.gerenciador_de_pessoas.domain.Pessoa;
import lombok.Value;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class PessoaListResponse {
    private UUID id;
    private String dataNascimento;
    private String nomeCompleto;

    public static List<PessoaListResponse> converte(List<Pessoa> pessoa) {
        return pessoa.stream()
                .map(PessoaListResponse::new)
                .collect(Collectors.toList());
    }

    public PessoaListResponse(Pessoa pessoa) {
        this.id = pessoa.getId();
        this.dataNascimento = pessoa.getDataNascimento();
        this.nomeCompleto = pessoa.getNomeCompleto();
    }
}
