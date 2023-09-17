rootProject.name = "moremachines"

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenLocal { content { includeGroup("org.spigotmc") } }
        mavenCentral()
        maven("https://libraries.minecraft.net")
        maven("https://repo.xenondevs.xyz/releases")
    }
    versionCatalogs {
        create("libs") {
            val novaVersion = "0.14.10"
            from("xyz.xenondevs.nova:catalog:$novaVersion")
            
            library("nova-api", "xyz.xenondevs.nova:nova-api:$novaVersion")
        }
    }
}

pluginManagement {
    repositories {
        mavenLocal { content { includeGroup("org.spigotmc") } }
        mavenCentral()
        maven("https://repo.xenondevs.xyz/releases")
    }
}