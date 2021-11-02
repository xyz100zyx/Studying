package Weapons.TwoHandWeapon.Interfaces

import Character.Character

interface TwoHandAttackable<in p: Character>{

    fun attackTwoHand(player: p)
}