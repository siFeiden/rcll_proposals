package rcll.productbuilder;

import rcll.replicated.Goal;
import rcll.replicated.GoalFinishedEvent;
import rcll.replicated.ProductGoal;
import rcll.replicated.ProductElement.Base;
import rcll.replicated.ProductElement.Cap;
import rcll.replicated.ProductElement.Ring;

/**
 * Decides how a ProductElement is produced, i.e. turn the ProductElement into a tree of goals.
 * E.g. fetch additional resources, prepare machines etc.
 * Can be easily replaced to allow testing of different production schemes.
 */
public interface ProductPlanningStrategy {


  // TODO: Maybe these need a ProductionTree instead of a ProductElement as 2nd parameter.

  /**
   * Create a goal tree that cares for the production and delivery of the given base.
   * @param parent parent of the goal to be created
   * @param base the base to be produced
   * @param waitFor event to wait for
   * @param fireOnFinish event to fire after delivery
   * @return the goal tree for the given base
   */
  ProductGoal planBase(Goal parent, Base base, GoalFinishedEvent waitFor, GoalFinishedEvent fireOnFinish);

  /**
   * Create a goal tree that cares for the production and delivery of the given ring.
   * @param parent parent of the goal to be created
   * @param ring the ring to be produced
   * @param waitFor event to wait for
   * @param fireOnFinish event to fire after delivery
   * @return the goal tree for the given ring
   */
  ProductGoal planRing(Goal parent, Ring ring, GoalFinishedEvent waitFor, GoalFinishedEvent fireOnFinish);

  /**
   * Create a goal tree that cares for the production and delivery of the given cap.
   * @param parent parent of the goal to be created
   * @param cap the cap to be produced
   * @param waitFor event to wait for
   * @param fireOnFinish event to fire after delivery
   * @return the goal tree for the cap
   */
  ProductGoal planCap(Goal parent, Cap cap, GoalFinishedEvent waitFor, GoalFinishedEvent fireOnFinish);



  static ProductPlanningStrategy getDefaultStrategy() {
    return new ProductPlanningStrategy() {
      @Override
      public ProductGoal planBase(Goal parent, Base base, GoalFinishedEvent waitFor, GoalFinishedEvent fireOnFinish) {
        return new ProductGoal(parent, base, waitFor, fireOnFinish);
      }

      @Override
      public ProductGoal planRing(Goal parent, Ring ring, GoalFinishedEvent waitFor, GoalFinishedEvent fireOnFinish) {
        return new ProductGoal(parent, ring, waitFor, fireOnFinish);
      }

      @Override
      public ProductGoal planCap(Goal parent, Cap cap, GoalFinishedEvent waitFor, GoalFinishedEvent fireOnFinish) {
        return new ProductGoal(parent, cap, waitFor, fireOnFinish);
      }
    };
  }

}
