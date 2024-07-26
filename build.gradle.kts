plugins {
    `kotlin-dsl` apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.paperweight.userdev) apply false
    alias(libs.plugins.run.paper) apply false
    alias(libs.plugins.shadow) apply false
    alias(libs.plugins.maven.publish) apply false
}
