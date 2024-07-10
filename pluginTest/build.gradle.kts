plugins {
    id("java")
//    id("org.jetbrains.kotlin.jvm") version "1.9.24"
    id("org.jetbrains.intellij") version "1.17.4"
}

group = "org.rxy"
version = "1.0-SNAPSHOT"

repositories {
    maven {
        setUrl("https://maven.aliyun.com/nexus/content/groups/public/")
        setUrl("https://oss.sonatype.org/content/repositories/snapshots/")
    }

    mavenCentral()
    gradlePluginPortal()
}

// Configure Gradle IntelliJ Plugin
// Read more: https://plugins.jetbrains.com/docs/intellij/tools-gradle-intellij-plugin.html
intellij {
    pluginName.set("ZMNPlugin")

    version.set("2024.1.4")
    type.set("IC") // Target IDE Platform

    plugins.set(listOf(/* Plugin Dependencies */))
}

tasks {
    // Set the JVM compatibility versions
    withType<JavaCompile> {
        sourceCompatibility = "17"
        targetCompatibility = "17"
    }

    // 设置 Gradle 版本
     wrapper {
         gradleVersion = "7.6"
     }

    patchPluginXml {
        // 插件版本
        version.set("1.0-SNAPSHOT")
    // 支持的最早 IDE 版本
        sinceBuild.set("222.2680.4")
    // 支持的最新 IDE 版本
        untilBuild.set("223.*")
        changeNotes.set("init.")


    }

    signPlugin {
        certificateChain.set(System.getenv("CERTIFICATE_CHAIN"))
        privateKey.set(System.getenv("PRIVATE_KEY"))
        password.set(System.getenv("PRIVATE_KEY_PASSWORD"))
    }

    publishPlugin {
        token.set(System.getenv("PUBLISH_TOKEN"))
    }
}
