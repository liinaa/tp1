/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Compte;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author poste HP
 */
public class CompteFacadeTest {
            CompteFacade instance = new CompteFacade();

    public CompteFacadeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of ouvrirCompte method, of class CompteFacade.
     */
    @Test
    public void testOuvrirCompte() {
        System.out.println("ouvrirCompte");
       /* String rib = "FF2";
        double soldeInitial = 300.0;
        instance.ouvrirCompte(rib, soldeInitial);
        // TODO review the generated test code and remove the default call to fail. */
    }

    /**
     * Test of fermerCompte method, of class CompteFacade.
     */
    @Test
    public void testFermerCompte() {
        System.out.println("fermerCompte");
        Compte compte = null;
        boolean expResult = false;
        boolean result = instance.fermerCompte(compte);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of crediter method, of class CompteFacade.
     */
    @Test
    public void testCrediter() {
        System.out.println("crediter");
        Compte compte = instance.find("EE2");
        double montantCredit = 0.0;
        boolean simuler = false;
        int expResult = 1;
        int result = instance.crediter(compte, montantCredit, simuler);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of debiter method, of class CompteFacade.
     */
    @Test
    public void testDebiter() {
        System.out.println("debiter");
        Compte compte = instance.find("EE5");
        double montant = 0.0;
        boolean simuler = false;
        int expResult = 1;
        int result = instance.debiter(compte, montant, simuler);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of transferer method, of class CompteFacade.
     */
    @Test
    public void testTransferer() {
        System.out.println("transferer");
        Compte compteSource = instance.find("EE1");
        Compte compteDestination = instance.find("EE0");
        double montant = 0.0;
        int expResult = 1;
        int result = instance.transferer(compteSource, compteDestination, montant);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    public void testFindByClasse(){
        System.out.println("FindByClasse");
        System.out.println(instance.findByClasse('A'));

    }
    public void testFindBySolde(){
         System.out.println("FindBySolde");
    }
    public void testDeleteByRib(){
         System.out.println("DeleteByRib");
         String rib1 = "EE1";
         int resultat = instance.deleteByRib(rib1);

    }
}
