package Party

interface Party<out T>{
    fun invite(player: @UnsafeVariance T)
    fun membersInfo()
    val party:MutableSet<@UnsafeVariance T>
}