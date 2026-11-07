package org.example;

import org.example.entities.Produit;
import org.example.service.CrudService;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import java.math.BigDecimal;

import static org.example.dao.GenericDAO.emf;

public class App {
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            // Opérations multiples
            Produit p = new Produit("Clavier", new BigDecimal("49.99"), catService.getById(1L));
            em.persist(p);
            // Simuler une erreur
            if (p.getPrix().compareTo(BigDecimal.ZERO) < 0) {
                throw new IllegalArgumentException("Prix négatif");
            }
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.err.println("Transaction annulée : " + e.getMessage());
        } finally {
            em.close();
        }
    }
}
