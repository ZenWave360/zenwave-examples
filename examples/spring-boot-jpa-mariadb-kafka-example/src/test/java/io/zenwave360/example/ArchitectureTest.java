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

    /**
     * Validates that dependencies between layers respect hexagonal/onion/clean architecture.
     *
     * <ul>
     * <li>Domain: has no dependencies on other layers.</li>
     * <li>Inbound/Outbound Interfaces: has dependencies only on Domain layer.</li>
     * <li>Implementation: has dependencies only on Inbound/Outbound Interfaces and Domain layer.</li>
     * <li>Infrastructure: has dependencies only on Outbound Interfaces and Domain layer.</li>
     * <li>Adapters: has dependencies only on Inbound Interfaces and Domain layer.</li>
     * </ul>
     */
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

    /**
     * Validates that dependencies go from the outer layers to the inner layers, and not the other way around.
     *
     * See: https://www.archunit.org/userguide/html/000_Index.html#_onion_architecture
     */
    @ArchTest
    static final ArchRule respectsOnionArchitecture = onionArchitecture()
            .withOptionalLayers(true)
            .domainModels("..core.domain..")
            .domainServices("..core.inbound..", "..core.outbound..")
            .applicationServices("..core.implementation..")
            .adapter("inbound", "..adapters.(*)..")
            .adapter("outbound", "..infrastructure.(*)..");
}
