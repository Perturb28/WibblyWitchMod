package wibblywitch.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import wibblywitch.character.WibblyWitch;

public class SpellQuickenAction extends AbstractGameAction {
    private AbstractPlayer p;
    private final int amount;

    public SpellQuickenAction(AbstractPlayer newP, int newAmount) {
        this.p = newP;
        this.amount = newAmount;
    }
    @Override
    public void update() {
        if (p.getClass() == WibblyWitch.class) {
            ((WibblyWitch) p).quicken(amount);
        }
        this.isDone = true;
    }
}
