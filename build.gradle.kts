import org.jetbrains.kotlin.gradle.dsl.KotlinJvmCompile

buildscript {
    repositories {
        mavenCentral()
        jcenter()
        google()
        maven { url = uri("https://repo.quickbirdstudios.com/artifactory/public") }
        maven { url = uri("https://plugins.gradle.org/m2/") }
    }

    dependencies {
        classpath(Deps.Plugins.kotlin)
        classpath(Deps.Plugins.ktlint)
    }
}

allprojects {
    repositories {
        mavenCentral()
        jcenter()
        google()
    }

    tasks.withType(KotlinJvmCompile::class.java).all {
        kotlinOptions {
            jvmTarget = "1.8"
            freeCompilerArgs = listOf(
                "-Xuse-experimental=kotlin.Experimental",
                "-Xuse-experimental=kotlinx.coroutines.ObsoleteCoroutinesApi",
                "-Xuse-experimental=kotlinx.coroutines.ExperimentalCoroutinesApi",
                "-Xuse-experimental=kotlin.ExperimentalStdlibApi"
            )
        }
    }
}
