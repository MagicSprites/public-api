package net.querix.api.user.objects

data class Leader(
    val name: String,
    val amount: Long // по сути это чаще всего инт, но я хочу шаблонизировать отыгранное время
)
