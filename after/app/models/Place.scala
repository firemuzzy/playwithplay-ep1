package models

import play.api.Play.current
import com.novus.salat._
import com.novus.salat.dao._
import se.radley.plugin.salat._
import mongoContext._
import com.mongodb.casbah.Imports._

/**
 * @author mcharkin
 * @since 10/27/12
 * 
 */
case class Place (
  id: ObjectId = new ObjectId,
  name: String,
  street: Option[String],
  city: Option[String],
  region: Option[String],
  postalCode: Option[String],
  country: Option[String],
  attributes: Seq[String],
  lat: Option[Double],
  lng: Option[Double]
)

object Place extends ModelCompanion[Place, ObjectId] {
  val dao = new SalatDAO[Place, ObjectId](collection = mongoCollection("places")) {}

  implicit def toDbObj(p : Place) = grater[Place].asDBObject(p)

}


