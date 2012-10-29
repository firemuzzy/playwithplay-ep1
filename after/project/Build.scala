import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "withSalat"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
      "se.radley" %% "play-plugins-salat" % "1.1"
      // Add your project dependencies here,
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = SCALA).settings(
      templatesImport += "models._",
      routesImport += "se.radley.plugin.salat.Binders._",
      templatesImport += "org.bson.types.ObjectId"
      // Add your own project settings here      
    )

}
