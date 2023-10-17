package another.project.buildTypes

import jetbrains.buildServer.configs.kotlin.BuildType
import jetbrains.buildServer.configs.kotlin.buildSteps.script

object BuildTypeInAnotherProject: BuildType({
    name = "Build Type in another project"

    steps {
        script {
            name = "Test step"
            scriptContent = "echo 'test'"
        }
    }
})