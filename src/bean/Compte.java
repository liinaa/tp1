/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author poste HP
 */
@Entity
public class Compte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String rib;
    private Double solde;
    private boolean ouvert;
    private char categorie;
    @OneToMany(mappedBy = "compte")
    private List<Operation> operations;

    public List<Operation> getOperations() {
        if(operations==null)
            operations= new ArrayList();
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    
    public Compte() {
    }

    public Compte(String rib, Double solde) {
        this.rib = rib;
        this.solde = solde;
    }
    
    

    public Compte(String rib, Double solde, boolean ouvert, char categorie) {
        this.rib = rib;
        this.solde = solde;
        this.ouvert = ouvert;
        this.categorie = categorie;
    }

    public String getRib() {
        return rib;
    }

    public void setRib(String rib) {
        this.rib = rib;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rib != null ? rib.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compte)) {
            return false;
        }
        Compte other = (Compte) object;
        if ((this.rib == null && other.rib != null) || (this.rib != null && !this.rib.equals(other.rib))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Compte[ id=" + rib + " ]";
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }

    public boolean isOuvert() {
        return ouvert;
    }

    public void setOuvert(boolean ouvert) {
        this.ouvert = ouvert;
    }

    public char getCategorie() {
        return categorie;
    }

    public void setCategorie(char categorie) {
        this.categorie = categorie;
    }

}
