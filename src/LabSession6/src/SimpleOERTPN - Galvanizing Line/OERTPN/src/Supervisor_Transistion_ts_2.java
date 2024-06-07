import Interfaces.PlaceHandlerTemplate;
import Interfaces.TransitionTemplate;

import java.util.List;

public class Supervisor_Transistion_ts_2 implements TransitionTemplate {

    Integer timeUnitControl = 500;
    Integer eet;
    Integer let;
    String Name;
    PlaceHandlerTemplate PH;
    PlaceHandlerTemplate ControllerPH ;

    public Supervisor_Transistion_ts_2( String name, PlaceHandlerTemplate PH,Integer delay) {
        this.Init(name, PH);
        this.SetDelay(delay);
     }

    public Supervisor_Transistion_ts_2( String name, PlaceHandlerTemplate PH,Integer eet, Integer let) {
        this.Init(name, PH);
        this.SetDelayInRange(eet, let);
    }

    @Override
    public void Init(String Name, PlaceHandlerTemplate PH) {
        this.PH = PH;
        this.Name = Name;
    }

    public void Init(String Name, PlaceHandlerTemplate PH, Integer delay) {
        this.Init(Name, PH);
        this.SetDelay(delay);
    }

    @Override
    public void SetDelay(int value) {
        this.eet=value;
    }

    @Override
    public void SetDelayInRange(int eet, int let) {
        this.eet = eet;
        this.let = let;
    }

    @Override
    public void TransitionDelay() {
        try {
            if (this.let == null) {
                Thread.sleep(this.eet * timeUnitControl);
            } else {
                Thread.sleep(Math.round(Math.random() * (this.let - this.eet) + this.eet) * timeUnitControl);
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public Boolean TransitionGuardsMappings() {
        TransitionDelay();
        String toPrint="--------------Supervisor--------------\n";
        List<Rel> list= (List<Rel>) PH.GetPlaceByName("ps_1").Get();
        Integer r = null;
        try {
            if (list.size() > 0) r = list.get(list.size() - 1).r;
            else PH.GetPlaceByName("ps_1").Set(null);
        }
        catch (NullPointerException e){
        }
        if (!PH.GetPlaceByName("ps_1").IsNull() && !PH.GetPlaceByName("ps_2").IsNull() && r!=PH.GetPlaceByName("ps_2").Get()) {
            toPrint = toPrint.concat(Print() + "\n");
            this.SetDelay(list.get(list.size() - 1).e);
            PH.GetPlaceByName("ps_3").Set(list.get(list.size() - 1).e);
            list.remove(list.get(list.size() - 1));
            PH.GetPlaceByName("ps_1").Set(list);
            ControllerPH.GetPlaceByName("p_i1").Set(r);
            


            toPrint = toPrint.concat(Print() + "\n");
            toPrint = toPrint.concat("--------------------------------------\n");

            System.out.println(toPrint);
            return true;
        }

        return false;
    }

    @Override
    public String Print() {
            return this.Name + "\n" + this.PH.PrintAllPlaces();
    }
}
