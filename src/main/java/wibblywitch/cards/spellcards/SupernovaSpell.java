package wibblywitch.cards.spellcards;

import basemod.patches.com.megacrit.cardcrawl.screens.compendium.CardLibraryScreen.NoCompendium;
import wibblywitch.orbs.SupernovaOrb;

@NoCompendium
public class SupernovaSpell extends AbstractSpellCard{
    public static final String ID = makeID(SupernovaSpell.class.getSimpleName());

    public SupernovaSpell() {
        super(ID);
        setDamage(SupernovaOrb.BASE_DAMAGE);
    }
}
