package alchemistmod.powers;

import com.megacrit.cardcrawl.core.AbstractCreature;

import static alchemistmod.ModFile.makeID;

public class VitalityPower extends AbstractEasyPower{
    public static final String NAME = "Vitality";
    public static final String POWER_ID = makeID("VitalityPower");
    public static final PowerType POWER_TYPE = PowerType.BUFF;
    public static final boolean IS_TURN_BASED = false;

    public VitalityPower(d, AbstractCreature owner, int amount) {
        super(ID, NAME, powerType, isTurnBased, owner, amount);
    }
}
