import command.*
import jetbrains.buildServer.configs.kotlin.v2019_2.project
import jetbrains.buildServer.configs.kotlin.v2019_2.version
import jetbrains.buildServer.configs.kotlin.v2019_2.Project


object PlaygroundProject : Project ({
    name = "Playground project"
    description = "A project without any specific purpose - it's being used as a playground for various DSL features."
    buildType(SampleCommandLineBuild)
})

version = "2022.04"
project(PlaygroundProject)