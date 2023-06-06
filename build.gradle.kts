plugins {
    kotlin("jvm") version "1.7.21"
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("xyz.jpenilla.run-paper") version "2.0.1"
}

group = "com.example"
version = "1.0.0"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.19.4-R0.1-SNAPSHOT")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }

    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }

    shadowJar {
        relocate("kotlin", "com.example.kotlin")
        relocate("org.jetbrains.annotations", "com.example.jetbrains.annotations")
        relocate("org.intellij.lang.annotations", "com.example.intellij.lang.annotations")
    }

    runServer {
        minecraftVersion("1.19.4")
    }
}