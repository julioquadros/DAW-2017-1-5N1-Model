
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
@Entity
@Table(name = "pessoa_fisica")
@Inheritance(strategy = InheritanceType.JOINED)
public class PessoaFisica extends Pessoa implements Serializable {
    
    @NotNull(message = "O rg não pode ser nulo")
    @Length(max = 10, message = "O RG não pode ter mais de {max} caracteres")
    @NotBlank(message = "O RG não pode ser em branco")
    @Column(name = "rg", length = 10, nullable = false)      
    private String rg;
    @CPF(message = "O CPF deve ser válido")
    @NotNull(message = "O CPF não pode ser nulo")
    @Length(max = 14, message = "O CPF não pode ter mais de {max} caracteres")
    @NotBlank(message = "O CPF não pode ser em branco")
    @Column(name = "cpf", length = 14, nullable = false)      
    private String cpf;
    @NotNull(message = "O nascimento deve ser informado")
    @Temporal(TemporalType.DATE)
    @Column(name = "nascimento", nullable = false)
    private Calendar nascimento;
    @ManyToMany
    @JoinTable(name = "desejos",
            joinColumns = 
            @JoinColumn(name = "pessoa_fisica", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = 
            @JoinColumn(name = "produto", referencedColumnName = "id", nullable = false))
    private List<Produto> desejos = new ArrayList<>();

    public PessoaFisica(){
        
    }
    
    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Calendar getNascimento() {
        return nascimento;
    }

    public void setNascimento(Calendar nascimento) {
        this.nascimento = nascimento;
    }

    public List<Produto> getDesejos() {
        return desejos;
    }

    public void setDesejos(List<Produto> desejos) {
        this.desejos = desejos;
    }

}
