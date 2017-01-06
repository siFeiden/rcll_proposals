package rcll.knowledgestore;

import rcll.replicated.Robot;

/**
 * Store all three robots.
 */
public class RobotStore extends FixedSizeObjectStore<Robot> {

  private static final int ROBOTS_PER_TEAM = 3;


  public RobotStore() {
    super(ROBOTS_PER_TEAM);
  }

  /**
   * Find the robot with the given id.
   * @param id the id to look for
   * @return the robot with the given id
   */
  public Robot byId(int id) {
    return this.find(r -> r.getId() == id);
  }

  /**
   * Find the robot closest to the given location,
   * @param x x coordinate of the location
   * @param y y coordinate of the location
   * @return the robot closest to (x,y)
   */
  public Robot closestTo(double x, double y) {
    // find closest robot
    return null;
  }
}
