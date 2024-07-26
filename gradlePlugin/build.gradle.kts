import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}

dependencies {
    implementation(libs.kotlin.gradle.plugin)
    implementation(libs.paperweight.userdev)
    implementation(libs.run.task)
}

val jdkVersion: String by project
kotlin {
    jvmToolchain {
        languageVersion = JavaLanguageVersion.of(jdkVersion)
    }
    compilerOptions {
        jvmTarget = JvmTarget.fromTarget(jdkVersion)
    }
}
