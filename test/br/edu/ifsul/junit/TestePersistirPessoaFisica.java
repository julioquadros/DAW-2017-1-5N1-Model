package br.edu.ifsul.junit;

import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.PessoaFisica;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jorge
 */
public class TestePersistirPessoaFisica {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirPessoaFisica() {
    }
    
    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("DAW-2017-1-5N1ModelPU");
        em = emf.createEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
        emf.close();        
    }
    
    @Test
    public void testar(){
        boolean exception = false;
        try {
            Cidade c = em.find(Cidade.class, 5);
            PessoaFisica pf = new PessoaFisica();
            pf.setCidade(c);
            pf.setNome("Jorge");
            pf.setBairro("Centro");
            pf.setCep("99876-098");
            pf.setComplemento("Ap 300");
            pf.setCpf("699.239.490-87");
            pf.setEmail("jorge.bavaresco@passofundo.ifsul.edu.br");
            pf.setEndereco("Rua xxx");
            pf.setNascimento(new GregorianCalendar(1979, Calendar.OCTOBER, 25));
            pf.setRg("9867465378");
            em.getTransaction().begin();
            em.persist(pf);
            em.getTransaction().commit();
        } catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        // vou verificar se o resultado é o esperado
        Assert.assertEquals(false, exception);
    }
    
    
}
