plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.dagger.hilt.android.plugin)
    alias(libs.plugins.kotlin.kapt)
}

android {
    namespace = "com.example.nelumbotechnicaltest"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.nelumbotechnicaltest"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    implementation(libs.retrofit2.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.androidx.navigation.compose.v277)
    implementation(libs.hilt.android.v249)
    kapt(libs.hilt.android.compiler)
    implementation(libs.androidx.hilt.work.v100)
    kapt(libs.androidx.hilt.compiler.v100)
    implementation(libs.androidx.work.runtime.ktx.v281)
    implementation(libs.androidx.hilt.navigation.compose.v100)
    implementation(libs.kotlin.reflect.v1922)
    implementation(libs.jwtdecode)
    implementation(libs.androidx.material.icons.extended.v167)
    coreLibraryDesugaring(libs.desugar.jdk.libs.v204)
}