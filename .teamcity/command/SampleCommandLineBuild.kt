package command

import jetbrains.buildServer.configs.kotlin.v2019_2.BuildType
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2019_2.failureConditions.BuildFailureOnMetric
import jetbrains.buildServer.configs.kotlin.v2019_2.failureConditions.failOnMetricChange


object SampleCommandLineBuild : BuildType({
    name = "Sample Command Line Build"
    steps {
        script {
            name = "Command Line Script"
            scriptContent =
                "echo \"##teamcity[buildStatisticValue key='myReportedCustomStatisticValue' value='0']\""
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