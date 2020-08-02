package navigator

import scala.collection.mutable.HashSet

case class Agent(
    currentAbilities: List[Ability],
    developingAbilities: List[Ability],
    plannedAbilities: List[Ability]
)

case class Ability(
    name: String,
    functions: List[String],
    properties: List[String]
)

case class Application(
    name: String,
    description: String,
    abilitiesRequired: List[Ability]
)

// Design Pattern: Composite
// TODO: Extract out the Composite functionality so this is uncluttered
class CustomerGrouping(
    val description: String,
    val level: Int,
    _parent: Option[CustomerGrouping] = None
) {
  var subGroupings: List[CustomerGrouping] = List.empty[CustomerGrouping]
  def addSubGrouping(description: String): CustomerGrouping = {
    val rv = new CustomerGrouping(description, level + 1, Some(this))
    subGroupings = rv :: subGroupings
    rv
  }
  def parent: CustomerGrouping = _parent.getOrElse(RootCustomer)
}

// All CustomerGroupings will be branches of the RootCustomer tree
// This is because CustomerGroupings must be compared on the same level of abstraction
// In order to compute levels of abstraction, groupings need a common root
object RootCustomer extends CustomerGrouping("root", 0) {
  override val parent: CustomerGrouping = this
}

case class MarketOpprotunity(
    application: Application,
    customerGrouping: CustomerGrouping
)

//TODO: Initial Screen
// Do the customer need exist?
// Can we really satisfy the customer need using our unique abilities, and better than existing solutions?
// Are there severe restrictions that would hunder us from executing on this market opprotunity?
// Will this opprotunity be in conflict with any of our core values?

object OpprotunityMarketSet {
  val current = HashSet[MarketOpprotunity]()
  val considerations = HashSet[MarketOpprotunity]()
}
