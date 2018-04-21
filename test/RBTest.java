/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gustavo
 */
public class RBTest {
    
    public RBTest() {
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
     * Test of put method, of class RB.
     */
    @Test
    public void testPut() {
        System.out.println("put");
        Object key = null;
        Object val = null;
        RB instance = new RB();
        instance.put((Comparable) key, val);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of deleteMin method, of class RB.
     */
    @Test
    public void testDeleteMin() {
        System.out.println("deleteMin");
        RB instance = new RB();
        instance.deleteMin();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of deleteMax method, of class RB.
     */
    @Test
    public void testDeleteMax() {
        System.out.println("deleteMax");
        RB instance = new RB();
        instance.deleteMax();
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of delete method, of class RB.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Object key = null;
        RB instance = new RB();
        instance.delete((Comparable) key);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    
}
