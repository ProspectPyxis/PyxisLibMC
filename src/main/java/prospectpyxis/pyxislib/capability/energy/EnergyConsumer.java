package prospectpyxis.pyxislib.capability.energy;

public class EnergyConsumer extends EnergyManager {

    public EnergyConsumer(int capacity, int maxTransfer) {
        super(capacity, maxTransfer == -1 ? capacity : maxTransfer);
    }

    @Override
    public boolean canExtract() {
        return false;
    }

    public int voidEnergy(int maxRemove) {
        int energyRemoved = Math.min(energy, Math.min(this.maxExtract, maxRemove));
        this.energy -= energyRemoved;
        return energyRemoved;
    }
}
