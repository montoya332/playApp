package v1.user

import javax.inject.{Inject, Singleton}
import play.api.mvc.{Controller}

@Singleton
class UserController @Inject() extends Controller {
	implicit val readsUserItem = ???
	implicit val userItemWrites = ???

	def list = ???
	def details(id: Long) = ???
	def create = ???
	
	def update(id: Long) = ???
	def delete(id: Long) = ???
}
