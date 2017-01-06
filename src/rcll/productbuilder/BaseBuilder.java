package rcll.productbuilder;

import rcll.replicated.ProductElement;

public interface BaseBuilder {

  RingBuilder base(ProductElement.Base base);

  default RingBuilder base(ProductElement.Color color) {
    return base(new ProductElement.Base(color));
  }
}
