package wibblywitch.cards.spellcards;

import basemod.patches.com.megacrit.cardcrawl.screens.compendium.CardLibraryScreen.NoCompendium;

@NoCompendium
public class DustSpell extends AbstractSpellCard {
    public static final String ID = makeID(DustSpell.class.getSimpleName());

    public DustSpell() {
        super(ID);
    }
}
