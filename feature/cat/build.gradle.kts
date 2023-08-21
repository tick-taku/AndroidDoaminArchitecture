@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.android.gradle.library)
    alias(libs.plugins.kotlin.gradle)
    alias(libs.plugins.ksp.gradle)
    alias(libs.plugins.dagger.hilt.gradle)
}

android {
    namespace = "tick.taku.android"
    compileSdk = libs.versions.target.sdk.get().toInt()

    defaultConfig {
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
    implementation(project(":domain:cat"))
    implementation(project(":core:entity"))

    implementation(libs.androidx.core)
    implementation(libs.androidx.lifecycle.runtime)
    implementation(libs.bundles.compose)
    implementation(libs.compose.coil)
    debugImplementation(libs.compose.ui.tooling)
    implementation(libs.coroutines.core)

    implementation(libs.dagger.hilt)
    ksp(libs.dagger.hilt.compiler)
}