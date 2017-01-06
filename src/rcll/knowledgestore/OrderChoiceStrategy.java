package rcll.knowledgestore;

import rcll.replicated.Order;

import java.util.Comparator;

/**
 * Compares two orders and chooses the one that should be executed,
 * e.g. by number of rings or proximity of deadline or a combination
 * of attributes.
 */
public interface OrderChoiceStrategy extends Comparator<Order> {
}
