package dojo.items.house

import dojo.items.TimedItem

class JukeBox(id:Int) extends HouseItem(id) with TimedItem {
  protected def action = "Blah-Blah"

}
