@file:Suppress("UnstableApiUsage")

import io.papermc.paperweight.userdev.ReobfArtifactConfiguration
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.paperweight.userdev)
    alias(libs.plugins.run.paper)
    alias(libs.plugins.shadow)
    alias(libs.plugins.maven.publish)
}

repositories {
    mavenCentral()
    maven("https://repo.xenondevs.xyz/releases")
}

dependencies {
    paperweight.paperDevBundle(libs.versions.paper)
    api(platform(libs.kotlin.bom))
    api(libs.kotlin.stdlib)
    api(libs.kotlin.reflect)
    api(platform(libs.kotlinx.coroutines.bom))
    api(libs.kotlinx.coroutines.core)
    api(libs.bundles.mccoroutine.folia)
    api(libs.invui.kotlin) {
        exclude(group = "org.jetbrains.kotlin")
    }
    implementation(libs.inventory.access.r20)
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

testing {
    suites {
        named<JvmTestSuite>(JavaPlugin.TEST_TASK_NAME) {
            useKotlinTest(libs.versions.kotlin)
        }
    }
}

tasks {
    val processPaperPluginYml by registering(ProcessResources::class)
    afterEvaluate {
        processPaperPluginYml {
            mustRunAfter(processResources)
            from(sourceSets.main.map { it.resources })
            filesMatching("paper-plugin.yml") {
                filteringCharset = Charsets.UTF_8.name()
                expand("version" to project.version)
            }
            sourceSets.main
                .map { it.output.resourcesDir }
                .orNull
                ?.let { into(it) }
        }
        jar {
            dependsOn(processPaperPluginYml)
        }
        shadowJar {
            dependsOn(processPaperPluginYml)
        }
    }
}

publishing {
    repositories {
        maven("https://maven.pkg.github.com/SkiesMC/aion") {
            name = "githubPackages"
            credentials {
                username = providers.gradleProperty("github.actor").getOrElse(System.getenv("GITHUB_ACTOR"))
                password = providers.gradleProperty("github.token").getOrElse(System.getenv("GITHUB_TOKEN"))
            }
        }
    }
}

paperweight {
    reobfArtifactConfiguration = ReobfArtifactConfiguration.MOJANG_PRODUCTION
}
