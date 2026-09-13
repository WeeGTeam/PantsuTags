import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidKotlinMultiplatformLibrary)
    alias(libs.plugins.kotlinxSerialization)
    alias(libs.plugins.openApiGenerator)
}

kotlin {
    android {
        namespace = "moe.mizugi.pantsutags.api.generated"
        compileSdk = libs.versions.android.compileSdk.get().toInt()
        minSdk = libs.versions.android.minSdk.get().toInt()
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
        }
    }

    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ApiGenerated"
            isStatic = true
        }
    }

    jvm()

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
    }

    sourceSets {
        commonMain.dependencies {
            implementation(libs.kotlinx.serialization)
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.contentNegotiation)
            implementation(libs.ktor.serialization.json)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
            implementation(libs.kotlinx.coroutines.test)
        }
        androidMain.dependencies {
            implementation(libs.ktor.client.android)
        }
        appleMain.dependencies {
            implementation(libs.ktor.client.darwin)
        }
        jvmMain.dependencies {
            implementation(libs.ktor.client.java)
        }
        jvmTest.dependencies {
            implementation(libs.ktor.client.mock)
        }
    }
}

openApiGenerate {
    generatorName.set("kotlin")
    generateApiTests.set(false)
    generateModelTests.set(false)
    inputSpec.set("$rootDir/openapi.yaml")
    outputDir.set(layout.buildDirectory.dir("generated/openapi").get().asFile.path)
    packageName.set("moe.mizugi.pantsutags.api.generated")
    apiPackage.set("moe.mizugi.pantsutags.api.generated.api")
    modelPackage.set("moe.mizugi.pantsutags.api.generated.model")
    typeMappings.set(
        mapOf(
            "string+binary" to "kotlin.ByteArray"
        )
    )
    configOptions.set(
        mapOf(
            "dateLibrary" to "kotlinx-datetime",
            "enumPropertyNaming" to "UPPERCASE",
            "library" to "multiplatform",
        )
    )
}

// AGP derives a baseline-profile source directory from the generated sources
// (build/generated/openapi/src/main/baselineProfiles), so its ART profile tasks
// read openApiGenerate's output and need the dependency declared explicitly.
tasks.matching { it.name.contains("ArtProfile") }.configureEach {
    dependsOn("openApiGenerate")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompilationTask<*>>().configureEach {
    dependsOn("openApiGenerate")
    compilerOptions {
        freeCompilerArgs.addAll(
            "-opt-in=kotlin.time.ExperimentalTime"
        )
    }
}

kotlin.sourceSets.named("commonMain") {
    kotlin.srcDir(layout.buildDirectory.dir("generated/openapi/src/main/kotlin"))
}

