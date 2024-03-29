import org.gradle.configurationcache.extensions.capitalized
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "com.lapzupi.dev"
version = "0.0.6"


val mojangMapped = project.hasProperty("mojang-mapped")

plugins {
    alias(libs.plugins.kotlin)
    alias(libs.plugins.nova)
    alias(libs.plugins.stringremapper)
    alias(libs.plugins.specialsource)
}

dependencies {
    implementation(libs.nova)
    implementation(libs.nova.api)
}

addon {
    id.set(project.name)
    name.set(project.name)
    version.set(project.version.toString())
    novaVersion.set(libs.versions.nova)
    main.set("com.lapzupi.dev.MoreMachinesAddon")
    authors.add("sarhatabaot")
    depend.add("machines")
    depend.add("logistics")
    depend.add("simple-upgrades")
}

spigotRemap {
    spigotVersion.set(libs.versions.spigot.get().substringBefore('-'))
    sourceJarTask.set(tasks.jar)
}

remapStrings {
    remapGoal.set(if (mojangMapped) "mojang" else "spigot")
    spigotVersion.set(libs.versions.spigot.get())
}

tasks {
    register<Copy>("addonJar") {
        group = "build"
        dependsOn("addon", if (mojangMapped) "jar" else "remapObfToSpigot")
        
        from(File(project.buildDir, "libs/${project.name}-${project.version}.jar"))
        into((project.findProperty("outDir") as? String)?.let(::File) ?: project.buildDir)
        rename { it.replace(project.name, addon.get().addonName.get()) }
    }
    
    withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "17"
        }
    }
}