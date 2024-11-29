import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
}

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    )

    jvm("desktop")

    sourceSets {
        commonMain {
            dependencies {
                api(libs.kotlinx.coroutines)
                api(libs.kotlinx.datetime)
                api(libs.kotlinx.serialization)
            }
        }
    }
}


android {
    namespace = "com.memest.core.core"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
}
