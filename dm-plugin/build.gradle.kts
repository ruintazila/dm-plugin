@file:Suppress("UnstableApiUsage")

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    `kotlin-dsl`
//    `maven-publish`
    alias(libs.plugins.gradle.publish)
}

group = "io.github.ruintazila"
version = "0.1.4"

pluginBundle {
    website = "https://github.com/ruintazila/dm-plugin"
    vcsUrl = "https://github.com/ruintazila/dm-plugin.git"
    tags = arrayListOf("android", "config")
}

publishing {
    repositories {
        maven {
            setUrl("../../local-repo")
            name = "localRepo"
        }
    }
}

gradlePlugin {
    plugins.register("dm-plugin") {
        id = "io.github.ruintazila.dm-plugin"
        implementationClass = "com.ruint.core.plugin.dm.DMPlugin"
        displayName = "Dependency management plugin for Android"
        description = "A plugin for managing Android dependencies"
    }
}


dependencies {
    implementation(libs.plugin.gradle.android)
    implementation(libs.plugin.gradle.kotlin)
}

