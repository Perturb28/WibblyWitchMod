package wibblywitch.cards.spellcards;

import basemod.patches.com.megacrit.cardcrawl.screens.compendium.CardLibraryScreen.NoCompendium;

@NoCompendium
public class CometsSpell extends AbstractSpellCard{
    public static final String ID = makeID(CometsSpell.class.getSimpleName());

    public CometsSpell() {
        super(ID);
        setDamage(4);
        setMagic(6);
    }
}
