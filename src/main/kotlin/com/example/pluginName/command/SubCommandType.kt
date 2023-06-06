package com.example.pluginName.command

enum class SubCommandType(
        val command: String,
        val usage: String,
        val alias: String,
        val permission: String) {

    HELP("Help", "/template help", "h", "template.help"),
    Test("Test", "/template test", "t", "template.test"),

}