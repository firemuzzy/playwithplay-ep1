import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "withSalat"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
      // Add your project dependencies here,
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = SCALA).settings(
      templatesImport += "models._"
      // Add your own project settings here      
    )

}
