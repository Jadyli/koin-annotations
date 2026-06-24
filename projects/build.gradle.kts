plugins {
    //trick: for the same plugin versions in all sub-modules
    alias(libs.plugins.kotlinMultiplatform).apply(false)
    alias(libs.plugins.dokka).apply(false)
    alias(libs.plugins.nexusPublish).apply(false)
    alias(libs.plugins.nmcp).apply(false)
}

fun getRepositoryUsername(): String =
    findProperty("OSSRH_USERNAME")?.toString() ?: System.getenv("OSSRH_USERNAME") ?: ""

fun getRepositoryPassword(): String =
    findProperty("OSSRH_PASSWORD")?.toString() ?: System.getenv("OSSRH_PASSWORD") ?: ""

//nexusPublishing {
//    repositories {
//        sonatype {
//            nexusUrl.set(uri("https://s01.oss.sonatype.org/service/local/"))
//            username.set(getRepositoryUsername())
//            password.set(getRepositoryPassword())
//        }
//    }
//}

allprojects {

    val koinAnnotationsVersion: String by project

    group = "io.insert-koin"
    version = koinAnnotationsVersion

    apply(plugin = "org.jetbrains.dokka")
    val dokkaHtml by tasks.getting(org.jetbrains.dokka.gradle.DokkaTask::class)
    val javadocJar: TaskProvider<Jar> by tasks.registering(Jar::class) {
        dependsOn(dokkaHtml)
        archiveClassifier.set("javadoc")
        from(dokkaHtml.outputDirectory)
    }
}

subprojects {
    plugins.withId("maven-publish") {
        extensions.configure<PublishingExtension> {
            repositories {
                maven {
                    name = "aliyun"
                    url = uri("https://packages.aliyun.com/66b7f208953179b1ec5f5db8/maven/2486646-snapshot-3qr5na")
                    credentials {
                        username = "66b7e3a18043c5959c0c01e2"
                        password = "no2udBiPX]2("
                    }
                }
            }
        }
    }
}
