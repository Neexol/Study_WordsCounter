plugins {
    kotlin("jvm") version "1.8.20"
    id("org.sonarqube") version "3.5.0.2730"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.apache.opennlp:opennlp-tools:2.2.0")
    implementation("org.slf4j:slf4j-api:1.7.5")
    implementation("org.slf4j:slf4j-log4j12:1.7.5")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(11)
}

application {
    mainClass.set("MainKt")
}

sonarqube {
    properties {
        property("sonar.projectKey", "Neexol_Study_WordsCounter")
        property("sonar.organization", "neexol")
        property("sonar.host.url", "https://sonarcloud.io")
    }
}