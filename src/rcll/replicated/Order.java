package rcll.replicated;

/**
 * Dummy for our order class.
 * Replicated from original code.
 */
public class Order {

  public final Product product;
  public final int amount;
  public final long deadline;

  public Order(Product product, int amount, long deadline) {
    this.product = product;
    this.amount = amount;
    this.deadline = deadline;
  }

  public Product getProduct() {
    return product;
  }

  public int getAmount() {
    return amount;
  }

  public long getDeadline() {
    return deadline;
  }
}
