package rcll.knowledgestore;

public class KS {

  private static KS instance;

  private OrderStore orders;
  private RobotStore robots;
  private MachineStore cyan;
  private MachineStore magenta;


  private KS() {

  }


  public static void initialize() {
     instance = new KS();
  }

  private static KS getInstance() {
    if ( instance == null ) {
      final String message = "KnowledgeStore must be initialized before use";
      throw new IllegalStateException(message);
    }

    return instance;
  }

  public static OrderStore orders() {
    final KS ks = getInstance();
    return ks.orders;
  }

  public static RobotStore robots() {
    final KS ks = getInstance();
    return ks.robots;
  }

  public static MachineStore cyan() {
    final KS ks = getInstance();
    return ks.cyan;
  }

  public static MachineStore magenta() {
    final KS ks = getInstance();
    return ks.magenta;
  }

  /*public static MachineStore team(Team team) {
    return Team.CYAN.equals(team) ? cyan() : magenta();
  }*/

}
