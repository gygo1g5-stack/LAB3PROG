package Enums;

public enum PersonFeatures {
    PINKBALDSPOT("розовая лысина, "),
    REDCHEEKS("красные щёчки, "),
    NARROWEYES("узкие глазки, "),
    FUNNYFACE("весёлое выражение лица"),
    NOTHING("нет особых деталей ");
    private String description;
    PersonFeatures(String description){
        this.description=description;
    }
    public String getDescription() {
        return description;
    }
}
