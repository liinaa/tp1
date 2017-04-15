/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Compte;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author poste HP
 */
public class CompteFacade extends AbstractFacade<Compte> {

    public CompteFacade() {
        super(Compte.class);
    }

    public void ouvrirCompte(String rib, double soldeInitial) {
        char categorie = 'A';
        if (soldeInitial >= 0 && soldeInitial < 200) {
            categorie = 'D';
        }
        if (soldeInitial >= 200 && soldeInitial < 1000) {
            categorie = 'C';
        }
        if (soldeInitial >= 1000 && soldeInitial < 60000) {
            categorie = 'B';
        } else {
            categorie = 'A';
        }
        create(new Compte(rib, soldeInitial, true, categorie));

    }
   

    public boolean fermerCompte(Compte compte) {
        if (compte != null && compte.getSolde() == 0) {
            compte.setOuvert(false);
            edit(compte);
            return true;
        } else {
            return false;
        }
    }

    public int crediter(Compte compte, double montantCredit, boolean simuler) {

        if (compte == null || compte.isOuvert() == false) {
            return -1;
        } else {
            if (simuler == false) {
                compte.setSolde(montantCredit + compte.getSolde());
                edit(compte);
            }
            return 1;
        }
    }

    public int debiter(Compte compte, double montant, boolean simuler) {
        if (compte == null) {

            return -1;
        } else if (compte.isOuvert() == false) {

            return -2;
        } else if (compte.getSolde() < montant) {

            return -3;
        } else if (compte.getSolde() < 100) {
            return -4;
        } else if (montant >= 6000) {

            return -5;
        } else {
            if (simuler == false) {
                compte.setSolde(compte.getSolde() - montant);
                edit(compte);
            }
            return 1;
        }
    }

    public int transferer(Compte compteSource, Compte compteDestination, double montant) {
        int resDebit = debiter(compteSource, montant, true);
        if (resDebit > 0) {
            int resCredit = crediter(compteDestination, montant, true);
            if (resCredit > 0) {
                debiter(compteSource, montant, false);
                crediter(compteDestination, montant, false);
                return 1;
            }
            return resCredit;
        }
        return resDebit;
    }
    public List<Compte> findByClasseDump(char classe){
        List<Compte> comptes = findAll();
        List<Compte> compteResult = new ArrayList<Compte>();
        for (Compte compte : comptes) {
            if(compte.getCategorie()==classe){
                compteResult.add(compte);
            }
        }
        return compteResult;
    }
    public List<Compte> findByClasse(char classe){
      
        return getEntityManager().createQuery("SELECT  c FROM Compte c WHERE c.categorie ='"+classe+"'").getResultList();
    }
    public List<Compte> findBySolde(double soldeMin){
        return getEntityManager().createQuery("SELECT c FROM Compte c WHERE c.solde >= '"+soldeMin+"'").getResultList();
    }
    public int deleteByRib(String rib){
        return getEntityManager().createQuery("DELETE FROM Compte c WHERE c.rib = '"+rib+"'").executeUpdate();

    }
    
    public static void main(String[] args) {
        CompteFacade compteFacade = new CompteFacade();
       /* for (int i = 2; i < 10; i++) {
            compteFacade.ouvrirCompte("EE"+i, i*100.0);
        } */
         for (int i = 5; i < 10; i++) {
            compteFacade.ouvrirCompte("EF"+i, i*400.0);
        }
    }
}
