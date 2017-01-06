package rcll.knowledgestore;

import java.util.function.Predicate;

public class FixedSizeObjectStore<V> implements ObjectStore<V> {

  private final SimpleObjectStore<V> store;
  private final int maxSize;

  public FixedSizeObjectStore(int maxSize) {
    this.maxSize = maxSize;
    this.store = new SimpleObjectStore<V>();
  }

  @Override
  public void add(V element) {
    if ( store.size() < maxSize )
      store.add(element);
  }

  @Override
  public V find(Predicate<V> choice) {
    return store.find(choice);
  }

  @Override
  public int size() {
    return store.size();
  }
}
