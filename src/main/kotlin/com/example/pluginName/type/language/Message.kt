package com.example.pluginName.type.language

import com.example.pluginName.PluginName
import com.example.pluginName.type.Config
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.minimessage.MiniMessage
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder

import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File

object Message {
    private lateinit var config: FileConfiguration

    private val prefix get() = config.getBetterString("prefix")

    val noPermission get() = parseString(config.getBetterString("no-permission"))
    val illegalArguments get() = parseString(config.getBetterString("illegal-arguments"))
    val exampleMessage get() = parseString(config.getBetterString("example-message"))

    fun init(pluginName: PluginName) {
        if (Config.language == null) {
            pluginName.getLogger().warning("No language set in config.yml. Defaulting to EN_US")
        }

        var language = Language.EN_US

        try {
            language = Language.valueOf(Config.language?.uppercase() ?: "EN_US")
        } catch (e: IllegalArgumentException) {
            println("Language ${Config.language} is not supported. Defaulting to EN_US")
        }

        if (!language.supported) {
            println("Language ${Config.language} is not supported. Defaulting to EN_US")
            language = Language.EN_US
        }

        val file = File("${pluginName.dataFolder}${File.separator}languages", "$language.yml")
        pluginName.saveResource("languages${File.separator}$language.yml", true)
        config = YamlConfiguration.loadConfiguration(file)
    }

    private fun parseString(string: String): Component {
        return MiniMessage.miniMessage().deserialize(
            string,
            Placeholder.component(
                "prefix", MiniMessage.miniMessage().deserialize(prefix)
            )
        )
    }

    fun Component.fillInVariables(args: Array<String>): Component {
        var serialized = MiniMessage.miniMessage().serialize(this)

        for ((i, arg) in args.withIndex()) {
            serialized = serialized.replace("**{$i}**", arg)
        }

        return MiniMessage.miniMessage().deserialize(serialized)
    }

    private fun FileConfiguration.getBetterString(path: String): String {
        val configString = this.getString(path)
        if (configString.isNullOrEmpty()) {
            throw LanguageLoadingException("Failed to load string at $path, defaulting to English")
        }

        return configString
    }

    fun String.deserialize(): Component = MiniMessage.miniMessage().deserialize(this)
    fun Component.serialize(): String = MiniMessage.miniMessage().serialize(this)

}