package org.muellners.finscale.multitenancy

import javax.transaction.Transactional
import org.junit.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
@Transactional
class TenantConsumerService {

    fun init() {
    }

    @Test
    @Transactional
    fun assertThatNewTenantIsCreated() {
    }
}
