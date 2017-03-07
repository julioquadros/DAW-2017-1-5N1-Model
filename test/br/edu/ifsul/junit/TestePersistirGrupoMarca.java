package br.edu.ifsul.junit;

import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.Grupo;
import br.edu.ifsul.modelo.Marca;
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
public class TestePersistirGrupoMarca {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirGrupoMarca() {
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
    public void teste(){
        boolean resultado = false;
        try {
            Grupo g = new Grupo();
            g.setNome("Eletrônicos");
            Marca m = new Marca();
            m.setNome("Dell");
            em.getTransaction().begin();
            em.persist(g);
            em.persist(m);
            em.getTransaction().commit();
        } catch (Exception e){
            resultado = true;
            e.printStackTrace();
        }
        // aqui verifico se o resultado que ocorreu é igual ao esperado
        Assert.assertEquals(false, resultado);
    }
    
    
    
}
