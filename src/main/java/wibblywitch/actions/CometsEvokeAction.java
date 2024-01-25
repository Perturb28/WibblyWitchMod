package wibblywitch.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import wibblywitch.orbs.CometsOrb;

public class CometsEvokeAction extends AbstractGameAction {
    private int count;

    public CometsEvokeAction(int count) {
        this.count = count;
    }
    @Override
    public void update() {
        AbstractCreature m = AbstractDungeon.getRandomMonster();
        if (m != null) {
            for (int i = 0; i < count; i++) {
                m = AbstractDungeon.getRandomMonster();
                DamageInfo info = new DamageInfo(AbstractDungeon.player, CometsOrb.BASE_DAMAGE, DamageInfo.DamageType.THORNS);
                this.addToBot(new DamageAction(m, info, AttackEffect.SMASH, true));
            }
        }
        this.isDone = true;
    }
}
