package wibblywitch.actions.spells;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class SupernovaEvokeAction extends AbstractGameAction{
    private final AbstractMonster m;
    private final int damage;

    public SupernovaEvokeAction(AbstractMonster m, int damage) {
        this.m = m;
        this.damage = damage;
    }

    @Override
    public void update() {
        DamageInfo info = new DamageInfo(AbstractDungeon.player, damage, DamageInfo.DamageType.THORNS);
        this.addToBot(new DamageAction(m, info, AttackEffect.SMASH, true));
        this.isDone = true;
    }
}
