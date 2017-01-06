package rcll.productbuilder;

import rcll.replicated.ProductElement;

public interface RingBuilder {

  RingBuilder ring(ProductElement.Ring ring);

  default RingBuilder ring(ProductElement.Color color) {
    return ring(new ProductElement.Ring(color));
  }

  CapBuilder cap(ProductElement.Cap cap);

  default CapBuilder cap(ProductElement.Color color) {
    return cap(new ProductElement.Cap(color));
  }
}
