package Enums;
public enum EnergyState{
    SAVING(30),
    MIDDLE(65),
    READY(100);
    private int energy;
    EnergyState(int energy){
        this.energy=energy;
    }
    public int getEnergy() {
        return energy;
    }
}