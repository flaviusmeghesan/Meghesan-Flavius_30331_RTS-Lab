import Interfaces.PlaceHandlerTemplate;
import Interfaces.TransitionTemplate;

import java.util.ArrayList;
import java.util.List;

public class Supervisor_Transistion_ts_1 implements TransitionTemplate {

    Integer timeUnitControl = 500;
    Integer eet;
    Integer let;
    String name;
    PlaceHandlerTemplate PH;

    public Supervisor_Transistion_ts_1(String name, PlaceHandlerTemplate PH,Integer delay) {
        this.Init(name, PH);
        this.SetDelay(delay);
    }

    public Supervisor_Transistion_ts_1(String name, PlaceHandlerTemplate PH, Integer eet, Integer let) {
        this.Init(name, PH);
        this.SetDelayInRange(eet, let);
    }

    @Override
    public void Init(String Name, PlaceHandlerTemplate PH) {
        this.PH = PH;
        this.name = Name;
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

        if (!PH.GetPlaceByName("ps_i1").IsNull() ) {
            toPrint = toPrint.concat(Print() + "\n");


            List<Rel> list = new ArrayList<>();
            list= (List<Rel>) PH.GetPlaceByName("ps_1").Get();

            list.add((Rel) PH.GetPlaceByName("ps_i1").Get());

            PH.GetPlaceByName("ps_1").Set(list);
            PH.GetPlaceByName("ps_i1").Set(null );

            toPrint = toPrint.concat(Print() + "\n");
            toPrint = toPrint.concat("--------------------------------------\n");

            System.out.println(toPrint);
            return true;
        }

        return false;
    }

    @Override
    public String Print() {
        return this.name + "\n" + this.PH.PrintAllPlaces();
    }
}
