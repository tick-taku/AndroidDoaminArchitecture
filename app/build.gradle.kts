@Suppress("DSL_SCOPE_VIOLATION")
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

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }

    buildTypes {
        release {
            isMinifyEnabled = false
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
    implementation(project(":core:entity"))
    implementation(project(":feature:cat"))
    implementation(project(":domain:cat"))
    implementation(project(":domain:usecase"))
    implementation(project(":datasource:api"))
    implementation(project(":datasource:repository"))

    implementation(libs.androidx.core)
    implementation(libs.androidx.appcompat)
    implementation(libs.bundles.compose)
    implementation(libs.coroutines.core)

    implementation(libs.dagger.hilt)
    ksp(libs.dagger.hilt.compiler)
}