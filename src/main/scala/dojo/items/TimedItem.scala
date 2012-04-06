package dojo.items

trait TimedItem {

  var now: Int = -1

  var delay: Int = -1

  protected def action: String

  def ready(now:Int) = {
    now >= this.now + this.delay
  }

  def act(now:Int) : Option[Any] = {
    if (ready(now)) {
      Some(action)
    } else {
      None
    }
  }
  
  def startClock(now:Int) = {
    this.now = now
  }

}
