package vinicius.prado.modules.pessoas.converter;

import jakarta.enterprise.context.RequestScoped;
import lombok.RequiredArgsConstructor;
import vinicius.prado.modules.pessoas.dtos.EnderecoDTO;
import vinicius.prado.modules.pessoas.entities.Endereco;

import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
@RequiredArgsConstructor
public class EnderecoConverter {

    private final PessoaConverter pessoaConverter;

    public EnderecoDTO ormToDto(Endereco orm){
        return EnderecoDTO.builder().id(orm.getId())
                .cep(orm.getCep())
                .estado(orm.getEstado())
                .cidade(orm.getCidade())
                .numero(orm.getNumero())
                .logradouro(orm.getLogradouro())
                .snEnderecoPrincipal(orm.getSnEnderecoPrincipal()).build();
    }

    public Endereco dtoToOrm(EnderecoDTO dto){
        return Endereco.builder().id(dto.getId())
                .cep(dto.getCep())
                .estado(dto.getEstado())
                .numero(dto.getNumero())
                .cidade(dto.getCidade())
                .logradouro(dto.getLogradouro())
                .snEnderecoPrincipal(dto.getSnEnderecoPrincipal())
                .pessoa(pessoaConverter.dtoToOrm(dto.getPessoa())).build();
    }


    public List<EnderecoDTO> ormListToDtoList(List<Endereco> ormList){
        return ormList.stream().map(this::ormToDto).collect(Collectors.toList());
    }

    public List<Endereco> dtoListToOrmList(List<EnderecoDTO> dtoList ){
        return dtoList.stream().map(this::dtoToOrm).collect(Collectors.toList());
    }

}
