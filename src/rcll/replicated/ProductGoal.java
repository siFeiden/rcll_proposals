package rcll.replicated;

import rcll.productbuilder.BaseBuilder;
import rcll.productbuilder.ProductBuilderImpl;
import rcll.productbuilder.ProductPlanningStrategy;


/**
 * High level goal that executes the production of a product.
 * Replicated from original code.
 */
public class ProductGoal extends ConditionedGoal {


  private final ProductElement element;

  public ProductGoal(Goal parent, ProductElement element, GoalFinishedEvent waitFor, GoalFinishedEvent fireOnFinish) {
    super(parent, waitFor, fireOnFinish);

    this.element = element;
  }

  public static BaseBuilder builder(ProductPlanningStrategy planningStrategy) {
    return new ProductBuilderImpl(planningStrategy);
  }
}
