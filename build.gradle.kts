// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        mavenCentral()
        google()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:7.0.3")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.32")
    }
}

plugins {
    id("org.jlleitschuh.gradle.ktlint") version "10.2.0"
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}