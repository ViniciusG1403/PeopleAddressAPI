package vinicius.prado.modules.pessoas.dtos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import vinicius.prado.modules.pessoas.entities.Pessoa;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class EnderecoDTO {


    private UUID id;

    @NotNull(message = "A pessoa não pode ser nula")
    private PessoaDTO pessoa;

    @NotNull(message = "O logradouro não pode ser nulo")
    private String logradouro;

    @NotNull(message = "O cep não pode ser nulo")
    @Size(min = 8, max = 8, message = "O cep deve ter 8 caracteres")
    private String cep;

    @NotNull(message = "O número não pode ser nulo - caso não tenho número no endereço utilizar S/N")
    private String numero;

    @NotNull(message = "A cidade não pode ser nula")
    private String cidade;

    @NotNull(message = "O estado não pode ser nulo")
    private String estado;

    private Boolean snEnderecoPrincipal;


    @Builder
    public EnderecoDTO(UUID id, PessoaDTO pessoa,
                       String logradouro,
                       String cep,
                       String numero,
                       String cidade,
                       String estado,
                       Boolean snEnderecoPrincipal) {
        this.id = id;
        this.pessoa = pessoa;
        this.logradouro = logradouro;
        this.cep = cep;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.snEnderecoPrincipal = snEnderecoPrincipal;
    }
}
