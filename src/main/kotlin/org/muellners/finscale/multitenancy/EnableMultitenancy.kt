package org.muellners.finscale.multitenancy

import org.muellners.finscale.multitenancy.config.MultitenancyImportSelector
import org.springframework.context.annotation.Import

@kotlin.annotation.Target(AnnotationTarget.CLASS)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@Import(MultitenancyImportSelector::class)
annotation class EnableMultitenancy()
