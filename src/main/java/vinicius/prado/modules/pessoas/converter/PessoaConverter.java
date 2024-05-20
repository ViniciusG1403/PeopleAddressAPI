package vinicius.prado.modules.pessoas.converter;

import jakarta.enterprise.context.RequestScoped;
import lombok.RequiredArgsConstructor;
import vinicius.prado.modules.pessoas.dtos.PessoaDTO;
import vinicius.prado.modules.pessoas.entities.Pessoa;

@RequestScoped
@RequiredArgsConstructor
public class PessoaConverter {

    private EnderecoConverter enderecoConverter;

    public static PessoaDTO ormToDto(Pessoa orm){
        return PessoaDTO.builder().id(orm.getId())
                .nome(orm.getNome())
                .dtNascimento(orm.getDtNascimento())
                .enderecos(enderecoConverter.ormListToDtoList(orm.getEnderecos())).build();

    }

    public Pessoa dtoToOrm(PessoaDTO dto){
        return Pessoa.builder().id(dto.getId())
                .nome(dto.getNome())
                .dtNascimento(dto.getDtNascimento())
                .enderecos(enderecoConverter.dtoListToOrmList(dto.getEnderecos())).build();
    }


}
