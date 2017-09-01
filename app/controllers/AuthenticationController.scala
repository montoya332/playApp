package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import java.util.Calendar
import play.api.libs.json.{ JsValue, Json }

@Singleton
class AuthenticationController @Inject() extends Controller {
	def Response(data: JsValue = Json.obj(), success: Boolean = true): JsValue = {
		Json.obj(
			"data" -> data,
			"success" -> success,
			"time" -> Calendar.getInstance().getTime.toString
		)
	}
	def login = Action {
		Ok(Response(Json.parse("{\"user\":123}")))
	}
	def authenticate = Action {
		Ok(Response(Json.parse("{\"user\":123}")))
	}
	def logout = Action {
		Ok(Response(Json.parse("{\"user\":123}")))
	}

}
