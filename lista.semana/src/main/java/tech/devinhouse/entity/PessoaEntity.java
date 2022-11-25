package tech.devinhouse.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "pessoas")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PessoaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Gerar id automaticamente
    private Long id;

    @Column(name = "name") //nome como está no banco de dados
    @NotNull
    private String name; // nome da variável na aplicação

    @Column(name = "email")
    @NotNull
    private String email;

    @Column(name = "status")
    private Boolean status;

}
