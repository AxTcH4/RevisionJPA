package org.example.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CommandeProduitPK implements Serializable {
    @Column(name = "commande_id")
    private Long commandeId;
    @Column(name = "produit_id")
    private Long produitId;
    // equals & hashCode

    public Long getCommandeId() { return commandeId; }
    public void setCommandeId(Long commandeId) { this.commandeId = commandeId; }

    public void setProduitId(Long produitId) {
        this.produitId = produitId;
    }
}

