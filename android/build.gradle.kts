import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    id("com.android.library")
}

group = "com.baseflow.geocoding"
version = "1.0-SNAPSHOT"

repositories {
        google()
        mavenCentral()
    }

android {
    namespace = "com.baseflow.geocoding"
    compileSdk = 37

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    defaultConfig {
        minSdk = 24
    }

    dependencies {
        testImplementation("org.jetbrains.kotlin:kotlin-test")
        testImplementation("org.mockito:mockito-core:5.23.0")
    }

    testOptions {
        unitTests.all {
            useJUnitPlatform()

            testLogging {
               events "passed", "skipped", "failed", "standardOut", "standardError"
               outputs.upToDateWhen {false}
               showStandardStreams = true
            }
        }
    }
}

kotlin {
    compilerOptions {
        jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_21
    }
}
