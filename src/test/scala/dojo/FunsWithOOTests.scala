package dojo

import items.Item
import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

@RunWith(classOf[JUnitRunner])
class FunsWithOOTests extends FunSuite with ShouldMatchers {

  test("all items should have an id"){
    class TestItem(id:Int) extends Item(id)

    val testItem = new TestItem(5)
    testItem.id should equal (5)

  }

  // all fashion and house items should be able to be bought for cash deducted from user

  // MachineGunUnicorn and JukeBox have special actions that are available a set time after creation
  // * MachineGunUnicorn prints Bam-Bam
  // * JukeBox prints Blah-Blah

}
