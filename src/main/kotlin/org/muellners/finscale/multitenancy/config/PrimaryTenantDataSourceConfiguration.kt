package org.muellners.finscale.multitenancy.config

import com.zaxxer.hikari.HikariDataSource
import javax.sql.DataSource
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment

@Configuration
class PrimaryTenantDataSourceConfiguration(val env: Environment) {

    @Bean
    @Qualifier("primaryTenantDataSource")
    fun primaryTenantDataSource(): DataSource = HikariDataSource()
        .apply {
            jdbcUrl = env.getProperty("spring.datasource.url")
            username = env.getProperty("spring.datasource.username")
            password = env.getProperty("spring.datasource.password")
    }
}
