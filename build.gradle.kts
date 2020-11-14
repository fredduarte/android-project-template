buildscript {
    repositories {
        google()
        jcenter()
    }

    dependencies {
        classpath(CommonDependencies.androidGradlePlugin)
        classpath(kotlin("gradle-plugin", version = Versions.kotlin))

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle.kts.kts files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
