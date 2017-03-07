package br.edu.ifsul.junit;

import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.Grupo;
import br.edu.ifsul.modelo.Marca;
import br.edu.ifsul.modelo.Produto;
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
public class TestePersistirProduto {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirProduto() {
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
            Grupo g = em.find(Grupo.class, 1);            
            Marca m = em.find(Marca.class, 1);
            Produto p = new Produto();
            p.setNome("Mouse Laser Dell");
            p.setDescricao("Mouse Laser");
            p.setPreco(130.00);
            p.setEstoque(20.0);
            p.setGrupo(g);
            p.setMarca(m);
            em.getTransaction().begin();
            em.persist(p);            
            em.getTransaction().commit();
        } catch (Exception e){
            resultado = true;
            e.printStackTrace();
        }
        // aqui verifico se o resultado que ocorreu é igual ao esperado
        Assert.assertEquals(false, resultado);
    }
    
    
    
}
