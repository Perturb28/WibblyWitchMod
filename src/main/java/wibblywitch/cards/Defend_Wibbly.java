package wibblywitch.cards;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import wibblywitch.character.WibblyWitch;
import wibblywitch.util.CardStats;

public class Defend_Wibbly extends BaseCard {

    private static final int BLOCK = 5;
    private static final int UPG_BLOCK = 3;

    public static final String ID = makeID(Defend_Wibbly.class.getSimpleName());
    public static final CardStats info = new CardStats(
            WibblyWitch.Enums.CARD_COLOR,
            CardType.SKILL,
            CardRarity.COMMON,
            CardTarget.SELF,
            1
    );

    public Defend_Wibbly() {
        super(ID, info);
        setBlock(BLOCK,UPG_BLOCK);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new GainBlockAction(p, p, this.block));
    }
}
