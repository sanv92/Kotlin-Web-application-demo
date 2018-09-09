import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


plugins {
    java
    kotlin("jvm") version "1.2.61"
    // id("com.bmuschko.tomcat") version "2.5"
}

group = "web-application-demo"
version = "1.0-SNAPSHOT"

java.sourceSets["main"].withConvention(KotlinSourceSet::class) {
    kotlin.srcDirs(files("src/main/kotlin"))
    kotlin.srcDirs(files("src/main/java"))
}

repositories {
    mavenCentral()
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
    // testCompile("junit", "junit", "5.2.0")

    compile(kotlin("reflect"))
    testCompile(kotlin("test"))
    testCompile(kotlin("test-junit"))

    compile("org.postgresql:postgresql:42.2.5")
    compile("org.hibernate:hibernate-agroal:5.3.5.Final")

    compile("javax.servlet:javax.servlet-api:3.1.0")
    compile("org.eclipse.jetty:jetty-server:9.4.12.v20180830")
    compile("org.eclipse.jetty:jetty-servlet:9.4.12.v20180830")
    compile("org.eclipse.jetty:jetty-webapp:9.4.12.v20180830")
    compile("org.eclipse.jetty:jetty-util:9.4.12.v20180830")
    compile("org.eclipse.jetty:jetty-plus:9.4.12.v20180830")
    compile("org.eclipse.jetty:jetty-annotations:9.4.12.v20180830")

    compile("org.jboss.resteasy:resteasy-jaxrs:3.6.1.Final")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
