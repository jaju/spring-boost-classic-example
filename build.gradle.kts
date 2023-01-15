plugins {
    id("java")
    id("org.springframework.boot") version "2.7.7"
    id("io.spring.dependency-management") version "1.1.0"
}

repositories {
    mavenLocal()
    maven {
        name = "Clojars"
        url = uri("https://clojars.org/repo")
    }
    mavenCentral()
}

sourceSets {
    main {
        java {
            srcDir("src/main/clojure")
        }
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.clojure:clojure:1.11.1")
    implementation("org.msync:spring-boost-classic:0.1.1-SNAPSHOT")
    implementation("compojure:compojure:1.7.0")
}

tasks.register<Copy>("copyClojure") {
    from("src/main/clojure")
    into("build/classes/java/main")
}

tasks.getByName("bootRunMainClassName").dependsOn("copyClojure")

testing {
    suites {
        val test by getting(JvmTestSuite::class) {
            useJUnitJupiter("5.9.2")
        }
    }
}