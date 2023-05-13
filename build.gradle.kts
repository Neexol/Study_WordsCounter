plugins {
    kotlin("jvm") version "1.8.20"
    id("org.sonarqube") version "3.5.0.2730"
    application
    jacoco
}

group = "org.example"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.apache.opennlp:opennlp-tools:2.2.0")
    implementation("org.slf4j:slf4j-api:2.0.7")
    implementation("org.slf4j:slf4j-log4j12:2.0.7")
}

tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport)
}

tasks.jacocoTestReport {
    dependsOn(tasks.test)
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