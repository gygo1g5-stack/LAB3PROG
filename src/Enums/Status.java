package Enums;

public enum Status {
    THINKING(" думает, "),
    SEEING(" осматривает, "),
    WALKING(" гуляет, "),
    SITING(" сидит,"),
    POKING(" тыкает, "),
    NOTHING(" ничего не делает,"),
    MOVING(" перемещается, "),
    WORKING(" работает, "),
    RELAX(" отдохнул "),
    CUT(" cтрижёт "),
    FEELGOOD(" чувствует доброту "),
    FEELSAD(" чувствует растроенность "),
    FEELPITY(" чуствутет жалость "),
    FEELJEALOUS(" чувствует зависть "),
    VIEWFEATURES(" осматривает персонажа ");
    
    
    Status(String s){
        description=s;
    }
    private String description;
    public String getDescription() {
        return description;
    }
}

