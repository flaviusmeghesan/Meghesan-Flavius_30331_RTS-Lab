import Interfaces.PlaceHandlerTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Supervizor extends Thread{
    boolean stop = false;
    public Controller c;
    PlaceHandler PH = new PlaceHandler();
    Supervisor_Transistion_ts_2 ts_2;
    Supervisor_Transistion_ts_3 ts_3;

    Supervisor_Transistion_ts_1 ts_1;
    Scanner in = new Scanner(System.in);


    public void run() {
        List<Rel> list = new ArrayList<>();
        list.add(new Rel(1,2,3));
        list.add(new Rel(4,3,6));
        list.add(new Rel(1,1,2));

        PH.AddPlace(new RelPlace("ps_i1",new Rel(1,4,6)));
        PH.AddPlace(new ListPlace("ps_1",list));
        PH.AddPlace(new IntPlace("ps_2", 0));
        PH.AddPlace(new IntPlace("ps_3", 0));
        PH.AddPlace(new IntPlace("ps_o2", null));
        PH.AddPlace(new IntPlace("ps_i2", null));
        ts_1=new Supervisor_Transistion_ts_1("ts_1",PH,0);
        ts_3 = new Supervisor_Transistion_ts_3("ts_3", PH, 0);
        ts_2 = new Supervisor_Transistion_ts_2("ts_2", PH, 0);
        ts_2.ControllerPH=c.PH;
        while (!stop) {

            ts_1.TransitionGuardsMappings();
            ts_2.TransitionGuardsMappings();
            ts_3.TransitionGuardsMappings();

            // For slower printing on the console
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    public void StopThread() {
        this.stop = true;
    }

}

