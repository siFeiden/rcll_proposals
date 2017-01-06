package rcll.knowledgestore;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SimpleObjectStore<V> implements ObjectStore<V> {

  private final List<V> elements;

  SimpleObjectStore() {
    elements = new ArrayList<V>();
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

  @Override
  public int size() {
    return elements.size();
  }
}
