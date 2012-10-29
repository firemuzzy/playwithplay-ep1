package controllers

import play.api._
import play.api.mvc._
import models.Place

object Application extends Controller {

  def index = Action {
    Redirect(routes.Application.places)
  }

  def places = Action {
    Ok(views.html.places(Place.all.toSeq.sortBy(_.name)))
  }

  def place(name: String) = Action {
    Place.get(name) match {
      case Some(place) => Ok(views.html.place(place))
      case None => BadRequest
    }
  }
}