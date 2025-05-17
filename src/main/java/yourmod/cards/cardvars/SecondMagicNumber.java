package yourmod.cards.cardvars;

import com.megacrit.cardcrawl.cards.AbstractCard;
import yourmod.cards.AbstractReptoCard;

import static yourmod.ModFile.makeID;

public class SecondMagicNumber extends AbstractEasyDynamicVariable {

    @Override
    public String key() {
        return makeID("m2");
    }

    @Override
    public boolean isModified(AbstractCard card) {
        if (card instanceof AbstractReptoCard) {
            return ((AbstractReptoCard) card).isSecondMagicModified;
        }
        return false;
    }

    @Override
    public int value(AbstractCard card) {
        if (card instanceof AbstractReptoCard) {
            return ((AbstractReptoCard) card).secondMagic;
        }
        return -1;
    }

    public void setIsModified(AbstractCard card, boolean v) {
        if (card instanceof AbstractReptoCard) {
            ((AbstractReptoCard) card).isSecondMagicModified = v;
        }
    }

    @Override
    public int baseValue(AbstractCard card) {
        if (card instanceof AbstractReptoCard) {
            return ((AbstractReptoCard) card).baseSecondMagic;
        }
        return -1;
    }

    @Override
    public boolean upgraded(AbstractCard card) {
        if (card instanceof AbstractReptoCard) {
            return ((AbstractReptoCard) card).upgradedSecondMagic;
        }
        return false;
    }
}