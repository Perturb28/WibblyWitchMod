package wibblywitch.cards;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import wibblywitch.actions.SpellPrepareAction;
import wibblywitch.cards.spellcards.DustSpell;
import wibblywitch.character.WibblyWitch;
import wibblywitch.orbs.DustOrb;
import wibblywitch.orbs.SupernovaOrb;
import wibblywitch.util.CardStats;

import static wibblywitch.WibblyWitchMod.makeID;

public class PrepareSupernova extends BaseCard{
    public static final String ID = makeID(PrepareSupernova.class.getSimpleName());
    public static final CardStats info = new CardStats(
            WibblyWitch.Enums.CARD_COLOR,
            AbstractCard.CardType.SKILL,
            AbstractCard.CardRarity.RARE,
            AbstractCard.CardTarget.ENEMY,
            2
    );

    public PrepareSupernova() {
        super(ID, info);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new SpellPrepareAction(new SupernovaOrb(m)));
    }

    @Override
    public AbstractCard makeCopy() {
        return new PrepareSupernova();
    }
}
