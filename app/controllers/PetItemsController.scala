package controllers

import javax.inject.{Inject, Singleton}
import models.PetItem

import play.api.mvc.{Action, Controller}
import play.api.libs.json._

@Singleton
class PetItemsController @Inject() extends Controller {
  implicit val readsPetItem = Json.reads[PetItem]
  implicit val petItemWrites = new Writes[PetItem] {
    def writes(pet: PetItem) = Json.obj(
      "id" -> pet.id,
      "name" -> pet.name,
      "price" -> pet.price
    )
  }
  val petShop = models.PetShop

  def index = Action { NotImplemented }
  def list = Action{
    Ok(Json.toJson(petShop.list))
  }
  def details(id: Long) = Action{
    Ok(Json.toJson(petShop.details(1)))
  }
  def create = Action{ NotImplemented }
  def update = Action{ NotImplemented }
  def delete = Action{ NotImplemented }
}
