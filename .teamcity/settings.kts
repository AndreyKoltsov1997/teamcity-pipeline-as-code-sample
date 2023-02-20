import command.SampleCommandLineBuild
import jetbrains.buildServer.configs.kotlin.v2019_2.project
import jetbrains.buildServer.configs.kotlin.v2019_2.version
import jetbrains.buildServer.configs.kotlin.v2019_2.Project



object PlaygroundProject : Project ({
    description = "A project without any specific purpose - it's being used as a playground for various DSL features."
    buildType(SampleCommandLineBuild)
})

project(PlaygroundProject)

