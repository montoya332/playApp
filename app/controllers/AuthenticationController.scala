package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import java.util.Calendar
import play.api.libs.json.{ JsValue, Json }
import play.filters.csrf._
import play.filters.csrf.CSRF.Token

@Singleton
class AuthenticationController @Inject() extends Controller {
	def Response(data:Any, success: Boolean = true): JsValue = {
		val response: JsValue = data match {
			case x:JsValue => x
			case _ => Json.parse(data.toString)
		}
		Json.obj(
				"data" -> response,
				"success" -> success,
				"time" -> Calendar.getInstance().getTime.toString
			)
	}
	def login = Action {
		Ok(Response("{\"user\":123}"))
	}
	def authenticate = Action {
		Ok(Response("{\"user\":123}"))
	}
	def logout = Action {
		Ok(Response("{\"user\":123}"))
	}

}
