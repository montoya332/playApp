package v1.user

import javax.inject.Inject

import play.api.routing.Router.Routes
import play.api.routing.SimpleRouter
import play.api.routing.sird._

/*  Routes and URLs to the UserResource controller. */
class UserRouter @Inject()(controller: UserController) extends SimpleRouter {
	val prefix = "/v1/users"

	override def routes: Routes = {
		case GET(p"/")				=>	controller.list
		case POST(p"/")				=>	controller.create
		case GET(p"/$id")			=>	controller.details(id.toLong: Long)
		case PUT(p"/$id")			=>	controller.update(id.toLong: Long)
		case DELETE(p"/$id")		=>	controller.delete(id.toLong: Long)
	}

}
