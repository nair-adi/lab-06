
package com.example.lab6

import com.example.lab6.ui.theme.Wizard
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class WizardTest {

    private lateinit var evilWizard: Wizard

    // Set up a new wizard before every test
    @Before
    fun setUp() {
        evilWizard = Wizard("Evil Wizard", 30, 10)
    }

    @Test
    fun castSpell_explosion_successful() {
        val damageDealt = evilWizard.castSpell("Explosion")

        assertEquals(30, damageDealt) // 10 * 3 = 30
        assertEquals(20, evilWizard.mana) // 30 - 10 = 20
    }

    @Test
    fun castSpell_explosion_unsuccessful() {
        evilWizard.mana = 5 // Not enough mana
        val damageDealt = evilWizard.castSpell("Explosion")

        assertEquals(0, damageDealt)
        assertEquals(5, evilWizard.mana)
    }

    @Test
    fun castSpell_frostbite_successful() {
        val damageDealt = evilWizard.castSpell("Frostbite")

        assertEquals(20, damageDealt) // 10 * 2 = 20
        assertEquals(25, evilWizard.mana) // 30 - 5 = 25
    }

    @Test
    fun castSpell_frostbite_unsuccessful() {
        evilWizard.mana = 3 // Not enough mana
        val damageDealt = evilWizard.castSpell("Frostbite")

        assertEquals(0, damageDealt)
        assertEquals(3, evilWizard.mana)
    }
}
