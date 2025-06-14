plugins {
    id("com.android.library") version Versions.androidLibraryVersion apply false
    id("org.jetbrains.kotlin.android") version Versions.kotlinAndroidVersion apply false
}

tasks.register("clean", Delete::class.java) {
    delete(layout.buildDirectory)
}