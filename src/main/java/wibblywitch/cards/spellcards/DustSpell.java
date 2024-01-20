package wibblywitch.cards.spellcards;

import basemod.patches.com.megacrit.cardcrawl.screens.compendium.CardLibraryScreen.NoCompendium;
import wibblywitch.orbs.DustOrb;

@NoCompendium
public class DustSpell extends AbstractSpellCard {

    public static final String ID = makeID(DustSpell.class.getSimpleName());

    public DustSpell() {
        super(ID);
        setDamage(DustOrb.BASE_DAMAGE);
    }
}
