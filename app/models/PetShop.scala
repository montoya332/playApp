package models
import java.util.concurrent.atomic.AtomicLong
import scala.collection.concurrent.TrieMap

case class PetItem(id: Long, name: String, price: Double){
  println(s"My name is $name")
}

trait Franchise {
  def list(): Seq[PetItem]
  def details(id: Long): Option[PetItem]
}

object PetShop extends Franchise {
  private val items = TrieMap.empty[Long, PetItem]
  private val seq = new AtomicLong

  items.put(1, PetItem(1, "Kuma", 3000) )
  items.put(2, PetItem(2, "Rex", 3000) )

  def list(): Seq[PetItem] = items.values.to[Seq]

  def details(id: Long) = items.get(id)

  def create(name: String, price: Double): Option[PetItem] = {
    val id = seq.incrementAndGet()
    val item = PetItem(id, name, price)
    items.put(id, item)
    Some(item)
  }
}
