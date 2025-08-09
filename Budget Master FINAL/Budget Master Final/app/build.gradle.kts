plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-kapt") // Keep this for Kotlin Annotation Processor
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.budgetmaster"
    compileSdk = 35 // Keeping your compileSdk to 35

    defaultConfig {
        applicationId = "com.example.budgetmaster"
        minSdk = 26 // Changed minSdk to 24 for broader compatibility, as your original layouts might imply.
        // If you intend to use Android 13+ specific features, keep it higher.
        targetSdk = 35
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
        dataBinding = true
        viewBinding = true // Explicitly enable view binding for easier UI element access
        buildConfig = true
    }
}

dependencies {
    // AndroidX Core & UI
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    // Navigation Components (if you are using them, though not directly in the provided activities)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Room components
    implementation("androidx.room:room-runtime:2.6.1")
    kapt("androidx.room:room-compiler:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1") // For Kotlin Extensions and Coroutines support

    // Lifecycle components (LiveData and ViewModel)
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    implementation("androidx.activity:activity-ktx:1.9.0") // For by viewModels() and activity-level KTX
    implementation("com.github.PhilJay:MPAndroidChart:v3.1.0")
    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    implementation("com.google.firebase:firebase-storage-ktx")
    implementation(platform("com.google.firebase:firebase-bom:33.15.0"))
    implementation("com.google.firebase:firebase-analytics")

    // Add the dependency for Firebase Cloud Firestore
    implementation("com.google.firebase:firebase-firestore-ktx")

    // If you're using Firebase Authentication (highly recommended for user data)
    implementation("com.google.firebase:firebase-auth-ktx")

    implementation ("com.github.bumptech.glide:glide:4.16.0")
    kapt ("com.github.bumptech.glide:compiler:4.16.0") // Used kapt here as you already have it enabled

}