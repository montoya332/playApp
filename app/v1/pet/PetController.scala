package v1.pet

import javax.inject.{Inject, Singleton}
import play.api.mvc.{Action, Controller}
import play.api.libs.json._

@Singleton
class PetController @Inject() extends Controller {
	implicit val readsPetItem = Json.reads[models.PetItem]
	implicit val petItemWrites = new Writes[models.PetItem] {
		def writes(pet: models.PetItem) = Json.obj(
			"id" -> pet.id,
			"name" -> pet.name,
			"price" -> pet.price
		)
	}
	val petShop = models.PetShop

	def initialize = Action {
		petShop.create("Kuma", 3000 )
		petShop.create("Rex", 3000 )
		Ok("Created Two Items")
	}
	def list = Action{
		Ok(Json.toJson(petShop.list))
	}
	def details(id: String) = Action{ NotImplemented }
	// Action{
	// petShop.details(id) match {
	// 	case Some(item) => Ok("Ok(Json.toJson(item))")
	// 	case None => NotFound
	// 	}
	// }
	def create = Action(parse.json) { request =>
		(request.body \ "name").asOpt[String].map { name =>
			Ok("Hello " + name)
		}.getOrElse {
			BadRequest("Missing parameter [name]")
		}
	}


	def update(id: String) = Action{ NotImplemented }
	def delete(id: String) = Action{ NotImplemented }
}
