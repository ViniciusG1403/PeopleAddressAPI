package vinicius.prado.modules.pessoas.usecases;

import jakarta.enterprise.context.RequestScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import vinicius.prado.modules.pessoas.converter.PessoaConverter;
import vinicius.prado.modules.pessoas.dtos.PessoaDTO;
import vinicius.prado.modules.pessoas.entities.Pessoa;

import java.util.Optional;
import java.util.UUID;

@Transactional
@RequestScoped
@RequiredArgsConstructor
public class BuscarPessoaPeloID {

    private final PessoaConverter pessoaConverter;

    public Optional<PessoaDTO> execute(UUID id) {
        Optional<Pessoa> pessoa = Optional.ofNullable(Pessoa.findById(id));

        return pessoa.map(PessoaConverter::ormToDto);

    }
}
