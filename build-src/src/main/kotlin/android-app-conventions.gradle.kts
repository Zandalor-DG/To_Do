import com.android.build.gradle.BaseExtension

plugins {
  id("com.android.application")
  kotlin("android")
}

configure<BaseExtension> {
  val libs = libsWorkaround

  plugins {
    id(libs.plugHiltAndroid())
    id(libs.plugKsp())
  }

  dependencies {
    implementation(libs.libHiltAndroid())
    kspWorkaround(libs.libHiltCompiler())
  }
}

android {
  namespace = AndroidConfig.applicationId

  compileSdk = AndroidConfig.compileSdk

  signingConfigs {
    create("release") {
      if (project.hasProperty("storeFile")) {
        storeFile = file(project.properties["storeFile"] as String)
        storePassword = project.properties["storePassword"] as String
        keyAlias = project.properties["keyAlias"] as String
        keyPassword = project.properties["keyPassword"] as String
      }
    }
  }

  defaultConfig {
    applicationId = AndroidConfig.applicationId
    minSdk = AndroidConfig.minSdk
    targetSdk = AndroidConfig.targetSdk
    versionCode = AndroidConfig.versionCode
    versionName = AndroidConfig.versionName
    testInstrumentationRunner = AndroidConfig.testInstrumentationRunner
  }

  buildTypes {
    getByName("release") {
      isMinifyEnabled = true
      isShrinkResources = true
      signingConfig = if (project.hasProperty("storeFile")) {
        signingConfigs.getByName("release")
      } else {
        signingConfigs.getByName("debug")
      }
      proguardFiles(
        getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
      )
    }
    getByName("debug") {
      applicationIdSuffix = ".debug"
      isDebuggable = true
    }
  }

  compileOptions {
    sourceCompatibility = LangOptions.javaVersion
    targetCompatibility = LangOptions.javaVersion
  }

  lint {
    abortOnError = false
    warningsAsErrors = false
    checkReleaseBuilds = false
  }

  buildFeatures {
    compose = true
  }
}

kotlin {
  jvmToolchain(LangOptions.jvmToolchain)
}

dependencies {

  // Data
  implementation(projectsWorkaround.module.data)
  // Domain
  implementation(projectsWorkaround.module.domain)


}