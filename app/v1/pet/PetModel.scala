package v1.pet

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

	def list(): Seq[PetItem] = items.values.to[Seq]

	def details(id: Long) = items.get(id)

	def create(name: String, price: Double): Option[PetItem] = {
		val id = seq.incrementAndGet()
		val item = PetItem(id, name, price)
		items.put(id, item)
		Some(item)
	}
	def delete(id: Long): Boolean = items.remove(id).isDefined
	def size(): Int = list().size
}
class PetId private (val underlying: Int) extends AnyVal {
	override def toString: String = underlying.toString
}

object PetId {
	def apply(raw: String): PetId = {
		require(raw != null)
		new PetId(Integer.parseInt(raw))
	}
}
