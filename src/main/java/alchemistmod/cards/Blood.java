package alchemistmod.cards;

import alchemistmod.powers.FuryPower;
import alchemistmod.powers.VitalityPower;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static alchemistmod.ModFile.makeID;
import static alchemistmod.util.Wiz.atb;

public class Blood extends AbstractHumourCard {
    public final static String ID = makeID("Blood");
    // intellij stuff skill, self, basic, , ,  5, 3, ,
    public Blood() {
        this(0);
    }

    public Blood(int level) {
        super(ID, 0, CardRarity.SPECIAL, CardTarget.SELF);
        baseMagicNumber = 4;
        baseSecondMagic = 2;
        for (int i = 0; i < level; i++) {
            upgrade();
        }
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new ApplyPowerAction(p, p, new FuryPower(p, magicNumber), magicNumber));
        atb(new ApplyPowerAction(p, p, new VitalityPower(p, secondMagic), secondMagic));
        atb(new DrawCardAction(1));
    }

    @Override
    public void upp() {
        upgradeMagicNumber(2);
        upgradeSecondMagic(1);
    }
}