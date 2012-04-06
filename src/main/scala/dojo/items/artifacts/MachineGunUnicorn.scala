package dojo.items.artifacts

import dojo.items.TimedItem

class MachineGunUnicorn(id:Int) extends ArtifactItem(id) with TimedItem {
  protected def action = "Bam-Bam"
}
