
enableFeaturePreview("VERSION_CATALOGS")
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")


pluginManagement{
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
        maven { setUrl("https://jitpack.io") }
        maven { setUrl("./local-repo/") }
    }
}

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories{
        mavenCentral()
        google()
        maven { setUrl("https://jitpack.io") }
    }
    versionCatalogs {
        create("libs"){
            from(files("${rootDir.path}/.configs/libs.toml"))
        }
    }
}



rootProject.name = "plugins"

include("dm-plugin")
