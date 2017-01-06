package rcll.knowledgestore;

import rcll.replicated.Order;
import rcll.replicated.Product;

/**
 * Store all active orders.
 */
public class OrderStore extends OrderedObjectStore<Order> {

  /**
   * Create an OrderStore that chooses the next order to process
   * according to the given strategy.
   * @param orderChoice strategy to choose the next order
   */
  protected OrderStore(OrderChoiceStrategy orderChoice) {
    super(orderChoice);
  }

  /**
   * Return the next order that should be produced.
   * @return the next order
   */
  public Order next() {
    return first();
  }

  /**
   * Find the order that contains the given product.
   * @param product the product to look for
   * @return the order for the given product
   */
  public Order forProduct(Product product) {
    // find order containing product.
    return null;
  }
}
