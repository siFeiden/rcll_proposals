package rcll.replicated;

/**
 * Dummy for our ConditionedGoal.
 * Replicated from original code.
 */
public class ConditionedGoal extends Goal {

  private final GoalFinishedEvent waitFor;
  private final GoalFinishedEvent fireOnFinish;

  public ConditionedGoal(Goal parent, GoalFinishedEvent waitFor, GoalFinishedEvent fireOnFinish) {
    super(parent);
    this.waitFor = waitFor;
    this.fireOnFinish = fireOnFinish;
  }

  public GoalFinishedEvent getWaitFor() {
    return waitFor;
  }

  public GoalFinishedEvent getFireOnFinish() {
    return fireOnFinish;
  }
}
