package rcll.replicated;

/**
 * Part of a product: Base, Ring or Cap with a color.
 * Replicated from original code.
 */
public class ProductElement {

  public enum Color {
    RED, BLACK, ORANGE, GREEN, GREY,
  }


  private final Color color;

  public ProductElement(Color color) {
    this.color = color;
  }

  public Color getColor() {
    return color;
  }

  public static class Cap extends ProductElement {

    public Cap(Color color) {
      super(color);
    }

    @Override
    public String toString() {
      return "Cap{" + getColor() + "}";
    }
  }


  public static class Ring extends ProductElement {

    public Ring(Color color) {
      super(color);
    }

    @Override
    public String toString() {
      return "Ring{" + getColor() + "}";
    }
  }


  public static class Base extends ProductElement {

    public Base(Color color) {
      super(color);
    }

    @Override
    public String toString() {
      return "Base{" + getColor() + "}";
    }
  }
}
