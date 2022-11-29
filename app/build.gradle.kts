plugins {
    id("com.android.application")
    id("androidx.navigation.safeargs")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(Versions.compileSdkVersion)

    defaultConfig {
        applicationId = Versions.applicationId

        minSdkVersion(Versions.minSdkVersion)
        targetSdkVersion(Versions.targetSdkVersion)

        versionCode = Versions.versionCode
        versionName = Versions.versionName
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    buildFeatures {
        dataBinding = true
    }

    sourceSets["main"].apply {
        java.srcDir("src/main/kotlin")
    }

    buildTypes {
        getByName("debug") {
            isDebuggable = true
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        getByName("release") {
            isDebuggable = false
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(kotlin("stdlib-jdk8", Versions.kotlin))

    implementation(CommonDependencies.appCompat)
    implementation(CommonDependencies.coreKtx)

    implementation(UiDependencies.constraintLayout)
    implementation(UiDependencies.materialComponents)

    implementation(LifecycleDependencies.viewModelKtx)
    implementation(LifecycleDependencies.liveDataKtx)

    implementation(UiDependencies.navigationRuntimeKtx)
    implementation(UiDependencies.navigationFragmentKtx)
    implementation(UiDependencies.navigationUiKtx)

    implementation(UiDependencies.recyclerView)

    implementation(UiDependencies.glide)
    kapt(UiDependencies.glideCompiler)
}
