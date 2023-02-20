import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.script

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
