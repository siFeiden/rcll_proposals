package rcll.productbuilder;

import rcll.replicated.Goal;
import rcll.replicated.ProductGoal;
import rcll.replicated.StrategyDetails;

public interface CapBuilder {

  ProductGoal build(Goal parent, StrategyDetails details);
}
