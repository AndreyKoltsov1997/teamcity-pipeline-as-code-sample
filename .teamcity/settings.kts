import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.script

version = "2022.04"

project {
  buildType(SampleCommandLineBuild)
}

object SampleCommandLineBuild: BuildType({
    name = "Sample Command Line Build"
    steps {
        script {
            scriptContent = "echo 'Hello world!'"
        }
    }
})
