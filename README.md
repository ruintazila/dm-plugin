# dm-plugin-for-android
dependency management plugin for Android

[![](https://www.jitpack.io/v/ruintazila/dm-plugin.svg)](https://www.jitpack.io/#ruintazila/dm-plugin)

gradle 插件仓库：[dm-plugin](https://plugins.gradle.org/plugin/io.github.ruintazila.dm-plugin)

Using the plugins DSL:
``` kotlin
plugins {
  id("io.github.ruintazila.dm-plugin") version "0.1.81"
}
```

Using legacy plugin application:
``` kotlin
buildscript {
  repositories {
    maven {
      url = uri("https://plugins.gradle.org/m2/")
    }
  }
  dependencies {
    classpath("io.github.ruintazila:dm-plugin:0.1.81")
  }
}

apply(plugin = "io.github.ruintazila.dm-plugin")
```
