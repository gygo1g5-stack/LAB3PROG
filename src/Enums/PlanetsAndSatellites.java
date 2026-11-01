package Enums;
public enum PlanetsAndSatellites{
    
    Earth ("Земле",9.8),
    Moon ("Луне",1.6);
    
    private String title;
    private double gravity;
    
    PlanetsAndSatellites(String title,double gravity){
        this.title=title;
        this.gravity=gravity;
        

    }
    public double getGravity() {
        return gravity;
    }
    public String getTitle() {
        return title;
    }
}