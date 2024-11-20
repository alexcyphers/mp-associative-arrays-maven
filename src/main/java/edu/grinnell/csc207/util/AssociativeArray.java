package edu.grinnell.csc207.util;

import static java.lang.reflect.Array.newInstance;

/**
 * A basic implementation of Associative Arrays with keys of type K
 * and values of type V. Associative Arrays store key/value pairs
 * and permit you to look up values by key.
 *
 * @param <K> the key type
 * @param <V> the value type
 *
 * @author Alex Cyphers
 * @author Samuel A. Rebelsky
 */
public class AssociativeArray<K, V> {
  // +-----------+---------------------------------------------------
  // | Constants |
  // +-----------+

  /**
   * The default capacity of the initial array.
   */
  static final int DEFAULT_CAPACITY = 16;

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The size of the associative array (the number of key/value pairs).
   */
  int size;

  /**
   * The array of key/value pairs.
   */
  KVPair<K, V>[] pairs;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new, empty associative array.
   */
  @SuppressWarnings({ "unchecked" })
  public AssociativeArray() {
    // Creating new arrays is sometimes a PITN.
    this.pairs = (KVPair<K, V>[]) newInstance((new KVPair<K, V>()).getClass(),
        DEFAULT_CAPACITY);
    this.size = 0;
  } // AssociativeArray()

  // +------------------+--------------------------------------------
  // | Standard Methods |
  // +------------------+

  /**
   * Create a copy of this AssociativeArray.
   *
   * @return a new copy of the array
   */
  public AssociativeArray<K, V> clone() {
    AssociativeArray<K, V> arr = new AssociativeArray<>();
    try {
      for (int i = 0; i < this.size; i++) {
        arr.set(this.pairs[i].key, this.pairs[i].val);
      } // for-loop
    } catch (NullKeyException e) {
      //Do nothing because we are just copying the array.
    } // try-catch

    return arr;
  } // clone()

  /**
   * Convert the array to a string.
   *
   * @return a string of the form "{Key0:Value0, Key1:Value1, ... KeyN:ValueN}"
   */
  public String toString() {

    String str = "";

    for (int i = 0; i < this.size; i++) {
      String strKey = "";
      String strVal = "";

      if (this.pairs[i].key == null) {
        strKey = "null";
      } else {
        strKey = this.pairs[i].key.toString();
      } // if/else

      if (this.pairs[i].val == null) {
        strVal = "null";
      } else {
        strVal = this.pairs[i].val.toString();
      } // if/else

      str = str + strKey + ":" + strVal + ", ";
    } // for-loop

    return "{" + str + "}";
  } // toString()

  // +----------------+----------------------------------------------
  // | Public Methods |
  // +----------------+

  /**
   * Set the value associated with key to value. Future calls to
   * get(key) will return value.
   *
   * @param key
   *   The key whose value we are setting.
   * @param value
   *   The value of that key.
   *
   * @throws NullKeyException
   *   If the client provides a null key.
   */
  public void set(K key, V value) throws NullKeyException {

    if (key == null) {
      throw new NullKeyException();
    } // if

    if (this.hasKey(key)) {
      try {
        int index = find(key);
        pairs[index].val = value;
        return;
      } catch (KeyNotFoundException e) {
        // Do nothing: We shouldn't get an exception.
      } // try-catch
    } else {
      if (this.size == pairs.length) {
        expand();
      } // if
      pairs[this.size++] = new KVPair<>(key, value);
    } // if/else
  } // set(K,V)

  /**
   * Get the value associated with key.
   *
   * @param key
   *   A key
   *
   * @return
   *   The corresponding value
   *
   * @throws KeyNotFoundException
   *   when the key is null or does not appear in the associative array.
   */
  public V get(K key) throws KeyNotFoundException {

    if (key == null) {
      throw new KeyNotFoundException();
    } // if

    for (int i = 0; i < this.size; i++) {
      if (pairs[i].key.equals(key)) {
        return pairs[i].val;
      } // if
    } // for-loop

    throw new KeyNotFoundException();
  } // get(K)

  /**
   * Determine if key appears in the associative array. Should
   * return false for the null key, since it cannot appear.
   *
   * @param key
   *   The key we're looking for.
   *
   * @return true if the key appears and false otherwise.
   */
  public boolean hasKey(K key) {
    for (int i = 0; i < this.size; i++) {
      if (pairs[i].key.equals(key)) {
        return true;
      } // if
    } // for-loop
    return false;
  } // hasKey(K)

  /**
   * Remove the key/value pair associated with a key. Future calls
   * to get(key) will throw an exception. If the key does not appear
   * in the associative array, does nothing.
   *
   * @param key
   *   The key to remove.
   */
  public void remove(K key) {

    if (!this.hasKey(key)) {
      return;
    } // if

    int index = 0;

    for (int i = 0; i < this.size; i++) {
      if (pairs[i].key.equals(key)) {
        index = i;
      } // if
    } // for-loop

    for (int i = index; i < this.size - 1; i++) {
      pairs[i] = pairs[i + 1];
    } // for-loop

    this.size--;
  } // remove(K)

  /**
   * Determine how many key/value pairs are in the associative array.
   *
   * @return The number of key/value pairs in the array.
   */
  public int size() {
    return this.size;
  } // size()

  // +-----------------+---------------------------------------------
  // | Private Methods |
  // +-----------------+

  /**
   * Expand the underlying array.
   */
  void expand() {
    this.pairs = java.util.Arrays.copyOf(this.pairs, this.pairs.length * 2);
  } // expand()

  /**
   * Find the index of the first entry in `pairs` that contains key.
   * If no such entry is found, throws an exception.
   *
   * @param key
   *   The key of the entry.
   *
   * @return
   *   The index of the key, if found.
   *
   * @throws KeyNotFoundException
   *   If the key does not appear in the associative array.
   */
  int find(K key) throws KeyNotFoundException {
    for (int i = 0; i < this.size; i++) {
      if (pairs[i].key.equals(key)) {
        return i;
      } // if
    } // for-loop
    throw new KeyNotFoundException();
  } // find(K)
} // class AssociativeArray
