package dojo.items.fashion

import dojo.items.Purchasable

class Hat(id:Int) extends FashionItem(id) with Purchasable {
  def price = 5
}
