package org.muellners.finscale.multitenancy;

import org.junit.Test
import org.springframework.boot.test.context.SpringBootTest
import javax.transaction.Transactional

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
