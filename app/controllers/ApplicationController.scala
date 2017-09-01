package controllers

import javax.inject._
import play.api._
import play.api.mvc._

@Singleton
class ApplicationController @Inject() extends Controller {

	def index = Action {
		Ok(views.html.index("Index Page"))
	}
}
