package vinicius.prado.modules.pessoas.usecases;

import jakarta.enterprise.context.RequestScoped;
import vinicius.prado.modules.pessoas.dtos.EnderecoDTO;

import java.util.List;
import java.util.Objects;

@RequestScoped
public class HasEnderecoPrincipal {


    public boolean execute(List<EnderecoDTO> enderecoList){
        return enderecoList.stream().anyMatch(endereco -> Objects.equals(endereco.getSnEnderecoPrincipal(), Boolean.TRUE));
    }

}
