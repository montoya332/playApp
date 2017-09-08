package controllers

import javax.inject.{Inject, Singleton}

import play.api.mvc.{Action, Controller}
import play.api.libs.json._

@Singleton
class PetItemsController @Inject() extends Controller {

  def index = Action{
    Ok(Json.obj(
      "id" -> 1,
      "name" -> "Kuma",
      "price" -> 30000
    ))
  }
  def list = Action{ NotImplemented }
}
