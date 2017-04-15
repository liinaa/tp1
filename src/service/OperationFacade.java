/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Compte;
import bean.Operation;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Lina
 */
public class OperationFacade extends AbstractFacade<Operation> {

    public OperationFacade() {
        super(Operation.class);
    }

    public int save(Operation operation, Compte compte, boolean simuler) {
        Double montant = operation.getMontant();
        CompteFacade compteFacade = new CompteFacade();
        if (operation.getType() == 2) {
            if (compte.isOuvert() == false) {
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
                    compteFacade.edit(compte);
                    operation.setCompte(compte);
                    create(operation);
                }
                return 1;
            }
        } else if (operation.getType() == 1) {
            if (simuler == false) {
                compte.setSolde(montant + compte.getSolde());
                compteFacade.edit(compte);
                operation.setCompte(compte);
                create(operation);

            }
            return 1;

        }
        return -7;
    }
}
