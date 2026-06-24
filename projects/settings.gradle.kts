enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        maven { setUrl("https://maven.aliyun.com/repository/public") }
        maven { setUrl("https://maven.aliyun.com/repository/central") }
        maven { setUrl("https://maven.aliyun.com/repository/google") }
        maven {
            name = "aliyun"
            setUrl("https://packages.aliyun.com/66b7f208953179b1ec5f5db8/maven/2486646-snapshot-3qr5na")
            credentials {
                username = "66b7e3a18043c5959c0c01e2"
                password = "no2udBiPX]2("
            }
        }
        maven { setUrl("https://mirrors.tencent.com/nexus/repository/maven-tencent") }
        maven { setUrl("https://mirrors.tencent.com/nexus/repository/maven-public") }
        mavenCentral()
        mavenLocal()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        maven { setUrl("https://maven.aliyun.com/repository/public") }
        maven { setUrl("https://maven.aliyun.com/repository/central") }
        maven { setUrl("https://maven.aliyun.com/repository/google") }
        maven {
            name = "aliyun"
            setUrl("https://packages.aliyun.com/66b7f208953179b1ec5f5db8/maven/2486646-snapshot-3qr5na")
            credentials {
                username = "66b7e3a18043c5959c0c01e2"
                password = "no2udBiPX]2("
            }
        }
        maven { setUrl("https://mirrors.tencent.com/nexus/repository/maven-tencent") }
        maven { setUrl("https://mirrors.tencent.com/nexus/repository/maven-public") }
        mavenCentral()
        mavenLocal()
    }
}

include(
    // Core
    ":koin-jsr330",
    ":koin-annotations",
    ":koin-ksp-compiler",
    ":koin-annotations-bom",
)
