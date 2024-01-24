package wibblywitch.cards;

import com.megacrit.cardcrawl.actions.animations.TalkAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import wibblywitch.actions.SpellIntensifyAction;
import wibblywitch.character.WibblyWitch;
import wibblywitch.powers.EssentialSpellPower;
import wibblywitch.powers.IntensifyPower;
import wibblywitch.util.CardStats;

public class WibblyForm extends BaseCard {

    public static final String ID = makeID(WibblyForm.class.getSimpleName());
    public static final CardStats info = new CardStats(
            WibblyWitch.Enums.CARD_COLOR,
            CardType.POWER,
            CardRarity.RARE,
            CardTarget.SELF,
            3
    );

    public WibblyForm() {
        super(ID, info);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new TalkAction(true, "SCHWIBBLEDY DIBBLEDY!", 1.0F, 2.0F));
        this.addToBot(new ApplyPowerAction(p, p, new IntensifyPower(p, 1)));
    }

}
