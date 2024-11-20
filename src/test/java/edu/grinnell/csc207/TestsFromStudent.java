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
  } // cyphersAlexTest2()


  @Test
  public void cyphersAlexEdge1() throws Exception {
  } // cyphersAlexEdge1()
} // class TestsFromSam
