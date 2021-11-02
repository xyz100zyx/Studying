package Character

import Weapons.TwoHandWeapon.Interfaces.TwoHandAttackable

class Warrior(name: String?): Character(name), TwoHandAttackable<Character> {
    init {
        this.healthPoint = 110
        this.damagePoint = 24
    }

    override val className: String
        get() = "Warrior"

    override fun attackTwoHand(player: Character) {
        player.healthPoint -= this.damagePoint
    }

}