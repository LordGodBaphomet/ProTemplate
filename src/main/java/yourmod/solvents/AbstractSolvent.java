package yourmod.solvents;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;

import static yourmod.ModFile.makeImagePath;
import static yourmod.ModFile.modID;
import static yourmod.util.Wiz.*;

public abstract class AbstractSolvent {
    protected int amount;
    public String name;
    public String description;
    public String ID;
    public Boolean doesInject;


    public AbstractSolvent(String ID, String name, String description, int amount, Boolean doesInject) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.doesInject = doesInject;
        this.amount = amount;
    }

    public AbstractSolvent(String ID, String name, String description, int amount) {
        this(ID, name, description, amount, true);
    }

    public AbstractSolvent(String ID, String name, String description) {
        this(ID, name, description, 1);
    }

    public abstract void InjectEffect(AbstractPlayer p, AbstractCreature target);
}
