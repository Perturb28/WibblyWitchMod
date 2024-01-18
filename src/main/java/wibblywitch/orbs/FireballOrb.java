package wibblywitch.orbs;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.defect.AnimateOrbAction;
import com.megacrit.cardcrawl.actions.defect.EvokeOrbAction;
import com.megacrit.cardcrawl.actions.defect.LightningOrbEvokeAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.localization.OrbStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import com.megacrit.cardcrawl.vfx.combat.LightningOrbActivateEffect;
import com.megacrit.cardcrawl.vfx.combat.OrbFlareEffect;
import wibblywitch.WibblyWitchMod;
import wibblywitch.actions.SpellEvokeAction;

import static wibblywitch.WibblyWitchMod.makeID;

public class FireballOrb extends AbstractSpellOrb {

    public static final String ID = makeID("FireballOrb");
    private static final OrbStrings orbStrings = CardCrawlGame.languagePack.getOrbString(ID);

    private int DAMAGE;

    public FireballOrb(AbstractMonster m) {
        super(2, m);
        WibblyWitchMod.logger.info("New Spell Orb created");
        WibblyWitchMod.logger.info(ID);

        this.name = orbStrings.NAME;
        this.img = ImageMaster.ORB_LIGHTNING;
        this.basePassiveAmount = 2;
        this.passiveAmount = 2;
        this.baseEvokeAmount = 2;
        this.evokeAmount = 2;

        this.DAMAGE = 15;

        this.updateDescription();
    }
    @Override
    public void updateDescription() {
        super.updateDescription();
        this.description += orbStrings.DESCRIPTION[0] + this.DAMAGE + orbStrings.DESCRIPTION[1];
    }

    @Override
    public void onEvoke() {
        AbstractDungeon.actionManager.addToTop(new SpellEvokeAction(new DamageInfo(AbstractDungeon.player, this.DAMAGE, DamageInfo.DamageType.THORNS), target));
    }

    @Override
    public AbstractOrb makeCopy() {
        return null;
    }

    public void triggerEvokeAnimation() {
        CardCrawlGame.sound.play("ORB_LIGHTNING_EVOKE", 0.1F);
        AbstractDungeon.effectsQueue.add(new LightningOrbActivateEffect(this.cX, this.cY));
    }
}
