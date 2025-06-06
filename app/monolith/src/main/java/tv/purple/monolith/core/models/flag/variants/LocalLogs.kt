package tv.purple.monolith.core.models.flag.variants

import tv.purple.monolith.core.models.flag.core.Variant

enum class LocalLogs(val value: String) : Variant {
    L0("0"),
    L500("500"),
    L1000("1000"),
    L5000("5000"),
    L10000("10000");

    override fun getDefault(): Variant {
        return L0
    }

    override fun toString(): String {
        return value
    }
}