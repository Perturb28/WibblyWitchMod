package wibblywitch.cards.spellcards;

import basemod.patches.com.megacrit.cardcrawl.screens.compendium.CardLibraryScreen.NoCompendium;
import wibblywitch.orbs.CometsOrb;

@NoCompendium
public class CometsSpell extends AbstractSpellCard{
    public static final String ID = makeID(CometsSpell.class.getSimpleName());

    public CometsSpell() {
        super(ID);
        setDamage(CometsOrb.BASE_DAMAGE);
        // The magic number in this case is used so the description knows how many times it hits.
        setMagic(CometsOrb.BASE_COUNT);
    }
}
