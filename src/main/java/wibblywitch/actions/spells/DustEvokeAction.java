package wibblywitch.actions.spells;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class DustEvokeAction extends AbstractGameAction{
    private final AbstractMonster m;
    private final int damage;

    public DustEvokeAction(int damage, AbstractMonster m) {
        this.m = m;
        this.damage = damage;
    }

    @Override
    public void update() {
        // Deals damage to a single enemy.
        DamageInfo info = new DamageInfo(AbstractDungeon.player, damage, DamageInfo.DamageType.THORNS);
        this.addToBot(new DamageAction(m, info, AttackEffect.BLUNT_HEAVY, true));
        this.isDone = true;
    }
}
