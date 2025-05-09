package alchemistmod.relics;

import alchemistmod.CharacterFile;

import static alchemistmod.ModFile.makeID;

public class TodoItem extends AbstractEasyRelic {
    public static final String ID = makeID("TodoItem");

    public TodoItem() {
        super(ID, RelicTier.STARTER, LandingSound.FLAT, CharacterFile.Enums.ALCHEMIST_COLOR);
    }
}
