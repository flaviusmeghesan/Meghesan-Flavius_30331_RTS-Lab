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
import PetriDataPackage.Guard;

import javax.xml.crypto.Data;


public class Q1 {
    public static void main(String[] args) {

        // ----------------------- main petri ------------------------------------

        PetriNet pn = new PetriNet();
        pn.PetriNetName = "Main Petri";
        pn.NetworkPort = 1080;

        // ----------------------- sub petris ------------------------------------
        PetriNet spn1 = new PetriNet();
        spn1.PetriNetName = "Sub Petri1";

        PetriNet spn2 = new PetriNet();
        spn2.PetriNetName = "Sub Petri2";

        DataSubPetriNet subPetriNet1 = new DataSubPetriNet();
        subPetriNet1.SetName("SubPetri1");
        SubPetri sptr1= new SubPetri(spn1);
        subPetriNet1.SetValue(sptr1);
        pn.ConstantPlaceList.add(subPetriNet1);

        DataSubPetriNet subPetriNet2 = new DataSubPetriNet();
        subPetriNet2.SetName("SubPetri2");
        SubPetri sptr2= new SubPetri(spn2);
        subPetriNet2.SetValue(sptr2);
        spn1.ConstantPlaceList.add(subPetriNet2);

        DataFloat subConstantValue1 = new DataFloat();
        subConstantValue1.SetName("subConstantValue1");
        subConstantValue1.SetValue(0.01f);
        spn1.ConstantPlaceList.add(subConstantValue1);

        DataFloat subConstantValue2 = new DataFloat();
        subConstantValue1.SetName("subConstantValue2");
        subConstantValue1.SetValue(0.0001f);
        spn2.ConstantPlaceList.add(subConstantValue2);




        // ----------------------- sub petri 2 ------------------------------------

        DataFloat p21 = new DataFloat();
        p21.SetName("p21");
        spn2.PlaceList.add(p21);

        DataFloat p22 = new DataFloat();
        p22.SetName("p22");
        spn2.PlaceList.add(p22);

        DataFloat p23 = new DataFloat();
        p23.SetName("p23");
        spn2.PlaceList.add(p23);

        // T21 ------------------------------------------------

        PetriTransition t21 = new PetriTransition(spn2);
        t21.TransitionName = "t21";
        t21.InputPlaceName.add("p21");


        Condition T21Ct1 = new Condition(t21, "p21", TransitionCondition.NotNull);
        Condition T21Ct2 = new Condition(t21, "p21",TransitionCondition.LessThanOrEqual, "constantValue1");
        T21Ct1.SetNextCondition(LogicConnector.AND, T21Ct2);


        GuardMapping grdT21 = new GuardMapping();
        grdT21.condition = T21Ct1;
        grdT21.Activations.add(new Activation(t21, "p21", TransitionOperation.Move, "p22"));
        t21.GuardMappingList.add(grdT21);
        t21.Delay = 4;
        spn2.Transitions.add(t21);

        // T22 ------------------------------------------------

        PetriTransition t22 = new PetriTransition(spn2);
        t22.TransitionName = "t22";
        t22.InputPlaceName.add("p22");

        Condition T22Ct1 = new Condition(t22, "p22", TransitionCondition.NotNull);

        GuardMapping grdT22 = new GuardMapping();
        grdT22.condition = T22Ct1;
        grdT22.Activations.add(new Activation(t22, "p22", TransitionOperation.Add, "p23"));
        t22.GuardMappingList.add(grdT22);
        t22.Delay = 0;
        spn2.Transitions.add(t22);


        // T23 ------------------------------------------------
        PetriTransition t23 = new PetriTransition(spn1);
        t23.TransitionName = "t23";
        t23.InputPlaceName.add("p22");

        Condition T23Ct1 = new Condition(t23, "p22", TransitionCondition.NotNull);
        Condition T23Ct2 = new Condition(t23, "p22", TransitionCondition.LessThan, "subConstantValue2");
        T23Ct1.SetNextCondition(LogicConnector.AND, T23Ct2);

        GuardMapping grdT23 = new GuardMapping();
        grdT23.condition = T23Ct1;
        grdT23.Activations.add(new Activation(t23, "p22", TransitionOperation.StopPetriNet, ""));

        t23.GuardMappingList.add(grdT23);
        t23.Delay = 0;
        spn1.Transitions.add(t23);

        // T24 ------------------------------------------------

        PetriTransition t24 = new PetriTransition(spn2);
        t24.TransitionName = "t24";
        t24.InputPlaceName.add("p23");

        Condition T24Ct1 = new Condition(t24, "p23", TransitionCondition.NotNull);
        GuardMapping grdT24 = new GuardMapping();
        grdT24.condition = T24Ct1;
        grdT24.Activations.add(new Activation(t24, "p23", TransitionOperation.Move, "p21"));
        t24.GuardMappingList.add(grdT24);
        t24.Delay = 0;
        spn2.Transitions.add(t24);


        // ----------------------- sub petri 2 ------------------------------------

        DataFloat p11 = new DataFloat();
        p11.SetName("p11");
        spn1.PlaceList.add(p11);


        DataFloat p12 = new DataFloat();
        p12.SetName("p12");
        spn1.PlaceList.add(p12);

        DataFloat p13 = new DataFloat();
        p13.SetName("p13");
        spn1.PlaceList.add(p13);


        // T11 ------------------------------------------------
        PetriTransition t11 = new PetriTransition(spn1);
        t11.TransitionName = "t11";
        t11.InputPlaceName.add("p11");

        Condition T11Ct1 = new Condition(t11, "p11", TransitionCondition.NotNull);

        GuardMapping grdT11 = new GuardMapping();
        grdT11.condition = T11Ct1;
        grdT11.Activations.add(new Activation(t11, "SubPetri2", TransitionOperation.Move, "p12"));
        grdT11.Activations.add(new Activation(t11, "p11", TransitionOperation.Move, "p12-p21"));
        grdT11.Activations.add(new Activation(t11, "p12", TransitionOperation.ActivateSubPetri, ""));

        t11.GuardMappingList.add(grdT11);

        Condition T11Ct3 = new Condition(t11, "p11", TransitionCondition.NotNull);

        GuardMapping grd2T11 = new GuardMapping();
        grd2T11.condition = T11Ct3;
        grd2T11.Activations.add(new Activation(t11, "SubPetri", TransitionOperation.Copy, "p12"));
        grd2T11.Activations.add(new Activation(t11, "p11", TransitionOperation.Move, "p12-p21"));

        t11.GuardMappingList.add(grd2T11);

        t11.Delay = 0;
        spn1.Transitions.add(t11);

        // T12 ------------------------------------------------

        PetriTransition t12 = new PetriTransition(spn1);
        t12.TransitionName = "t12";
        t12.InputPlaceName.add("p12");


        Condition T12Ct1 = new Condition(t12, "p12", TransitionCondition.NotNull);
        GuardMapping grdT12 = new GuardMapping();
        grdT12.condition = T12Ct1;
        grdT12.Activations.add(new Activation(t12, "p12", TransitionOperation.Move, "p13"));
        t12.GuardMappingList.add(grdT12);
        t12.Delay = 0;
        spn1.Transitions.add(t12);

        // T14 ------------------------------------------------

        PetriTransition t14 = new PetriTransition(spn1);
        t14.TransitionName = "t14";
        t14.InputPlaceName.add("p13");

        Condition T14Ct1 = new Condition(t14, "p13", TransitionCondition.NotNull);
        GuardMapping grdT14 = new GuardMapping();
        grdT14.condition = T14Ct1;
        grdT14.Activations.add(new Activation(t14, "p13", TransitionOperation.StopPetriNet, ""));
        t14.GuardMappingList.add(grdT14);
        t14.Delay = 0;
        spn1.Transitions.add(t14);


        // ----------------------- main petri ------------------------------------

        DataFloat p0 = new DataFloat();
        p0.SetName("p0");
        p0.SetValue(1.0f);
        pn.PlaceList.add(p0);

        DataFloat p3 = new DataFloat();
        p3.SetName("p3");
        pn.PlaceList.add(p3);

        DataFloat p1 = new DataFloat();
        p1.SetName("p1");
        pn.PlaceList.add(p1);

        DataFloat p2 = new DataFloat();
        p2.SetName("p2");
        pn.PlaceList.add(p2);


        // T0 ------------------------------------------------
        PetriTransition t0 = new PetriTransition(pn);
        t0.TransitionName = "t0";
        t0.InputPlaceName.add("p0");
        t0.InputPlaceName.add("p3");

        Condition T0Ct1 = new Condition(t0, "p0", TransitionCondition.NotNull);
        Condition T0Ct2 = new Condition(t0, "p4", TransitionCondition.NotNull);
        T0Ct1.SetNextCondition(LogicConnector.AND, T0Ct2);

        GuardMapping grdT0 = new GuardMapping();
        grdT0.condition = T0Ct1;
        grdT0.Activations.add(new Activation(t0, "SubPetri1", TransitionOperation.Move, "p1"));
        grdT0.Activations.add(new Activation(t0, "p3", TransitionOperation.Move, "p1-p11"));
        grdT0.Activations.add(new Activation(t0, "p1", TransitionOperation.ActivateSubPetri, ""));

        t0.GuardMappingList.add(grdT0);

        Condition T0Ct3 = new Condition(t0, "p0", TransitionCondition.NotNull);
        Condition T0Ct4 = new Condition(t0, "p3", TransitionCondition.NotNull);
        T0Ct3.SetNextCondition(LogicConnector.AND, T0Ct4);

        GuardMapping grd2T0 = new GuardMapping();
        grd2T0.condition = T0Ct3;
        grd2T0.Activations.add(new Activation(t0, "SubPetri1", TransitionOperation.Copy, "p1"));
        grd2T0.Activations.add(new Activation(t0, "p4", TransitionOperation.Move, "p1-p11"));

        t0.GuardMappingList.add(grd2T0);

        t0.Delay = 0;
        pn.Transitions.add(t0);

        // T1 ------------------------------------------------

        PetriTransition t1 = new PetriTransition(pn);
        t1.TransitionName = "t1";
        t1.InputPlaceName.add("p1");

        Condition T1Ct1 = new Condition(t1, "p1", TransitionCondition.NotNull);
        GuardMapping grdT1 = new GuardMapping();
        grdT1.condition = T1Ct1;
        grdT1.Activations.add(new Activation(t1, "p1", TransitionOperation.Move, "p2"));
        t1.GuardMappingList.add(grdT1);
        t1.Delay = 0;
        pn.Transitions.add(t1);

        // T2 ------------------------------------------------

        PetriTransition t2 = new PetriTransition(pn);
        t2.TransitionName = "t2";
        t2.InputPlaceName.add("p2");

        Condition T2Ct1 = new Condition(t2, "p2", TransitionCondition.NotNull);
        GuardMapping grdT2 = new GuardMapping();
        grdT2.condition = T2Ct1;
        grdT2.Activations.add(new Activation(t2, "p1", TransitionOperation.Move, "p0"));
        t2.GuardMappingList.add(grdT2);
        t2.Delay = 2;
        pn.Transitions.add(t2);


        System.out.println("Execution started \n ------------------------------");
        pn.Delay = 2000;

        PetriNetWindow frame = new PetriNetWindow(false);
        frame.petriNet = pn;
        frame.setVisible(true);

    }
}
