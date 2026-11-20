package Record;
import Exceptions.*;
public record Item(String name, int lengthInCm)  {
    public Item {
        if (name==null || name.isEmpty()){
            throw new NameException();
        }
    }
}