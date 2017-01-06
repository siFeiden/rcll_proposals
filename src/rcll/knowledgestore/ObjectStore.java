package rcll.knowledgestore;

import java.util.function.Predicate;

interface ObjectStore<V> {

  void add(V element);

  /**
   * Find the only contained element matching choice.
   * @param choice predicate to check all elements against
   * @return the element matching the given predicate
   */
  V find(Predicate<V> choice);

  int size();
}
