package rcll.replicated;

import java.util.Arrays;
import java.util.List;

public class Product {

  public final ProductElement.Base base;
  public final List<ProductElement.Ring> rings;
  public final ProductElement.Cap cap;

  public Product(ProductElement.Base base, ProductElement.Cap cap, ProductElement.Ring... rings) {
    this.base = base;
    this.rings = Arrays.asList(rings);
    this.cap = cap;
  }

  public int numRings() {
    return rings.size();
  }
}
