/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Compte;
import bean.Operation;
import java.util.ArrayList;
import java.util.Date;
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
        
    Operation operation = new Operation(new Date(), 1, montantCredit);
    return new OperationFacade().save(operation, compte, simuler);
    }

    public int debiter(Compte compte, double montantCredit, boolean simuler) {
        Operation operation = new Operation(new Date(), 2, montantCredit);
        return new OperationFacade().save(operation, compte, simuler);
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
    public void deleteByRib(String rib){
       // return getEntityManager().createQuery("DELETE FROM Compte c WHERE c.rib = '"+rib+"'").executeUpdate();
        remove(new  Compte(rib, 0.0));
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
