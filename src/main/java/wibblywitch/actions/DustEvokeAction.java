package wibblywitch.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class DustEvokeAction extends AbstractGameAction{
    AbstractMonster m;
    DamageInfo damageInfo;

    public DustEvokeAction(DamageInfo info, AbstractMonster m) {
        this.m = m;
        this.damageInfo = info;
        this.attackEffect = AttackEffect.NONE;
    }

    @Override
    public void update() {
        this.addToBot(new DamageAction(m, damageInfo, AttackEffect.NONE, true));
        this.isDone = true;
    }
}
