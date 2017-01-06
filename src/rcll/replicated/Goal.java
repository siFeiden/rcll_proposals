package rcll.replicated;

/**
 * Dummy for ActorSim rcll Goal with minimal implementation.
 * Replicated from original code.
 */
public class Goal {

  private final Goal parent;

  public Goal(Goal parent) {
    this.parent = parent;
  }

  public void formulate(StrategyDetails details) {

  }
}
