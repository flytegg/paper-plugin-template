plugins {
    alias(libs.plugins.kotlin)
    alias(libs.plugins.shadow)
    alias(libs.plugins.paperweight)
    alias(libs.plugins.run.paper)
}

group = "gg.flyte"
version = "1.0.1"

repositories {
    mavenCentral()
    maven("https://jitpack.io")
    maven("https://repo.flyte.gg/releases")
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    paperweight.paperDevBundle("1.20.2-R0.1-SNAPSHOT")

    implementation(libs.twilight)
    implementation(libs.paperlib)

    implementation(libs.lamp.common)
    implementation(libs.lamp.bukkit)
    implementation(libs.lamp.brigadier)
}

tasks {
    build { dependsOn(shadowJar) }
    runServer { minecraftVersion("1.20.2") }
    compileKotlin { kotlinOptions.jvmTarget = "17" }

    shadowJar {
        relocate("kotlin", "gg.flyte.kotlin")
        relocate("io.papermc.lib", "gg.flyte.paperlib")
        relocate("org.jetbrains.annotations", "gg.flyte.jetbrains.annotations")
        relocate("org.intellij.lang.annotations", "gg.flyte.intellij.lang.annotations")
    }
}