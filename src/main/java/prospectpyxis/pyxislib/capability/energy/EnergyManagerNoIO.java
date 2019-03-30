package prospectpyxis.pyxislib.capability.energy;

public class EnergyManagerNoIO extends EnergyManager {

    public EnergyManagerNoIO(int capacity) {
        super(capacity, 0);
    }

    @Override
    public boolean canExtract() {
        return false;
    }

    @Override
    public boolean canReceive() {
        return false;
    }
}
