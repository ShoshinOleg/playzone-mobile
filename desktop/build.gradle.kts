plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

kotlin {
    jvm {
        withJava()
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:core"))
                implementation(project(":common:core-compose"))
                implementation(project(":common:core-utils"))
                implementation(project(":common:umbrella-core"))
                implementation(project(":common:umbrella-compose"))

                implementation(Dependencies.Other.Navigation.core)
                implementation(Dependencies.Other.Navigation.compose)

                implementation(project(":common:auth:compose"))
                implementation(project(":common:games:api"))
                implementation(project(":common:main:compose"))
            }
        }

        named("jvmMain") {
            dependencies {
                implementation(compose.desktop.currentOs)
            }
        }
    }
}

compose.desktop {
    application {
        mainClass = "Main_desktopKt"

        nativeDistributions {
            targetFormats(
                org.jetbrains.compose.desktop.application.dsl.TargetFormat.Dmg,
                org.jetbrains.compose.desktop.application.dsl.TargetFormat.Msi,
                org.jetbrains.compose.desktop.application.dsl.TargetFormat.Deb
            )

            packageName = "PlayZone-Admin"
            packageVersion = "1.0.0"

            windows {
                menuGroup = "PlayZone Admin"
                upgradeUuid = "31c47d7e-a187-11ed-a8fc-0242ac120002"
            }
        }
    }
}