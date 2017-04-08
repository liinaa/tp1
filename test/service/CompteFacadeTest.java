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
        String rib = "";
        double soldeInitial = 0.0;
        CompteFacade instance = new CompteFacade();
        instance.ouvrirCompte(rib, soldeInitial);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fermerCompte method, of class CompteFacade.
     */
    @Test
    public void testFermerCompte() {
        System.out.println("fermerCompte");
        Compte compte = null;
        CompteFacade instance = new CompteFacade();
        boolean expResult = false;
        boolean result = instance.fermerCompte(compte);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of crediter method, of class CompteFacade.
     */
    @Test
    public void testCrediter() {
        System.out.println("crediter");
        Compte compte = null;
        double montantCredit = 0.0;
        boolean simuler = false;
        CompteFacade instance = new CompteFacade();
        int expResult = 0;
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
        Compte compte = null;
        double montant = 0.0;
        boolean simuler = false;
        CompteFacade instance = new CompteFacade();
        int expResult = 0;
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
        Compte compteSource = new Compte(rib, Double.NaN, true, 0);
        Compte compteDestination = null;
        double montant = 0.0;
        CompteFacade instance = new CompteFacade();
        int expResult = 0;
        int result = instance.transferer(compteSource, compteDestination, montant);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
