package controllers

import play.api._
import play.api.mvc._
import models.Place
import org.bson.types.ObjectId

object Application extends Controller {

  def index = Action {
    Redirect(routes.Application.places)
  }

  def places = Action {
    Ok(views.html.places(Place.findAll.toSeq.sortBy(_.name)))
  }

  def place(id: ObjectId) = Action {
    Place.findOneById(id) match {
      case Some(found) => Ok(views.html.place(found))
      case None => BadRequest
    }

  }

}