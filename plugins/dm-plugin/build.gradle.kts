@file:Suppress("UnstableApiUsage")

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    `kotlin-dsl`
    `maven-publish`
    alias(libs.plugins.gradle.publish)
}

group = "io.github.ruintazila"
version = "0.1.9"

gradlePlugin {
    website.set("https://github.com/ruintazila/dm-plugin")
    vcsUrl.set("https://github.com/ruintazila/dm-plugin")
    plugins {
        create("dm-plugin") {
            id = "io.github.ruintazila.dm-plugin"
            implementationClass = "com.ruint.core.plugins.dm.DMPlugin"
            displayName = "Dependency Management Plugin for Android"
            description = "A plugin helps you to manage android extensions"
            tags.set(listOf("android", "ruinT", "dm-plugin", "core-lib", "ruintazila"))
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

afterEvaluate {
    publishing {
        publications {
            register<MavenPublication>("release") {
                groupId = "com.github.ruintazila"
                artifactId = "dm-plugin"
                version = "0.1.9"
                from(components.getByName("java"))
            }
        }
    }
}

@Suppress("DSL_SCOPE_VIOLATION")
dependencies {
        implementation(libs.android.gradlePlugin)
        implementation(libs.kotlin.gradlePlugin)
        implementation(libs.kotlin.stdlib)
        implementation(libs.kotlin.reflect)
//    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.20")
//    implementation("com.android.tools.build:gradle:7.3.1")
//    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.7.20")
//    implementation("org.jetbrains.kotlin:kotlin-reflect:1.7.20")
}
