import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.script

project {
  buildType(SampleCommandLineBuild)
}

object SampleCommandLineBuild: BuildType({
    name = "Sample Command Line Build"
    steps {
        script {
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
