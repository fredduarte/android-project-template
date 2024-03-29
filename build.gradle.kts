buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(CommonDependencies.androidGradlePlugin)
        classpath(kotlin("gradle-plugin", version = Versions.kotlin))

        classpath(UiDependencies.navigationSafeArgsPlugin)

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle.kts.kts files
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
