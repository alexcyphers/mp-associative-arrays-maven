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


  @Test
  public void cyphersAlexTest2() throws Exception {
    AssociativeArray<String, String> aa = 
       new AssociativeArray<String, String>();

    aa.set("key1", "microwave");
    aa.set("key2", "spoon");
    aa.set("key3", "bike");
    aa.set("key4", "pineapple");

    assertEquals(aa.get("key1"), "microwave", "M: We can get the value from the first key.");
    aa.remove("key1");
    assertFalse(aa.get("key1").equals("microwave"), "M: We can't get the value from the first key after it's been removed.");
    aa.remove("key3");
    assertFalse(aa.get("key3").equals("bike"), "M: We can't get the value from a middle key after it's been removed.");
    assertEquals(aa.get("key2"), "spoon", "M: We can still get a value that has not been removed");
  } // cyphersAlexTest2()


  @Test
  public void cyphersAlexEdge1() throws Exception {
  } // cyphersAlexEdge1()
} // class TestsFromSam
