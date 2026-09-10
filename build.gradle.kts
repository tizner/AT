plugins {
    id("java")
}

group = "StepUP"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
    outputs.upToDateWhen { false }
}

tasks.register<Test>("TestMethod") {
 group = "tests"
    useJUnitPlatform()
    testLogging {
        showStandardStreams = true
    }
    outputs.upToDateWhen { false }
}

tasks.register("End") {
    group = "tests"
    doLast {
        println(" ")
        println("Test run is over")
    }
}
 tasks.named("End"){
     dependsOn("TestMethod")

 }

