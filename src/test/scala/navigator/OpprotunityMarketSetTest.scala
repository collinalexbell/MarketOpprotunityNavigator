package navigator

import org.scalatest._
import flatspec._
import matchers._

class OpprotunityMarketSetTest extends AnyFlatSpec with should.Matchers {
  "A customer grouping" should "be added via the RootCustomer" in {
    val grouping = RootCustomer.addSubGrouping("a subgrouping of customer")
    RootCustomer.subGroupings.length should be(1)
    grouping.description should be("a subgrouping of customer")
  }

  it should "have a level that is relative to the root" in {
    val customer = RootCustomer.addSubGrouping("a subgrouping of customer")
    val subCustomer = customer.addSubGrouping("a sub sub grouping")
    customer.level should be(1)
    subCustomer.level should be(2)
  }
}
