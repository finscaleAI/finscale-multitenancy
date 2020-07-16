package org.muellners.finscale.multitenancy.config

import kotlin.collections.HashSet
import org.muellners.finscale.multitenancy.service.TenantConsumerService
import org.springframework.context.annotation.ImportSelector
import org.springframework.core.type.AnnotationMetadata

class MultitenancyImportSelector : ImportSelector {
    override fun selectImports(importingClassMetadata: AnnotationMetadata): Array<String> {
        val classesToImport: MutableSet<Class<*>> = HashSet()

        classesToImport.add(DataSourceConfiguration::class.java)
        classesToImport.add(PrimaryTenantDataSourceConfiguration::class.java)
        classesToImport.add(RedisStreamConfiguration::class.java)
        classesToImport.add(TenantConsumerService::class.java)

        return classesToImport.map { it.canonicalName }.toTypedArray()
    }
}
