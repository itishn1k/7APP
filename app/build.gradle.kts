plugins {
    id(Plugins.AGP.application)
    id(Plugins.KotlinAndroid.kotlin)
    id(Plugins.KotlinAndroid.kapt)
    id(Plugins.DaggerHilt.hilt)
}

android {
    namespace = AndroidConfig.namespace
    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        applicationId = AndroidConfig.applicationId
        minSdk = AndroidConfig.minSdk
        targetSdk = AndroidConfig.targetSdk
        versionCode = AndroidConfig.versionCode
        versionName = AndroidConfig.versionName

        testInstrumentationRunner = AndroidConfig.testInstrumentationRunner
    }

    buildFeatures {
        viewBinding = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile(
                    "proguard-android-optimize.txt"
                ),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = KotlinConfig.jvmTarget
    }
}

dependencies {
    //ui
    implementation(Dependencies.UI.coreKtx)
    implementation(Dependencies.UI.appcompat)
    implementation(Dependencies.UI.material)
    implementation(Dependencies.UI.constraintLayout)
    implementation(Dependencies.UI.fragmentKtx)
    testImplementation(Dependencies.Test.junit)
    androidTestImplementation(Dependencies.Test.extJunit)
    androidTestImplementation(Dependencies.Test.espressoCore)

    //coroutines
    implementation(Dependencies.Coroutines.coroutinesAndroid)

    //view binding property delegate no reflection
    implementation(Dependencies.BindingDelegate.bindingDelegate)

    //nav component
    implementation(Dependencies.NavComponent.fragmentKtx)
    implementation(Dependencies.NavComponent.uiKtx)

    //room
    implementation(Dependencies.Room.runtime)
    implementation(Dependencies.Room.roomKtx)
    annotationProcessor(Dependencies.Room.compiler)
    kapt(Dependencies.Room.compiler)

    //hilt
    implementation(Dependencies.DaggerHilt.android)
    kapt(Dependencies.DaggerHilt.compiler)
    kapt(Dependencies.DaggerHilt.androidCompiler)

    //lifecycle
    implementation(Dependencies.Lifecycle.liveDataktx)
    implementation(Dependencies.Lifecycle.viewModelktx)
    implementation(Dependencies.Lifecycle.runtimektx)
}