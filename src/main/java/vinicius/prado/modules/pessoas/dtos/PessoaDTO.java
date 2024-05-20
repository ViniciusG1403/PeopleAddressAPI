package vinicius.prado.modules.pessoas.dtos;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import vinicius.prado.modules.pessoas.entities.Endereco;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class PessoaDTO {

    private UUID id;

    private String nome;

    private Timestamp dtNascimento;

    private List<EnderecoDTO> enderecos = new ArrayList<>();

    @Builder
    public PessoaDTO(UUID id, String nome, Timestamp dtNascimento, List<EnderecoDTO> enderecos) {
        this.id = id;
        this.nome = nome;
        this.dtNascimento = dtNascimento;
        this.enderecos = enderecos;
    }

}
