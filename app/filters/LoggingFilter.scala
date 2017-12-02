package filters


import javax.inject.Inject
import akka.stream.Materializer
import play.api.Logger
import play.api.mvc._
import scala.concurrent.{ExecutionContext, Future}
import play.api.routing.Router.Tags

/**
  * This is a simple filter that adds a header to all requests. It's
  * added to the application's list of filters by the
  * [[Filters]] class.
  *
  * @param mat This object is needed to handle streaming of requests
  * and responses.
  * @param exec This class is needed to execute code asynchronously.
  * It is used below by the `map` method.
  * result.withHeaders("X-test" -> "foo")
  */
class LoggingFilter @Inject() (implicit val mat: Materializer, ec: ExecutionContext) extends Filter {

  def apply(nextFilter: RequestHeader => Future[Result])
           (requestHeader: RequestHeader): Future[Result] = {

    val startTime = System.currentTimeMillis

    nextFilter(requestHeader).map { result =>

      val action = requestHeader.tags(Tags.RouteController) +
        "." + requestHeader.tags(Tags.RouteActionMethod)
      val endTime = System.currentTimeMillis
      val requestTime = endTime - startTime

      Logger.info(s"${action} took ${requestTime}ms and returned ${result.header.status}")

      result.withHeaders("X-test" -> "foo")
      result.withHeaders("Request-Time" -> requestTime.toString)
    }
  }
}


