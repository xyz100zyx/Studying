package Character

import Character.CommonActivities.Inspection
import Descriptions.Colors.ColorableClass
import Descriptions.Colors.Colors
import Descriptions.Ranks.AvailableRanks
import Descriptions.Ranks.Ranks
import Party.Party

abstract class Character(name:String?) : Inspection<Character>, Party<Character>, AvailableRanks, ColorableClass {

    abstract val className: String

    val colorClass: String

    var name: String?
        get() = field ?: "Undefined"
        private set

    var rank: String
        private set

    var healthPoint: Int = 0
        set(value){
            if (value<0) field = 0 else field = value
        }
        get() = field

    var damagePoint: Int = 0
        set(value) {
            if (value<=0) field = 1 else field = value
        }
        get() = field

    override val party: MutableSet<Character> = mutableSetOf()
        get() = field

    final override val myRanks: MutableSet<String> = mutableSetOf()

    init{
        this.myRanks.add(Ranks.RANK_START)
        this.rank = myRanks.toString()
        this.name = name
        this.rank = Ranks.RANK_START
        colorClass = setColor()
    }

    private fun showInfo(player: Character){
        print("\nColor: ${player.colorClass}\nName: ${player.name}\nRank: ${player.rank}\nHealth: ${player.healthPoint}\nDamage: ${player.damagePoint}")
    }

    fun showInfo(){
        print("\nColor: ${this.colorClass}\nName: ${this.name}\nRank: ${this.rank}\nHealth: ${this.healthPoint}\nDamage: ${this.damagePoint}")
    }

    final override fun inspect(player: Character) {
        this.showInfo(player)
    }

    final override fun invite(player: Character) {
        this.party.add(player)
    }

    final override fun membersInfo() {
        for (member in this.party) member.showInfo()
    }

    final override fun setRank(rank: String) {
        for (available in myRanks) if (rank==available) changeRank(rank) else print("You haven't this rank your available ranks.")
    }

    final override fun addNewRank(rank: String) {
        myRanks.add(rank)
    }

    final override fun changeRank(rank: String) {
        this.rank = rank
    }

    final override fun setColor(): String = when (this.className)
    {
        "Warrior" -> Colors.COLOR_WARRIOR
        "Paladin" -> Colors.COLOR_PALADIN
        "Death Knight" -> Colors.COLOR_DEATH_KNIGHT
        else -> ""
    }
}