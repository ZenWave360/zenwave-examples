# ZenWave Code Generator Examples and Playground

> 👉 [ZenWave360](https://zenwave360.github.io/) Helps You Create Software that's Easy to Understand

This repository contains examples and playground for [ZenWave Code Generator](https://zenwave360.github.io/zenwave-code-generator/).

## Examples vs Skeletons

**Skeleton modules** only contain a minimal spring-boot application created from [Spring Initializr](https://start.spring.io/) and just a few configuration options on top.

They include:

- JDL/ZDL Models in `src/main/resources/model` folder that will be the basis for code generation.
- There is a README.md file with step-by-step instruction to construct a complete running application.
- Maven Plugin configuration in `pom.xml` to generate code as part of the build process.
- You may also find OpenAPI and AsyncAPI files in `src/main/resources/model` folder. They were generated from JDL/ZDL models using [ZenWave Code Generator](https://zenwave360.github.io/zenwave-code-generator/) and the reason they are already present for configured maven plugins not to fail during build.

If you follow the instructions in the README.md file you can evaluate how ZenWave Code Generator can assist you "From Model To Code & Tests".

**Examples** are complete applications that were generated using ZenWave Code Generator and they are ready to run.

## Skeletons

- [spring-boot-mongodb-elasticsearch-kafka-skeleton](skeletons/spring-boot-mongodb-elasticsearch-kafka-skeleton)
- [spring-boot-jpa-mariadb-kafka-skeleton](skeletons/spring-boot-jpa-mariadb-kafka-skeleton)


## Examples

- [spring-boot-mongodb-elasticsearch-kafka-example](examples/spring-boot-mongodb-elasticsearch-kafka-example)
- [spring-boot-jpa-mariadb-kafka-skeleton](skeletons/spring-boot-jpa-mariadb-kafka-skeleton)

## AsyncAPI: API-First Tests, Examples

You may also be interested in checking out [ZenWave Code Generator for AsyncAPI: API-First Tests, Examples and the Kitchen Sink](/ZenWave360/AsyncAPI-ApiFirst-Generator-KitchenSink) repository.

> 👉 [ZenWave360](https://zenwave360.github.io/) Helps You Create Software that's Easy to Understand
