package OETPN;



import java.util.ArrayList;

import Components.Activation;
import Components.Condition;
import Components.GuardMapping;
import Components.PetriNet;
import Components.PetriNetWindow;
import Components.PetriTransition;
import DataObjects.DataFloat;
import DataObjects.DataSubPetriNet;
import DataOnly.SubPetri;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

public class Supervisor {

    public static void main(String[] args) {
        PetriNet pn = new PetriNet();
        pn.PetriNetName = "Main Petri";
        pn.NetworkPort = 1080;

        DataFloat ps_i1 = new DataFloat();
        ps_i1.SetName("ps_i1");
        pn.PlaceList.add(ps_i1);

        DataFloat ps_1 = new DataFloat();
        ps_1.SetName("ps_1");
        ps_1.SetValue(1.0f);
        pn.PlaceList.add(ps_1);

        DataFloat ps_o1 = new DataFloat();
        ps_o1.SetName("ps_o1");
        pn.PlaceList.add(ps_o1);

        DataFloat ps_2 = new DataFloat();
        ps_2.SetName("ps_2");
        ps_2.SetValue(1.0f);
        pn.PlaceList.add(ps_2);

        DataFloat ps_3 = new DataFloat();
        ps_3.SetName("ps_3");
        ps_3.SetValue(1.0f);
        pn.PlaceList.add(ps_3);

        DataFloat ps_o2 = new DataFloat();
        ps_o2.SetName("ps_o2");
        pn.PlaceList.add(ps_o2);

        DataFloat ps_i2 = new DataFloat();
        ps_i2.SetName("ps_i2");
        pn.PlaceList.add(ps_i2);

        // Ts1 ------------------------------------------------
        PetriTransition ts1 = new PetriTransition(pn);
        ts1.TransitionName = "ts1";
        ts1.InputPlaceName.add("ps_1");
        ts1.InputPlaceName.add("ps_i1");

        Condition Ts1Ct1 = new Condition(ts1, "ps_1", TransitionCondition.NotNull);
        Condition Ts1Ct2 = new Condition(ts1, "ps_i1", TransitionCondition.NotNull);
        Ts1Ct1.SetNextCondition(LogicConnector.AND, Ts1Ct2);

        GuardMapping grdTs1 = new GuardMapping();
        grdTs1.condition = Ts1Ct1;
        grdTs1.Activations.add(new Activation(ts1, "ps_1", TransitionOperation.Move, "ps_1"));
        grdTs1.Activations.add(new Activation(ts1, "ps_i1", TransitionOperation.Move, "ps_1"));


        ts1.GuardMappingList.add(grdTs1);
        ts1.Delay = 0;
        pn.Transitions.add(ts1);

        // Ts_2 ------------------------------------------------
        PetriTransition ts_2 = new PetriTransition(pn);
        ts_2.TransitionName = "ts_2";
        ts_2.InputPlaceName.add("ps_1");
        ts_2.InputPlaceName.add("ps_2");
        ts_2.InputPlaceName.add("ps_3");

        Condition Ts_2Ct1 = new Condition(ts_2, "ps_1", TransitionCondition.NotNull);
        Condition Ts_2Ct2 = new Condition(ts_2, "ps_2", TransitionCondition.NotNull);
        Condition Ts_2Ct3 = new Condition(ts_2, "ps_3", TransitionCondition.NotNull);
        Ts_2Ct1.SetNextCondition(LogicConnector.AND, Ts_2Ct2);
        Ts_2Ct1.SetNextCondition(LogicConnector.AND, Ts_2Ct3);


        GuardMapping grdTs_2 = new GuardMapping();
        grdTs_2.condition = Ts_2Ct1;
        grdTs_2.Activations.add(new Activation(ts1, "ps_1", TransitionOperation.Move, "ps_1"));
        grdTs_2.Activations.add(new Activation(ts1, "ps_3", TransitionOperation.Move, "ps_3"));
        grdTs_2.Activations.add(new Activation(ts1, "ps_2", TransitionOperation.Move, "ps_o1"));


        ts_2.GuardMappingList.add(grdTs_2);
        ts_2.Delay = 0;
        pn.Transitions.add(ts_2);


        // Ts_3 ------------------------------------------------
        PetriTransition ts_3 = new PetriTransition(pn);
        ts_3.TransitionName = "ts_3";
        ts_3.InputPlaceName.add("ps_i2");

        Condition Ts_3Ct1 = new Condition(ts_3, "ps_i2", TransitionCondition.NotNull);

        GuardMapping grdTs_3 = new GuardMapping();
        grdTs_3.condition = Ts_3Ct1;

        grdTs_3.Activations.add(new Activation(ts_3,"ps_i2", TransitionOperation.Move, "ps_o2"));
        grdTs_3.Activations.add(new Activation(ts_3,"ps_i2", TransitionOperation.Move, "ps_2"));

        ts_3.GuardMappingList.add(grdTs_3);
        ts_3.Delay = 0;
        pn.Transitions.add(ts_3);




        System.out.println("Supervisor started \n ------------------------------");
        pn.Delay = 3000;

        PetriNetWindow frame = new PetriNetWindow(false);
        frame.petriNet = pn;
        frame.setVisible(true);
    }
}
