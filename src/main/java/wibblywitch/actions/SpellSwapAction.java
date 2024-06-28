package wibblywitch.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import wibblywitch.cards.spellcards.AbstractSpellCard;
import wibblywitch.orbs.AbstractSpellOrb;

import java.util.Collections;

public class SpellSwapAction extends AbstractGameAction {
    private final AbstractPlayer p;

    public SpellSwapAction(AbstractPlayer newP) {
        this.duration = Settings.ACTION_DUR_FAST;
        this.p = newP;
    }
    @Override
    public void update() {
        Collections.swap(p.orbs, 0, 1);
        // Not only does the player class need to know the orb positions, so must the orbs themselves!
        p.orbs.get(0).setSlot(0, 2);
        p.orbs.get(1).setSlot(1,2);
        this.isDone = true;
    }
}
