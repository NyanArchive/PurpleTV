plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "tv.orange"
    compileSdk = 35
    defaultConfig {
        minSdk = 21
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = Config.jvmTarget
    }

    sourceSets.named("main") {
        java.filter.exclude("**/*")
    }
}

tasks.register("genDex") {
    delete("${project.rootDir}/monolith/build/")
    dependsOn(":app:mergeDexRelease")
    doLast {
        val dexDir = file("${project.rootDir}/monolith/build/.transforms")
        println("[monolith] Looking for dex files in: ${dexDir.absolutePath}")
        println("[monolith] Directory exists: ${dexDir.exists()}")
        if (dexDir.exists()) {
            val dexFiles = dexDir.walk()
                .filter { it.isFile && it.name.endsWith(".dex") }
                .toList()

            if (dexFiles.isNotEmpty()) {
                println("[monolith] Found dex file: ${dexFiles[0].name}")
                copy {
                    from(dexFiles[0])
                    into("${project.rootDir}/dex/")
                    rename { "app.dex" }
                }
                println("[monolith] Dex file has been copied successfully!")
            } else {
                println("[monolith] No dex files found in ${dexDir.absolutePath} or its subdirectories")
            }
        } else {
            println("[monolith] Transforms directory not found at ${dexDir.absolutePath}")
        }
    }
}

tasks.configureEach {
    when (this.name) {
        "dexBuilderRelease" -> this.doFirst {
            copy {
                println("[monolith] Exclude R.java from building")
                from("${rootProject.projectDir}/app/R.jar")
                into("${rootProject.projectDir}/app/build/intermediates/compile_and_runtime_not_namespaced_r_class_jar/release")
            }
        }

        "mergeDexRelease" -> this.doFirst {
            copy {
                println("[monolith] Exclude R.java from building")
                from("${rootProject.projectDir}/app/R.jar")
                into("${rootProject.projectDir}/app/build/intermediates/compile_and_runtime_not_namespaced_r_class_jar/release")
            }
            delete(fileTree("${rootProject.projectDir}/app/build/intermediates/project_dex_archive/release/out") {
                println("[monolith] Exclude all *.jar's from building")
                include(
                    "**/*.jar"
                )
            })
            println("[monolith] Exclude Twitch module *.dex'es")
            delete(fileTree("${rootProject.projectDir}/Twitch/build/.transforms") { include("**/*.dex") })
            println("[monolith] Exclude external libs from building")
            delete(fileTree("${rootProject.projectDir}/app/build/intermediates/external_libs_dex") {
                include(
                    "**/*.dex"
                )
            })
        }

        // Comment this section for gen app dex'es
        "compileReleaseJavaWithJavac" -> this.doLast {
            val path = "${layout.buildDirectory.get()}/intermediates/javac/release/classes"
            println("--------> $path")
            delete(file(path))
            mkdir(path)
        }
    }
}

dependencies {
    api(project(":monolith"))

    api(Dependencies.Hilt)
    kapt(Dependencies.HiltCompiler)
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}

hilt {
    enableAggregatingTask = false
}

afterEvaluate {
    File("${project.rootDir}/dex").mkdirs()
}