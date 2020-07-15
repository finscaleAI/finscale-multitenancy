package org.muellners.finscale.multitenancy

import com.tngtech.archunit.core.importer.ClassFileImporter
import com.tngtech.archunit.core.importer.ImportOption
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses
import org.junit.jupiter.api.Test

class ArchTest {

    @Test
    fun servicesAndRepositoriesShouldNotDependOnWebLayer() {

        val importedClasses = ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("org.muellners.finscale.multitenancy")

        noClasses()
            .that()
                .resideInAnyPackage("org.muellners.finscale.multitenancy.service..")
            .or()
                .resideInAnyPackage("org.muellners.finscale.multitenancy.repository..")
            .should().dependOnClassesThat()
                .resideInAnyPackage("..org.muellners.finscale.multitenancy.web..")
        .because("Services and repositories should not depend on web layer")
        .check(importedClasses)
    }
}
