package wibblywitch.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import wibblywitch.actions.SpellQuickenAction;
import wibblywitch.actions.SpellSwapAction;
import wibblywitch.character.WibblyWitch;
import wibblywitch.util.CardStats;

public class StaffSwipe extends BaseCard {

    private static final int DAMAGE = 4;

    public static final String ID = makeID(StaffSwipe.class.getSimpleName());
    public static final CardStats info = new CardStats(
            WibblyWitch.Enums.CARD_COLOR,
            CardType.ATTACK,
            CardRarity.COMMON,
            CardTarget.ENEMY,
            1
    );

    public StaffSwipe() {
        super(ID, info);
        this.selfRetain = true;

        setDamage(DAMAGE);
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        addToBot(new SpellSwapAction(p));
        addToBot(new SpellQuickenAction(p, 1));
    }

    @Override
    public AbstractCard makeCopy() {
        return new StaffSwipe();
    }
}
