// formatter:off
package io.zenwave360.example;

import com.tngtech.archunit.core.importer.ImportOption.DoNotIncludeTests;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;
import static com.tngtech.archunit.library.Architectures.onionArchitecture;

@AnalyzeClasses(packages = "io.zenwave360.example", importOptions = DoNotIncludeTests.class)
public class ArchitectureTest {

    @ArchTest
    static final ArchRule respectsLayersForHexagonalArchitecture = layeredArchitecture()
        .consideringOnlyDependenciesInAnyPackage("io.zenwave360.example..")
        .layer("Config").definedBy("..config..")
        .layer("Core").definedBy("..core..")
        .layer("Domain").definedBy("..core.domain..")
        .optionalLayer("SearchModel").definedBy("..core.domain.search..")
        .optionalLayer("InfrastructureSearch").definedBy("..core.outbound.search..")
        .layer("CoreImplementation").definedBy("..core.implementation..")
        .layer("CoreInbound").definedBy("..core.inbound..")
        .layer("CoreOutbound").definedBy("..core.outbound..")
        .optionalLayer("Infrastructure").definedBy("..infrastructure..")
        .optionalLayer("Adapters").definedBy("..adapters..")

        .whereLayer("Config").mayNotBeAccessedByAnyLayer()
        .whereLayer("CoreImplementation").mayNotBeAccessedByAnyLayer()
        .whereLayer("CoreImplementation").mayOnlyAccessLayers("Core", "CoreInbound", "CoreOutbound", "Domain")
        .whereLayer("Infrastructure").mayOnlyBeAccessedByLayers("Config")
        .whereLayer("Infrastructure").mayOnlyAccessLayers("CoreOutbound", "Domain")
        .whereLayer("CoreInbound").mayOnlyAccessLayers("Domain")
        .whereLayer("CoreInbound").mayOnlyBeAccessedByLayers("CoreImplementation", "Adapters")
        .whereLayer("CoreOutbound").mayOnlyAccessLayers("Domain")
        .whereLayer("CoreOutbound").mayOnlyBeAccessedByLayers("CoreImplementation", "Infrastructure", "InfrastructureSearch")
        .whereLayer("Domain").mayOnlyAccessLayers("Domain")
        .whereLayer("SearchModel").mayOnlyAccessLayers("Domain")
        ;

    @ArchTest
    static final ArchRule respectsOnionArchitecture = onionArchitecture()
            .withOptionalLayers(true)
            .domainModels("..core.domain..")
            .domainServices("..core.inbound..", "..core.outbound..")
            .applicationServices("..core.implementation..")
            .adapter("web", "..adapters.web..")
            .adapter("event", "..adapters.event..")
            .adapter("jpa", "..infrastructure.jpa..")
            .adapter("mongodb", "..infrastructure.mongodb..")
            .adapter("search", "..infrastructure.search..");
}
