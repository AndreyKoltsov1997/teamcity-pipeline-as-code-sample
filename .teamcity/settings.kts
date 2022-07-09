import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.script

version = "2022.04"

project {
  buildType {
    id("Sample")
    name = "Sample App"
    steps {
        script {
            scriptContent = "echo 'Hello world!'"
        }
    }
  }
}

