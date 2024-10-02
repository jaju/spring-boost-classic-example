plugins {
    id("java")
    id("org.springframework.boot") version "3.3.4"
    id("io.spring.dependency-management") version "1.1.6"
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
        resources {
            srcDir("src/main/clojure")
        }
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.clojure:clojure:1.12.0")
    implementation("org.msync:spring-boost-classic:0.3.0-alpha3")
    implementation("compojure:compojure:1.7.1")
}

testing {
    suites {
        val test by getting(JvmTestSuite::class) {
            useJUnitJupiter("5.11.1")
        }
    }
}
