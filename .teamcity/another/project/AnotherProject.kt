package another.project

import another.project.buildTypes.BuildTypeInAnotherProject
import jetbrains.buildServer.configs.kotlin.Project

object AnotherProject: Project({
    id("AnotherProject")
    name = "Another Project in sample DSL"

    buildType(BuildTypeInAnotherProject)
})