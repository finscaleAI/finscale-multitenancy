package org.muellners.finscale.multitenancy.service

import javax.transaction.Transactional
import org.junit.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
@Transactional
class TenantConsumerServiceIT {

    fun init() {
    }

    @Test
    @Transactional
    fun assertThatNewTenantIsCreated() {
    }
}
