package wibblywitch.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import wibblywitch.WibblyWitchMod;
import wibblywitch.character.WibblyWitch;
import wibblywitch.orbs.AbstractSpellOrb;

public class SpellIntensifyAction extends AbstractGameAction {

    public SpellIntensifyAction() {

    }
    @Override
    public void update() {
        AbstractPlayer p = AbstractDungeon.player;
        if (p instanceof WibblyWitch) {
            AbstractOrb o = p.orbs.get(0);
            if (o instanceof AbstractSpellOrb) {
                ((AbstractSpellOrb) o).intensify();
                o.updateDescription();
            }
        }
        this.isDone = true;
    }
}
