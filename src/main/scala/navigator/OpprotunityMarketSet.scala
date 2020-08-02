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
case class CustomerGrouping(
    description: String,
    subGroupings: List[CustomerGrouping] = List.empty[CustomerGrouping]
)

case class MarketOpprotunity(
    application: Application,
    customerGrouping: CustomerGrouping
)
