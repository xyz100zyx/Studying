package Character.CommonActivities

interface Inspection <out T> {
    fun inspect(player: @UnsafeVariance T)
}