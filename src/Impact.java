
import Classes.*;
import Enums.*;
public interface Impact {
    void aply (Person pers1,Person pers2);
}
class GoodImpact implements Impact{
    @Override public void aply (Person pers1,Person pers2){
        if (pers2.getMainState()==EnergyState.SAVING){
            System.out.println(pers2.getName()+" выглядит устало, " + pers1.getName()+" испытывает жалость к нему");
            pers1.setStatus(Status.FEELPITY);
        } else {
            System.out.println(pers2.getName()+" выглядит бодрым и добрым, " + pers1.getName()+" проникается теплотой");
            pers1.setStatus(Status.FEELGOOD);
        }
    }
}
class BadImpact implements Impact{
    @Override public void aply (Person pers1,Person pers2){
        if (pers2.getMainState()==EnergyState.SAVING){
            System.out.println(pers2.getName()+" выглядит устало, но " + pers1.getName()+" ничего не чувствует");
            pers1.setStatus(Status.NOTHING);
        } else {
            System.out.println(pers2.getName()+" выглядит бодрым," + pers1.getName()+" чувствует зависть");
            pers1.setStatus(Status.FEELJEALOUS);
        }
    }
}