plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.listycity"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.listycity"
        minSdk = 24
        targetSdk = 36
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

    // Make unit tests use JUnit 5 (fixes "Test events were not received")
    testOptions {
        unitTests.all {
            it.useJUnitPlatform()
        }
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(files("C:\\Users\\Kanav\\AppData\\Local\\Android\\Sdk\\platforms\\android-36\\android.jar"))

    // Instrumented tests
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    // JUnit 5
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.0.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.0.1")
}

