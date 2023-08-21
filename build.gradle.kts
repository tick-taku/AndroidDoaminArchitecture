plugins {
    alias(libs.plugins.android.gradle) apply false
    alias(libs.plugins.android.gradle.library) apply false
    alias(libs.plugins.kotlin.gradle) apply false
    alias(libs.plugins.kotlin.serialization.gradle) apply false
    alias(libs.plugins.dagger.hilt.gradle) apply false
    alias(libs.plugins.ksp.gradle) apply false
}