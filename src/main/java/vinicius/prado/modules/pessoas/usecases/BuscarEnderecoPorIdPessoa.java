package vinicius.prado.modules.pessoas.usecases;

import jakarta.enterprise.context.RequestScoped;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import vinicius.prado.modules.pessoas.converter.EnderecoConverter;
import vinicius.prado.modules.pessoas.dtos.EnderecoDTO;
import vinicius.prado.modules.pessoas.entities.Endereco;

import java.util.List;
import java.util.UUID;

@Transactional
@RequestScoped
@RequiredArgsConstructor
public class BuscarEnderecoPorIdPessoa {

    private final EnderecoConverter enderecoConverter;

    public List<EnderecoDTO> execute(UUID idPessoa){
        List<Endereco> enderecos = Endereco.find("pessoa.id", idPessoa).list();

        return enderecoConverter.ormListToDtoList(enderecos);
    }


}
