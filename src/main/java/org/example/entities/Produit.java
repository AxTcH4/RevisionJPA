package org.example.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "produits")
@NamedQueries({
        @NamedQuery(name = "Produit.findAll", query = "SELECT p FROM Produit p"),
        @NamedQuery(name = "Produit.findByCategorie", query = "SELECT p FROM Produit p WHERE p.categorie.id = :catId"),
        @NamedQuery(name = "Produit.searchByLibelle", query = "SELECT p FROM Produit p WHERE LOWER(p.libelle) LIKE LOWER(CONCAT('%', :term, '%'))")
})
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String libelle;

    @Column(precision = 10, scale = 2)
    private BigDecimal prix;

    @Column(name = "date_creation")
    private LocalDate dateCreation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categorie_id", nullable = false)
    private Categorie categorie;

    // Constructeurs, getters, setters, toString
    public Produit() {}
    public Produit(String libelle, BigDecimal prix, Categorie categorie) {
        this.libelle = libelle;
        this.prix = prix;
        this.categorie = categorie;
        this.dateCreation = LocalDate.now();
    }
    // getters & setters omitted for brevity
    public Long getProduitId() { return id; }
    public void setProduitId(Long id) { this.id = id; }
    public String getLibelle() { return libelle; }
    public BigDecimal getPrix() { return prix; }
    public LocalDate getDateCreation() { return dateCreation; }
    public Categorie getCategorie() { return categorie; }

    public void setCategorie(Categorie categorie) {
    }
}