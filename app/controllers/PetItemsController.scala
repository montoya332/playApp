package controllers

import javax.inject.{Inject, Singleton}

import play.api.mvc.{Action, Controller}
import play.api.libs.json._

@Singleton
class PetItemsController @Inject() extends Controller {
  case class PetItem(id: Long, name: String, price: Double)
  implicit val readsPet_Item = Json.reads[PetItem]
  implicit val pet_ItemWrites = new Writes[PetItem] {
    def writes(pet: PetItem) = Json.obj(
      "id" -> pet.id,
      "name" -> pet.name,
      "price" -> pet.price
    )
  }
  val pet = PetItem(1,"kuma",30000)

  def index = Action { NotImplemented }
  def list = Action{
    val list: Seq[PetItem] = Seq(pet)
    Ok(Json.toJson(list))
  }
  def detail(id: Long) = Action{
    Ok(Json.toJson(pet) )
  }
  def create = Action{ NotImplemented }
  def update = Action{ NotImplemented }
  def delete = Action{ NotImplemented }
}
