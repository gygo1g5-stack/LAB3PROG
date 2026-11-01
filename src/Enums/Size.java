package Enums;
public enum Size{
    SMALL(10),
    MEDIUM(40),
    LARGE(70);
    private int sizeInSm;
    Size(int sizeInSm){
        this.sizeInSm=sizeInSm;
    }
    public int getSizeInSm() {
        return sizeInSm;
    }
}