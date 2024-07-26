@file:Suppress("UnstableApiUsage")

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

rootProject.name = "aion"

subproject("core", "paperPlugin")
subproject("gradle-plugin", "gradlePlugin")

fun subproject(
    module: String,
    dir: String,
) {
    val name = "${rootProject.name}-$module"
    include(name)
    project(":$name").projectDir = file(dir)
}
