package prospectpyxis.pyxislib.energy;

public class EnergyGenerator extends EnergyManager {

    public EnergyGenerator(int capacity, int maxTransfer) {
        super(capacity, maxTransfer);
    }

    @Override
    public boolean canReceive() {
        return false;
    }

    public int generateEnergy(int maxReceive) {
        int energyReceived = Math.min(capacity - energy, Math.min(this.maxReceive, maxReceive));
        energy += energyReceived;
        return energyReceived;
    }
}
