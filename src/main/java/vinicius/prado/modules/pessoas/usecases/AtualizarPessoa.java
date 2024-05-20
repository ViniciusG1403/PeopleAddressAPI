package vinicius.prado.modules.pessoas.usecases;

import jakarta.enterprise.context.RequestScoped;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import vinicius.prado.modules.pessoas.converter.EnderecoConverter;
import vinicius.prado.modules.pessoas.dtos.PessoaDTO;
import vinicius.prado.modules.pessoas.entities.Pessoa;

@Transactional
@RequestScoped
@RequiredArgsConstructor
public class AtualizarPessoa {

    private final HasEnderecoPrincipal hasEnderecoPrincipal;

    private final EnderecoConverter enderecoConverter;

    public void execute(@Valid PessoaDTO pessoaDTO){
        if(hasEnderecoPrincipal.execute(pessoaDTO.getEnderecos())){
            throw new ValidationException("Deve se ter um endereço principal");
        }

        Pessoa pessoa = Pessoa.findById(pessoaDTO.getId());

        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setDtNascimento(pessoaDTO.getDtNascimento());
        pessoa.setEnderecos(enderecoConverter.dtoListToOrmList(pessoaDTO.getEnderecos()));

        pessoa.persist();


    }

}
