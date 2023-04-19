// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(Plugins.AGP.application) version Versions.AGP apply false
    id(Plugins.AGP.library) version Versions.AGP apply false
    id(Plugins.KotlinAndroid.kotlin) version Versions.kotlin apply false
    id(Plugins.DaggerHilt.hilt) version Versions.hilt apply false
    //id(Plugins.KotlinAndroid.jvm) version Versions.kotlin apply false
}