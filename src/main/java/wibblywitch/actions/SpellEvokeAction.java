package wibblywitch.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.utility.SFXAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.combat.LightningEffect;
import wibblywitch.WibblyWitchMod;

public class SpellEvokeAction extends AbstractGameAction {
    private DamageInfo info;
    protected AbstractMonster m;

    public SpellEvokeAction(DamageInfo info, AbstractMonster m){
        this.m = m;
        this.info = info;
        this.actionType = ActionType.DAMAGE;
        this.attackEffect = AttackEffect.NONE;
    }

    @Override
    public void update() {
        if (m.isDead) {
            m = AbstractDungeon.getRandomMonster();
        }
        if (m != null) {
            WibblyWitchMod.logger.info(m);

            float speedTime = 0.1F;

            if (Settings.FAST_MODE) {
                speedTime = 0.0F;
            }

            this.addToTop(new DamageAction(m, this.info, AttackEffect.NONE, true));
            this.addToTop(new VFXAction(new LightningEffect(m.drawX, m.drawY), speedTime));
            this.addToTop(new SFXAction("ORB_LIGHTNING_EVOKE"));
            this.isDone = true;
        }
    }
}
