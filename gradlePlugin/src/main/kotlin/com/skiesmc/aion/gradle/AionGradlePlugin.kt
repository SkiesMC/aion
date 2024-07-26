package com.skiesmc.aion.gradle

import io.papermc.paperweight.userdev.PaperweightUser
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.assign
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.provideDelegate
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinPluginWrapper
import xyz.jpenilla.runpaper.RunPaperPlugin

abstract class AionGradlePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.plugins.apply(KotlinPluginWrapper::class)
        target.plugins.apply(PaperweightUser::class)
        target.plugins.apply(RunPaperPlugin::class)

        target.extensions.configure<KotlinJvmProjectExtension> {
            val jdkVersion: String by target
            jvmToolchain(jdkVersion.toInt())
            compilerOptions {
                jvmTarget = JvmTarget.fromTarget(jdkVersion)
            }
        }
    }
}
