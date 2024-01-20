package wibblywitch.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;

public class FireballEvokeAction extends AbstractGameAction {
    AbstractPlayer p;

    public FireballEvokeAction(AbstractPlayer p) {
        this.p = p;
    }

    @Override
    public void update() {
        this.addToBot(new DamageAllEnemiesAction(p, 15, DamageInfo.DamageType.THORNS, AttackEffect.FIRE));
        this.isDone = true;
    }
}
