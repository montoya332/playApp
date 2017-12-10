package v1.user

import java.util.concurrent.atomic.AtomicLong
import scala.collection.concurrent.TrieMap

case class UserItem(id: Long, name: String){
	println(s"My name is $name")
}

object UserShop {
	private val items = TrieMap.empty[Long, UserItem]
	private val seq = new AtomicLong

	def list(): Seq[UserItem] = ???

	def details(id: Long) = ???

	def create(name: String): Option[UserItem] = ???
	def delete(id: Long): Boolean = ???
	def size(): Int = ???
}
class UserId private (val underlying: Int) extends AnyVal {
	override def toString: String = underlying.toString
}

object UserId {
	def apply(raw: String): UserId = {
		require(raw != null)
		new UserId(Integer.parseInt(raw))
	}
}
