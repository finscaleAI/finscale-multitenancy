package org.muellners.finscale.multitenancy.config

import javax.sql.DataSource
import org.muellners.finscale.multitenancy.domain.ContextAwareRoutingDataSource
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.DependsOn
import org.springframework.context.annotation.Primary

@Configuration
class DataSourceConfiguration(
    @Qualifier("primaryTenantDataSource") val primaryTenantDataSource: DataSource
) {

    @Primary
    @Bean(name = ["dataSource"])
    @DependsOn("primaryTenantDataSource")
    fun dataSource(tenantDataSourceMap: MutableMap<String, DataSource>): DataSource {
        val contextAwareRoutingDataSource = ContextAwareRoutingDataSource()
        contextAwareRoutingDataSource.setTargetDataSources(tenantDataSourceMap() as Map<Any, Any>)

        return contextAwareRoutingDataSource
    }

    @Bean
    fun tenantDataSourceMap() = mutableMapOf<Any, DataSource>("primary" to primaryTenantDataSource)
}
