pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "playzone-mobile"
include(":androidApp")
include(":common:core")
include(":common:umbrella-ios")
include(":common:umbrella-compose")

include(":common:auth:api")
include(":common:auth:presentation")
include(":common:auth:data")
include(":common:auth:compose")

include(":common:tournaments:api")
include(":common:tournaments:presentation")
include(":common:tournaments:data")
include(":common:tournaments:compose")

include(":common:games:api")
include(":common:games:presentation")
include(":common:games:data")
include(":common:games:compose")


