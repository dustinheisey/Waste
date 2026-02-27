import dev.scaffoldit.hytale.wire.HytaleManifest

rootProject.name = "Waste"

plugins {
    id("dev.scaffoldit") version "0.2.9"
}
hytale {
    usePatchline("release")
    useVersion("latest")

    repositories {
        // Any external repositories besides: MavenLocal, MavenCentral, HytaleMaven, and
    }

    dependencies {
        // Any external dependency you also want to include
       implementation("curse.maven:unified-materials-1445381:7669527")
    }

    manifest {
        Group = "Inconvenient"
        Name = "Waste"
        Version = "0.3.0"
        Description = "Turning trash into treasure"
        Authors = listOf(HytaleManifest.Author("Inconvenient Dev", "", "https://inconvenient.gg"))
        Website = "https://www.curseforge.com/hytale/mods/waste"
        ServerVersion = "2026.02.19-1a311a592"
        Main = "gg.inconvenient.waste.Waste"
        IncludesAssetPack = false
    }
}