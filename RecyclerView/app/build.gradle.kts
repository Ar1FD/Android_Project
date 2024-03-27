plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.recyclerview"
    compileSdk = 34



    defaultConfig {
        applicationId = "com.example.recyclerview"
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

    buildFeatures {
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}


dependencies {

    // AppCompat Library for backward compatibility
    implementation ("androidx.appcompat:appcompat:1.3.1")

    // RecyclerView for efficient list display
    implementation ("androidx.recyclerview:recyclerview:1.2.1")

    // ConstraintLayout for flexible layouts
    implementation ("androidx.constraintlayout:constraintlayout:2.1.3")

    // Picasso for image loading and caching
    implementation ("com.squareup.picasso:picasso:2.71828")


    implementation("com.google.android.material:material:1.11.0")
    // Test dependencies
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test:runner:1.4.0")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.4.0")
}

