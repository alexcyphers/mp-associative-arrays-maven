package edu.grinnell.csc207;

import edu.grinnell.csc207.util.AssociativeArray;
import edu.grinnell.csc207.util.NullKeyException;
import edu.grinnell.csc207.util.KeyNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

/**
 * A place for you to put your own tests (beyond the shared repo).
 *
 * @author Alex Cyphers
 */
public class TestsFromStudent {
  /**
   * A simple test.
   */
  @Test
  public void alwaysPass() throws Exception {
  } // alwaysPass()



  /**
   * Tests that hasKey works when trying to find character keys. It also 
   * must return false if the key is not in the array.
   *
   * @throws Exception
   */
  @Test
  public void cyphersAlexTest1() throws Exception {
    AssociativeArray<Character, Integer> alphaArray = 
        new AssociativeArray<Character, Integer>();
    
    for(char ch = 'a'; ch <= 'z'; ch++) {
      alphaArray.set(ch, (int) ch);
    } // for-loop
    assertEquals(alphaArray.hasKey('a'), true, "M: We can find the first key if it exists.");
    assertEquals(alphaArray.hasKey('g'), true, "M: We can find a middle key if it exists.");
    assertEquals(alphaArray.hasKey('z'), true, "M: We can find the last key if it exists.");
    assertEquals(alphaArray.hasKey('!'), false, "M: We can't find the key if it doesn't exist.");
  } // cyphersAlexTest1()

  /**
   * Tests that when you use set with a key that already exists
   * it correctly updates the value.
   *
   * @throws Exception
   */
  @Test
  public void cyphersAlexTest2() throws Exception {
    AssociativeArray<String, String> aa = 
       new AssociativeArray<String, String>();

    aa.set("key1", "microwave");
    assertEquals(aa.get("key1"), "microwave", "M: We can get the value from the first key.");
    aa.set("key1", "spoon");
    assertEquals(aa.get("key1"), "spoon","M: We can get the new value after changing the key.");
    aa.set("key1", "bike");
    assertEquals(aa.get("key1"), "bike", "M: Correct value after changing the key for the second time");
    aa.remove("key1");
    aa.set("key1", "pineapple");
    assertEquals(aa.get("key1"), "pineapple", "M: Correct value after removing and setting the key");
  } // cyphersAlexTest2()

  
  /**
   * Ensures that you can't get anything from an empty array and
   * that it will properly throw a key not found exception.
   *
   * @throws Exception
   */
  @Test
  public void cyphersAlexEdge1() throws Exception {
    AssociativeArray<Integer, Integer> aa = 
       new AssociativeArray<Integer, Integer>();

    assertThrows(KeyNotFoundException.class, () -> aa.get(1), "Throws exception trying get from empty array");
    aa.set(1, 20);
    assertEquals(aa.get(1), 20, "M: Check to see if set works properly has passed");
    aa.remove(1);
    assertThrows(KeyNotFoundException.class, () -> aa.get(1), "Throws exception after set and removal with an empty array");
    aa.hasKey(1);
  } // cyphersAlexEdge1()
} // class TestsFromSam
