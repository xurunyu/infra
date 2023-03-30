plugins {
	id("org.springframework.boot") version "3.0.0"
	id("io.spring.dependency-management") version "1.1.0"
	kotlin("jvm") version "1.7.21"
	kotlin("plugin.spring") version "1.7.21"
}

group = "com.airwallex"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.freemarker:freemarker:2.3.31")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation("org.apache.httpcomponents:httpclient:4.5.14")
	implementation("com.alibaba:fastjson:2.0.21")
	implementation("javax.xml.bind:jaxb-api:2.4.0-b180830.0359")
	implementation("com.fasterxml.jackson.core:jackson-databind")
	implementation("io.vavr:vavr-jackson:0.10.3")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
	kotlinOptions {
		jvmTarget = "17"
	}
}