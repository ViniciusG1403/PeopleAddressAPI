package vinicius.prado.modules.pessoas.usecases;

import jakarta.enterprise.context.RequestScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import vinicius.prado.modules.pessoas.converter.EnderecoConverter;
import vinicius.prado.modules.pessoas.dtos.EnderecoDTO;
import vinicius.prado.modules.pessoas.entities.Endereco;

import java.util.Optional;
import java.util.UUID;

@Transactional
@RequestScoped
@RequiredArgsConstructor
public class BuscarEnderecoPeloID {

    private final EnderecoConverter enderecoConverter;

    public Optional<EnderecoDTO> execute(UUID id) {
        Optional<Endereco> endereco = Optional.ofNullable(Endereco.findById(id));

        return endereco.map(enderecoConverter::ormToDto);
    }
}
