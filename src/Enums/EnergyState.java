package Enums;
public enum EnergyState{
    SAVING(30," не достаточно для действия " ),
    MIDDLE(65," немного не хватает для действия "),
    READY(100," готов к действию");
    private int energy;
    private String stat;
    EnergyState(int energy,String stat){
        this.energy=energy;
        this.stat=stat;
    }
    public int getEnergy() {
        return energy;
    }
    public String printDescription(){
        return this.stat;
    }
}