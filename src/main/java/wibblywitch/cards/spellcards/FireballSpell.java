package wibblywitch.cards.spellcards;

import basemod.patches.com.megacrit.cardcrawl.screens.compendium.CardLibraryScreen.NoCompendium;
import wibblywitch.WibblyWitchMod;
import wibblywitch.orbs.FireballOrb;

@NoCompendium
public class FireballSpell extends AbstractSpellCard{
    public static final String ID = makeID(FireballSpell.class.getSimpleName());

    public FireballSpell() {
        super(ID);
        setDamage(FireballOrb.BASE_DAMAGE);
    }
}
