package wibblywitch.actions.spells;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class FireballEvokeAction extends AbstractGameAction {
    private final int damage;

    public FireballEvokeAction(int damage) {
        this.damage = damage;
    }

    @Override
    public void update() {
        // Deals damage to all enemies.
        this.addToBot(new DamageAllEnemiesAction(AbstractDungeon.player, damage, DamageInfo.DamageType.THORNS, AttackEffect.FIRE));
        this.isDone = true;
    }
}
