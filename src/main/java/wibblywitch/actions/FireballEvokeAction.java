package wibblywitch.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;

public class FireballEvokeAction extends AbstractGameAction {
    private AbstractPlayer p;
    private int damage;

    public FireballEvokeAction(AbstractPlayer p, int damage) {
        this.p = p;
        this.damage = damage;
    }

    @Override
    public void update() {
        this.addToBot(new DamageAllEnemiesAction(p, damage, DamageInfo.DamageType.THORNS, AttackEffect.FIRE));
        this.isDone = true;
    }
}
