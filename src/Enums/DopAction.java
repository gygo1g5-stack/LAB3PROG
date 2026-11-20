package Enums;

public enum DopAction {
    COMPARESIZEFLOWERS(" сравнивает размеры цветов "),
    UNDERSTANDSPLACE(" понимает, что находится на "),
    UPHILL(" поднялся на холм "),
    HABITUATION(" привык ");
    
    

    
    DopAction(String s){
        description=s;
    }
    private String description;
    public String getDescription() {
        return description;
    }
}
