package prospectpyxis.pyxislib.capability.energy;

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

    public void setCapacity(int value) {
        capacity = Math.max(0, value);
    }

    public void setMaxInput(int value) {
        maxReceive = Math.max(0, value);
    }

    public void setMaxOutput(int value) {
        maxExtract = Math.max(0, value);
    }
}
