package navigator

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
class CustomerGrouping(
    val description: String,
    val level: Int
) {
  var subGroupings: List[CustomerGrouping] = List.empty[CustomerGrouping]
  def addSubGrouping(description: String): CustomerGrouping = {
    val rv = new CustomerGrouping(description, level + 1)
    subGroupings = rv :: subGroupings
    rv
  }
}

// All CustomerGroupings will be branches of the RootCustomer tree
// This is because CustomerGroupings must be compared on the same level of abstraction
// In order to compute levels of abstraction, groupings need a common root
object RootCustomer extends CustomerGrouping("root", 0) {}

case class MarketOpprotunity(
    application: Application,
    customerGrouping: CustomerGrouping
)
