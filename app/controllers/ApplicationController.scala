package controllers

import javax.inject._
import play.api._
import play.api.mvc._

@Singleton
class ApplicationController @Inject() extends Controller {

	def index = Action {
		Ok(views.html.index("Index Page"))
	}
	def login = Action {
		Ok(views.html.index("login Page"))
	}
	def authenticate = Action {
		Ok(views.html.index("authenticate Page"))
	}
	def logout = Action {
		Ok(views.html.index("logout Page"))
	}

}
