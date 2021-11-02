package Descriptions.Ranks

interface AvailableRanks {
    val myRanks: MutableSet<String>
    fun setRank(rank: String)
    fun changeRank(rank: String)
    fun addNewRank(rank: String)
}