plugins {
    id(libs.plugins.ksp.get().pluginId)
}

android {
    defaultConfig {
        applicationId = "com.explorer.android"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        vectorDrawables {
            useSupportLibrary = true
        }
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

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:ui"))

    implementation(project(":discovery:domain"))
    implementation(project(":discovery:data"))
    implementation(project(":discovery:local"))
    implementation(project(":discovery:ui"))

    implementation(libs.androidx.activity.compose)

    implementation(libs.dagger.android)
    ksp(libs.dagger.compiler)
}