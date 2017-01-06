package rcll.knowledgestore;

import rcll.replicated.Machine;
import rcll.replicated.ProductElement;

/**
 * Store all stations for a team. Stores at most six
 * machines (BS, 2xRS, 2xCS, DS).
 */
public class MachineStore extends FixedSizeObjectStore<Machine> {

  private static final int MACHINES_PER_TEAM = 6;


  public MachineStore() {
    super(MACHINES_PER_TEAM);
  }

  /**
   * Find the ring station that has the given color available.
   * @param color the color to find the ring station for
   * @return the ring station for the given color
   */
  public Machine ringsOfColor(ProductElement.Color color) {
    return null;
  }

  /**
   * Return the base station of this team.
   * @return the base station
   */
  public Machine base() {
    return null;
  }

  /**
   * Toggle the team of the contained machines:
   * cyan <-> magenta
   */
  public void toggleTeam() {
    // toggle team of stored machines
  }
}
