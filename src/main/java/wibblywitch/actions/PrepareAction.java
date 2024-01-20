package wibblywitch.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import com.megacrit.cardcrawl.orbs.EmptyOrbSlot;

import java.util.Iterator;

public class PrepareAction extends AbstractGameAction {
    private AbstractOrb orbType;

    public PrepareAction(AbstractOrb newSpellType){
        this.duration = Settings.ACTION_DUR_FAST;
        this.orbType = newSpellType;
    }

    @Override
    public void update() {
        // Might need moving or rethinking?
        AbstractPlayer p = AbstractDungeon.player;
        if (this.duration == Settings.ACTION_DUR_FAST) {
            if (p.hasEmptyOrb()) {
                p.channelOrb(this.orbType);
            }
            else {
                AbstractOrb oldOrb1 = p.orbs.get(0);
                AbstractOrb oldOrb2 = p.orbs.get(1);

                // Replace primary orb if it has delay 0.
                if (oldOrb1.passiveAmount == 0){
                    oldOrb1.onEvoke();
                }

                p.orbs.set(0, new EmptyOrbSlot());
                p.channelOrb(this.orbType);
            }

            if (Settings.FAST_MODE) {
                this.isDone = true;
                return;
            }
        }

        this.tickDuration();
    }
}
