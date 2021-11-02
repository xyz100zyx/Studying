package Character

import Weapons.TwoHandWeapon.Interfaces.TwoHandAttackable

class Paladin(name: String): Character(name), TwoHandAttackable<Character> {

    init {
        this.healthPoint = 145
        this.damagePoint = 15
    }

    override val className: String
        get() = "Paladin"

    override fun attackTwoHand(player: Character) {
        player.healthPoint -= this.damagePoint
    }
}