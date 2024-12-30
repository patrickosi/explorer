
android {
    buildFeatures {
        buildConfig = true
    }

    defaultConfig {
        buildConfigField("int", "MANUFACTURER", "3309")
        buildConfigField("boolean", "CONNECTABLE", "true")
        buildConfigField("String", "UUID", "\"0000180A-0000-1000-8000-00805F9B34FB\"")
    }
}

dependencies {
    implementation(project(":discovery:domain"))
    implementation(project(":discovery:data"))

    implementation(libs.dagger)

    testImplementation(libs.junit)
    testImplementation(libs.kotlin.test)
    testImplementation(libs.kotlinx.test.coroutines)
    testImplementation(libs.mockk)
    testImplementation(libs.mockk.jvm)
}
