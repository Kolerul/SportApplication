buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("gradle.plugin.com.onesignal:onesignal-gradle-plugin:0.14.0")
    }
    val agp_version by extra("7.2.0")
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "7.2.0" apply false
    id("org.jetbrains.kotlin.android") version "1.8.0" apply false
    id("com.google.gms.google-services") version "4.3.15" apply false
}
