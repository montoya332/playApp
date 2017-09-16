package v1.pet

import javax.inject.Inject

import play.api.routing.Router.Routes
import play.api.routing.SimpleRouter
import play.api.routing.sird._

/*  Routes and URLs to the PetResource controller. */
class PetRouter @Inject()(controller: PetController) extends SimpleRouter {
	val prefix = "/v1/pets"

	def link(id: PetId): String = {
		import com.netaporter.uri.dsl._
		val url = prefix / id.toString
		url.toString()
	}

	override def routes: Routes = {
		case GET(p"/")				=>	controller.list
		case GET(p"/initialize")	=>	controller.initialize
		case POST(p"/")				=>	controller.create
		case GET(p"/$id")			=>	controller.details(id: String)
		case PUT(p"/$id")			=>	controller.update(id: String)
		case DELETE(p"/$id")		=>	controller.delete(id: String)
	}

}
