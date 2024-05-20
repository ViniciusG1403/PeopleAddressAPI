package vinicius.prado.modules.pessoas.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "enderecos")
public class Endereco extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "id_pessoa", nullable = false)
    private Pessoa pessoa;

    @Column(name = "logradouro", nullable = false)
    private String logradouro;

    @Column(name = "cep", nullable = false)
    private String cep;

    @Column(name = "numero", nullable = false)
    private String numero;

    @Column(name = "cidade", nullable = false)
    private String cidade;

    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "sn_enderecoprincipal", nullable = false)
    private Boolean snEnderecoPrincipal;


    @Builder
    public Endereco(UUID id,
                    Pessoa pessoa,
                    String logradouro,
                    String cep,
                    String numero,
                    String cidade,
                    String estado,
                    Boolean snEnderecoPrincipal) {
        this.id = id;
        this.pessoa = pessoa;
        this.logradouro = logradouro;
        this.cep = cep;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.snEnderecoPrincipal = snEnderecoPrincipal;
    }


}
