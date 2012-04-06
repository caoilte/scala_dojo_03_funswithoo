package dojo.items.house

import dojo.items.Purchasable

class Chair(id:Int) extends HouseItem(id) with Purchasable {
  def price = 3
}
