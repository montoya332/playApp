package v1.pet

import javax.inject.{Inject, Singleton}
import play.api.mvc.{Action, Controller}
import play.api.libs.json._
import v1.pet.{PetItem, PetShop}

@Singleton
class PetController @Inject() extends Controller {
	implicit val readsPetItem = Json.reads[PetItem]
	implicit val petItemWrites = new Writes[PetItem] {
		def writes(pet: PetItem) = Json.obj(
			"id" -> pet.id,
			"name" -> pet.name,
			"price" -> pet.price
		)
	}
	val petShop = PetShop

	def initialize = Action {
		petShop.create("Kuma", 3000 )
		petShop.create("Rex", 3000 )
		Ok("Created Two Items")
	}
	def list = Action{
		Ok(Json.toJson(petShop.list))
	}
	def details(id: Long) = Action{
		petShop.details(id) match {
			case Some(item) => Ok(Json.toJson(item))
			case None => NotFound
		}
	}
	def create = Action(parse.json) { request =>
		(request.body \ "name").asOpt[String].map { name =>
			Ok("Hello " + name)
		}.getOrElse {
			BadRequest("Missing parameter [name]")
		}
	}
	
	def update(id: Long) = Action{ NotImplemented }
	def delete(id: Long) = Action{ NotImplemented }
}
