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
include(":desktop")

include(":common:core")
include(":common:umbrella-core")
include(":common:umbrella-ios")
include(":common:umbrella-compose")
include(":common:core-compose")
include(":common:core-utils")

include(":common:main:api")
include(":common:main:presentation")
include(":common:main:data")
include(":common:main:compose")

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


