package vinicius.prado.modules.pessoas.usecases;


import jakarta.enterprise.context.RequestScoped;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import vinicius.prado.modules.pessoas.converter.PessoaConverter;
import vinicius.prado.modules.pessoas.dtos.PessoaDTO;
import vinicius.prado.modules.pessoas.entities.Pessoa;

@RequestScoped
@Transactional
@RequiredArgsConstructor
public class CriarPessoa {

    private final PessoaConverter pessoaConverter;

    private final HasEnderecoPrincipal hasEnderecoPrincipal;

    public void execute(@Valid PessoaDTO pessoaDTO){

        if(!hasEnderecoPrincipal.execute(pessoaDTO.getEnderecos())){
            throw new ValidationException("Deve se ter um endereço principal");
        }

        Pessoa pessoa = pessoaConverter.dtoToOrm(pessoaDTO);

        pessoa.persist();
    }


}
