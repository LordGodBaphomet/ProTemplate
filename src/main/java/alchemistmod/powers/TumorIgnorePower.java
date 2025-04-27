package alchemistmod.powers;

import com.badlogic.gdx.graphics.Color;
import com.evacipated.cardcrawl.mod.stslib.powers.interfaces.HealthBarRenderPower;
import com.megacrit.cardcrawl.core.AbstractCreature;

import static alchemistmod.ModFile.makeID;

public class TumorIgnorePower extends AbstractEasyPower {
    public static final String NAME = "TumorIgnore"; //TODO: change this
    public static final String POWER_ID = makeID("TumorIgnorePower");
    public static final PowerType POWER_TYPE = PowerType.BUFF;
    public static final boolean IS_TURN_BASED = false;

    public TumorIgnorePower(AbstractCreature owner, int amount) {
        super(POWER_ID, NAME, POWER_TYPE, IS_TURN_BASED, owner, amount);
    }

    @Override
    public void updateDescription() {
        if (this.amount == 1) {
            this.description = DESCRIPTIONS[0];
        } else {
            this.description = DESCRIPTIONS[1] + amount + DESCRIPTIONS[2];
        }
    }
}
