/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Compte;
import bean.Operation;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lina
 */
public class OperationFacadeTest {
    
    public OperationFacadeTest() {
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
     * Test of save method, of class OperationFacade.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        Operation operation = new Operation(new Date(), 1, 100.0);
        Compte compte = new  CompteFacade().find("EE1");
        boolean simuler = false;
        OperationFacade instance = new OperationFacade();
        int expResult = 1;
        int result = instance.save(operation, compte, simuler);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
