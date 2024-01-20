package wibblywitch.orbs;

import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.localization.OrbStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import wibblywitch.actions.DustEvokeAction;
import wibblywitch.actions.FireballEvokeAction;

import static wibblywitch.WibblyWitchMod.makeID;

public class DustOrb extends AbstractSpellOrb {


    public static final String ABSTRACT_SPELL_ORB_ID = makeID("AbstractSpellOrb");
    public static final OrbStrings orbStrings = CardCrawlGame.languagePack.getOrbString(ABSTRACT_SPELL_ORB_ID);
    private AbstractMonster m;

    private int DAMAGE;
    public DustOrb(AbstractMonster m) {
        super(0);

        this.name = orbStrings.NAME;
        this.img = ImageMaster.ORB_PLASMA;

        this.m = m;
        this.DAMAGE = 8;

        this.updateDescription();
    }

    @Override
    public void updateDescription() {
        super.updateDescription();
        this.description += orbStrings.DESCRIPTION[0] + this.DAMAGE + orbStrings.DESCRIPTION[1];
    }

    @Override
    public void onEvoke() {
        AbstractDungeon.actionManager.addToTop(new DustEvokeAction(new DamageInfo(AbstractDungeon.player, this.DAMAGE, DamageInfo.DamageType.THORNS), m));
    }

    @Override
    public AbstractOrb makeCopy() {
        return new DustOrb(m);
    }
}
