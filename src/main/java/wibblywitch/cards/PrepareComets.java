package wibblywitch.cards;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import wibblywitch.WibblyWitchMod;
import wibblywitch.actions.SpellPrepareAction;
import wibblywitch.cards.spellcards.CometsSpell;
import wibblywitch.character.WibblyWitch;
import wibblywitch.orbs.CometsOrb;
import wibblywitch.orbs.DustOrb;
import wibblywitch.util.CardStats;

import static wibblywitch.WibblyWitchMod.makeID;

public class PrepareComets extends BaseCard{
    public static final String ID = makeID(PrepareComets.class.getSimpleName());
    public static final CardStats info = new CardStats(
            WibblyWitch.Enums.CARD_COLOR,
            AbstractCard.CardType.SKILL,
            AbstractCard.CardRarity.COMMON,
            CardTarget.SELF,
            2
    );
    public PrepareComets() {
        super(ID, info);
        this.cardsToPreview = new CometsSpell();
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new SpellPrepareAction(new CometsOrb()));
    }

    @Override
    public AbstractCard makeCopy() {
        return new PrepareComets();
    }
}
