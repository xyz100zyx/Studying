package Character

import Weapons.TwoHandWeapon.Interfaces.TwoHandAttackable

class DeathKnight(name:String): Character(name), TwoHandAttackable<Character> {
    init {
        this.healthPoint = 150
        this.damagePoint = 13
    }

    override val className: String
        get() = "Death Knight"

    override fun attackTwoHand(player: Character) {
        player.healthPoint -= this.damagePoint
    }

}