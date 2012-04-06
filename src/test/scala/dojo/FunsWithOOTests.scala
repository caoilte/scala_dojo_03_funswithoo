package dojo

import items.artifacts.{MachineGunUnicorn, Unicorn}
import items.fashion.Hat
import items.house.{JukeBox, Chair}
import items.{Item, Purchasable, TimedItem, User}
import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

@RunWith(classOf[JUnitRunner])
class FunsWithOOTests extends FunSuite with ShouldMatchers{

  // all items should have an id
  test("Unicorn should have id of 1"){
    new Unicorn(1).id should equal (1)
  }

  test("anonymous items should have an id"){
    new Item(2) {}.id should equal (2)
  }

  // all fashion and house items should be able to be bought for cash deducted from user

  test("should buy hat and deduct 5 cash from user"){
    assertPurchasableItemCashDeduction(new Hat(1))
  }

  test("should buy chair and deduct 3 cash from user"){
    assertPurchasableItemCashDeduction(new Chair(1))
  }

  def assertPurchasableItemCashDeduction(item:Purchasable){
    val balance = 10
    val user = new User(balance)
    user.buy(item)
    user.cash should equal (10 - item.price)
  }

  // MachineGunUnicorn and JukeBox have special actions that are available a set time after creation
  // * MachineGunUnicorn prints Bam-Bam
  // * JukeBox prints Blah-Blah

  test("MachineGunUnicorn goes Bam-Bam"){
    val machineGunUnicorn = new MachineGunUnicorn(1)
    val delay = 10
    machineGunUnicorn.delay = delay
    assertTimedItem(Some("Bam-Bam"), machineGunUnicorn, delay)
  }

  test("JukeBox goes Blah-Blah"){
    val jukeBox = new JukeBox(1)
    val delay = 10
    jukeBox.delay = delay
    assertTimedItem(Some("Blah-Blah"), jukeBox, delay)
  }

  def assertTimedItem(expected: Some[Any], timedItem: TimedItem, delay: Int){
    val now = 10
    timedItem.startClock(now)

    timedItem.ready(now)          should  equal (false)
    timedItem.act(now + delay -1) should  equal (None)

    timedItem.ready(now + delay)  should  equal (true)
    timedItem.act(now + delay)    should  equal (expected)
  }

}
