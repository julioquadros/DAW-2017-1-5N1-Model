
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Estado;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
public class TesteRemoverEstado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DAW-2017-1-5N1ModelPU");
        EntityManager em = emf.createEntityManager(); 
        Estado e = em.find(Estado.class, 3);
        em.getTransaction().begin();
        em.remove(e);
        em.getTransaction().commit();
    }

}
