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
import wibblywitch.actions.FireballEvokeAction;

import static wibblywitch.WibblyWitchMod.makeID;

public class FireballOrb extends AbstractSpellOrb {

    public static final String ID = makeID("FireballOrb");
    private static final OrbStrings orbStrings = CardCrawlGame.languagePack.getOrbString(ID);

    private static final int INTENSIFY_DAMAGE = 4;
    private static final int BASE_DELAY = 2;
    public static final int BASE_DAMAGE = 14;
    private int damage;

    public FireballOrb() {
        super(BASE_DELAY);

        this.name = orbStrings.NAME;
        this.img = FIREBALL_IMG;

        this.damage = BASE_DAMAGE;

        this.updateDescription();
    }
    @Override
    public void updateDescription() {
        super.updateDescription();
        this.description += orbStrings.DESCRIPTION[0] + this.damage + orbStrings.DESCRIPTION[1];
        this.description += orbStrings.DESCRIPTION[2] + INTENSIFY_DAMAGE + orbStrings.DESCRIPTION[3];
    }

    @Override
    public void onEvoke() {
        AbstractDungeon.actionManager.addToTop(new FireballEvokeAction(damage));
    }

    @Override
    public void intensify() {
        this.damage += INTENSIFY_DAMAGE;
        updateDescription();
    }

    @Override
    public AbstractOrb makeCopy() {
        return new FireballOrb();
    }
}
