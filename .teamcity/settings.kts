import jetbrains.buildServer.configs.kotlin.Project

import jetbrains.buildServer.configs.kotlin.BuildType
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.failureConditions.BuildFailureOnMetric
import jetbrains.buildServer.configs.kotlin.failureConditions.failOnMetricChange
import jetbrains.buildServer.configs.kotlin.project


version = "2022.04"
project(Project)

object Project : Project({
    name = "Playground project"
    description = "A project without any specific purpose - it's being used as a playground for various DSL features."
    buildType(SampleCommandLineBuild)
}

object SampleCommandLineBuild: BuildType({
    name = "Sample Command Line Build"
    steps {
        script {
            name = "Command Line Script"
            scriptContent = "echo \"##teamcity[buildStatisticValue key='myReportedCustomStatisticValue' value='10']\""
        }
    }
    failureConditions {
        failOnMetricChange {
            param("metricKey", "myReportedCustomStatisticValue")
            threshold = 2
            units = BuildFailureOnMetric.MetricUnit.DEFAULT_UNIT
            comparison = BuildFailureOnMetric.MetricComparison.MORE
            compareTo = build {
                buildRule = lastSuccessful()
            }
        }
    }
})
