plugins {
    alias(libs.plugins.android.gradle)
    alias(libs.plugins.kotlin.gradle)
    alias(libs.plugins.ksp.gradle)
    alias(libs.plugins.dagger.hilt.gradle)
}

android {
    namespace = "tick.taku.android"
    compileSdk = libs.versions.target.sdk.get().toInt()

    defaultConfig {
        applicationId = "tick.taku.android"
        minSdk = libs.versions.min.sdk.get().toInt()
        targetSdk = libs.versions.target.sdk.get().toInt()
        versionCode = libs.versions.application.get().toInt()
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            @Suppress("UnstableApiUsage")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    implementation(libs.androidx.core)
    implementation(libs.coroutines.core)
    implementation(libs.kotlinx.serialization)

    implementation(libs.dagger.hilt)
    ksp(libs.dagger.hilt.compiler)
}