import another.project.AnotherProject
import command.SampleCommandLineBuild
import jetbrains.buildServer.configs.kotlin.Project
import jetbrains.buildServer.configs.kotlin.project


object PlaygroundProject : Project ({
    description = "A project without any specific purpose - it's being used as a playground for various DSL features."
    buildType(SampleCommandLineBuild)

    subProject(AnotherProject)
})

project(PlaygroundProject)

