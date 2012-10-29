import com.mongodb.casbah.commons.MongoDBObject
import models.Place
import play.api._


/**
 * @author mcharkin
 * @since 10/27/12
 * 
 */
object Global extends GlobalSettings {

  override def onStart(app: Application) {
    val cathedral = Place(
      name = "St. Basil's Cathedral",
      street=Some("Red Square"),
      city=Some("Moscow"),
      region=None,
      postalCode = Some("109012"),
      country=Some("Russia"),
      attributes = Seq("red", "government", "catheral", "russia"),
      lat = Some(55.75249),
      lng = Some(37.63317)
    )

    val whiteHouseRu = Place(
      name = "White House",
      street=Some("2 Krasnopresnenskaya naberezhnaya"),
      city=Some("Moscow"),
      region=None,
      postalCode = Some("103274"),
      country=Some("Russia"),
      attributes = Seq("white", "government", "russia"),
      lat = Some(55.7548),
      lng = Some(37.5730)
    )

    val whiteHouseUS = Place(
      name = "White House",
      street=Some("1600 Penselvania Avenue"),
      city=Some("Washington"),
      region=Some("D.C."),
      postalCode = Some("20500"),
      country=Some("United States"),
      attributes = Seq("white", "government", "US", "Obama"),
      lat = Some(38.89768),
      lng = Some(-77.0365)
    )

    val carnegieMellon = Place(
      name = "Carnegie Mellon",
      street=Some("5000 Forbes Avenue"),
      city=Some("Pittsburgh"),
      region=Some("Pennsylvania"),
      postalCode = Some("15213"),
      country=Some("United States"),
      attributes = Seq("university", "robots", "andrew carnegie", "tartan"),
      lat = Some(40.44420),
      lng = Some(-79.9426)
    )

    val mit = Place(
      name = "MIT",
      street=Some("77 Massachusetts Avenue"),
      city=Some("Cambridge"),
      region=Some("Massachusetts"),
      postalCode = Some("02139"),
      country=Some("United States"),
      attributes = Seq("university", "robots", "beaver"),
      lat = Some(42.3597),
      lng = Some(-71.0923)
    )

    val stanford = Place(
      name = "Stanford",
      street=Some("450 Serra Mall"),
      city=Some("Stanford"),
      region=Some("California"),
      postalCode = Some("02139"),
      country=Some("United States"),
      attributes = Seq("university", "robots", "stanley", "palm trees"),
      lat = Some(37.42898),
      lng = Some(-122.1697)
    )

    insertPlace(cathedral)
    insertPlace(whiteHouseRu)
    insertPlace(whiteHouseUS)
    insertPlace(carnegieMellon)
    insertPlace(mit)
    insertPlace(stanford)
  }

  private def insertPlace(place: Place) = {
    Place.update(MongoDBObject("name" -> place.name, "country" -> place.country), place.copy(id = null), true, false)
  }

}
