package wibblywitch.cards;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import wibblywitch.actions.PrepareAction;
import wibblywitch.cards.spellcards.AbstractSpellCard;
import wibblywitch.cards.spellcards.FireballSpell;
import wibblywitch.character.WibblyWitch;
import wibblywitch.orbs.FireballOrb;
import wibblywitch.util.CardStats;

public class PrepareFireball extends BaseCard {
    private static final int DAMAGE = 6;
    private static final int UPG_DAMAGE = 2;

    public static final String ID = makeID(PrepareFireball.class.getSimpleName());
    public static final CardStats info = new CardStats(
            WibblyWitch.Enums.CARD_COLOR,
            CardType.SKILL,
            CardRarity.COMMON,
            CardTarget.SELF,
            0
    );
    public PrepareFireball() {
        super(ID, info);

        this.cardsToPreview = new FireballSpell();
        setDamage(DAMAGE, UPG_DAMAGE);
        setBlock(0, 0);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new PrepareAction(new FireballOrb()));
    }

    @Override
    public AbstractCard makeCopy(){
        return new PrepareFireball();
    }
}
