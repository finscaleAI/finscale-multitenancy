package org.muellners.finscale.multitenancy.domain

object TenantContextHolder {
    private val context: ThreadLocal<String> = ThreadLocal()

    fun getContext(): String {
        return try {
            context.get()
        } catch (e: IllegalStateException) {
            "primary"
        }
    }

    fun setContext(identifier: String) = context.set(identifier)

    fun clearContext() = context.remove()
}
