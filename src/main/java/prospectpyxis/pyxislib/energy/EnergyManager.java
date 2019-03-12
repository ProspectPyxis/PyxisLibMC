package prospectpyxis.pyxislib.energy;

import net.minecraftforge.energy.EnergyStorage;

public class EnergyManager extends EnergyStorage {

    public EnergyManager(int capacity, int maxTransfer) {
        super(capacity, maxTransfer);
    }

    public EnergyManager(int capacity, int maxInput, int maxOutput) {
        super(capacity, maxInput, maxOutput);
    }

    public void setEnergy(int value) {
        energy = Math.min(capacity, value);
    }
}
