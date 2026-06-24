import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    alias(libs.plugins.kotlinMultiplatform)
}

kotlin {
    jvm()

    js(IR) {
        nodejs()
        browser()
        binaries.executable()
    }

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        binaries.executable()
        nodejs()
    }

    iosX64()
    iosArm64()
    iosSimulatorArm64()
    configureOhosArm64Target(project)
    macosX64()
    macosArm64()
    watchosArm32()
    watchosArm64()
    watchosSimulatorArm64()
    watchosX64()
    tvosArm64()
    tvosSimulatorArm64()
    tvosX64()
    mingwX64()
    linuxX64()
    linuxArm64()

    sourceSets {
        commonMain.dependencies {
            api(libs.koin.core.annotations)
//            api(project(":koin-jsr330"))
        }
        commonTest.dependencies {
        }
    }
}

apply(from = file("../gradle/publish.gradle.kts"))

fun org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension.configureOhosArm64Target(project: Project) {
    val target = javaClass.methods
        .firstOrNull { method -> method.name == "ohosArm64" && method.parameterCount == 0 }
        ?.invoke(this)
    if (target != null) {
        return
    }

    val presets = javaClass.methods
        .firstOrNull { method -> method.name == "getPresets" && method.parameterCount == 0 }
        ?.invoke(this)
    val getByName = presets?.javaClass?.methods
        ?.firstOrNull { method -> method.name == "getByName" && method.parameterTypes.contentEquals(arrayOf(String::class.java)) }
    val preset = getByName?.invoke(presets, "ohosArm64")
    val targetFromPreset = javaClass.methods.firstOrNull { method ->
        method.name == "targetFromPreset" && method.parameterCount == 1
    }
    if (preset == null || targetFromPreset == null) {
        error("Kotlin Multiplatform does not expose mandatory ohosArm64 target under the current Gradle/KGP classpath.")
    }
    targetFromPreset.invoke(this, preset)
}
