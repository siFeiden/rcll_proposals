package rcll;

import rcll.knowledgestore.KS;
import rcll.productbuilder.ProductPlanningStrategy;
import rcll.replicated.ProductElement.Color;
import rcll.replicated.ProductGoal;
import rcll.replicated.StrategyDetails;

public class Main {

  public static void main(String[] args) {

    // Example creation of a product.
    // See package productbuilder.

    // Strategy object that plans the different elements of the product
    final ProductPlanningStrategy productPlanner = ProductPlanningStrategy.getDefaultStrategy();

    // StrategyDetails like in the goal lifecycle.
    final StrategyDetails dummyDetails = new StrategyDetails();

    final ProductGoal goal = ProductGoal.builder(productPlanner)
        .base(Color.BLACK)
        .ring(Color.ORANGE)
        .ring(Color.GREEN)
        .cap(Color.GREY)
        .build(null, dummyDetails);

    System.out.println(goal);



    // Access the information in the global store:
    // See package knowledgestore

    KS.robots().byId(1); // robot with id 1

    KS.cyan().ringsOfColor(Color.RED); // ring station for red rings of team cyan

    KS.magenta().base(); // base station of team cyan

    KS.robots().closestTo(0, 1); // robot closest to position (0, 1)

    KS.orders().next(); // order that should be produced next
  }
}
