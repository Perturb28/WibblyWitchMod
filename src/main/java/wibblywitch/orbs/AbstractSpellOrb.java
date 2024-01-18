package wibblywitch.orbs;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.defect.AnimateOrbAction;
import com.megacrit.cardcrawl.actions.defect.EvokeOrbAction;
import com.megacrit.cardcrawl.actions.defect.LightningOrbEvokeAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.localization.OrbStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import com.megacrit.cardcrawl.vfx.combat.OrbFlareEffect;
import wibblywitch.actions.SpellEvokeAction;

import static wibblywitch.WibblyWitchMod.makeID;

public class AbstractSpellOrb extends AbstractOrb {

    protected AbstractMonster target;

    public static final String ABSTRACT_SPELL_ORB_ID = makeID("AbstractSpellOrb");
    public static final OrbStrings orbStrings = CardCrawlGame.languagePack.getOrbString(ABSTRACT_SPELL_ORB_ID);

    public AbstractSpellOrb(int delay, AbstractMonster m) {
        this.img = ImageMaster.ORB_LIGHTNING;
        this.basePassiveAmount = delay;
        this.passiveAmount = delay;
        this.baseEvokeAmount = delay;
        this.evokeAmount = delay;

        this.target = m;
    }

    @Override
    public void updateDescription() {
        if (this.passiveAmount > 1){
            this.description = orbStrings.DESCRIPTION[0] + this.passiveAmount + orbStrings.DESCRIPTION[1];
        }
        else if (this.passiveAmount == 1) {
            this.description = orbStrings.DESCRIPTION[2];
        }
        else{
            this.description = orbStrings.DESCRIPTION[3];
        }
    }

    @Override
    public void onEvoke() {
        // Should always be overridden by inheritors.
    }

    @Override
    public void onEndOfTurn() {
        if (this.passiveAmount == 0) {
            this.onEvoke();
        }
    }

    @Override
    public AbstractOrb makeCopy() {
        return null;
    }

    @Override
    public void render(SpriteBatch sb) {
        this.shineColor.a = this.c.a / 2.0F;
        sb.setColor(this.shineColor);
        sb.setBlendFunction(770, 1);
        sb.draw(this.img, this.cX - 48.0F, this.cY - 48.0F + this.bobEffect.y, 48.0F, 48.0F, 96.0F, 96.0F, this.scale + MathUtils.sin(this.angle / 12.566371F) * 0.05F + 0.19634955F, this.scale * 1.2F, this.angle, 0, 0, 96, 96, false, false);
        sb.draw(this.img, this.cX - 48.0F, this.cY - 48.0F + this.bobEffect.y, 48.0F, 48.0F, 96.0F, 96.0F, this.scale * 1.2F, this.scale + MathUtils.sin(this.angle / 12.566371F) * 0.05F + 0.19634955F, -this.angle, 0, 0, 96, 96, false, false);
        sb.setBlendFunction(770, 771);
        sb.setColor(this.c);
        sb.draw(this.img, this.cX - 48.0F, this.cY - 48.0F + this.bobEffect.y, 48.0F, 48.0F, 96.0F, 96.0F, this.scale, this.scale, this.angle / 12.0F, 0, 0, 96, 96, false, false);
        this.renderText(sb);
        this.hb.render(sb);
    }

    @Override
    public void playChannelSFX() {

    }
}
