package org.example.entities;

import javax.persistence.*;


@Entity
@Table(name = "commande_produit")
public class CommandeProduit {
    @EmbeddedId
    private CommandeProduitPK id;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("commandeId")
    private Commande commande;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("produitId")
    private Produit produit;
    @Column(nullable = false)
    private int quantite;
    public CommandeProduit() {}
    public CommandeProduit(Commande commande, Produit produit, int quantite) {
        this.commande = commande;
        this.produit = produit;
        this.quantite = quantite;
        this.id = new CommandeProduitPK();
        this.id.setCommandeId(commande.getId());
        this.id.setProduitId(produit.getProduitId());
    }
    // getters/setters
    public int getQuantite() { return quantite; }
    public void setQuantite(int quantite) { this.quantite = quantite; }

}
