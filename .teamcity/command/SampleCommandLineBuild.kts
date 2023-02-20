package command

import jetbrains.buildServer.configs.kotlin.BuildType
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.failureConditions.BuildFailureOnMetric
import jetbrains.buildServer.configs.kotlin.failureConditions.failOnMetricChange
import jetbrains.buildServer.configs.kotlin.project

object SampleCommandLineBuild : BuildType({
    name = "Sample Command Line Build"
    steps {
        script {
            name = "Command Line Script"
            scriptContent =
                "echo \"##teamcity[buildStatisticValue key='myReportedCustomStatisticValue' value='10']\""
        }
    }

    failureConditions {
        failOnMetricChange {
            param("metricKey", "myReportedCustomStatisticValue")
            threshold = 2
            units = BuildFailureOnMetric.MetricUnit.PERCENTS
            comparison = BuildFailureOnMetric.MetricComparison.MORE
            compareTo = build {
                buildRule = lastSuccessful()
            }
        }
    }
})