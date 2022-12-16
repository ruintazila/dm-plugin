@file:Suppress("UnstableApiUsage")

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    `kotlin-dsl`
    `maven-publish`
    alias(libs.plugins.gradle.publish)
}

group = "io.github.ruintazila"
version = "0.1.6"


gradlePlugin {
    website.set("https://github.com/ruintazila/dm-plugin")
    vcsUrl.set("https://github.com/ruintazila/dm-plugin")
    plugins {
        create("dm-plugin") {
            id = "io.github.ruintazila.dm-plugin"
            implementationClass = "com.ruint.core.plugins.dm.DMPlugin"
            displayName = "Dependency Management Plugin for Android"
            description = "A plugin helps you to manage android extensions"
            tags.set(listOf("android", "ruinT", "plugin", "dm-plugin", "core-lib", "ruintazila"))
        }
    }
}



pluginBundle {

}

publishing {
    repositories {
        maven {
            setUrl("../../local-repo")
            name = "localRepo"
        }
    }
}

dependencies {
    implementation(libs.android.gradlePlugin)
    implementation(libs.kotlin.gradlePlugin)
    implementation(libs.kotlin.stdlib)
    implementation(libs.kotlin.reflect)
}
