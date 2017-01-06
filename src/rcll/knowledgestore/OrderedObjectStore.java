package rcll.knowledgestore;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.function.Predicate;

/**
 * An object store that keeps the elements in order.
 * @param <V> type of the stored objects
 */
class OrderedObjectStore<V> implements ObjectStore<V> {

  private final PriorityQueue<V> elements;

  protected OrderedObjectStore(Comparator<V> elementComparator) {
    elements = new PriorityQueue<V>(elementComparator);
  }

  @Override
  public void add(V element) {
    elements.add(element);
  }

  @Override
  public V find(Predicate<V> choice) {
    return elements.stream()
        .filter(choice)
        .findFirst()
        .orElse(null);
  }

  public V first() {
    return elements.poll();
  }

  @Override
  public int size() {
    return elements.size();
  }
}
