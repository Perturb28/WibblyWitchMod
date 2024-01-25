package wibblywitch.cards.uncommon;

import basemod.patches.com.megacrit.cardcrawl.screens.compendium.CardLibraryScreen.NoCompendium;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import wibblywitch.cards.BaseCard;
import wibblywitch.character.WibblyWitch;
import wibblywitch.util.CardStats;

@NoCompendium
public class WyrdStrike extends BaseCard {

    private static final int DAMAGE = 6;
    private static final int UPG_DAMAGE = 2;

    public static final String ID = makeID(WyrdStrike.class.getSimpleName());
    public static final CardStats info = new CardStats(
        WibblyWitch.Enums.CARD_COLOR,
        CardType.ATTACK,
        CardRarity.UNCOMMON,
        CardTarget.ENEMY,
            1
    );
    public WyrdStrike() {
        super(ID, info);

        setDamage(DAMAGE, UPG_DAMAGE);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        for (int i = 0; i <= p.orbs.get(0).passiveAmount; i++) {
            addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_VERTICAL));
        }
    }

    @Override
    public AbstractCard makeCopy(){
        return new WyrdStrike();
    }
}
