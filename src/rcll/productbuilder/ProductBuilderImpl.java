package rcll.productbuilder;

import rcll.replicated.Goal;
import rcll.replicated.GoalFinishedEvent;
import rcll.replicated.ProductGoal;
import rcll.replicated.StrategyDetails;
import rcll.replicated.ProductElement.Base;
import rcll.replicated.ProductElement.Cap;
import rcll.replicated.ProductElement.Ring;

import java.util.ArrayList;
import java.util.List;


/**
 * A multi-step builder that translates ProductElements into a hierarchy of rcll.
 * 1. step: Add a base.
 * 2. step: Add one or more rings.
 * 3. step: Add a cap.
 * 4. step: build goal tree.
 */
public class ProductBuilderImpl implements BaseBuilder, RingBuilder, CapBuilder {


  private final ProductPlanningStrategy planningStrategy;

  private Base base;
  private List<Ring> rings;
  private Cap cap;


  public ProductBuilderImpl(ProductPlanningStrategy planningStrategy) {
    this.planningStrategy = planningStrategy;

    this.rings = new ArrayList<>();
  }

  @Override
  public RingBuilder base(Base base) {
    this.base = base;
    return this;
  }

  @Override
  public RingBuilder ring(Ring ring) {
    this.rings.add(0, ring);
    return this;
  }

  @Override
  public CapBuilder cap(Cap cap) {
    this.cap = cap;
    return this;
  }

  @Override
  public ProductGoal build(Goal parent, StrategyDetails details) {
    GoalFinishedEvent waitFor = null;
    GoalFinishedEvent fireOnFinish = new GoalFinishedEvent();

    // Plan cap first since it should be topmost in the production goal tree.
    ProductGoal goal = planningStrategy.planCap(parent, this.cap, waitFor, fireOnFinish);

    // Plan rings.
    for ( final Ring ring : rings ) {
      waitFor = fireOnFinish;
      fireOnFinish = new GoalFinishedEvent();

      goal = planningStrategy.planRing(goal, ring, waitFor, fireOnFinish);
    }

    waitFor = fireOnFinish;
    fireOnFinish = new GoalFinishedEvent();

    // Plan base.
    goal = planningStrategy.planBase(goal, this.base, waitFor, fireOnFinish);

    return goal;
  }
}
