# ZenWave Example

https://github.com/ZenWave360/zenwave-code-generator/tree/main/examples/spring-boot-mongo-elasticsearch

## ZenWave Code Generator

### Install ZenWave

```shell
jbang alias add --name=zw release@zenwave360/zenwave-code-generator
```

or if you prefer to use the latest **snapshot** versions:

```shell
jbang alias add --name=zw \
    -m=io.zenwave360.generator.Main \
    --repos=mavencentral,snapshots=https://s01.oss.sonatype.org/content/repositories/snapshots \
    --deps=\
org.slf4j:slf4j-simple:1.7.36,\
io.github.zenwave360.zenwave-code-generator.plugins:asyncapi-spring-cloud-streams3:0.9.9-SNAPSHOT,\
io.github.zenwave360.zenwave-code-generator.plugins:asyncapi-jsonschema2pojo:0.9.9-SNAPSHOT,\
io.github.zenwave360.zenwave-code-generator.plugins:openapi-spring-webtestclient:0.9.9-SNAPSHOT,\
io.github.zenwave360.zenwave-code-generator.plugins:openapi-rest-assured:0.9.9-SNAPSHOT,\
io.github.zenwave360.zenwave-code-generator.plugins:jdl-backend-application-default:0.9.9-SNAPSHOT,\
io.github.zenwave360.zenwave-code-generator.plugins:jdl-to-openapi:0.9.9-SNAPSHOT,\
io.github.zenwave360.zenwave-code-generator.plugins:jdl-to-asyncapi:0.9.9-SNAPSHOT,\
io.github.zenwave360.zenwave-code-generator.plugins:jdl-openapi-controllers:0.9.9-SNAPSHOT\
    io.github.zenwave360.zenwave-code-generator:zenwave-code-generator-cli:0.9.9-SNAPSHOT
```

### Starting Docker Infrastructure

```shell
cd src/main/docker
docker-compose -f all-dependencies.yml up -d
```

### Generate Backend Application

```shell
jbang zw -p io.zenwave360.generator.plugins.JDLBackendApplicationDefaultPlugin \
    specFile=src/main/resources/model/orders-model.jdl \
    basePackage=io.zenwave360.example \
    persistence=jpa \
    databaseType=mariadb \
    style=imperative \
    targetFolder=.
```

#### JDL To OpenAPI

Generate OpenAPI definition from JDL entities:

- Component Schemas for entities, plain and paginated lists
- CRUD operations for entities

```shell
jbang zw -p io.zenwave360.generator.plugins.JDLToOpenAPIPlugin \
    specFile=src/main/resources/model/orders-model.jdl \
    idType=integer \
    idTypeFormat=int64 \
    targetFile=src/main/resources/model/openapi.yml
```

#### JDL To AsyncAPI

Generate AsyncAPI definition from JDL entities:

- One channel for each entity update events
- Messages and payloads for each entity Create/Update/Delete events (AVRO and AsyncAPI schema)

```shell
jbang zw -p io.zenwave360.generator.plugins.JDLToAsyncAPIPlugin \
    includeCommands=true \
    specFile=src/main/resources/model/orders-model.jdl \
    idType=integer \
    idTypeFormat=int64 \
    annotations=aggregate \
    targetFile=src/main/resources/model/asyncapi.yml
```

#### API-First Maven Plugins

There are two Maven Plugins for API-First code generation:

- OpenAPI Generator Maven Plugin: https://github.com/ZenWave360/zenwave-examples/blob/main/skeletons/spring-boot-jpa-mariadb-kafka-skeleton/pom.xml#L107
- ZenWave Maven Plugin for AsyncAPI (spring-cloud-streams3 and jsonschema2pojo): https://github.com/ZenWave360/zenwave-examples/blob/main/skeletons/spring-boot-jpa-mariadb-kafka-skeleton/pom.xml#L139

Use the following command to generate OpenAPI and AsyncAPI api-first code:

```shell
mvn clean generate-sources
```

#### SpringMVC Controllers from OpenAPI

Generate new SpringMVC controllers from OpenAPI:

```shell
jbang zw -p io.zenwave360.generator.plugins.JDLOpenAPIControllersPlugin \
    specFile=src/main/resources/model/openapi.yml \
    jdlFile=src/main/resources/model/orders-model.jdl \
    basePackage=io.zenwave360.example \
    openApiApiPackage=io.zenwave360.example.adapters.web \
    openApiModelPackage=io.zenwave360.example.adapters.web.model \
    openApiModelNameSuffix=DTO \
    targetFolder=.
```

#### Spring WebTestClient

Generates test for SpringMVC or Spring WebFlux using WebTestClient based on OpenAPI specification.

```shell
jbang zw -p io.zenwave360.generator.plugins.SpringWebTestClientPlugin \
    specFile=src/main/resources/model/openapi.yml \
    jdlFile=src/main/resources/model/orders-model.jdl \
    targetFolder=src/test/java \
    testsPackage=io.zenwave360.example.adapters.web \
    openApiApiPackage=io.zenwave360.example.adapters.web \
    openApiModelPackage=io.zenwave360.example.adapters.web.model \
    openApiModelNameSuffix=DTO \
    groupBy=service
```

#### AsyncAPI Command Adapters


```shell
jbang zw -p io.zenwave360.generator.plugins.SpringCloudStreams3AdaptersPlugin \
    specFile=src/main/resources/model/asyncapi.yml \
    jdlFile=src/main/resources/model/orders-model.jdl \
    role=provider \
    style=imperative \
    basePackage=io.zenwave360.example \
    consumerApiPackage=io.zenwave360.example.adapters.events \
    modelPackage=io.zenwave360.example.core.domain.events \
    targetFolder=.
```

#### AsyncAPI Commands Tests


```shell
jbang zw -p io.zenwave360.generator.plugins.SpringCloudStreams3TestsPlugin \
    specFile=src/main/resources/model/asyncapi.yml \
    role=provider \
    style=imperative \
    basePackage=io.zenwave360.example \
    consumerApiPackage=io.zenwave360.example.adapters.events \
    modelPackage=io.zenwave360.example.core.domain.events \
    targetFolder=.
```
or

```shell
mvn zenwave-code-generator:generate@consumer-tests
```
