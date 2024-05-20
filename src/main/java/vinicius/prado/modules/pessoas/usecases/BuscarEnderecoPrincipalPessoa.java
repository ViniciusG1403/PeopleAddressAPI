package vinicius.prado.modules.pessoas.usecases;


import jakarta.enterprise.context.RequestScoped;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import vinicius.prado.modules.pessoas.converter.EnderecoConverter;
import vinicius.prado.modules.pessoas.dtos.EnderecoDTO;
import vinicius.prado.modules.pessoas.entities.Endereco;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Transactional
@RequestScoped
@RequiredArgsConstructor
public class BuscarEnderecoPrincipalPessoa {

    private final EnderecoConverter enderecoConverter;

    public Optional<EnderecoDTO> execute(UUID idPessoa) {
        List<Endereco> endereco = Endereco.find("pessoa.idPessoa", idPessoa).list();

        return endereco.stream().filter(end -> Objects.equals(end.getSnEnderecoPrincipal(), Boolean.TRUE))
                .map(enderecoConverter::ormToDto).findFirst();
    }


}
