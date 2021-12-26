plugins {
    id("com.android.library")
    kotlin("android")
    `maven-publish`
}

android {
    compileSdk = 30

    defaultConfig {
        minSdk = 16
        targetSdk = 30

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.5.32")
    implementation("com.google.zxing:core:3.2.1")
}

afterEvaluate {
    publishing {
        publications {

            // Creates a Maven publication called "release".
            create<MavenPublication>("release") {

                // Applies the component for the release build variant.
                from(components["release"])

                // You can then customize attributes of the publication as shown below.
                groupId = "dev.hirogakatageri"
                artifactId = "android-qr-code"
                version = "1.2.1"

                pom {
                    name.set("android-qr-code")
                    description.set("Awesome QR Code by SumiMakito")

                    licenses {
                        license {
                            name.set("Apache-2.0")
                            url.set("https://github.com/HirogaKatageri/AwesomeQRCode/blob/master/LICENSE")
                        }
                    }

                    developers {
                        developer {
                            id.set("SumiMakito")
                            name.set("SumiMakito")
                            email.set("i@keep.moe")
                        }
                    }
                }
            }
        }
    }
}
