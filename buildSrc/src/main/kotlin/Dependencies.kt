object Dependencies {
    object UI {
        const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
        const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
        const val material = "com.google.android.material:material:${Versions.material}"
        const val constraintLayout =
            "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
        const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtx}"
    }

    object Test {
        const val junit = "junit:junit:${Versions.junit}"
        const val extJunit = "androidx.test.ext:junit:${Versions.extJunit}"
        const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    }

    object Coroutines {
        const val coroutinesAndroid =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesAndroid}"
    }

    object BindingDelegate {
        const val bindingDelegate =
            "com.github.kirich1409:viewbindingpropertydelegate-noreflection:${Versions.bindingDelegate}"
    }

    object NavComponent {
        const val fragmentKtx =
            "androidx.navigation:navigation-fragment-ktx:${Versions.NavComponent}"
        const val uiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.NavComponent}"
    }

    object Room {
        const val runtime = "androidx.room:room-runtime:${Versions.Room}"
        const val roomKtx = "androidx.room:room-ktx:${Versions.Room}"
        const val compiler = "androidx.room:room-compiler:${Versions.Room}"
    }

    object DaggerHilt {
        const val android = "com.google.dagger:hilt-android:${Versions.hilt}"
        const val compiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"
        const val androidCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    }

    object Lifecycle {
        const val liveDataktx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
        const val viewModelktx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
        const val runtimektx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    }
//    object JavaX {
//        const val inject = "javax.inject:javax.inject:1"
//    }
}

object Versions {
    const val AGP = "7.4.2"
    const val kotlin = "1.8.0"
    const val hilt = "2.44"
    const val coreKtx = "1.10.0"
    const val appcompat = "1.6.1"
    const val material = "1.8.0"
    const val constraintLayout = "2.1.4"
    const val fragmentKtx = "1.5.6"
    const val lifecycle = "2.6.1"
    const val junit = "4.13.2"
    const val extJunit = "1.1.5"
    const val espressoCore = "3.5.1"
    const val coroutinesAndroid = "1.6.4"
    const val bindingDelegate = "1.5.8"
    const val NavComponent = "2.5.3"
    const val Room = "2.5.1"
}

object Plugins {
    object AGP {
        const val application = "com.android.application"
        const val library = "com.android.library"
    }

    object KotlinAndroid {
        const val kotlin = "org.jetbrains.kotlin.android"
        const val kapt = "kotlin-kapt"
   //     const val jvm = "org.jetbrains.kotlin.jvm"
    }

    object DaggerHilt {
        const val hilt = "com.google.dagger.hilt.android"
    }
//    object Java {
//        const val library = "java-library"
//    }
}