/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pseudocell.core.nodes;

import java.util.ArrayList;
import java.util.List;
import org.pseudocell.core.rules.RuleFactory;

/**
 *
 * @author ViníciusPierdoná
 */
public class DefaultNodesBuilder {

    NodeFactory nodeFactory = new NodeFactory();
    RuleFactory ruleFactory = new RuleFactory();

    public List<Node> createDefaultNodes() {

        List<Node> defaultNodes = new ArrayList<>();

        //// Creates the default nodes and populates them with the respective logic rules
        // AADeprivation
        Node AADeprivation = nodeFactory.createGeneralNode("AADeprivation");
        
        defaultNodes.add(AADeprivation);
        // ABL1
        Node ABL1 = nodeFactory.createNode("ABL1");
        ABL1.getRules().add(ruleFactory.createRule("Node:DOK1# >= 1 | Node:DSB# >= 1", 1.0));
        defaultNodes.add(ABL1);
        // AFAP1
        Node AFAP1 = nodeFactory.createNode("AFAP1");
        AFAP1.getRules().add(ruleFactory.createRule("Node:SRC# >= 1", 1.0));
        defaultNodes.add(AFAP1);
        // AKT1
        Node AKT1 = nodeFactory.createNode("AKT1");
        AKT1.getRules().add(ruleFactory.createRule("(Node:RNF168# >= 1 | Node:mTORC2# >= 1 | "
                + "Node:PI34P# >= 0.5 | Node:PI345P# >= 0.5 | Node:ATM# >= 1 |"
                + "Node:ATR# >= 1 | (Node:IFNGR# >= 1 & Node:JAK2# >= 1)) & Node:PTEN# == 0 &"
                + "Node:PKN2_F# == 0 & (Node:PP2A# == 0 | (Node:PP2A# >= 1 & Mod:PP2A#PPP2R2; == 0.0) |"
                + "Node:HSP90AA1# >= 1)", 1.0));
        defaultNodes.add(AKT1);
        // AMPK
        Node AMPK = nodeFactory.createNode("AMPK");
        AMPK.getRules().add(ruleFactory.createRule("Node:ATM# >= 1 | Node:STK11# >= 1 | "
                + "Node:SESN1# >= 1 | Node:SESN2# >= 1", 1.0));
        defaultNodes.add(AMPK);
        // ANP32A
        Node ANP32A = nodeFactory.createNode("ANP32A");
        defaultNodes.add(ANP32A);
        // APAF1
        Node APAF1 = nodeFactory.createNode("APAF1");
        APAF1.getRules().add(ruleFactory.createRule("Node:CytochromeCRelease# >= 1", 1.0));
        defaultNodes.add(APAF1);
        // ARAP1
        Node ARAP1 = nodeFactory.createNode("ARAP1");
        ARAP1.getRules().add(ruleFactory.createRule("Node:SH3KBP1# >= 1 | Node:PI345P# >= 0.5", 1.0));
        defaultNodes.add(ARAP1);
        // ARF1
        Node ARF1 = nodeFactory.createNode("ARF1");

        defaultNodes.add(ARF1);
        // ARF5
        Node ARF5 = nodeFactory.createNode("ARF5");

        defaultNodes.add(ARF5);
        // ARFGEF1
        Node ARFGEF1 = nodeFactory.createNode("ARFGEF1");
        defaultNodes.add(ARFGEF1);
        // ARP2_3
        Node ARP2_3 = nodeFactory.createNode("ARP2_3");
        ARP2_3.getRules().add(ruleFactory.createRule("Node:WAS# >= 1 | Node:WASF1# >= 1", 1.0));
        defaultNodes.add(ARP2_3);
        // ASAP1
        Node ASAP1 = nodeFactory.createNode("ASAP1");
        ASAP1.getRules().add(ruleFactory.createRule("(Node:CRK# >= 1 | Node:SRC# >= 1 | Node:CBL# >= 1 | "
                + "Node:SH3KBP1# >= 1) & Node:PI45P# >= 0.5", 1.0));
        defaultNodes.add(ASAP1);
        // ASAP2
        Node ASAP2 = nodeFactory.createNode("ASAP2");
        ASAP2.getRules().add(ruleFactory.createRule("Node:SH3KBP1# >= 1 & Node:CBL# == 0", 1.0));
        defaultNodes.add(ASAP2);
        // ATF2
        Node ATF2 = nodeFactory.createNode("ATF2");
        ATF2.getRules().add(ruleFactory.createRule("Node:MAPK14# >= 1 | Node:JNK1# >= 1 | Node:JNK2# >= 1 | "
                + "Node:JNK3# >= 1 | Node:ERK1# >= 1 | Node:ERK2# >= 1", 1.0));
        defaultNodes.add(ATF2);
        // ATG1
        Node ATG1 = nodeFactory.createNode("ATG1");
        ATG1.getRules().add(ruleFactory.createRule("(Node:AMPK# >= 1 | (Node:PP2A# >= 1 & Mod:PP2A#PPP2R2; == 1.0)) & "
                + "Node:mTORC1# == 0", 1.0));
        defaultNodes.add(ATG1);
        // ATM
        Node ATM = nodeFactory.createNode("ATM");
        ATM.getRules().add(ruleFactory.createRule("((Node:MRN# >= 1 | (Node:FOXO3# >= 1 & Node:KAT5# >= 1 & "
                + "Node:NOTCH1# == 0)) & Node:E2F1# >= 1) & Node:PPM1D# == 0", 2.0));
        ATM.getRules().add(ruleFactory.createRule("(Node:MRN# >= 1 | (Node:FOXO3# >= 1 & Node:KAT5# >= 1 & "
                + "Node:NOTCH1# == 0)) & Node:PPM1D# == 0", 1.0));
        defaultNodes.add(ATM);
        // ATP2A1
        Node ATP2A1 = nodeFactory.createNode("ATP2A1");
        ATP2A1.getRules().add(ruleFactory.createRule("Node:PLN# == 0 & Node:SLN# == 0", 1.0));
        defaultNodes.add(ATP2A1);
        // ATP2A2
        Node ATP2A2 = nodeFactory.createNode("ATP2A2");
        ATP2A2.getRules().add(ruleFactory.createRule("Node:S100A1# >= 1 & (Node:PLN# == 0 & Node:SLN# == 0 & "
                + "Node:CALR# == 0 & Node:IRS1# == 0)", 1.0));
        defaultNodes.add(ATP2A2);
        // ATP2A3
        Node ATP2A3 = nodeFactory.createNode("ATP2A3");
        
        defaultNodes.add(ATP2A3);
        // ATP2B1
        Node ATP2B1 = nodeFactory.createNode("ATP2B1");
        ATP2B1.getRules().add(ruleFactory.createRule("(Node:CALM1# >= 1 | Node:CAPN1# >= 1) & (Node:PI45P# >= 0.5 | "
                + "Node:PKA# >= 1)", 2.0));
        ATP2B1.getRules().add(ruleFactory.createRule("Node:CALM1# >= 1 | Node:CAPN1# >= 1", 1.0));
        defaultNodes.add(ATP2B1);
        // ATP2B2
        Node ATP2B2 = nodeFactory.createNode("ATP2B2");
        ATP2B2.getRules().add(ruleFactory.createRule("(Node:CALM1# >= 1 | Node:CAPN1# >= 1) & Node:PI45P# >= 0.5", 2.0));
        ATP2B2.getRules().add(ruleFactory.createRule("Node:CALM1# >= 1 | Node:CAPN1# >= 1", 1.0));
        defaultNodes.add(ATP2B2);
        // ATP2B3
        Node ATP2B3 = nodeFactory.createNode("ATP2B3");
        ATP2B3.getRules().add(ruleFactory.createRule("(Node:CALM1# >= 1 | Node:CAPN1# >= 1) & Node:PI45P# >= 0.5", 2.0));
        ATP2B3.getRules().add(ruleFactory.createRule("Node:CALM1# >= 1 | Node:CAPN1# >= 1", 1.0));
        defaultNodes.add(ATP2B3);
        // ATP2B4
        Node ATP2B4 = nodeFactory.createNode("ATP2B4");
        ATP2B4.getRules().add(ruleFactory.createRule("((Node:CALM1# >= 1 | Node:CAPN1# >= 1) & Node:PI45P# >= 0.5) & "
                + "(Node:PTK2# == 0 | Node:SRC# == 0)", 2.0));
        ATP2B4.getRules().add(ruleFactory.createRule("(Node:CALM1# >= 1 | Node:CAPN1# >= 1) & (Node:PTK2# == 0 | "
                + "Node:SRC# == 0)", 1.0));
        defaultNodes.add(ATP2B4);
        // ATP2C1
        Node ATP2C1 = nodeFactory.createNode("ATP2C1");
        ATP2C1.getRules().add(ruleFactory.createRule("Node:Ca_c# >= 1", 1.0));
        defaultNodes.add(ATP2C1);
        // ATP2C2
        Node ATP2C2 = nodeFactory.createNode("ATP2C2");
        ATP2C2.getRules().add(ruleFactory.createRule("Node:Ca_c# >= 1", 1.0));
        defaultNodes.add(ATP2C2);
        // ATR
        Node ATR = nodeFactory.createNode("ATR");
        ATR.getRules().add(ruleFactory.createRule("Node:SSB# >= 1", 1.0));
        defaultNodes.add(ATR);
        // ActomyosinFibers
        Node ActomyosinFibers = nodeFactory.createGeneralNode("ActomyosinFibers");
        ActomyosinFibers.getRules().add(ruleFactory.createRule("(Node:MYLK# >= 1 | Node:ARP2_3# >= 1 | "
                + "Node:PFN1# >= 1 | Node:ROCK2# >= 1) & (Node:PPP1CB# == 0 | Node:CFL1# == 0)", 1.0));
        defaultNodes.add(ActomyosinFibers);
        // Apoptose
        Node Apoptose = nodeFactory.createGeneralNode("Apoptose");
        Apoptose.getRules().add(ruleFactory.createRule("(Node:CASP3# >= 1 | Node:CASP7# >= 1) & Node:AKT1# == 0", 1.0));
        defaultNodes.add(Apoptose);
        // ArachidonicAcid
        Node ArachidonicAcid = nodeFactory.createGeneralNode("ArachidonicAcid");
        ArachidonicAcid.getRules().add(ruleFactory.createRule("Node:PLA2G4A# >= 1 | Node:PLA2G4C# >= 1", 1.0));
        defaultNodes.add(ArachidonicAcid);
        // BAD
        Node BAD = nodeFactory.createNode("BAD");
        BAD.setRestingStatus(1.0);
        BAD.getRules().add(ruleFactory.createRule("Node:AKT1# >= 1 | Node:PIM1# >= 1 | Node:RAF1# >= 1 | "
                + "Node:ERK1# >= 1 | Node:ERK2# >= 1 | Node:PKN1# >= 1 | Node:PKA# >= 1", 0.0));
        BAD.getRules().add(ruleFactory.createRule("Node:BAD# == 0 & Node:PP2A# >= 1", 1.0));
        defaultNodes.add(BAD);
        // BAK
        Node BAK = nodeFactory.createNode("BAK");
        BAK.getRules().add(ruleFactory.createRule("(Node:BCL2# >= 1 & Node:NR4A1# >= 1) | Node:tBID# >= 1 | "
                + "Node:BIM# >= 1", 1.0));
        defaultNodes.add(BAK);
        // BAX
        Node BAX = nodeFactory.createNode("BAX");
        BAX.getRules().add(ruleFactory.createRule("((Node:TP53# >= 1 & Mod:TP53#Ser46; == 1.0) | Node:tBID# >= 1 | "
                + "Node:BIM# >= 1 | Node:AKT1# >= 1) & Node:CtBP# == 0", 1.0));
        defaultNodes.add(BAX);
        // BCAR1
        Node BCAR1 = nodeFactory.createNode("BCAR1");
        BCAR1.getRules().add(ruleFactory.createRule("Node:SRC# >= 1", 1.0));
        defaultNodes.add(BCAR1);
        // BCL2
        Node BCL2 = nodeFactory.createBCL2();
        BCL2.getRules().add(ruleFactory.createModificationRule("Node:MAPK14# >= 1", "Thr56", 1.0));
        BCL2.getRules().add(ruleFactory.createModificationRule("Node:JNK1# >= 1 | Node:JNK2# >= 1 | Node:JNK3# >= 1", "Thr69", 1.0));
        BCL2.getRules().add(ruleFactory.createModificationRule("Node:ERK1# >= 1 | Node:ERK2# >= 1 | Node:PRKCA# >= 1 | Node:JNK1# >= 1 | "
                + "Node:JNK2# >= 1 | Node:JNK3# >= 1", "Ser70", 1.0));
        BCL2.getRules().add(ruleFactory.createModificationRule("Node:JNK1# >= 1 | Node:JNK2# >= 1 | Node:JNK3# >= 1 | Node:MAPK14# >= 1", "Ser87", 1.0));
        BCL2.getRules().add(ruleFactory.createModificationRule("(Node:PP2A# >= 1 & Mod:PP2A#PPP2R5; == 1.0) | Node:TP53# >= 1", "Thr56", 0.0));
        BCL2.getRules().add(ruleFactory.createModificationRule("(Node:PP2A# >= 1 & Mod:PP2A#PPP2R5; == 1.0) | Node:TP53# >= 1", "Thr69", 0.0));
        BCL2.getRules().add(ruleFactory.createModificationRule("(Node:PP2A# >= 1 & Mod:PP2A#PPP2R5; == 1.0) | Node:TP53# >= 1", "Ser70", 0.0));
        BCL2.getRules().add(ruleFactory.createModificationRule("(Node:PP2A# >= 1 & Mod:PP2A#PPP2R5; == 1.0) | Node:TP53# >= 1", "Ser87", 0.0));

        BCL2.getRules().add(ruleFactory.createRule("Node:PUMA# >= 1 | Node:BIM# >= 1 | Node:BAD# >= 1 | Node:BMF# >= 1 | Node:TP53# >= 1", 0.0));
        defaultNodes.add(BCL2);
        // BCL2A1
        Node BCL2A1 = nodeFactory.createNode("BCL2A1");
        BCL2A1.setRestingStatus(1.0);
        BCL2A1.getRules().add(ruleFactory.createRule("Node:BIM# >= 1 | Node:BIK# >= 1 | Node:PUMA# >= 1 | "
                + "Node:NOXA# >= 1 | Node:HRK# >= 1 | Node:tBID# >= 1", 0.0));
        defaultNodes.add(BCL2A1);
        // BCL2L2
        Node BCL2L2 = nodeFactory.createNode("BCL2L2");
        BCL2L2.setRestingStatus(1.0);
        BCL2L2.getRules().add(ruleFactory.createRule("Node:BIM# >= 1 | Node:BIK# >= 1 | Node:PUMA# >= 1 | "
                + "Node:BAD# >= 1 | Node:BMF# >= 1 | Node:HRK# >= 1 | Node:tBID# >= 1", 0.0));
        defaultNodes.add(BCL2L2);
        // BCLXL (BCL2L1)
        Node BCLXL = nodeFactory.createNode("BCLXL");
        BCLXL.setRestingStatus(1.0);
        BCLXL.getRules().add(ruleFactory.createRule("Node:TP53# >= 1 | (Node:BAD# >= 1 & Node:RSK# == 0) | Node:BIM# >= 1 | "
                + "Node:PUMA# >= 1 | Node:BIK# >= 1 | Node:BMF# >= 1 | Node:HRK# >= 1 | Node:tBID# >= 1 | "
                + "Node:NonCanonical_NFKB# >= 1 | Node:Canonical_NFKB# >= 1 ", 0.0));
        defaultNodes.add(BCLXL);
        // BCR
        Node BCR = nodeFactory.createNode("BCR");
        
        defaultNodes.add(BCR);
        // BECN1
        Node BECN1 = nodeFactory.createNode("BECN1");
        BECN1.getRules().add(ruleFactory.createRule("Node:ATG1# >= 1 & (Node:BCL2# == 0 | "
                + "(Node:BCL2# >= 1 & Mod:BCL2#Thr69; == 0.0 & Mod:BCL2#Ser70; == 0.0 & Mod:BCL2#Ser87; == 0.0))", 1.0));
        defaultNodes.add(BECN1);
        // BFL1
        Node BFL1 = nodeFactory.createNode("BFL1");
        BFL1.getRules().add(ruleFactory.createRule("Node:Canonical_NFKB# >= 1", 1.0));
        defaultNodes.add(BFL1);
        // BID
        Node BID = nodeFactory.createNode("BID");
        BID.setRestingStatus(1.0);
        
        defaultNodes.add(BID);
        // BIK
        Node BIK = nodeFactory.createNode("BIK");
        
        defaultNodes.add(BIK);
        // BIM
        Node BIM = nodeFactory.createNode("BIM");
        BIM.getRules().add(ruleFactory.createRule("Node:BCL2# == 0 & Node:BCLXL# == 0 & Node:BCL2L2# == 0 & Node:MCL1# == 0"
                + "Node:BCL2A1# == 0", 1.0));
        defaultNodes.add(BIM);
        // BIRC2
        Node BIRC2 = nodeFactory.createNode("BIRC2");
        BIRC2.getRules().add(ruleFactory.createRule("Node:TRAF2# >= 1 & Node:DIABLO# == 0", 1.0));
        defaultNodes.add(BIRC2);
        // BIRC3
        Node BIRC3 = nodeFactory.createNode("BIRC3");
        BIRC3.getRules().add(ruleFactory.createRule("Node:TRAF2# >= 1 & Node:DIABLO# == 0", 1.0));
        defaultNodes.add(BIRC3);
        // BMF
        Node BMF = nodeFactory.createNode("BMF");
        
        defaultNodes.add(BMF);
        // CACNA1A
        Node CACNA1A = nodeFactory.createNode("CACNA1A");
        CACNA1A.getRules().add(ruleFactory.createRule("Node:HVA# >= 1 & (Node:CALM1# == 0 & Node:Ca_c# < 2)", 1.0));
        defaultNodes.add(CACNA1A);
        // CACNA1B
        Node CACNA1B = nodeFactory.createNode("CACNA1B");
        CACNA1B.getRules().add(ruleFactory.createRule("Node:HVA# >= 1 & (Node:CALM1# == 0 & Node:Ca_c# < 2)", 1.0));
        defaultNodes.add(CACNA1B);
        // CACNA1C
        Node CACNA1C = nodeFactory.createNode("CACNA1C");
        CACNA1C.getRules().add(ruleFactory.createRule("Node:HVA# >= 1 & (Node:CALM1# == 0 & Node:Ca_c# < 2)", 1.0));
        defaultNodes.add(CACNA1C);
        // CACNA1D
        Node CACNA1D = nodeFactory.createNode("CACNA1D");
        CACNA1D.getRules().add(ruleFactory.createRule("Node:HVA# >= 1 & (Node:CALM1# == 0 & Node:Ca_c# < 2)", 1.0));
        defaultNodes.add(CACNA1D);
        // CACNA1E
        Node CACNA1E = nodeFactory.createNode("CACNA1E");
        CACNA1E.getRules().add(ruleFactory.createRule("Node:HVA# >= 1 & (Node:CALM1# == 0 & Node:Ca_c# < 2)", 1.0));
        defaultNodes.add(CACNA1E);
        // CACNA1F
        Node CACNA1F = nodeFactory.createNode("CACNA1F");
        CACNA1F.getRules().add(ruleFactory.createRule("Node:HVA# >= 1 & (Node:CALM1# == 0 & Node:Ca_c# < 2)", 1.0));
        defaultNodes.add(CACNA1F);
        // CACNA1G
        Node CACNA1G = nodeFactory.createNode("CACNA1G");
        CACNA1G.getRules().add(ruleFactory.createRule("Node:LVA# >= 1", 1.0));
        defaultNodes.add(CACNA1G);
        // CACNA1H
        Node CACNA1H = nodeFactory.createNode("CACNA1H");
        CACNA1H.getRules().add(ruleFactory.createRule("Node:LVA# >= 1", 1.0));
        defaultNodes.add(CACNA1H);
        // CACNA1I
        Node CACNA1I = nodeFactory.createNode("CACNA1I");
        CACNA1I.getRules().add(ruleFactory.createRule("Node:LVA# >= 1", 1.0));
        defaultNodes.add(CACNA1I);
        // CACNA1S
        Node CACNA1S = nodeFactory.createNode("CACNA1S");
        CACNA1S.getRules().add(ruleFactory.createRule("Node:HVA# >= 1 & (Node:CALM1# == 0 & Node:Ca_c# < 2)", 1.0));
        defaultNodes.add(CACNA1S);
        // DFFB
        Node DFFB = nodeFactory.createNode("DFFB");
        DFFB.getRules().add(ruleFactory.createRule("Node:ICAD# >= 1", 1.0));
        defaultNodes.add(DFFB);
        // CALM1
        Node CALM1 = nodeFactory.createNode("CALM1");
        
        defaultNodes.add(CALM1);
        // CALR
        Node CALR = nodeFactory.createNode("CALR");
        
        defaultNodes.add(CALR);
        // CAMK2
        Node CAMK2 = nodeFactory.createNode("CAMK2");
        CAMK2.getRules().add(ruleFactory.createRule("Node:RAPGEF3# >= 1", 1.0));
        defaultNodes.add(CAMK2);
        // CAPN1
        Node CAPN1 = nodeFactory.createNode("CAPN1");
        
        defaultNodes.add(CAPN1);
        // CASK
        Node CASK = nodeFactory.createNode("CASK");

        defaultNodes.add(CASK);
        // CASP10
        Node CASP10 = nodeFactory.createNode("CASP10");
        CASP10.getRules().add(ruleFactory.createRule("Node:FADD# >= 1 & Node:ProCASP10# >= 1", 1.0));
        defaultNodes.add(CASP10);
        // CASP2
        Node CASP2 = nodeFactory.createNode("CASP2");
        CASP2.getRules().add(ruleFactory.createRule("Node:ATR# >= 1 | Node:CASP3# >= 1", 1.0));
        defaultNodes.add(CASP2);
        // CASP3
        Node CASP3 = nodeFactory.createNode("CASP3");
        CASP3.getRules().add(ruleFactory.createRule("(Node:CASP10# >= 1 | Node:CASP8# >= 1 | Node:CASP9# >= 1) & "
                + "Node:Survivin# == 0", 1.0));
        defaultNodes.add(CASP3);
        // CASP7
        Node CASP7 = nodeFactory.createNode("CASP7");
        CASP7.getRules().add(ruleFactory.createRule("(Node:CASP10# >= 1 | Node:CASP8# >= 1 | Node:CASP9# >= 1) & "
                + "Node:Survivin# == 0", 1.0));
        defaultNodes.add(CASP7);
        // CASP8
        Node CASP8 = nodeFactory.createNode("CASP8");
        CASP8.getRules().add(ruleFactory.createRule("Node:FADD# >= 1 & Node:ProCASP8# >= 1", 1.0));
        defaultNodes.add(CASP8);
        // CASP9
        Node CASP9 = nodeFactory.createNode("CASP9");
        CASP9.getRules().add(ruleFactory.createRule("Node:APAF1# >= 1 & Node:ProCASP9# >= 1 & Node:AKT1# == 0", 1.0));
        defaultNodes.add(CASP9);
        // CAT
        Node CAT = nodeFactory.createNode("CAT");
        CAT.setRestingStatus(1.0);
        
        defaultNodes.add(CAT);
        // CBL
        Node CBL = nodeFactory.createNode("CBL");
        CBL.getRules().add(ruleFactory.createRule("Node:CSF1R# >= 1 | Node:HCK# >= 1 & "
                + "(Node:CD2AP# == 0 & Node:INPP5D# == 0)", 1.0));
        defaultNodes.add(CBL);
        // CBLB
        Node CBLB = nodeFactory.createNode("CBLB");
        
        defaultNodes.add(CBLB);
        // CBP
        Node CBP = nodeFactory.createNode("CBP");
        
        defaultNodes.add(CBP);
        // CCL11
        Node CCL11 = nodeFactory.createNode("CCL11");
        CCL11.getRules().add(ruleFactory.createRule("Node:Canonical_NFKB# >= 1", 1.0));
        defaultNodes.add(CCL11);
        // CCL13
        Node CCL13 = nodeFactory.createNode("CCL13");
        
        defaultNodes.add(CCL13);
        // CCL2
        Node CCL2 = nodeFactory.createNode("CCL2");
        CCL2.getRules().add(ruleFactory.createRule("Node:Canonical_NFKB# >= 1 | Node:JUN# >= 1", 1.0));
        defaultNodes.add(CCL2);
        // CCL24
        Node CCL24 = nodeFactory.createNode("CCL24");
        
        defaultNodes.add(CCL24);
        // CCL26
        Node CCL26 = nodeFactory.createNode("CCL26");
        
        defaultNodes.add(CCL26);
        // CCL3
        Node CCL3 = nodeFactory.createNode("CCL3");
        
        defaultNodes.add(CCL3);
        // CCL5
        Node CCL5 = nodeFactory.createNode("CCL5");
        
        defaultNodes.add(CCL5);
        // CCL7
        Node CCL7 = nodeFactory.createNode("CCL7");
        
        defaultNodes.add(CCL7);
        // CCL8
        Node CCL8 = nodeFactory.createNode("CCL8");
        
        defaultNodes.add(CCL8);
        // CCR1
        Node CCR1 = nodeFactory.createNode("CCR1");
        CCR1.getRules().add(ruleFactory.createRule("Node:CCL3# >= 1 | Node:CCL5# >= 1 | Node:CCL7# >= 1", 1.0));
        defaultNodes.add(CCR1);
        // CCR2
        Node CCR2 = nodeFactory.createNode("CCR2");
        CCR2.getRules().add(ruleFactory.createRule("(Node:CCL2# >= 1 | Node:CCL7# >= 1) & Node:CCL11# == 0", 1.0));
        defaultNodes.add(CCR2);
        // CCR3
        Node CCR3 = nodeFactory.createNode("CCR3");
        CCR3.getRules().add(ruleFactory.createRule("Node:CCL5# >= 1 | Node:CCL7# >= 1 | Node:CCL8# >= 1 | "
                + "Node:CCL11# >= 1 | Node:CCL13# >= 1 | Node:CCL24# >= 1 | Node:CCL26# >= 1", 1.0));
        defaultNodes.add(CCR3);
        // CCR5
        Node CCR5 = nodeFactory.createNode("CCR5");
        CCR5.getRules().add(ruleFactory.createRule("Node:CCL11# >= 1", 1.0));
        defaultNodes.add(CCR5);
        // CD200
        Node CD200 = nodeFactory.createNode("CD200");
        
        defaultNodes.add(CD200);
        // CD200R1
        Node CD200R1 = nodeFactory.createNode("CD200R1");
        CD200R1.getRules().add(ruleFactory.createRule("Node:CD200# >= 1 & Node:CRKL# == 0", 1.0));
        defaultNodes.add(CD200R1);
        // CD22
        Node CD22 = nodeFactory.createNode("CD22");
        CD22.getRules().add(ruleFactory.createRule("Node:BCR# >= 1", 1.0));
        defaultNodes.add(CD22);
        // CD2AP
        Node CD2AP = nodeFactory.createNode("CD2AP");
        CD2AP.getRules().add(ruleFactory.createRule("Node:FCER1G# >= 1", 1.0));
        defaultNodes.add(CD2AP);
        // CD300LF
        Node CD300LF = nodeFactory.createNode("CD300LF");
        
        defaultNodes.add(CD300LF);
        // CDC42
        Node CDC42 = nodeFactory.createNode("CDC42");
        CDC42.getRules().add(ruleFactory.createRule("Node:CDC42# == 0 & (Node:VAV1# >= 1 | Node:VAV2# >= 1 | Node:DIAPH1# >= 1)", 1.0));
        defaultNodes.add(CDC42);
        // CDH1
        Node CDH1 = nodeFactory.createNode("CDH1");
        
        defaultNodes.add(CDH1);
        // CDH2
        Node CDH2 = nodeFactory.createNode("CDH2");
        
        defaultNodes.add(CDH2);
        // CDK2
        Node CDK2 = nodeFactory.createNode("CDK2");
        CDK2.getRules().add(ruleFactory.createRule("(Node:CDC25A# >= 1 | Node:CCNE# >= 1) & Node:CDKN1A# == 0", 1.0));
        defaultNodes.add(CDK2);
        // CDK4_6
        Node CDK4_6 = nodeFactory.createNode("CDK4_6");
        CDK4_6.getRules().add(ruleFactory.createRule("Node:MitosisStimule# >= 1 & Node:CDKN2A# == 0", 1.0));
        defaultNodes.add(CDK4_6);
        // CDKN1A
        Node CDKN1A = nodeFactory.createNode("CDKN1A");
        CDKN1A.getRules().add(ruleFactory.createRule("(Node:KAT5# >= 1 | Node:PRKCA# >= 1 | Node:STK11# >= 1 |"
                + "(Node:TP53# >= 1 & (Mod:TP53#Ser15; == 1.0 | Mod:TP53#Lys120; == 1.0 | Mod:TP53#Lys164; == 1.0 | Mod:TP53#Lys305; == 1.0 | "
                + "Mod:TP53#Ser46; == 1.0)) | Node:STK11# >= 1) & Node:GSK3B# == 0 ", 1.0));
        defaultNodes.add(CDKN1A);
        // CDKN1B
        Node CDKN1B = nodeFactory.createNode("CDKN1B");
        CDKN1B.getRules().add(ruleFactory.createRule("Node:PRKCA# >= 1 | Node:FOXO4# >= 1", 1.0));
        defaultNodes.add(CDKN1B);
        // CDKN2A
        Node CDKN2A = nodeFactory.createNode("CDKN2A");
        CDKN2A.getRules().add(ruleFactory.createRule("Node:PSMC3# >= 1 | Node:MAPK14# >= 1", 1.0));
        defaultNodes.add(CDKN2A);
        // CEP78
        Node CEP78 = nodeFactory.createNode("CEP78");
        
        defaultNodes.add(CEP78);
        // CERS1
        Node CERS1 = nodeFactory.createNode("CERS1");
        
        defaultNodes.add(CERS1);
        // CFL1
        Node CFL1 = nodeFactory.createNode("CFL1");

        defaultNodes.add(CFL1);
        // CHEK1
        Node CHEK1 = nodeFactory.createNode("CHEK1");
        CHEK1.getRules().add(ruleFactory.createRule("Node:ATR# >= 1 & Node:PPM1D# == 0", 1.0));
        defaultNodes.add(CHEK1);
        // CHEK2
        Node CHEK2 = nodeFactory.createNode("CHEK2");
        CHEK2.getRules().add(ruleFactory.createRule("(Node:ATM# >= 1 & Node:E2F1# >= 1) & Node:PPM1D# == 0", 2.0));
        CHEK2.getRules().add(ruleFactory.createRule("Node:ATM# >= 1 & Node:PPM1D# == 0", 1.0));
        defaultNodes.add(CHEK2);
        // CHUK
        Node CHUK = nodeFactory.createNode("CHUK");
        CHUK.getRules().add(ruleFactory.createRule("Node:IKBKG# >= 1 | Node:AGER# >= 1", 1.0));
        defaultNodes.add(CHUK);
        // CIB1
        Node CIB1 = nodeFactory.createNode("CIB1");
        
        defaultNodes.add(CIB1);
        // CIP2A
        Node CIP2A = nodeFactory.createNode("CIP2A");
        CIP2A.getRules().add(ruleFactory.createRule("Node:CHEK1# >= 1 & Node:E2F1# >= 1", 1.0));
        defaultNodes.add(CIP2A);
        // CISH
        Node CISH = nodeFactory.createNode("CISH");
        CISH.getRules().add(ruleFactory.createRule("Node:CSF3R# >= 1", 1.0));
        defaultNodes.add(CISH);
        // CIT
        Node CIT = nodeFactory.createNode("CIT");
        CIT.getRules().add(ruleFactory.createRule("Node:RHOA# >= 1", 1.0));
        defaultNodes.add(CIT);
        // CLEC4C
        Node CLEC4C = nodeFactory.createNode("CLEC4C");
        
        defaultNodes.add(CLEC4C);
        // CPP110
        Node CPP110 = nodeFactory.createNode("CPP110");

        defaultNodes.add(CPP110);
        // CRK
        Node CRK = nodeFactory.createNode("CRK");
        CRK.getRules().add(ruleFactory.createRule("Node:CBL# >= 1 | Node:DOK1# >= 1", 1.0));
        defaultNodes.add(CRK);
        // CRKL
        Node CRKL = nodeFactory.createNode("CRKL");
        CRKL.getRules().add(ruleFactory.createRule("Node:SHC1# >= 1 | Node:PTPN11# >= 1 | Node:EPOR# >= 1 | "
                + "Node:DOK1# >= 1", 1.0));
        defaultNodes.add(CRKL);
        // CSF1
        Node CSF1 = nodeFactory.createNode("CSF1");
        
        defaultNodes.add(CSF1);
        // CSF1R
        Node CSF1R = nodeFactory.createNode("CSF1R");
        CSF1R.getRules().add(ruleFactory.createRule("(Node:CSF1# >= 1 | Node:IL34# >= 1) & Node:CBL# == 0", 1.0));
        defaultNodes.add(CSF1R);
        // CSF3R
        Node CSF3R = nodeFactory.createNode("CSF3R");
        CSF3R.getRules().add(ruleFactory.createRule("Node:CSF2# >= 1", 1.0));
        defaultNodes.add(CSF3R);
        // CSK
        Node CSK = nodeFactory.createNode("CSK");
        CSK.getRules().add(ruleFactory.createRule("Node:DOK3# >= 1", 1.0));
        defaultNodes.add(CSK);
        // CSNK1A1
        Node CSNK1A1 = nodeFactory.createNode("CSNK1A1");
        
        defaultNodes.add(CSNK1A1);
        // CXCL10
        Node CXCL10 = nodeFactory.createNode("CXCL10");

        defaultNodes.add(CXCL10);
        // CXCL12
        Node CXCL12 = nodeFactory.createNode("CXCL12");
        
        defaultNodes.add(CXCL12);
        // CXCL8
        Node CXCL8 = nodeFactory.createNode("CXCL8");
        CXCL8.getRules().add(ruleFactory.createRule("(Node:JUN# >= 1 | Node:FOS# >= 1 | Node:Canonical_NFKB# >= 1 | "
                + "Node:MAPK14# >= 1) & (Node:NKRF# == 0 | Node:Canonical_NFKB# >= 1) & Node:NuRDComplex# == 0 & "
                + "Node:POU2F1# == 0 & Node:KHSRP# == 0 & Node:ZFP36# == 0", 1.0));
        defaultNodes.add(CXCL8);
        // CXCR3
        Node CXCR3 = nodeFactory.createNode("CXCR3");
        CXCR3.getRules().add(ruleFactory.createRule("Node:CXCL10# >= 1", 1.0));
        defaultNodes.add(CXCR3);
        // CXCR4
        Node CXCR4 = nodeFactory.createNode("CXCR4");
        CXCR4.getRules().add(ruleFactory.createRule("Node:CXCL12# >= 1", 1.0));
        defaultNodes.add(CXCR4);
        // CYBA
        Node CYBA = nodeFactory.createNode("CYBA");
        CYBA.getRules().add(ruleFactory.createRule("Node:NCF1# >= 1 | Node:NCF2# >= 1", 1.0));
        defaultNodes.add(CYBA);
        // CYBB
        Node CYBB = nodeFactory.createNode("CYBB");
        CYBB.getRules().add(ruleFactory.createRule("Node:CYBA# >= 1 & (Node:RAC1# >= 1 | Node:RAC2# >= 1) & "
                + "Node:NCF1# >= 1 & Node:NCF2# >= 1 & Node:NCF4# >= 1", 1.0));
        defaultNodes.add(CYBB);
        // ComplexI
        Node ComplexI = nodeFactory.createGeneralNode("ComplexI");
        ComplexI.getRules().add(ruleFactory.createRule("Node:NADH# >= 1", 1.0));
        defaultNodes.add(ComplexI);
        // ComplexII
        Node ComplexII = nodeFactory.createGeneralNode("ComplexII");
        ComplexII.getRules().add(ruleFactory.createRule("Node:Succinate# >= 1", 1.0));
        defaultNodes.add(ComplexII);
        // ComplexIII
        Node ComplexIII = nodeFactory.createGeneralNode("ComplexIII");
        ComplexIII.getRules().add(ruleFactory.createRule("Node:Ubiquinol# >= 1 & Node:Oxygen# >= 1", 1.0));
        defaultNodes.add(ComplexIII);
        // ComplexIV
        Node ComplexIV = nodeFactory.createGeneralNode("ComplexIV");
        ComplexIV.getRules().add(ruleFactory.createRule("Node:CytochromeC# >= 1", 1.0));
        defaultNodes.add(ComplexIV);
        // CtBP
        Node CtBP = nodeFactory.createNode("CtBP");
        CtBP.setRestingStatus(1.0);
        CtBP.getRules().add(ruleFactory.createRule("Node:HIPK2# >= 1", 0.0));
        defaultNodes.add(CtBP);
        // CytochromeC
        Node CytochromeC = nodeFactory.createNode("CytochromeC");
        CytochromeC.getRules().add(ruleFactory.createRule("Node:ComplexIII# >= 1", 1.0));
        defaultNodes.add(CytochromeC);
        // CytochromeCRelease
        Node CytochromeCRelease = nodeFactory.createGeneralNode("CytochromeCRelease");
        CytochromeCRelease.getRules().add(ruleFactory.createRule("Node:BAX# >= 1 | Node:BAK# >= 1", 1.0));
        defaultNodes.add(CytochromeCRelease);
        // DCAF1
        Node DCAF1 = nodeFactory.createNode("DCAF1");
        
        defaultNodes.add(DCAF1);
        // DCC
        Node DCC = nodeFactory.createNode("DCC");
        DCC.getRules().add(ruleFactory.createRule("Node:NTN1# >= 1 & Node:SIAH2# == 0", 1.0));
        defaultNodes.add(DCC);
        // DDB1
        Node DDB1 = nodeFactory.createNode("DDB1");
        
        defaultNodes.add(DDB1);
        // DIABLO
        Node DIABLO = nodeFactory.createNode("DIABLO");
        DIABLO.getRules().add(ruleFactory.createRule("Node:CytochromeCRelease# >= 1", 1.0));
        defaultNodes.add(DIABLO);
        // DIAPH1
        Node DIAPH1 = nodeFactory.createNode("DIAPH1");
        DIAPH1.getRules().add(ruleFactory.createRule("Node:RHOA# >= 1 | Node:AGER# >= 1", 1.0));
        defaultNodes.add(DIAPH1);
        // DNADamage
        Node DNADamage = nodeFactory.createGeneralNode("DNADamage");
        
        defaultNodes.add(DNADamage);
        // DNAResection
        Node DNAResection = nodeFactory.createGeneralNode("DNAResection");

        defaultNodes.add(DNAResection);
        // DOCK1
        Node DOCK1 = nodeFactory.createNode("DOCK1");
        DOCK1.getRules().add(ruleFactory.createRule("Node:ELMO1# >= 1", 1.0));
        defaultNodes.add(DOCK1);
        // DOK1
        Node DOK1 = nodeFactory.createNode("DOK1");
        DOK1.getRules().add(ruleFactory.createRule("(Node:DOK2# >= 1 | Node:TEC# >= 1 | Node:LYN# >= 1) & "
                + "Node:INPP5D# == 0", 1.0));
        defaultNodes.add(DOK1);
        // DOK2
        Node DOK2 = nodeFactory.createNode("DOK2");
        DOK2.getRules().add(ruleFactory.createRule("Node:CD200R1# >= 1 & Node:DOK1# == 0", 1.0));
        defaultNodes.add(DOK2);
        // DOK3
        Node DOK3 = nodeFactory.createNode("DOK3");
        
        defaultNodes.add(DOK3);
        // DRAM1
        Node DRAM1 = nodeFactory.createNode("DRAM1");
        DRAM1.getRules().add(ruleFactory.createRule("Node:TP53# >= 1", 1.0));
        defaultNodes.add(DRAM1);
        // DSB
        Node DSB = nodeFactory.createGeneralNode("DSB");
        DSB.getRules().add(ruleFactory.createRule("Node:Superoxide# >= 2.5", 2.0));
        DSB.getRules().add(ruleFactory.createRule("Node:Superoxide# >= 2", 1.0));
        defaultNodes.add(DSB);
        // DSF
        Node DSF = nodeFactory.createDrug("DSF");
        
        defaultNodes.add(DSF);
        // DUSP1
        Node DUSP1 = nodeFactory.createNode("DUSP1");
        DUSP1.getRules().add(ruleFactory.createRule("(Node:JUN# >= 1 | Node:ATF2# >= 1) & "
                + "Node:DNADamage# == 0", 1.0));
        defaultNodes.add(DUSP1);
        // DYRK1A
        Node DYRK1A = nodeFactory.createNode("DYRK1A");
        
        defaultNodes.add(DYRK1A);
        // DYRK2
        Node DYRK2 = nodeFactory.createNode("DYRK2");
        DYRK2.getRules().add(ruleFactory.createRule("Node:ATM# >= 1 & Node:SIAH2# == 0", 1.0));
        defaultNodes.add(DYRK2);
        // DYRK3
        Node DYRK3 = nodeFactory.createNode("DYRK3");
        
        defaultNodes.add(DYRK3);
        // E2F1
        Node E2F1 = nodeFactory.createNode("E2F1");
        E2F1.setRestingStatus(1.0);
        E2F1.getRules().add(ruleFactory.createRule("Node:Rb# >= 1 | Node:CDKN2A# >= 1", 0.0));
        defaultNodes.add(E2F1);
        // EDVPComplex
        Node EDVPComplex = nodeFactory.createGeneralNode("EDVPComplex");
        EDVPComplex.getRules().add(ruleFactory.createRule("(Node:UBR5# >= 1 & Node:DCAF1# >= 1 & Node:DDB1# >= 1 & "
                + "Node:DYRK2# >= 1) & Node:CEP78# == 0", 1.0));
        defaultNodes.add(EDVPComplex);
        // EGFR
        Node EGFR = nodeFactory.createNode("EGFR");

        defaultNodes.add(EGFR);
        // EGLN3
        Node EGLN3 = nodeFactory.createNode("EGLN3");

        defaultNodes.add(EGLN3);
        // ELK1
        Node ELK1 = nodeFactory.createNode("ELK1");
        ELK1.getRules().add(ruleFactory.createRule("Node:MAPK14# >= 1 | Node:JNK1# >= 1 | Node:JNK2# >= 1 | "
                + "Node:JNK3# >= 1 | Node:ERK1# >= 1 | Node:ERK2# >= 1", 1.0));
        defaultNodes.add(ELK1);
        // ELK4
        Node ELK4 = nodeFactory.createNode("ELK4");
        ELK4.getRules().add(ruleFactory.createRule("Node:MAPK14# >= 1 | Node:JNK1# >= 1 | Node:JNK2# >= 1 | "
                + "Node:JNK3# >= 1 | Node:ERK1# >= 1 | Node:ERK2# >= 1", 1.0));
        defaultNodes.add(ELK4);
        // ELMO1
        Node ELMO1 = nodeFactory.createNode("ELMO1");
        ELMO1.getRules().add(ruleFactory.createRule("Node:HCK# >= 1", 1.0));
        defaultNodes.add(ELMO1);
        // EPO
        Node EPO = nodeFactory.createNode("EPO");
        EPO.getRules().add(ruleFactory.createRule("Node:HIF1# >= 1", 1.0));
        defaultNodes.add(EPO);
        // EPOR
        Node EPOR = nodeFactory.createNode("EPOR");
        EPOR.getRules().add(ruleFactory.createRule("Node:EPO# >= 1 & Node:PTPN6# == 0", 1.0));
        defaultNodes.add(EPOR);
        // ERK1
        Node ERK1 = nodeFactory.createNode("ERK1");
        ERK1.getRules().add(ruleFactory.createRule("(Node:MAP2K1# >= 1 | Node:Superoxide# >= 2) & Node:DUSP1# == 0", 1.0));
        defaultNodes.add(ERK1);
        // ERK2
        Node ERK2 = nodeFactory.createNode("ERK2");
        ERK2.getRules().add(ruleFactory.createRule("(Node:MAP2K1# >= 1 | Node:Superoxide# >= 2) & Node:DUSP1# == 0", 1.0));
        defaultNodes.add(ERK2);
        // FADD
        Node FADD = nodeFactory.createNode("FADD");
        FADD.getRules().add(ruleFactory.createRule("(Node:RIPK1# >= 1 & Mod:RIPK1#ComplexII; == 1) | "
                + "Node:FAS# >= 1", 1.0));
        defaultNodes.add(FADD);
        // FAS
        Node FAS = nodeFactory.createNode("FAS");
        FAS.getRules().add(ruleFactory.createRule("(Node:TP53# >= 1 | (Node:JUN# >= 1 & Node:FOS# == 0) & "
                + "((Node:YBX1# == 0 & Node:PURA# == 0) | Node:PURB# >= 1)) & Node:FASL# >= 1", 1.0));
        defaultNodes.add(FAS);
        // FASL
        Node FASL = nodeFactory.createNode("FASL");
        FASL.getRules().add(ruleFactory.createRule("Node:JNK1# >= 1 | Node:JNK2# >= 1 | Node:JNK3# >= 1 | "
                + "Node:FOXO3# >= 1 | Node:NFATC1# >= 1", 1.0));
        defaultNodes.add(FASL);
        // FCER1G
        Node FCER1G = nodeFactory.createNode("FCER1G");
        FCER1G.getRules().add(ruleFactory.createRule("Node:CLEC4C# >= 1 | Node:LILRA4# >= 1", 1.0));
        defaultNodes.add(FCER1G);
        // FCGR2B
        Node FCGR2B = nodeFactory.createNode("FCGR2B");
        
        defaultNodes.add(FCGR2B);
        // FGR
        Node FGR = nodeFactory.createNode("FGR");
        FGR.getRules().add(ruleFactory.createRule("Node:CCR3# >= 1", 1.0));
        defaultNodes.add(FGR);
        // FIG4
        Node FIG4 = nodeFactory.createNode("FIG4");
        
        defaultNodes.add(FIG4);
        // FKBP1A
        Node FKBP1A = nodeFactory.createNode("FKBP1A");
        
        defaultNodes.add(FKBP1A);
        // FKBP1B
        Node FKBP1B = nodeFactory.createNode("FKBP1B");
        
        defaultNodes.add(FKBP1B);
        // FOS
        Node FOS = nodeFactory.createNode("FOS");
        FOS.getRules().add(ruleFactory.createRule("(Node:ELK4# >= 1 | Node:ELK1# >= 1) & Node:KCNIP3# == 0", 1.0));
        defaultNodes.add(FOS);
        // FOXK1
        Node FOXK1 = nodeFactory.createNode("FOXK1");
        FOXK1.getRules().add(ruleFactory.createRule("Node:PP2A# >= 1 | Node:mTORC1# >= 1", 1.0));
        defaultNodes.add(FOXK1);
        // FOXO3
        Node FOXO3 = nodeFactory.createNode("FOXO3");
        FOXO3.getRules().add(ruleFactory.createRule("Node:KAT5# >= 1 & (Node:AKT1# == 0 | Node:SGK3# == 0)", 1.0));
        defaultNodes.add(FOXO3);
        // FOXP3
        Node FOXP3 = nodeFactory.createNode("FOXP3");
        
        defaultNodes.add(FOXP3);
        // FXYD1
        Node FXYD1 = nodeFactory.createNode("FXYD1");
        FXYD1.getRules().add(ruleFactory.createRule("Node:PKA# >= 1", 1.0));
        defaultNodes.add(FXYD1);
        // FYN
        Node FYN = nodeFactory.createNode("FYN");
        FYN.getRules().add(ruleFactory.createRule("Node:JAK2# >= 1 & Node:AGTR1# >= 1", 1.0));
        defaultNodes.add(FYN);
        // GAB1
        Node GAB1 = nodeFactory.createNode("GAB1");
        GAB1.getRules().add(ruleFactory.createRule("Node:MET# >= 1 | Node:SHC1# >= 1 | Node:GRB2# >= 1", 1.0));
        defaultNodes.add(GAB1);
        // GAB2
        Node GAB2 = nodeFactory.createNode("GAB2");
        GAB2.getRules().add(ruleFactory.createRule("Node:SHC1# >= 1 | Node:GRB2# >= 1", 1.0));
        defaultNodes.add(GAB2);
        // GABARAP
        Node GABARAP = nodeFactory.createNode("GABARAP");
        GABARAP.getRules().add(ruleFactory.createRule("(Node:TP53INP1# >= 1 | Node:TP53INP2# >= 1) & Node:VMP1# >= 1", 1.0));
        defaultNodes.add(GABARAP);
        // GABARAPL2
        Node GABARAPL2 = nodeFactory.createNode("GABARAPL2");
        GABARAPL2.getRules().add(ruleFactory.createRule("(Node:TP53INP1# >= 1 | Node:TP53INP2# >= 1) & "
                + "Node:VMP1# >= 1", 1.0));
        defaultNodes.add(GABARAPL2);
        // GPX1
        Node GPX1 = nodeFactory.createNode("GPX1");
        
        defaultNodes.add(GPX1);
        // GRB2
        Node GRB2 = nodeFactory.createNode("GRB2");
        GRB2.getRules().add(ruleFactory.createRule("Node:MET# >= 1 | Node:CBL# >= 1 | Node:CD22# >= 1 | "
                + "Node:EPOR# >= 1 | Node:SHC1# >= 1 | Node:KIT# >= 1 | (Node:EGFR# >= 1 & Node:JAK2# >= 1)", 1.0));
        defaultNodes.add(GRB2);
        // GRB7
        Node GRB7 = nodeFactory.createNode("GRB7");
        GRB7.getRules().add(ruleFactory.createRule("Node:KIT# >= 1", 1.0));
        defaultNodes.add(GRB7);
        // GSK3A
        Node GSK3A = nodeFactory.createNode("GSK3A");

        defaultNodes.add(GSK3A);
        // GSK3B
        Node GSK3B = nodeFactory.createNode("GSK3B");
        GSK3B.getRules().add(ruleFactory.createRule("(Node:FRAT1# >= 1) & Node:AKT1# == 0", 1.0));
        defaultNodes.add(GSK3B);
        // GSR
        Node GSR = nodeFactory.createNode("GSR");
        
        defaultNodes.add(GSR);
        // GYS1
        Node GYS1 = nodeFactory.createNode("GYS1");

        defaultNodes.add(GYS1);
        // H1
        Node H1 = nodeFactory.createNode("H1");
        H1.getRules().add(ruleFactory.createRule("Node:RNF8# >= 1", 1.0));
        defaultNodes.add(H1);
        // H2AX
        Node H2AX = nodeFactory.createNode("H2AX");
        H2AX.getRules().add(ruleFactory.createRule("Node:ATM# >= 1 | Node:FOXO3# >= 1 | Node:KAT5# >= 1", 1.0));
        defaultNodes.add(H2AX);
        // HCK
        Node HCK = nodeFactory.createNode("HCK");
        HCK.getRules().add(ruleFactory.createRule("Node:CCR3# >= 1", 1.0));
        defaultNodes.add(HCK);
        // HGF
        Node HGF = nodeFactory.createNode("HGF");
        
        defaultNodes.add(HGF);
        // HIPK2
        Node HIPK2 = nodeFactory.createNode("HIPK2");
        HIPK2.setRestingStatus(1.0);
        HIPK2.getRules().add(ruleFactory.createRule("Node:SIAH1# >= 1", 0.0));
        defaultNodes.add(HIPK2);
        // HIST2H2BE
        Node HIST2H2BE = nodeFactory.createNode("HIST2H2BE");
        HIST2H2BE.getRules().add(ruleFactory.createRule("Node:DYRK2# >= 1 | Node:DYRK3# >= 1", 1.0));
        defaultNodes.add(HIST2H2BE);
        // HIST3H3
        Node HIST3H3 = nodeFactory.createNode("HIST3H3");
        HIST3H3.getRules().add(ruleFactory.createRule("Node:DYRK1A# >= 1 | Node:DYRK2# >= 1 | Node:DYRK3# >= 1", 1.0));
        defaultNodes.add(HIST3H3);
        // HOMER1
        Node HOMER1 = nodeFactory.createNode("HOMER1");
        
        defaultNodes.add(HOMER1);
        // HRK
        Node HRK = nodeFactory.createNode("HRK");
        HRK.getRules().add(ruleFactory.createRule("(Node:JUN# >= 1 & Node:ATF2# >= 1 & Node:FOS# == 0) & "
                + "Node:NitricOxide# > 1 & Node:KCNIP3# == 0", 1.0));
        defaultNodes.add(HRK);
        // HSP90AA1
        Node HSP90AA1 = nodeFactory.createNode("HSP90AA1");
        
        defaultNodes.add(HSP90AA1);
        // HSPB1
        Node HSPB1 = nodeFactory.createNode("HSPB1");
        HSPB1.getRules().add(ruleFactory.createRule("Node:MAPKAPK2# >= 1 & Node:TRAF6# == 0", 1.0));
        defaultNodes.add(HSPB1);
        // HVA
        Node HVA = nodeFactory.createGeneralNode("HVA");
        
        defaultNodes.add(HVA);
        // ICAD
        Node ICAD = nodeFactory.createNode("ICAD");
        ICAD.getRules().add(ruleFactory.createRule("Node:CASP2# >= 1 | Node:CASP3# >= 1 | Node:CASP7# >= 1", 1.0));
        defaultNodes.add(ICAD);
        // IFNB1
        Node IFNB1 = nodeFactory.createNode("IFNB1");
        IFNB1.setRestingStatus(1.0);
        IFNB1.getRules().add(ruleFactory.createRule("Node:NKRF# >= 1", 0.0));
        defaultNodes.add(IFNB1);
        // IGFBP1
        Node IGFBP1 = nodeFactory.createNode("IGFBP1");
        IGFBP1.getRules().add(ruleFactory.createRule("Node:FOXO3# >= 1", 1.0));
        defaultNodes.add(IGFBP1);
        // IKBKG
        Node IKBKG = nodeFactory.createNode("IKBKG");
        IKBKG.getRules().add(ruleFactory.createRule("Node:ATM# >= 1 | Node:IRAK1# >= 1 | Node:MAP3K3# >= 1 | "
                + "Node:MAP3K7# >= 1 | Node:RIPK2# >= 1", 1.0));
        defaultNodes.add(IKBKG);
        // IL1A
        Node IL1A = nodeFactory.createNode("IL1A");
        IL1A.getRules().add(ruleFactory.createRule("Node:Canonical_NFKB# >= 1", 1.0));
        defaultNodes.add(IL1A);
        // IL1B
        Node IL1B = nodeFactory.createNode("IL1B");
        IL1B.getRules().add(ruleFactory.createRule("Node:Canonical_NFKB# >= 1", 1.0));
        defaultNodes.add(IL1B);
        // IL1R1
        Node IL1R1 = nodeFactory.createNode("IL1R1");
        IL1R1.getRules().add(ruleFactory.createRule("Node:IL1RAP# >= 1 & (Node:IL1A# >= 1 | Node:IL1B# >= 1) & "
                + "Node:sIL1RAP# == 0 & Node:IL1R2# == 0 & Node:IL1RN# == 0", 1.0));
        defaultNodes.add(IL1R1);
        // IL1R2
        Node IL1R2 = nodeFactory.createNode("IL1R2");
        IL1R2.getRules().add(ruleFactory.createRule("Node:IL1A# >= 1 | Node:IL1B# >= 1", 1.0));
        defaultNodes.add(IL1R2);
        // IL1RAP
        Node IL1RAP = nodeFactory.createNode("IL1RAP");
        IL1RAP.setRestingStatus(1.0);
        
        defaultNodes.add(IL1RAP);
        // IL1RN
        Node IL1RN = nodeFactory.createNode("IL1RN");
        IL1RN.getRules().add(ruleFactory.createRule("Node:Canonical_NFKB# >= 1", 1.0));
        defaultNodes.add(IL1RN);
        // IL34
        Node IL34 = nodeFactory.createNode("IL34");
        
        defaultNodes.add(IL34);
        // IL4
        Node IL4 = nodeFactory.createNode("IL4");
        IL4.getRules().add(ruleFactory.createRule("Node:Canonical_NFKB# >= 1", 1.0));
        defaultNodes.add(IL4);
        // IL4R
        Node IL4R = nodeFactory.createNode("IL4R");
        IL4R.getRules().add(ruleFactory.createRule("Node:IL4# >= 1", 1.0));
        defaultNodes.add(IL4R);
        // IL6
        Node IL6 = nodeFactory.createNode("IL6");
        IL6.getRules().add(ruleFactory.createRule("(Node:MAPK14# >= 1 | Node:Canonical_NFKB# >= 1) & Node:KHSRP# == 0 & Node:ZFP36# == 0", 1.0));
        defaultNodes.add(IL6);
        // IL6R
        Node IL6R = nodeFactory.createNode("IL6R");
        IL6R.getRules().add(ruleFactory.createRule("Node:IL6# >= 1", 1.0));
        defaultNodes.add(IL6R);
        // INPP4B
        Node INPP4B = nodeFactory.createNode("INPP4B");
        
        defaultNodes.add(INPP4B);
        // INPP5D
        Node INPP5D = nodeFactory.createNode("INPP5D");
        INPP5D.getRules().add(ruleFactory.createRule("Node:KLRG1# >= 1 | Node:FCGR2B# >= 1 | Node:PECAM1# >= 1 | "
                + "Node:MET# >= 1 | Node:CSF1R# >= 1 | Node:CD22# >= 1 | Node:CD300LF# >= 1 | Node:CRKL# >= 1 | "
                + "Node:CSF3R# >= 1 | Node:DOK3# >= 1 | Node:GAB1# >= 1 | Node:GRB2# >= 1 | Node:SHC1# >= 1 | "
                + "Node:IL4R# >= 1 | Node:SYK# >= 1 | Node:LCK# >= 1 | Node:JAK1# >= 1 | Node:LYN# >= 1 | "
                + "Node:CD2AP# >= 1 | Node:EPOR# >= 1", 1.0));
        defaultNodes.add(INPP5D);
        // INPPL1
        Node INPPL1 = nodeFactory.createNode("INPPL1");
        INPPL1.getRules().add(ruleFactory.createRule("Node:MET# >= 1", 1.0));
        defaultNodes.add(INPPL1);
        // IP3R1
        Node IP3R1 = nodeFactory.createNode("IP3R1");
        IP3R1.getRules().add(ruleFactory.createRule("Node:IP3# >= 0.5 & Node:Ca_c# < 3", 1.0));
        defaultNodes.add(IP3R1);
        // IP3R2
        Node IP3R2 = nodeFactory.createNode("IP3R2");
        IP3R2.getRules().add(ruleFactory.createRule("Node:IP3# >= 0.5 & Node:Ca_c# < 3", 1.0));
        defaultNodes.add(IP3R2);
        // IP3R3
        Node IP3R3 = nodeFactory.createNode("IP3R3");
        IP3R3.getRules().add(ruleFactory.createRule("Node:IP3# >= 0.5 & Node:Ca_c# < 3", 1.0));
        defaultNodes.add(IP3R3);
        // IQSEC1
        Node IQSEC1 = nodeFactory.createNode("IQSEC1");
        
        defaultNodes.add(IQSEC1);
        // IRAK1
        Node IRAK1 = nodeFactory.createNode("IRAK1");
        IRAK1.getRules().add(ruleFactory.createRule("Node:IL1R1# >= 1 | Node:IRAK4# >= 1 | Node:MYD88# >= 1", 1.0));
        defaultNodes.add(IRAK1);
        // IRAK2
        Node IRAK2 = nodeFactory.createNode("IRAK2");
        IRAK2.getRules().add(ruleFactory.createRule("Node:IRAK4# >= 1", 1.0));
        defaultNodes.add(IRAK2);
        // IRAK4
        Node IRAK4 = nodeFactory.createNode("IRAK4");
        IRAK4.getRules().add(ruleFactory.createRule("Node:MYD88# >= 1", 1.0));
        defaultNodes.add(IRAK4);
        // IRS1
        Node IRS1 = nodeFactory.createNode("IRS1");
        IRS1.getRules().add(ruleFactory.createRule("(Node:IL4R# >= 1 | Node:IGF1R# >= 1) & "
                + "Node:PRKCZ# == 0 & Node:PRKCD# == 0 & Node:S6K1# == 0 & Node:GRB10# == 0 & Node:mTORC1# == 0", 1.0));
        defaultNodes.add(IRS1);
        // JAK1
        Node JAK1 = nodeFactory.createNode("JAK1");
        JAK1.getRules().add(ruleFactory.createRule("(Node:BRCA1# >= 1 | Node:GHR# >= 1 | Node:IFNGR# >= 1 | "
                + "Node:IGF1R# >= 1 | Node:IL3R# >= 1 | Node:IL13R# >= 1 | Node:IL4R# >= 1 | Node:IL5R# >= 1) & "
                + "Node:SOCS1# == 0", 1.0));
        defaultNodes.add(JAK1);
        // JAK2
        Node JAK2 = nodeFactory.createNode("JAK2");
        JAK2.getRules().add(ruleFactory.createRule("(Node:AGER# >= 1 | (Node:EPOR# >= 1 & Node:PTPN6# == 0) | "
                + "Node:Superoxide# >= 2 | Node:IL12R# >= 1 | Node:AGTR1# >= 1 | Node:BRCA1# >= 1 | "
                + "Node:CCR2# >= 1 | Node:CCR5# >= 1 | Node:CRLF2# >= 1 | Node:CSF3R# >= 1 | Node:CXCR4# >= 1 | "
                + "Node:ERBB2# >= 1 | Node:GHR# >= 1 | Node:HTR2A# >= 1 | Node:IFNGR# >= 1 | Node:IGF1R# >= 1 | "
                + "Node:IL23R# >= 1 | Node:IL3R# >= 1 | Node:IL13R# >= 1 | Node:IL4R# >= 1 | Node:IL5R# >= 1 | "
                + "Node:INSR# >= 1 | Node:KIT# >= 1) & Node:SOCS1# == 0", 1.0));
        defaultNodes.add(JAK2);
        // JMY
        Node JMY = nodeFactory.createNode("JMY");
        JMY.getRules().add(ruleFactory.createRule("Node:E2F1# >= 1", 1.0));
        defaultNodes.add(JMY);
        // JNK1
        Node JNK1 = nodeFactory.createNode("JNK1");
        JNK1.getRules().add(ruleFactory.createRule("(Node:MAP2K7# >= 1 | Node:MAP2K4# >= 1) & Node:DUSP1# == 0", 1.0));
        defaultNodes.add(JNK1);
        // JNK2
        Node JNK2 = nodeFactory.createNode("JNK2");
        JNK2.getRules().add(ruleFactory.createRule("(Node:MAP2K7# >= 1 | Node:MAP2K4# >= 1) & Node:DUSP1# == 0", 1.0));
        defaultNodes.add(JNK2);
        // JNK3
        Node JNK3 = nodeFactory.createNode("JNK3");
        JNK3.getRules().add(ruleFactory.createRule("(Node:MAP2K7# >= 1 | Node:MAP2K4# >= 1) & Node:DUSP1# == 0", 1.0));
        defaultNodes.add(JNK3);
        // JUN
        Node JUN = nodeFactory.createNode("JUN");
        JUN.getRules().add(ruleFactory.createRule("(Node:JNK1# >= 1 & Node:CDKN2A# == 0) | Node:JNK2# >= 1 | "
                + "(Node:JNK3# >= 1 & Node:CDKN2A# == 0)", 1.0));
        defaultNodes.add(JUN);
        // KAT5
        Node KAT5 = nodeFactory.createNode("KAT5");
        KAT5.getRules().add(ruleFactory.createRule("Node:ABL1# >= 1", 1.0));
        defaultNodes.add(KAT5);
        // KATNA1
        Node KATNA1 = nodeFactory.createNode("KATNA1");

        defaultNodes.add(KATNA1);
        // KCNIP3
        Node KCNIP3 = nodeFactory.createNode("KCNIP3");
        KCNIP3.getRules().add(ruleFactory.createRule("Node:Ca_c# < 2", 1.0));
        defaultNodes.add(KCNIP3);
        // KHDRBS1
        Node KHDRBS1 = nodeFactory.createNode("KHDRBS1");
        KHDRBS1.getRules().add(ruleFactory.createRule("Node:HCK# >= 1", 1.0));
        defaultNodes.add(KHDRBS1);
        // KHSRP
        Node KHSRP = nodeFactory.createNode("KHSRP");
        KHSRP.getRules().add(ruleFactory.createRule("Node:MAPK14# == 0", 1.0));
        defaultNodes.add(KHSRP);
        // KIT
        Node KIT = nodeFactory.createNode("KIT");
        KIT.getRules().add(ruleFactory.createRule("Node:KITLG# >= 1", 1.0));
        defaultNodes.add(KIT);
        // KITLG
        Node KITLG = nodeFactory.createNode("KITLG");
        
        defaultNodes.add(KITLG);
        // KLRG1
        Node KLRG1 = nodeFactory.createNode("KLRG1");
        KLRG1.getRules().add(ruleFactory.createRule("Node:CDH1# >= 1 | Node:CDH2# >= 1", 1.0));
        defaultNodes.add(KLRG1);
        // LCK
        Node LCK = nodeFactory.createNode("LCK");
        
        defaultNodes.add(LCK);
        // LCMT1
        Node LCMT1 = nodeFactory.createNode("LCMT1");
        
        defaultNodes.add(LCMT1);
        // LILRA4
        Node LILRA4 = nodeFactory.createNode("LILRA4");
        
        defaultNodes.add(LILRA4);
        // LIMK2
        Node LIMK2 = nodeFactory.createNode("LIMK2");
        LIMK2.getRules().add(ruleFactory.createRule("Node:ROCK1# >= 1", 1.0));
        defaultNodes.add(LIMK2);
        // LVA
        Node LVA = nodeFactory.createGeneralNode("LVA");
        
        defaultNodes.add(LVA);
        // LYN
        Node LYN = nodeFactory.createNode("LYN");
        LYN.getRules().add(ruleFactory.createRule("Node:CD22# >= 1 | Node:EPOR# >= 1 | Node:KIT# >= 1", 1.0));
        defaultNodes.add(LYN);
        // MAP1LC3A
        Node MAP1LC3A = nodeFactory.createNode("MAP1LC3A");
        MAP1LC3A.getRules().add(ruleFactory.createRule("(Node:TP53INP1# >= 1 | Node:TP53INP2# >= 1) & "
                + "Node:VMP1# >= 1", 1.0));
        defaultNodes.add(MAP1LC3A);
        // MAP2K1
        Node MAP2K1 = nodeFactory.createNode("MAP2K1");
        MAP2K1.getRules().add(ruleFactory.createRule("Node:RAF1# >= 1", 1.0));
        defaultNodes.add(MAP2K1);
        // MAP2K3
        Node MAP2K3 = nodeFactory.createNode("MAP2K3");
        MAP2K3.getRules().add(ruleFactory.createRule("Node:MAP3K3# >= 1 | Node:MAP3K7# >= 1", 1.0));
        defaultNodes.add(MAP2K3);
        // MAP2K4
        Node MAP2K4 = nodeFactory.createNode("MAP2K4");
        MAP2K4.getRules().add(ruleFactory.createRule("Node:MAP3K1# >= 1 | Node:MAP3K3# >= 1 | Node:MAP3K7# >= 1", 1.0));
        defaultNodes.add(MAP2K4);
        // MAP2K6
        Node MAP2K6 = nodeFactory.createNode("MAP2K6");
        MAP2K6.getRules().add(ruleFactory.createRule("Node:MAP3K3# >= 1 | Node:MAP3K7# >= 1", 1.0));
        defaultNodes.add(MAP2K6);
        // MAP2K7
        Node MAP2K7 = nodeFactory.createNode("MAP2K7");
        MAP2K7.getRules().add(ruleFactory.createRule("Node:MAP3K5# >= 1 | Node:MAP3K3# >= 1 | Node:MAP3K7# >= 1", 1.0));
        defaultNodes.add(MAP2K7);
        // MAP3K1
        Node MAP3K1 = nodeFactory.createNode("MAP3K1");
        MAP3K1.getRules().add(ruleFactory.createRule("Node:PKN1# >= 1", 1.0));
        defaultNodes.add(MAP3K1);
        // MAP3K3
        Node MAP3K3 = nodeFactory.createNode("MAP3K3");
        MAP3K1.getRules().add(ruleFactory.createRule("Node:TRAF6# >= 1", 1.0));
        defaultNodes.add(MAP3K3);
        // MAP3K5
        Node MAP3K5 = nodeFactory.createNode("MAP3K5");

        defaultNodes.add(MAP3K5);
        // MAP3K7
        Node MAP3K7 = nodeFactory.createNode("MAP3K7");
        MAP3K7.getRules().add(ruleFactory.createRule("Node:TRAF6# >= 1 | Node:IRAK1# >= 1 | Node:TAB2# >= 1 | "
                + "Node:HSPB1# >= 1 | Node:TAB1# >= 1 | Node:TAB3# >= 1 | Node:BIRC2# >= 1 | Node:BIRC3# >= 1", 1.0));
        defaultNodes.add(MAP3K7);
        // MAP4K3
        Node MAP4K3 = nodeFactory.createNode("MAP4K3");

        defaultNodes.add(MAP4K3);
        // MAPK12
        Node MAPK12 = nodeFactory.createNode("MAPK12");
        MAPK12.getRules().add(ruleFactory.createRule("Node:MAP2K3# >= 1 | Node:MAP2K4# >= 1 | Node:MAP2K6# >= 1", 1.0));
        defaultNodes.add(MAPK12);
        // MAPK13
        Node MAPK13 = nodeFactory.createNode("MAPK13");
        MAPK13.getRules().add(ruleFactory.createRule("Node:MAP2K3# >= 1 | Node:MAP2K4# >= 1 | Node:MAP2K6# >= 1", 1.0));
        defaultNodes.add(MAPK13);
        // MAPKAPK2
        Node MAPKAPK2 = nodeFactory.createNode("MAPKAPK2");
        MAPKAPK2.getRules().add(ruleFactory.createRule("Node:MAPK14# >= 1", 1.0));
        defaultNodes.add(MAPKAPK2);
        // MCL1
        Node MCL1 = nodeFactory.createNode("MCL1");
        MCL1.setRestingStatus(1.0);
        MCL1.getRules().add(ruleFactory.createRule("Node:BIM# >= 1 | Node:PUMA# >= 1 | Node:NOXA# >= 1", 0.0));
        defaultNodes.add(MCL1);
        // MCU
        Node MCU = nodeFactory.createNode("MCU");
        MCU.getRules().add(ruleFactory.createRule("Node:Ca_c# >= 3", 1.0));
        defaultNodes.add(MCU);
        // MDC1
        Node MDC1 = nodeFactory.createNode("MDC1");
        MDC1.getRules().add(ruleFactory.createRule("Node:H2AX# >= 1 & Node:ATM# >= 1", 1.0));
        defaultNodes.add(MDC1);
        // MDM2
        Node MDM2 = nodeFactory.createNode("MDM2");
        MDM2.getRules().add(ruleFactory.createRule("(Node:AKT1# >= 1 | Node:TP53# >= 1) & "
                + "(Node:ATM# == 0 | Node:PPM1D# >= 1) & Node:CDKN2A# == 0", 1.0));
        defaultNodes.add(MDM2);
        // MET
        Node MET = nodeFactory.createNode("MET");
        MET.getRules().add(ruleFactory.createRule("Node:HGF# >= 1", 1.0));
        defaultNodes.add(MET);
        // MPO
        Node MPO = nodeFactory.createNode("MPO");
        
        defaultNodes.add(MPO);
        // MRN
        Node MRN = nodeFactory.createNode("MRN");
        MRN.getRules().add(ruleFactory.createRule("Node:DSB# >= 1 | Node:Shortenedtelomeres# >= 1", 1.0));
        defaultNodes.add(MRN);
        // MTM1
        Node MTM1 = nodeFactory.createNode("MTM1");
        
        defaultNodes.add(MTM1);
        // MTMR1
        Node MTMR1 = nodeFactory.createNode("MTMR1");
        
        defaultNodes.add(MTMR1);
        // MTMR2
        Node MTMR2 = nodeFactory.createNode("MTMR2");
        
        defaultNodes.add(MTMR2);
        // MTMR3
        Node MTMR3 = nodeFactory.createNode("MTMR3");
        
        defaultNodes.add(MTMR3);
        // MTMR6
        Node MTMR6 = nodeFactory.createNode("MTMR6");
        
        defaultNodes.add(MTMR6);
        // MYD88
        Node MYD88 = nodeFactory.createNode("MYD88");
        MYD88.getRules().add(ruleFactory.createRule("Node:IL1R1# >= 1 | (Node:AGER# >= 1 & Node:PRKCZ# >= 1) | "
                + "Node:TIRAP# >= 1", 1.0));
        defaultNodes.add(MYD88);
        // MYLK
        Node MYLK = nodeFactory.createNode("MYLK");
        MYLK.getRules().add(ruleFactory.createRule("Node:CALM1# >= 1", 1.0));
        defaultNodes.add(MYLK);
        // NCF1
        Node NCF1 = nodeFactory.createNode("NCF1");
        NCF1.getRules().add(ruleFactory.createRule("Node:PKN1# >= 1", 1.0));
        defaultNodes.add(NCF1);
        // NCF2
        Node NCF2 = nodeFactory.createNode("NCF2");
        NCF2.getRules().add(ruleFactory.createRule("Node:NCF1# >= 1", 1.0));
        defaultNodes.add(NCF2);
        // NCF4
        Node NCF4 = nodeFactory.createNode("NCF4");
        NCF4.getRules().add(ruleFactory.createRule("Node:NCF1# >= 1", 1.0));
        defaultNodes.add(NCF4);
        // NCK1
        Node NCK1 = nodeFactory.createNode("NCK1");
        NCK1.getRules().add(ruleFactory.createRule("Node:DOK2# >= 1", 1.0));
        defaultNodes.add(NCK1);
        // NFATC1
        Node NFATC1 = nodeFactory.createNode("NFATC1");
        NFATC1.getRules().add(ruleFactory.createRule("Node:PP2B# >= 1 & (Node:DYRK1A# == 0 & Node:DYRK2# == 0 & "
                + "Node:GSK3A# == 0 & Node:GSK3B# == 0)", 1.0));
        defaultNodes.add(NFATC1);
        // NFATC2
        Node NFATC2 = nodeFactory.createNode("NFATC2");
        NFATC2.getRules().add(ruleFactory.createRule("Node:PP2B# >= 1 & (Node:GSK3A# == 0 & Node:GSK3B# == 0)", 1.0));
        defaultNodes.add(NFATC2);
        // NFATC3
        Node NFATC3 = nodeFactory.createNode("NFATC3");
        NFATC3.getRules().add(ruleFactory.createRule("Node:PP2B# >= 1 & (Node:GSK3A# == 0 & Node:GSK3B# == 0)", 1.0));
        defaultNodes.add(NFATC3);
        // NFATC4
        Node NFATC4 = nodeFactory.createNode("NFATC4");
        NFATC4.getRules().add(ruleFactory.createRule("Node:PP2B# >= 1 & (Node:GSK3A# == 0 & Node:GSK3B# == 0 & "
                + "Node:CSNK1A1# == 0)", 1.0));
        defaultNodes.add(NFATC4);
        // Canonical_NFKB (Complex p50/RELA)
        Node Canonical_NFKB = nodeFactory.createNode("Canonical_NFKB");
        Canonical_NFKB.setRestingStatus(1.0);
        Canonical_NFKB.getRules().add(ruleFactory.createRule("Node:NFKBIA# >= 1 | Node:NOS2# >= 1 | Node:DUSP1# >= 1", 0.0));
        defaultNodes.add(Canonical_NFKB);
        // NHEJ
        Node NHEJ = nodeFactory.createGeneralNode("NHEJ");
        NHEJ.getRules().add(ruleFactory.createRule("Node:TP53BP1# >= 1 & Node:DSB# >= 1", 1.0));
        defaultNodes.add(NHEJ);
        // NKRF
        Node NKRF = nodeFactory.createNode("NKRF");

        defaultNodes.add(NKRF);
        // NOD1
        Node NOD1 = nodeFactory.createNode("NOD1");
        
        defaultNodes.add(NOD1);
        // NOD2
        Node NOD2 = nodeFactory.createNode("NOD2");
        NOD2.getRules().add(ruleFactory.createRule("Node:MDP# >= 1", 1.0));
        defaultNodes.add(NOD2);
        // NODosome
        Node NODosome = nodeFactory.createGeneralNode("NODosome");
        NODosome.getRules().add(ruleFactory.createRule("Node:NOD1# >= 1 & Node:NOD2# >= 1", 1.0));
        defaultNodes.add(NODosome);
        // NOS1
        Node NOS1 = nodeFactory.createNode("NOS1");

        defaultNodes.add(NOS1);
        // NOS2
        Node NOS2 = nodeFactory.createNode("NOS2");
        NOS2.getRules().add(ruleFactory.createRule("(Node:RAC2# >= 1) & Node:NKRF# == 0", 1.0));
        defaultNodes.add(NOS2);
        // NOTCH1
        Node NOTCH1 = nodeFactory.createNode("NOTCH1");
        
        defaultNodes.add(NOTCH1);
        // NOXA
        Node NOXA = nodeFactory.createNode("NOXA");
        NOXA.getRules().add(ruleFactory.createRule("Node:TP53# >= 1 & Node:CtBP# == 0", 1.0));
        defaultNodes.add(NOXA);
        // NR1I2
        Node NR1I2 = nodeFactory.createNode("NR1I2");

        defaultNodes.add(NR1I2);
        // NR4A1
        Node NR4A1 = nodeFactory.createNode("NR4A1");

        defaultNodes.add(NR4A1);
        // NTN1
        Node NTN1 = nodeFactory.createNode("NTN1");
        
        defaultNodes.add(NTN1);
        // NuRDComplex
        Node NuRDComplex = nodeFactory.createGeneralNode("NuRDComplex");
        
        defaultNodes.add(NuRDComplex);
        // ORAI1
        Node ORAI1 = nodeFactory.createNode("ORAI1");
        ORAI1.getRules().add(ruleFactory.createRule("Node:STIM1# >= 1 | Node:STIM2# >= 1", 1.0));
        defaultNodes.add(ORAI1);
        // PIDD1
        Node PIDD1 = nodeFactory.createNode("PIDD1");
        PIDD1.getRules().add(ruleFactory.createRule("Node:TP53# >= 1", 1.0));
        defaultNodes.add(PIDD1);
        // PARP1
        Node PARP1 = nodeFactory.createNode("PARP1");
        PARP1.getRules().add(ruleFactory.createRule("Node:DNADamage# >= 1", 1.0));
        defaultNodes.add(PARP1);
        // PCAF
        Node PCAF = nodeFactory.createNode("PCAF");
        
        defaultNodes.add(PCAF);
        // PDE4D
        Node PDE4D = nodeFactory.createNode("PDE4D");
        PDE4D.getRules().add(ruleFactory.createRule("Node:PKA# >= 1 | Node:CAMK2# >= 1", 1.0));
        defaultNodes.add(PDE4D);
        // PDGFA
        Node PDGFA = nodeFactory.createNode("PDGFA");
        
        defaultNodes.add(PDGFA);
        // PDGFAA
        Node PDGFAA = nodeFactory.createNode("PDGFAA");
        PDGFAA.getRules().add(ruleFactory.createRule("Node:PDGFA# >= 1", 1.0));
        defaultNodes.add(PDGFAA);
        // PDGFAB
        Node PDGFAB = nodeFactory.createNode("PDGFAB");
        PDGFAB.getRules().add(ruleFactory.createRule("Node:PDGFA# >= 1 & Node:PDGFB# >= 1", 1.0));
        defaultNodes.add(PDGFAB);
        // PDGFB
        Node PDGFB = nodeFactory.createNode("PDGFB");
        PDGFB.getRules().add(ruleFactory.createRule("Node:SP1# >= 1 | Node:SP3# >= 1", 1.0));
        defaultNodes.add(PDGFB);
        // PDGFBB
        Node PDGFBB = nodeFactory.createNode("PDGFBB");
        PDGFBB.getRules().add(ruleFactory.createRule("Node:PDGFB# >= 1", 1.0));
        defaultNodes.add(PDGFBB);
        // PDGFRA
        Node PDGFRA = nodeFactory.createNode("PDGFRA");
        PDGFRA.getRules().add(ruleFactory.createRule("(Node:PDGFAA# >= 1 | Node:PDGFAB# >= 1 | Node:PDGFBB# >= 1) & "
                + "Node:CBL# == 0", 1.0));
        defaultNodes.add(PDGFRA);
        // PDGFRB
        Node PDGFRB = nodeFactory.createNode("PDGFRB");
        PDGFRB.getRules().add(ruleFactory.createRule("(Node:PDGFAB# >= 1 | Node:PDGFBB# >= 1) & Node:CBL# == 0", 1.0));
        defaultNodes.add(PDGFRB);
        // PDPK1
        Node PDPK1 = nodeFactory.createNode("PDPK1");
        PDPK1.getRules().add(ruleFactory.createRule("Node:PI34P# >= 0.5 | Node:PI345P# >= 0.5", 1.0));
        defaultNodes.add(PDPK1);
        // PDYN
        Node PDYN = nodeFactory.createNode("PDYN");

        defaultNodes.add(PDYN);
        // PECAM1
        Node PECAM1 = nodeFactory.createNode("PECAM1");
        
        defaultNodes.add(PECAM1);
        // PELI1
        Node PELI1 = nodeFactory.createNode("PELI1");
        PELI1.getRules().add(ruleFactory.createRule("Node:IRAK4# >= 1 | Node:IRAK1# >= 1", 1.0));
        defaultNodes.add(PELI1);
        // PELI2
        Node PELI2 = nodeFactory.createNode("PELI2");
        PELI2.getRules().add(ruleFactory.createRule("Node:IRAK4# >= 1 | Node:IRAK1# >= 1", 1.0));
        defaultNodes.add(PELI2);
        // PELI3
        Node PELI3 = nodeFactory.createNode("PELI3");
        PELI3.getRules().add(ruleFactory.createRule("Node:IRAK4# >= 1 | Node:IRAK1# >= 1", 1.0));
        defaultNodes.add(PELI3);
        // PFN1
        Node PFN1 = nodeFactory.createNode("PFN1");
        PFN1.getRules().add(ruleFactory.createRule("Node:DIAPH1# >= 1", 1.0));
        defaultNodes.add(PFN1);
        // PI3K
        Node PI3K = nodeFactory.createNode("PI3K");
        PI3K.getRules().add(ruleFactory.createRule("Node:RAS# >= 1 | Node:CCR3# >= 1 | Node:MET# >= 1 | "
                + "Node:CSF1R# >= 1 | Node:CBL# >= 1 | Node:GAB1# >= 1 | Node:GAB2# >= 1 | Node:KIT# >= 1 | "
                + "Node:IRS1# >= 1 | (Node:IFNGR# >= 1 & Node:JAK2# >= 1)", 1.0));
        defaultNodes.add(PI3K);
        // PIKFYVE
        Node PIKFYVE = nodeFactory.createNode("PIKFYVE");
        PIKFYVE.getRules().add(ruleFactory.createRule("Node:VAC14# >= 1", 1.0));
        defaultNodes.add(PIKFYVE);
        // PIM1
        Node PIM1 = nodeFactory.createNode("PIM1");
        PIM1.getRules().add(ruleFactory.createRule("Node:PP2A# == 0", 1.0));
        defaultNodes.add(PIM1);
        // PKA
        Node PKA = nodeFactory.createNode("PKA");
        PKA.getRules().add(ruleFactory.createRule("Node:cAMP# >= 2", 1.0));
        defaultNodes.add(PKA);
        // PKN1
        Node PKN1 = nodeFactory.createNode("PKN1");
        PKN1.getRules().add(ruleFactory.createRule("Node:PDPK1# >= 1 | Node:RHOA# >= 1 | Node:CDC42# >= 1 | "
                + "Node:RAC1# >= 1", 1.0));
        defaultNodes.add(PKN1);
        // PKN2
        Node PKN2 = nodeFactory.createNode("PKN2");
        PKN2.getRules().add(ruleFactory.createRule("Node:PDPK1# >= 1", 1.0));
        defaultNodes.add(PKN2);
        // PKN2_F
        Node PKN2_F = nodeFactory.createNode("PKN2_F");
        PKN2_F.getRules().add(ruleFactory.createRule("Node:PKN2# >= 1 & Node:CASP3# >= 1", 1.0));
        defaultNodes.add(PKN2_F);
        // PLA2G4A
        Node PLA2G4A = nodeFactory.createNode("PLA2G4A");
        PLA2G4A.getRules().add(ruleFactory.createRule("Node:Ca_c# >= 1 | Node:ERK2# >= 1 | Node:MAPK14# >= 1", 1.0));
        defaultNodes.add(PLA2G4A);
        // PLA2G4C
        Node PLA2G4C = nodeFactory.createNode("PLA2G4C");
        PLA2G4C.getRules().add(ruleFactory.createRule("Node:Ca_c# >= 1 | Node:ERK2# >= 1 | Node:MAPK14# >= 1", 1.0));
        defaultNodes.add(PLA2G4C);
        // PLCB2
        Node PLCB2 = nodeFactory.createNode("PLCB2");
        PLCB2.getRules().add(ruleFactory.createRule("Node:CCR3# >= 1", 1.0));
        defaultNodes.add(PLCB2);
        // PLCG1
        Node PLCG1 = nodeFactory.createNode("PLCG1");
        PLCG1.getRules().add(ruleFactory.createRule("Node:MET# >= 1 | Node:CD22# >= 1 | Node:GRB2# >= 1 | "
                + "Node:SOS1# >= 1 | Node:SOS2# >= 1", 1.0));
        defaultNodes.add(PLCG1);
        // PLCG2
        Node PLCG2 = nodeFactory.createNode("PLCG2");
        PLCG2.getRules().add(ruleFactory.createRule("Node:CSF1R# >= 1", 1.0));
        defaultNodes.add(PLCG2);
        // PLN
        Node PLN = nodeFactory.createNode("PLN");

        defaultNodes.add(PLN);
        // PME1
        Node PME1 = nodeFactory.createNode("PME1");
        
        defaultNodes.add(PME1);
        // POU2F1
        Node POU2F1 = nodeFactory.createNode("POU2F1");
        
        defaultNodes.add(POU2F1);
        // PP1
        Node PP1 = nodeFactory.createNode("PP1");
        
        defaultNodes.add(PP1);
        // PP2A
        Node PP2A = nodeFactory.createPP2A();
        PP2A.getRules().add(ruleFactory.createModificationRule("Node:LCMT1# >= 1 & Node:Ceramide# >= 2", "PPP2R2", 1.0));
        PP2A.getRules().add(ruleFactory.createModificationRule("Node:Ceramide# >= 2 & Node:PRKCA# == 0", "PPP2R5", 1.0));
        PP2A.getRules().add(ruleFactory.createModificationRule("Node:PME1# >= 1", "PPP2R2", 1.0));
        PP2A.getRules().add(ruleFactory.createRule("Node:PTPA# >= 1 & Node:PME1# == 0 & Node:TIP# == 0 & "
                + "Node:ANP32A# == 0 & Node:SET# == 0 & Node:CIP2A# == 0", 1.0));
        defaultNodes.add(PP2A);
        // PP2B
        Node PP2B = nodeFactory.createNode("PP2B");
        PP2B.getRules().add(ruleFactory.createRule("(Node:Ca_c# >= 2 | Node:CALM1# >= 1) & (Node:BCL2# == 0 & "
                + "Node:ATP2B4# == 0)", 1.0));
        defaultNodes.add(PP2B);
        // PPM1D
        Node PPM1D = nodeFactory.createNode("PPM1D");
        PPM1D.getRules().add(ruleFactory.createRule("Node:TP53# >= 1", 1.0));
        defaultNodes.add(PPM1D);
        // PPP1CB
        Node PPP1CB = nodeFactory.createNode("PPP1CB");
        PPP1CB.getRules().add(ruleFactory.createRule("Node:PPP1R12A# >= 1", 1.0));
        defaultNodes.add(PPP1CB);
        // PPP1R12A
        Node PPP1R12A = nodeFactory.createNode("PPP1R12A");

        defaultNodes.add(PPP1R12A);
        // PPP1R13B
        Node PPP1R13B = nodeFactory.createNode("PPP1R13B");
        PPP1R13B.getRules().add(ruleFactory.createRule("Node:E2F1# >= 1", 1.0));
        defaultNodes.add(PPP1R13B);
        // PRKCA
        Node PRKCA = nodeFactory.createNode("PRKCA");
        PRKCA.getRules().add(ruleFactory.createRule("(Node:DAG# > 2 | Node:PDPK1# >= 1) & Node:PP2A# == 0", 1.0));
        defaultNodes.add(PRKCA);
        // PRKCB
        Node PRKCB = nodeFactory.createNode("PRKCB");
        PRKCB.getRules().add(ruleFactory.createRule("Node:PDPK1# >= 1", 1.0));
        defaultNodes.add(PRKCB);
        // PRKCD
        Node PRKCD = nodeFactory.createNode("PRKCD");
        PRKCD.getRules().add(ruleFactory.createRule("Node:PDPK1# >= 1 & Node:PKN2_F# == 0", 1.0));
        defaultNodes.add(PRKCD);
        // PRKCE
        Node PRKCE = nodeFactory.createNode("PRKCE");
        PRKCE.getRules().add(ruleFactory.createRule("Node:PDPK1# >= 1", 1.0));
        defaultNodes.add(PRKCE);
        // PRKCH
        Node PRKCH = nodeFactory.createNode("PRKCH");
        PRKCH.getRules().add(ruleFactory.createRule("Node:PDPK1# >= 1", 1.0));
        defaultNodes.add(PRKCH);
        // PRKCZ
        Node PRKCZ = nodeFactory.createNode("PRKCZ");
        PRKCZ.getRules().add(ruleFactory.createRule("(Node:AKT1# >= 1 | Node:PDPK1# >= 1 | Node:AGER# >= 1) & "
                + "Node:PKN2_F# == 0", 1.0));
        defaultNodes.add(PRKCZ);
        // PRKD1
        Node PRKD1 = nodeFactory.createNode("PRKD1");
        PRKD1.getRules().add(ruleFactory.createRule("Node:PRKCE# >= 1", 1.0));
        defaultNodes.add(PRKD1);
        // PRKDC
        Node PRKDC = nodeFactory.createNode("PRKDC");
        PRKDC.getRules().add(ruleFactory.createRule("Node:DNADamage# >= 1 | Node:AKT1# >= 1", 1.0));
        defaultNodes.add(PRKDC);
        // PTEN
        Node PTEN = nodeFactory.createNode("PTEN");
        PTEN.getRules().add(ruleFactory.createRule("(Node:TP53# >= 1 & "
                + "(Mod:TP53#Ser15; == 1.0 | Mod:TP53#Ser20; == 1.0 | Mod:TP53#Ser37; == 1.0))", 1.0));
        defaultNodes.add(PTEN);
        // PTK2
        Node PTK2 = nodeFactory.createNode("PTK2");
        PTK2.getRules().add(ruleFactory.createRule("Node:SRC# >= 1", 1.0));
        defaultNodes.add(PTK2);
        // PTPA
        Node PTPA = nodeFactory.createNode("PTPA");
        
        defaultNodes.add(PTPA);
        // PTPN11
        Node PTPN11 = nodeFactory.createNode("PTPN11");
        PTPN11.getRules().add(ruleFactory.createRule("Node:KLRG1# >= 1 | Node:EPOR# >= 1 | Node:GAB1# >= 1 | "
                + "Node:GAB2# >= 1 | Node:IL4R# >= 1", 1.0));
        defaultNodes.add(PTPN11);
        // PTPN6
        Node PTPN6 = nodeFactory.createNode("PTPN6");
        PTPN6.getRules().add(ruleFactory.createRule("Node:CD22# >= 1 | Node:CD300LF# >= 1 | Node:IL4R# >= 1", 1.0));
        defaultNodes.add(PTPN6);
        // PUMA
        Node PUMA = nodeFactory.createNode("PUMA");
        PUMA.getRules().add(ruleFactory.createRule("((Node:TP53# >= 1 & (Mod:TP53#Lys120; == 1.0 | Mod:TP53#Ser46; == 1.0)) & "
                + "Node:KAT5# >= 1) & Node:BCL2# == 0 & Node:BCLXL# == 0", 1.0));
        defaultNodes.add(PUMA);
        // PURA
        Node PURA = nodeFactory.createNode("PURA");
        
        defaultNodes.add(PURA);
        // PURB
        Node PURB = nodeFactory.createNode("PURB");
        
        defaultNodes.add(PURB);
        // ProCASP10
        Node ProCASP10 = nodeFactory.createNode("ProCASP10");
        ProCASP10.setRestingStatus(1.0);
        
        defaultNodes.add(ProCASP10);
        // ProCASP8
        Node ProCASP8 = nodeFactory.createNode("ProCASP8");
        //ProCASP8.getRules().add(ruleFactory.createRule("(Node:RIPK1# >= 1 & Mod:RIPK1#ComplexII; == 1.0)", 1.0));
        defaultNodes.add(ProCASP8);
        // ProCASP9
        Node ProCASP9 = nodeFactory.createNode("ProCASP9");
        ProCASP9.setRestingStatus(1.0);
        
        defaultNodes.add(ProCASP9);
        // RAC1
        Node RAC1 = nodeFactory.createNode("RAC1");
        RAC1.getRules().add(ruleFactory.createRule("Node:RAC1# == 0 & ((Node:ELMO1# >= 1 & Node:DOCK1# >= 1) "
                + "| Node:TIAM1# >= 1 | Node:VAV1# >= 1 | Node:VAV2# >= 1 | Node:DIAPH1# >= 1)", 1.0));
        defaultNodes.add(RAC1);
        // RAC2
        Node RAC2 = nodeFactory.createNode("RAC2");
        RAC2.getRules().add(ruleFactory.createRule("Node:RAC2# == 0 & (Node:VAV1# >= 1)", 1.0));
        defaultNodes.add(RAC2);
        // RAF1
        Node RAF1 = nodeFactory.createNode("RAF1");
        RAF1.getRules().add(ruleFactory.createRule("Node:RAS# >= 1 | Node:PRKCA# >= 1", 1.0));
        defaultNodes.add(RAF1);
        // RAP1A
        Node RAP1A = nodeFactory.createNode("RAP1A");
        RAP1A.getRules().add(ruleFactory.createRule("Node:RAP1A# == 0 & (Node:RAPGEF3# >= 1 | Node:RAPGEF1# >= 1)", 1.0));
        defaultNodes.add(RAP1A);
        // RAP2A
        Node RAP2A = nodeFactory.createNode("RAP2A");
        RAP2A.getRules().add(ruleFactory.createRule("Node:RAP2A# == 0 & (Node:RAPGEF3# >= 1 | Node:RAPGEF1# >= 1)", 1.0));
        defaultNodes.add(RAP2A);
        // RAPGEF1
        Node RAPGEF1 = nodeFactory.createNode("RAPGEF1");
        RAPGEF1.getRules().add(ruleFactory.createRule("Node:CRK# >= 1 | Node:GRB2# >= 1", 1.0));
        defaultNodes.add(RAPGEF1);
        // RAPGEF3
        Node RAPGEF3 = nodeFactory.createNode("RAPGEF3");
        RAPGEF3.getRules().add(ruleFactory.createRule("Node:cAMP# >= 2", 1.0));
        defaultNodes.add(RAPGEF3);
        // RAS
        Node RAS = nodeFactory.createNode("RAS");
        RAS.getRules().add(ruleFactory.createRule("Node:RAS# == 0 & ((Node:SOS1# >= 1 | Node:TIAM1# >= 1) & Node:NF1# == 0)", 1.0));
        defaultNodes.add(RAS);
        // RASA1
        Node RASA1 = nodeFactory.createNode("RASA1");
        RASA1.getRules().add(ruleFactory.createRule("(Node:CSF1R# >= 1 | (Node:DOK2# >= 1 & Node:INPP5D# == 0)) & "
                + "Node:DOK1# == 0", 1.0));
        defaultNodes.add(RASA1);
        // RASSF1
        Node RASSF1 = nodeFactory.createNode("RASSF1");
        RASSF1.getRules().add(ruleFactory.createRule("Node:ATP2B4# >= 1", 1.0));
        defaultNodes.add(RASSF1);
        // RHOA
        Node RHOA = nodeFactory.createNode("RHOA");
        RHOA.getRules().add(ruleFactory.createRule("Node:RHOA# == 0 & (Node:VAV1# >= 1 | Node:VAV2# >= 1 | "
                + "Node:AGER# >= 1)", 1.0));
        defaultNodes.add(RHOA);
        // RHOG
        Node RHOG = nodeFactory.createNode("RHOG");
        RHOG.getRules().add(ruleFactory.createRule("Node:RHOG# == 0 & (Node:VAV1# >= 1)", 1.0));
        defaultNodes.add(RHOG);
        // RIPK1
        Node RIPK1 = nodeFactory.createRIPK1();
        RIPK1.getRules().add(ruleFactory.createModificationRule("Node:CYLD# >= 1 | (Node:BIRC2# == 0 & Node:BIRC3# == 0)", "ComplexII", 1.0));
        RIPK1.getRules().add(ruleFactory.createModificationRule("(Node:BIRC2# >= 1 | Node:BIRC3# >= 1) & Node:CYLD# == 0", "ComplexI", 1.0));

        RIPK1.getRules().add(ruleFactory.createRule("(Node:PIDD1# >= 1 | Node:TNFRSF1A# >= 1 | Node:TRADD# >= 1) & Node:CASP8# == 0", 1.0));
        defaultNodes.add(RIPK1);
        // RIPK2
        Node RIPK2 = nodeFactory.createNode("RIPK2");
        RIPK2.getRules().add(ruleFactory.createRule("Node:NODosome# >= 1 & (Node:BIRC2# >= 1 | Node:BIRC3# >= 1)", 1.0));
        defaultNodes.add(RIPK2);
        // RND3
        Node RND3 = nodeFactory.createNode("RND3");

        defaultNodes.add(RND3);
        // RNF168
        Node RNF168 = nodeFactory.createNode("RNF168");
        RNF168.getRules().add(ruleFactory.createRule("Node:H1# >= 1", 1.0));
        defaultNodes.add(RNF168);
        // RNF8
        Node RNF8 = nodeFactory.createNode("RNF8");
        RNF8.getRules().add(ruleFactory.createRule("Node:MDC1# >= 1", 1.0));
        defaultNodes.add(RNF8);
        // ROCK1
        Node ROCK1 = nodeFactory.createNode("ROCK1");
        ROCK1.getRules().add(ruleFactory.createRule("Node:RHOA# >= 1 & Node:RND3# == 0", 1.0));
        defaultNodes.add(ROCK1);
        // ROCK2
        Node ROCK2 = nodeFactory.createNode("ROCK2");
        ROCK2.getRules().add(ruleFactory.createRule("Node:RHOA# >= 1", 1.0));
        defaultNodes.add(ROCK2);
        // S6K1
        Node S6K1 = nodeFactory.createNode("S6K1");
        S6K1.getRules().add(ruleFactory.createRule("Node:PDPK1# >= 1 | Node:mTORC1# >= 1", 1.0));
        defaultNodes.add(S6K1);
        // RYR1
        Node RYR1 = nodeFactory.createNode("RYR1");
        RYR1.getRules().add(ruleFactory.createRule("(Node:Ca_c# >= 1 | Node:Ca_er# == 4 | Node:HOMER1# >= 1 | "
                + "Node:NitricOxide# >= 2) & Node:CAMK2# >= 1 & Node:Ca_c# < 3 & Node:FKBP1A# == 0 & "
                + "Node:FKBP1B# == 0", 2.0));
        RYR1.getRules().add(ruleFactory.createRule("(Node:Ca_c# >= 1 | Node:Ca_er# == 4 | Node:HOMER1# >= 1 | "
                + "Node:NitricOxide# >= 2) & Node:Ca_c# < 3 & Node:FKBP1A# == 0 & Node:FKBP1B# == 0", 1.0));
        defaultNodes.add(RYR1);
        // RYR2
        Node RYR2 = nodeFactory.createNode("RYR2");
        RYR2.getRules().add(ruleFactory.createRule("(Node:Ca_c# >= 1 | Node:Ca_er# == 4 | Node:NitricOxide# >= 2) & "
                + "(Node:CAMK2# >= 1 | Node:PKA# >= 1) & Node:Ca_c# < 3 & Node:HOMER1# == 0 & Node:FKBP1A# == 0 & "
                + "Node:FKBP1B# == 0", 2.0));
        RYR2.getRules().add(ruleFactory.createRule("(Node:Ca_c# >= 1 | Node:Ca_er# == 4 | Node:NitricOxide# >= 2) & "
                + "Node:Ca_c# < 3 & Node:HOMER1# == 0 & Node:FKBP1A# == 0 & Node:FKBP1B# == 0", 1.0));
        defaultNodes.add(RYR2);
        // RYR3
        Node RYR3 = nodeFactory.createNode("RYR3");
        RYR3.getRules().add(ruleFactory.createRule("(Node:Ca_c# >= 1 | Node:Ca_er# == 4 | Node:NitricOxide# >= 2) & "
                + "Node:Ca_c# < 3 & Node:FKBP1A# == 0 & Node:FKBP1B# == 0", 1.0));
        defaultNodes.add(RYR3);
        // Rb
        Node Rb = nodeFactory.createNode("Rb");
        Rb.setRestingStatus(1.0);
        Rb.getRules().add(ruleFactory.createRule("Node:CDK4_6# >= 1 | Node:CDK2# >= 1 | Node:SIRT1# >= 1", 0.0));
        defaultNodes.add(Rb);
        // S100A1
        Node S100A1 = nodeFactory.createNode("S100A1");
        
        defaultNodes.add(S100A1);
        // SET
        Node SET = nodeFactory.createNode("SET");
        SET.getRules().add(ruleFactory.createRule("Node:PI3K# >= 1 & Node:Ceramide# < 2", 1.0));
        defaultNodes.add(SET);
        // SGK1
        Node SGK1 = nodeFactory.createNode("SGK1");
        SGK1.getRules().add(ruleFactory.createRule("Node:mTORC2# >= 1 & Node:PDPK1# >= 1", 1.0));
        defaultNodes.add(SGK1);
        // SGK2
        Node SGK2 = nodeFactory.createNode("SGK2");
        SGK2.getRules().add(ruleFactory.createRule("Node:mTORC2# >= 1 & Node:PDPK1# >= 1", 1.0));
        defaultNodes.add(SGK2);
        // SGK3
        Node SGK3 = nodeFactory.createNode("SGK3");
        SGK3.getRules().add(ruleFactory.createRule("Node:mTORC2# >= 1 & Node:PDPK1# >= 1", 1.0));
        defaultNodes.add(SGK3);
        // SGMS1
        Node SGMS1 = nodeFactory.createNode("SGMS1");
        SGMS1.getRules().add(ruleFactory.createRule("Node:FOXP3# == 0", 1.0));
        defaultNodes.add(SGMS1);
        // SH3KBP1
        Node SH3KBP1 = nodeFactory.createNode("SH3KBP1");
        SH3KBP1.getRules().add(ruleFactory.createRule("Node:CBL# >= 1", 1.0));
        defaultNodes.add(SH3KBP1);
        // SHC1
        Node SHC1 = nodeFactory.createNode("SHC1");
        SHC1.getRules().add(ruleFactory.createRule("(Node:MET# >= 1 | Node:EPOR# >= 1 | Node:IL4R# >= 1 | "
                + "Node:CD22# >= 1 | Node:AGER# >= 1) & Node:INPP5D# == 0", 1.0));
        defaultNodes.add(SHC1);
        // SIAH1
        Node SIAH1 = nodeFactory.createNode("SIAH1");
        SIAH1.getRules().add(ruleFactory.createRule("Node:ATM# >= 1 | Node:ATR# >= 1", 1.0));
        defaultNodes.add(SIAH1);
        // SIAH2
        Node SIAH2 = nodeFactory.createNode("SIAH2");
        SIAH2.getRules().add(ruleFactory.createRule("Node:DYRK2# >= 1", 1.0));
        defaultNodes.add(SIAH2);
        // SIRT1
        Node SIRT1 = nodeFactory.createNode("SIRT1");
        SIRT1.getRules().add(ruleFactory.createRule("Node:E2F1# >= 1", 1.0));
        defaultNodes.add(SIRT1);
        // SLA2
        Node SLA2 = nodeFactory.createNode("SLA2");
        SLA2.getRules().add(ruleFactory.createRule("Node:CSF1R# >= 1", 1.0));
        defaultNodes.add(SLA2);
        // SLC24A1
        Node SLC24A1 = nodeFactory.createNode("SLC24A1");
        
        defaultNodes.add(SLC24A1);
        // SLC24A2
        Node SLC24A2 = nodeFactory.createNode("SLC24A2");
        
        defaultNodes.add(SLC24A2);
        // SLC8A1
        Node SLC8A1 = nodeFactory.createNode("SLC8A1");
        SLC8A1.getRules().add(ruleFactory.createRule("Node:Ca_c# >= 1 & Node:FXYD1# == 0", 1.0));
        defaultNodes.add(SLC8A1);
        // SLC8A1_n
        Node SLC8A1_n = nodeFactory.createNode("SLC8A1_n");
        SLC8A1_n.getRules().add(ruleFactory.createRule("(Node:GM1# >= 1 & Node:Ca_n# >= 1) & Node:FXYD1# == 0", 1.0));
        defaultNodes.add(SLC8A1_n);
        // SLC8A2
        Node SLC8A2 = nodeFactory.createNode("SLC8A2");
        
        defaultNodes.add(SLC8A2);
        // SLC8A2_n
        Node SLC8A2_n = nodeFactory.createNode("SLC8A2_n");
        SLC8A2_n.getRules().add(ruleFactory.createRule("Node:GM1# >= 1 & (Node:FXYD1# == 0)", 1.0));
        defaultNodes.add(SLC8A2_n);
        // SLC8A3
        Node SLC8A3 = nodeFactory.createNode("SLC8A3");

        defaultNodes.add(SLC8A3);
        // SLC8A3_n
        Node SLC8A3_n = nodeFactory.createNode("SLC8A3_n");
        SLC8A3_n.getRules().add(ruleFactory.createRule("Node:GM1# >= 1 & (Node:KCNIP3# == 0)", 1.0));
        defaultNodes.add(SLC8A3_n);
        // SLC8B1
        Node SLC8B1 = nodeFactory.createNode("SLC8B1");
        
        defaultNodes.add(SLC8B1);
        // SLN
        Node SLN = nodeFactory.createNode("SLN");
        
        defaultNodes.add(SLN);
        // SMPD1
        Node SMPD1 = nodeFactory.createNode("SMPD1");
        
        defaultNodes.add(SMPD1);
        // SOD1
        Node SOD1 = nodeFactory.createNode("SOD1");
        SOD1.setRestingStatus(1.0);
        
        defaultNodes.add(SOD1);
        // SOS1
        Node SOS1 = nodeFactory.createNode("SOS1");
        SOS1.getRules().add(ruleFactory.createRule("Node:GRB2# >= 1", 1.0));
        defaultNodes.add(SOS1);
        // SOS2
        Node SOS2 = nodeFactory.createNode("SOS2");
        
        defaultNodes.add(SOS2);
        // SP1
        Node SP1 = nodeFactory.createNode("SP1");
        
        defaultNodes.add(SP1);
        // SP3
        Node SP3 = nodeFactory.createNode("SP3");
        
        defaultNodes.add(SP3);
        // SRC
        Node SRC = nodeFactory.createNode("SRC");
        SRC.getRules().add(ruleFactory.createRule("Node:MET# >= 1 | Node:DCC# >= 1 | Node:FCER1G# >= 1 | "
                + "Node:AGER# >= 1", 1.0));
        defaultNodes.add(SRC);
        // STAT1
        Node STAT1 = nodeFactory.createNode("STAT1");
        STAT1.getRules().add(ruleFactory.createRule("Node:CSF1R# >= 1 | Node:JAK2# >= 1", 1.0));
        defaultNodes.add(STAT1);
        // STAT3
        Node STAT3 = nodeFactory.createNode("STAT3");
        STAT3.getRules().add(ruleFactory.createRule("(Node:HES1# >= 1 | Node:HES2# >= 1) & Node:JAK2# >= 1", 2.0));
        STAT3.getRules().add(ruleFactory.createRule("(Node:MET# >= 1 | Node:CSF1R# >= 1 | Node:JAK2# >= 1) | "
                + "Node:STAT3# == 2", 1.0));
        defaultNodes.add(STAT3);
        // STAT5
        Node STAT5 = nodeFactory.createNode("STAT5");
        STAT5.getRules().add(ruleFactory.createRule("Node:LYN# >= 1 | Node:JAK2# >= 1", 1.0));
        defaultNodes.add(STAT5);
        // STIM1
        Node STIM1 = nodeFactory.createNode("STIM1");
        STIM1.getRules().add(ruleFactory.createRule("Node:Ca_er# == 0", 1.0));
        defaultNodes.add(STIM1);
        // STIM2
        Node STIM2 = nodeFactory.createNode("STIM2");
        STIM2.getRules().add(ruleFactory.createRule("Node:Ca_er# == 0", 1.0));
        defaultNodes.add(STIM2);
        // SYK
        Node SYK = nodeFactory.createNode("SYK");
        SYK.getRules().add(ruleFactory.createRule("(Node:CD22# >= 1 | Node:FCER1G# >= 1) & Node:CBL# == 0", 1.0));
        defaultNodes.add(SYK);
        // Starvation
        Node Starvation = nodeFactory.createGeneralNode("Starvation");
        
        defaultNodes.add(Starvation);
        // Survivin
        Node Survivin = nodeFactory.createNode("Survivin");
        Survivin.setRestingStatus(1.0);
        Survivin.getRules().add(ruleFactory.createRule("Node:DIABLO# >= 1", 0.0));
        defaultNodes.add(Survivin);
        // TAB1
        Node TAB1 = nodeFactory.createNode("TAB1");
        TAB1.getRules().add(ruleFactory.createRule("Node:TRAF6# >= 1 & Node:MAPK14# == 0", 1.0));
        defaultNodes.add(TAB1);
        // TAB2
        Node TAB2 = nodeFactory.createNode("TAB2");
        TAB2.getRules().add(ruleFactory.createRule("(Node:RIPK1# >= 1 & Mod:RIPK1#ComplexI; == 1.0) | "
                + "Node:TRAF6# >= 1 | Node:IRAK1# >= 1", 1.0));
        defaultNodes.add(TAB2);
        // TAB3
        Node TAB3 = nodeFactory.createNode("TAB3");
        TAB3.getRules().add(ruleFactory.createRule("(Node:RIPK1# >= 1 & Mod:RIPK1#ComplexI; == 1.0) | "
                + "Node:TRAF6# >= 1 & Node:MAPK14# == 0", 1.0));
        defaultNodes.add(TAB3);
        // TEC
        Node TEC = nodeFactory.createNode("TEC");
        TEC.getRules().add(ruleFactory.createRule("Node:LYN# >= 1", 1.0));
        defaultNodes.add(TEC);
        // TERT
        Node TERT = nodeFactory.createNode("TERT");
        TERT.getRules().add(ruleFactory.createRule("(Node:CIB1# >= 1 | (Node:AKT1# >= 1 & Node:mTORC1# >= 1)) & "
                + "(Node:EDVPComplex# == 0 & Node:ABL1# == 0 & (Node:PP2A# == 0 | (Node:PP2A# >= 1 & "
                + "Mod:PP2A#PPP2R2; == 0.0) | Node:HSP90AA1# >= 1))", 1.0));
        defaultNodes.add(TERT);
        // TIAM1
        Node TIAM1 = nodeFactory.createNode("TIAM1");
        TIAM1.getRules().add(ruleFactory.createRule("Node:SRC# >= 1", 1.0));
        defaultNodes.add(TIAM1);
        // TIP
        Node TIP = nodeFactory.createNode("TIP");
        
        defaultNodes.add(TIP);
        // TP53BP1
        Node TP53BP1 = nodeFactory.createNode("TP53BP1");
        TP53BP1.getRules().add(ruleFactory.createRule("Node:RNF168# >= 1", 1.0));
        defaultNodes.add(TP53BP1);
        // TP53BP2
        Node TP53BP2 = nodeFactory.createNode("TP53BP2");
        TP53BP2.getRules().add(ruleFactory.createRule("Node:E2F1# >= 1", 1.0));
        defaultNodes.add(TP53BP2);
        // TP53I3
        Node TP53I3 = nodeFactory.createNode("TP53I3");
        TP53I3.getRules().add(ruleFactory.createRule("Node:TP53# >= 1", 1.0));
        defaultNodes.add(TP53I3);
        // TP53INP1
        Node TP53INP1 = nodeFactory.createNode("TP53INP1");
        TP53INP1.getRules().add(ruleFactory.createRule("(Node:PRKCD# >= 1 | Node:TP53# >= 1) & "
                + "Node:mir155# == 0", 1.0));
        defaultNodes.add(TP53INP1);
        // TP53INP2
        Node TP53INP2 = nodeFactory.createNode("TP53INP2");
        TP53INP2.getRules().add(ruleFactory.createRule("Node:VMP1# >= 1", 1.0));
        defaultNodes.add(TP53INP2);
        // TRAF6
        Node TRAF6 = nodeFactory.createNode("TRAF6");
        TRAF6.getRules().add(ruleFactory.createRule("Node:IRAK1# >= 1 | Node:IRAK2# >= 1 | Node:IRAK4# >= 1 | "
                + "Node:MYD88# >= 1 | Node:HSPB1# >= 1", 1.0));
        defaultNodes.add(TRAF6);
        // TRIM28
        Node TRIM28 = nodeFactory.createNode("TRIM28");
        TRIM28.getRules().add(ruleFactory.createRule("Node:ATM# >= 1", 1.0));
        defaultNodes.add(TRIM28);
        // TSC2
        Node TSC2 = nodeFactory.createNode("TSC2");
        TSC2.setRestingStatus(1.0);
        TSC2.getRules().add(ruleFactory.createRule("(Node:ERK1# >= 1 | Node:ERK2# >= 1 | Node:AKT1# >= 1) & "
                + "Node:AMPK# == 0 & Node:DDIT4# == 0", 0.0));
        defaultNodes.add(TSC2);
        // UBR5
        Node UBR5 = nodeFactory.createNode("UBR5");
        
        defaultNodes.add(UBR5);
        // UNC5A
        Node UNC5A = nodeFactory.createNode("UNC5A");
        UNC5A.getRules().add(ruleFactory.createRule("Node:NTN1# >= 1", 1.0));
        defaultNodes.add(UNC5A);
        // UNC5B
        Node UNC5B = nodeFactory.createNode("UNC5B");
        UNC5B.getRules().add(ruleFactory.createRule("Node:NTN1# >= 1", 1.0));
        defaultNodes.add(UNC5B);
        // UNC5C
        Node UNC5C = nodeFactory.createNode("UNC5C");
        UNC5C.getRules().add(ruleFactory.createRule("Node:NTN1# >= 1", 1.0));
        defaultNodes.add(UNC5C);
        // UNC5D
        Node UNC5D = nodeFactory.createNode("UNC5D");
        UNC5D.getRules().add(ruleFactory.createRule("Node:NTN1# >= 1", 1.0));
        defaultNodes.add(UNC5D);
        // VAC14
        Node VAC14 = nodeFactory.createNode("VAC14");
        
        defaultNodes.add(VAC14);
        // VAV1
        Node VAV1 = nodeFactory.createNode("VAV1");
        
        defaultNodes.add(VAV1);
        // VAV2
        Node VAV2 = nodeFactory.createNode("VAV2");
        VAV2.getRules().add(ruleFactory.createRule("Node:SRC# >= 1", 1.0));
        defaultNodes.add(VAV2);
        // VMP1
        Node VMP1 = nodeFactory.createNode("VMP1");
        
        defaultNodes.add(VMP1);
        // VRK1
        Node VRK1 = nodeFactory.createNode("VRK1");
        
        defaultNodes.add(VRK1);
        // WAS
        Node WAS = nodeFactory.createNode("WAS");
        WAS.getRules().add(ruleFactory.createRule("Node:HCK# >= 1 | Node:FYN# >= 1 | Node:CDC42# >= 1", 1.0));
        defaultNodes.add(WAS);
        // WASF1
        Node WASF1 = nodeFactory.createNode("WASF1");
        
        defaultNodes.add(WASF1);
        // WASL
        Node WASL = nodeFactory.createNode("WASL");
        WASL.getRules().add(ruleFactory.createRule("Node:CDC42# >= 1 | Node:PI45P# >= 0.5", 1.0));
        defaultNodes.add(WASL);
        // WIPF1
        Node WIPF1 = nodeFactory.createNode("WIPF1");
        WIPF1.getRules().add(ruleFactory.createRule("Node:HCK# >= 1", 1.0));
        defaultNodes.add(WIPF1);
        // XIAP
        Node XIAP = nodeFactory.createNode("XIAP");

        defaultNodes.add(XIAP);
        // YBX1
        Node YBX1 = nodeFactory.createNode("YBX1");

        defaultNodes.add(YBX1);
        // ZFP36
        Node ZFP36 = nodeFactory.createNode("ZFP36");
        ZFP36.getRules().add(ruleFactory.createRule("Node:MAPKAPK2# == 0", 1.0));
        defaultNodes.add(ZFP36);
        // mTORC1
        Node mTORC1 = nodeFactory.createNode("mTORC1");
        mTORC1.getRules().add(ruleFactory.createRule("(Node:AKT1# >= 1 | Node:MAP4K3# >= 1 | Node:RSK# >= 1) "
                + "& (Node:Rapamycin# == 0 & Node:AMPK# == 0 & (Node:TSC1# == 0 | Node:TSC2# == 0))", 1.0));
        defaultNodes.add(mTORC1);
        // mTORC2
        Node mTORC2 = nodeFactory.createNode("mTORC2");
        mTORC2.getRules().add(ruleFactory.createRule("Node:PI345P# >= 0.5", 1.0));
        defaultNodes.add(mTORC2);
        // mir155
        Node mir155 = nodeFactory.createMiRNA("mir155");
        
        defaultNodes.add(mir155);
        // EP300
        Node EP300 = nodeFactory.createMiRNA("EP300");
        EP300.getRules().add(ruleFactory.createRule("(Node:ATM# >= 1 | Node:AKT1# >= 1) & Node:SIRT1# == 0", 1.0));
        defaultNodes.add(EP300);
        // MAPK14 (p38)
        Node MAPK14 = nodeFactory.createNode("MAPK14");
        MAPK14.getRules().add(ruleFactory.createRule("(Node:MAP2K3# >= 1 | Node:MAP2K4# >= 1 | Node:MAP2K6# >= 1 | "
                + "Node:MAP2K7# >= 1 | Node:Superoxide# >= 2) & Node:PPM1D# == 0 & Node:DUSP1# == 0", 1.0));
        defaultNodes.add(MAPK14);
        // TP53
        Node TP53 = nodeFactory.createP53();
        TP53.getRules().add(ruleFactory.createModificationRule("Node:ATM# >= 1 | Node:ATR# >= 1 | Node:PRKDC# >= 1 | Node:AMPK# >= 1 | "
                + "Node:TP53RK# >= 1 | Node:mTORC1# >= 1 | Node:STK11# >= 1", "Ser15", 1.0));
        TP53.getRules().add(ruleFactory.createModificationRule("Node:VRK1# >= 1", "Thr18", 1.0));
        TP53.getRules().add(ruleFactory.createModificationRule("Node:CHEK1# >= 1 | Node:CHEK2# >= 1", "Ser20", 1.0));
        TP53.getRules().add(ruleFactory.createModificationRule("Node:MAPK14# >= 1 | Node:GSK3B# >= 1", "Ser33", 1.0));
        TP53.getRules().add(ruleFactory.createModificationRule("Node:MAPK14# >= 1 | Node:ATR# >= 1", "Ser37", 1.0));
        TP53.getRules().add(ruleFactory.createModificationRule("Node:MAPK14# >= 1 | (Node:TP53INP1# >= 1 & (Node:CBX4# >= 1 | Node:PIAS3# >= 1)) | Node:DYRK2# >= 1", "Ser46", 1.0));
        TP53.getRules().add(ruleFactory.createModificationRule("Node:KAT5# >= 1", "Lys120", 1.0));
        TP53.getRules().add(ruleFactory.createModificationRule("Node:CBP# >= 1 | (Node:EP300# >= 1 & Node:MDM2# == 0)", "Lys164", 1.0));
        TP53.getRules().add(ruleFactory.createModificationRule("Node:CBP# >= 1 | (Node:EP300# >= 1 & Node:MDM2# == 0)", "Lys305", 1.0));
        TP53.getRules().add(ruleFactory.createModificationRule("Node:PCAF# >= 1", "Lys320", 1.0));
        TP53.getRules().add(ruleFactory.createModificationRule("Node:PP1# >= 1 | Node:PPM1D# >= 1", "Ser15", 0.0));
        TP53.getRules().add(ruleFactory.createModificationRule("Node:PP1# >= 1 | Node:PP2A# >= 1", "Ser37", 0.0));
        TP53.getRules().add(ruleFactory.createModificationRule("Node:NuRDComplex# >= 1", "Lys120", 0.0));
        TP53.getRules().add(ruleFactory.createModificationRule("Node:NuRDComplex# >= 1", "Lys164", 0.0));
        TP53.getRules().add(ruleFactory.createModificationRule("Node:NuRDComplex# >= 1", "Lys305", 0.0));
        TP53.getRules().add(ruleFactory.createModificationRule("Node:NuRDComplex# >= 1", "Lys320", 0.0));

        TP53.getRules().add(ruleFactory.createRule("((Mod:TP53#Ser15; == 1.0 | Mod:TP53#Thr18; == 1.0 | "
                + "Mod:TP53#Ser20; == 1.0 | Mod:TP53#Ser33; == 1.0 | Mod:TP53#Ser37; == 1.0 | Mod:TP53#Ser46; == 1.0) & "
                + "(Node:MDM2# == 0 | (Node:mTORC1# >= 1 | Node:mTORC2# >= 1))) | (Mod:TP53#Thr18; == 1.0 & Node:MDM2# >= 1) | (Mod:TP53#Ser15; == 1.0 & Mod:TP53#Thr18; == 1.0 & "
                + "Mod:TP53#Ser20; == 1.0 & Mod:TP53#Ser33; == 1.0 & Mod:TP53#Ser37; == 1.0 & Mod:TP53#Ser46; == 1.0 & "
                + "Node:MDM2# >= 1) | ((Mod:TP53#Lys120; == 1.0 | Mod:TP53#Lys164; == 1.0 | Mod:TP53#Lys305; == 1.0 | "
                + "Mod:TP53#Lys320; == 1.0) & (Node:MDM2# == 0 | (Node:mTORC1# >= 1 | Node:mTORC2# >= 1)))", 1.0));
        defaultNodes.add(TP53);
        // sIL1R1
        Node sIL1R1 = nodeFactory.createNode("sIL1R1");
        
        defaultNodes.add(sIL1R1);
        // sIL1R2
        Node sIL1R2 = nodeFactory.createNode("sIL1R2");
        
        defaultNodes.add(sIL1R2);
        // sIL1RAP
        Node sIL1RAP = nodeFactory.createNode("sIL1RAP");
        
        defaultNodes.add(sIL1RAP);
        // tBID
        Node tBID = nodeFactory.createNode("tBID");
        tBID.getRules().add(ruleFactory.createRule("(Node:CASP2# >= 1 | Node:CASP8# >= 1 | Node:CASP10# >= 1) & "
                + "Node:BID# >= 1 & (Node:BCLXL# == 0 & Node:BCL2# == 0 & Node:BCL2L2# == 0 & Node:MCL1# == 0 & "
                + "Node:BCL2A1# == 0)", 1.0));
        defaultNodes.add(tBID);
        // Apigenin
        Node Apigenin = nodeFactory.createDrug("Apigenin");
        
        defaultNodes.add(Apigenin);
        // SSB
        Node SSB = nodeFactory.createNode("SSB");
        
        defaultNodes.add(SSB);
        // CBX4
        Node CBX4 = nodeFactory.createNode("CBX4");
        CBX4.getRules().add(ruleFactory.createRule("Node:Superoxide# > 1", 1.0));
        defaultNodes.add(CBX4);
        // PIAS3
        Node PIAS3 = nodeFactory.createNode("PIAS3");
        PIAS3.getRules().add(ruleFactory.createRule("Node:Superoxide# > 1", 1.0));
        defaultNodes.add(PIAS3);
        // CDC25A
        Node CDC25A = nodeFactory.createNode("CDC25A");

        defaultNodes.add(CDC25A);
        // CDC25B
        Node CDC25B = nodeFactory.createNode("CDC25B");

        defaultNodes.add(CDC25B);
        // CDC25C
        Node CDC25C = nodeFactory.createNode("CDC25C");
        CDC25C.getRules().add(ruleFactory.createRule("(Node:MitosisStimule# >= 1 | Node:CDK1# >= 1) & "
                + "(Node:MAPK14# == 0 & Node:CHEK1# == 0)", 1.0));
        defaultNodes.add(CDC25C);
        // CDK1
        Node CDK1 = nodeFactory.createNode("CDK1");
        CDK1.getRules().add(ruleFactory.createRule("Node:CDC25C# >= 1 | Node:WEE1# == 0", 1.0));
        defaultNodes.add(CDK1);
        // CCND
        Node CCND = nodeFactory.createNode("CCND");
        CCND.getRules().add(ruleFactory.createRule("Node:CDK4_6# >= 1 & Node:CDKN2A# == 0", 1.0));
        defaultNodes.add(CCND);
        // CCNE
        Node CCNE = nodeFactory.createNode("CCNE");
        CCNE.getRules().add(ruleFactory.createRule("Node:E2F1# >= 1", 1.0));
        defaultNodes.add(CCNE);
        // CCNA
        Node CCNA = nodeFactory.createNode("CCNA");
        CCNA.getRules().add(ruleFactory.createRule("Node:E2F1# >= 1", 1.0));
        defaultNodes.add(CCNA);
        // DNAReplication
        Node DNAReplication = nodeFactory.createGeneralNode("DNAReplication");
        DNAReplication.getRules().add(ruleFactory.createRule("Node:CDK2# >= 1 & Node:CCNA# >= 1", 1.0));
        defaultNodes.add(DNAReplication);
        // WEE1
        Node WEE1 = nodeFactory.createNode("WEE1", 1.0);
        WEE1.setRestingStatus(1.0);
        WEE1.getRules().add(ruleFactory.createRule("Node:CDK1# == 0", 0.0));
        defaultNodes.add(WEE1);
        // HIF1
        Node HIF1 = nodeFactory.createNode("HIF1");
        HIF1.getRules().add(ruleFactory.createRule("(Node:Hypoxia# >= 1) & Node:CDKN2A# == 0", 1.0));
        defaultNodes.add(HIF1);
        // PSMC3
        Node PSMC3 = nodeFactory.createNode("PSMC3");
        
        defaultNodes.add(PSMC3);
        // HMGB1
        Node HMGB1 = nodeFactory.createNode("HMGB1");
        
        defaultNodes.add(HMGB1);
        // AGER
        Node AGER = nodeFactory.createNode("AGER");
        AGER.getRules().add(ruleFactory.createRule("(Node:AGE# >= 1 | Node:HMGB1# >= 1 | Node:S100A1# >= 1 | "
                + "Node:S100B# >= 1 | Node:S100P# >= 1 | Node:ITGAM# >= 1) & Node:Canonical_NFKB# >= 1", 2.0));
        AGER.getRules().add(ruleFactory.createRule("Node:AGE# >= 1 | Node:HMGB1# >= 1 | Node:S100A1# >= 1 | "
                + "Node:S100B# >= 1 | Node:S100P# >= 1 | Node:ITGAM# >= 1", 1.0));
        defaultNodes.add(AGER);
        // S100B
        Node S100B = nodeFactory.createNode("S100B");
        
        defaultNodes.add(S100B);
        // S100P
        Node S100P = nodeFactory.createNode("S100P");
        
        defaultNodes.add(S100P);
        // CD36
        Node CD36 = nodeFactory.createNode("CD36");
        CD36.getRules().add(ruleFactory.createRule("Node:AGE# >= 1", 1.0));
        defaultNodes.add(CD36);
        // ITGAM
        Node ITGAM = nodeFactory.createNode("ITGAM");
        
        defaultNodes.add(ITGAM);
        // CTLA4
        Node CTLA4 = nodeFactory.createNode("CTLA4");
        CTLA4.getRules().add(ruleFactory.createRule("Node:JAK2# >= 1", 1.0));
        defaultNodes.add(CTLA4);
        // IL12R
        Node IL12R = nodeFactory.createNode("IL12R");
        
        defaultNodes.add(IL12R);
        // AGT
        Node AGT = nodeFactory.createNode("AGT");
        
        defaultNodes.add(AGT);
        // AGTR1
        Node AGTR1 = nodeFactory.createNode("AGTR1");
        AGTR1.getRules().add(ruleFactory.createRule("Node:AGT# >= 1", 1.0));
        defaultNodes.add(AGTR1);
        // BRCA1
        Node BRCA1 = nodeFactory.createNode("BRCA1");
        BRCA1.getRules().add(ruleFactory.createRule("Node:ATM# >= 1 | Node:AKT1# >= 1", 1.0));
        defaultNodes.add(BRCA1);
        // CRLF2
        Node CRLF2 = nodeFactory.createNode("CRLF2");
        
        defaultNodes.add(CRLF2);
        // CSF2
        Node CSF2 = nodeFactory.createNode("CSF2");
        
        defaultNodes.add(CSF2);
        // JAK3
        Node JAK3 = nodeFactory.createNode("JAK3");
        JAK3.getRules().add(ruleFactory.createRule("Node:CXCR4# >= 1 | Node:GHR# >= 1", 1.0));
        defaultNodes.add(JAK3);
        // ERBB2
        Node ERBB2 = nodeFactory.createNode("ERBB2");
        
        defaultNodes.add(ERBB2);
        // FES
        Node FES = nodeFactory.createNode("FES");
        FES.getRules().add(ruleFactory.createRule("Node:JAK2# >= 1", 1.0));
        defaultNodes.add(FES);
        // GHR
        Node GHR = nodeFactory.createNode("GHR");
        GHR.getRules().add(ruleFactory.createRule("Node:GH1# >= 1", 1.0));
        defaultNodes.add(GHR);
        // TYK2
        Node TYK2 = nodeFactory.createNode("TYK2");
        TYK2.getRules().add(ruleFactory.createRule("Node:GHR# >= 1 | Node:IL23R# >= 1 | Node:IL13R# >= 1 | "
                + "Node:IL4R# >= 1", 1.0));
        defaultNodes.add(TYK2);
        // GH1
        Node GH1 = nodeFactory.createNode("GH1");
        
        defaultNodes.add(GH1);
        // HES1
        Node HES1 = nodeFactory.createNode("HES1");
        
        defaultNodes.add(HES1);
        // HES2
        Node HES2 = nodeFactory.createNode("HES2");
        
        defaultNodes.add(HES2);
        // HTR2A
        Node HTR2A = nodeFactory.createNode("HTR2A");
        
        defaultNodes.add(HTR2A);
        // PLCB1
        Node PLCB1 = nodeFactory.createNode("PLCB1");
        PLCB1.getRules().add(ruleFactory.createRule("Node:HTR2A# >= 1", 1.0));
        defaultNodes.add(PLCB1);
        // IFNGR
        Node IFNGR = nodeFactory.createNode("IFNGR");
        
        defaultNodes.add(IFNGR);
        // IGF1R
        Node IGF1R = nodeFactory.createNode("IGF1R");
        IGF1R.getRules().add(ruleFactory.createRule("Node:IGF1# >= 1", 1.0));
        defaultNodes.add(IGF1R);
        // SOCS1
        Node SOCS1 = nodeFactory.createNode("SOCS1");
        SOCS1.getRules().add(ruleFactory.createRule("Node:IRF1# >= 1", 1.0));
        defaultNodes.add(SOCS1);
        // IRF1
        Node IRF1 = nodeFactory.createNode("IRF1");
        IRF1.getRules().add(ruleFactory.createRule("Node:STAT1# >= 1", 1.0));
        defaultNodes.add(IRF1);
        // IL23R
        Node IL23R = nodeFactory.createNode("IL23R");
        
        defaultNodes.add(IL23R);
        // IL3R
        Node IL3R = nodeFactory.createNode("IL3R");
        
        defaultNodes.add(IL3R);
        // IL13R
        Node IL13R = nodeFactory.createNode("IL13R");
        IL13R.getRules().add(ruleFactory.createRule("Node:IL13# >= 1", 1.0));
        defaultNodes.add(IL13R);
        // IL5R
        Node IL5R = nodeFactory.createNode("IL5R");
        
        defaultNodes.add(IL5R);
        // INSR
        Node INSR = nodeFactory.createNode("INSR");
        
        defaultNodes.add(INSR);
        // TIRAP
        Node TIRAP = nodeFactory.createNode("TIRAP");
        TIRAP.getRules().add(ruleFactory.createRule("Node:AGER# >= 1 & Node:PRKCZ# >= 1", 1.0));
        defaultNodes.add(TIRAP);
        // FOXO4
        Node FOXO4 = nodeFactory.createNode("FOXO4");

        defaultNodes.add(FOXO4);
        // FOXO1
        Node FOXO1 = nodeFactory.createNode("FOXO1");

        defaultNodes.add(FOXO1);
        // MSN
        Node MSN = nodeFactory.createNode("MSN");
        MSN.getRules().add(ruleFactory.createRule("Node:RHOA# >= 1", 1.0));
        defaultNodes.add(MSN);
        // TNF
        Node TNF = nodeFactory.createNode("TNF");
        
        defaultNodes.add(TNF);
        // TNFRSF1A
        Node TNFRSF1A = nodeFactory.createNode("TNFRSF1A");
        TNFRSF1A.getRules().add(ruleFactory.createRule("Node:TNF# >= 1", 1.0));
        defaultNodes.add(TNFRSF1A);
        // TNFRSF1B
        Node TNFRSF1B = nodeFactory.createNode("TNFRSF1B");
        TNFRSF1B.getRules().add(ruleFactory.createRule("Node:TNF# >= 1", 1.0));
        defaultNodes.add(TNFRSF1B);
        // TRADD
        Node TRADD = nodeFactory.createNode("TRADD");
        TRADD.getRules().add(ruleFactory.createRule("Node:TNFRSF1A# >= 1", 1.0));
        defaultNodes.add(TRADD);
        // TRAF2
        Node TRAF2 = nodeFactory.createNode("TRAF2");
        TRAF2.getRules().add(ruleFactory.createRule("Node:TRADD# >= 1 | Node:TNFRSF1B# >= 1 |  Node:LTBR# >= 1", 1.0));
        defaultNodes.add(TRAF2);
        // TRAF5
        Node TRAF5 = nodeFactory.createNode("TRAF5");
        TRAF5.getRules().add(ruleFactory.createRule("Node:TRADD# >= 1", 1.0));
        defaultNodes.add(TRAF5);
        // CYLD
        Node CYLD = nodeFactory.createNode("CYLD");
        CYLD.getRules().add(ruleFactory.createRule("Node:Canonical_NFKB# >= 1 & Node:CASP8# == 0", 1.0));
        defaultNodes.add(CYLD);
        // TRAF1
        Node TRAF1 = nodeFactory.createNode("TRAF1");
        TRAF1.getRules().add(ruleFactory.createRule("Node:TNFRSF1B# >= 1", 1.0));
        defaultNodes.add(TRAF1);

        /* Metabolites */
        // AMP
        Node AMP = nodeFactory.createMetabolite("AMP", 1.0, -0.5, 1.0, 2.0);
        // Ca_c
        Node Ca_c = nodeFactory.createMetabolite("Ca_c", 0, 0.0, 0.0, 3.0);
        // Ca_ec
        Node Ca_ec = nodeFactory.createMetabolite("Ca_ec", 2, 1.0, 0.0, 3.0);
        // Ca_er
        Node Ca_er = nodeFactory.createMetabolite("Ca_er", 2, 0.0, 0.0, 4.0);
        // Ca_g
        Node Ca_g = nodeFactory.createMetabolite("Ca_g", 1, 0.0, 0.0, 2.0);
        // Ca_m
        Node Ca_m = nodeFactory.createMetabolite("Ca_m", 2, 0.0, 0.0, 3.0);
        // Ca_n
        Node Ca_n = nodeFactory.createMetabolite("Ca_n", 1, 0.0, 0.0, 2.0);
        // Ceramide
        Node Ceramide = nodeFactory.createMetabolite("Ceramide", 1, 0.2, 0.0, 2.0);
        // DAG
        Node DAG = nodeFactory.createMetabolite("DAG", 1, -0.2, 0.0, 3.0);
        // Fumarate
        Node Fumarate = nodeFactory.createMetabolite("Fumarate", 0, -0.5, 0.0, 3.0);
        // GM1
        Node GM1 = nodeFactory.createMetabolite("GM1", 1, 0.0, 0.0, 0.0);
        // GSH
        Node GSH = nodeFactory.createMetabolite("GSH", 2, 0.0, 0.0, 3.0);
        // GSSG
        Node GSSG = nodeFactory.createMetabolite("GSSG", 0, 0.0, 0.0, 3.0);
        // H2O
        Node H2O = nodeFactory.createMetabolite("H2O", 1, -0.5, 0.0, 3.0);
        // H2O2
        Node H2O2 = nodeFactory.createMetabolite("H2O2", 0, 0.0, 0.0, 3.0);
        // HOCl
        Node HOCl = nodeFactory.createMetabolite("HOCl", 0, -0.5, 0.0, 3.0);
        // IP3
        Node IP3 = nodeFactory.createMetabolite("IP3", 0, -0.1, 0.0, 2.0);
        // MDP
        Node MDP = nodeFactory.createMetabolite("MDP", 0, 0.0, 0.0, 2.0);
        // NAD
        Node NAD = nodeFactory.createMetabolite("NAD", 0, -0.5, 0.0, 3.0);
        // NADH
        Node NADH = nodeFactory.createMetabolite("NADH", 1, 0.1, 0.0, 3.0);
        // NADP
        Node NADP = nodeFactory.createMetabolite("NADP", 0, -0.5, 0.0, 3.0);
        // NADPH
        Node NADPH = nodeFactory.createMetabolite("NADPH", 1, 0.1, 0.0, 3.0);
        // NitricOxide
        Node NitricOxide = nodeFactory.createMetabolite("NitricOxide", 0, -0.5, 0.0, 3.0);
        // OH
        Node OH = nodeFactory.createMetabolite("OH", 0, -0.2, 0.0, 3.0);
        // Oxygen
        Node Oxygen = nodeFactory.createMetabolite("Oxygen", 1, 2.0, 0.0, 3.0);
        // PI345P
        Node PI345P = nodeFactory.createMetabolite("PI345P", 0, -0.1, 0.0, 2.0);
        // PI34P
        Node PI34P = nodeFactory.createMetabolite("PI34P", 0, -0.1, 0.0, 2.0);
        // PI35P
        Node PI35P = nodeFactory.createMetabolite("PI35P", 0, -0.1, 0.0, 2.0);
        // PI3P
        Node PI3P = nodeFactory.createMetabolite("PI3P", 1, -0.1, 1.0, 2.0);
        // PI45P
        Node PI45P = nodeFactory.createMetabolite("PI45P", 2, -0.1, 0.0, 2.0);
        // PI5P
        Node PI5P = nodeFactory.createMetabolite("PI5P", 0, -0.1, 0.0, 2.0);
        // Peroxynitrite        
        Node Peroxynitrite = nodeFactory.createMetabolite("Peroxynitrite", 1, 0.0, 0.0, 0.0);
        // PtdIns
        Node PtdIns = nodeFactory.createMetabolite("PtdIns", 2, 0.2, 1.0, 2.0);
        // Succinate
        Node Succinate = nodeFactory.createMetabolite("Succinate", 1, 0.1, 0.0, 3.0);
        // Superoxide
        Node Superoxide = nodeFactory.createMetabolite("Superoxide", 0, 0.0, 0.0, 3.0);
        // Ubiquinol
        Node Ubiquinol = nodeFactory.createMetabolite("Ubiquinol", 0, 0.0, 0.0, 3.0);
        // Ubiquinone
        Node Ubiquinone = nodeFactory.createMetabolite("Ubiquinone", 3, 0.0, 0.0, 3.0);
        // Ubisemiquinone
        Node Ubisemiquinone = nodeFactory.createMetabolite("Ubisemiquinone", 0, 0.0, 0.0, 3.0);
        // cAMP
        Node cAMP = nodeFactory.createMetabolite("cAMP", 1, 0.0, 1.0, 3.0);
        // G1_Phase
        Node G1_Phase = nodeFactory.createMetabolite("G1_Phase", 1, 0.0, 0.0, 1.0);
        // S_Phase
        Node S_Phase = nodeFactory.createMetabolite("S_Phase", 0, 0.0, 0.0, 1.0);
        // G2_Phase
        Node G2_Phase = nodeFactory.createMetabolite("G2_Phase", 0, 0.0, 0.0, 1.0);
        // Mitosis
        Node Mitosis = nodeFactory.createMetabolite("Mitosis", 0, 0.0, 0.0, 1.0);
        // MitosisStimule
        Node MitosisStimule = nodeFactory.createMetabolite("MitosisStimule", 0, 0.2, 0.0, 2.0);
        // AGE
        Node AGE = nodeFactory.createMetabolite("AGE", 0, -0.25, 0.0, 2.0);

        /* Metabolites Rules */
        // Ca_c
        Ca_c.getRules().add(ruleFactory.createMetabolicRule("Node:IP3R1# >= 1 | Node:IP3R2# >= 1 | Node:IP3R3# >= 1", "Ca_g", "Ca_c", 1.0));
        Ca_c.getRules().add(ruleFactory.createMetabolicRule("Node:IP3R1# >= 1 | Node:IP3R2# >= 1 | Node:IP3R3# >= 1", "Ca_er", "Ca_c", 1.0));
        Ca_c.getRules().add(ruleFactory.createMetabolicRule("Node:SLC8B1# >= 1", "Ca_m", "Ca_c", 1.0));
        Ca_c.getRules().add(ruleFactory.createMetabolicRule("Node:SLC8A3# >= 1", "Ca_m", "Ca_c", 1.0));
        Ca_c.getRules().add(ruleFactory.createMetabolicRule("Node:SLC8A3# >= 1", "Ca_er", "Ca_c", 1.0));
        Ca_c.getRules().add(ruleFactory.createMetabolicRule("Node:RYR1# >= 1 | Node:RYR2# >= 1 | Node:RYR3# >= 1", "Ca_er", "Ca_c", 1.0));
        Ca_c.getRules().add(ruleFactory.createMetabolicRule("Node:ORAI1# >= 1", "Ca_ec", "Ca_c", 1.0));
        Ca_c.getRules().add(ruleFactory.createMetabolicRule("Node:CACNA1S# >= 1 | Node:CACNA1C# >= 1 | Node:CACNA1D# >= 1 | Node:CACNA1F# >= 1 | Node:CACNA1A# >= 1 | Node:CACNA1B# >= 1 | Node:CACNA1E# >= 1 | Node:CACNA1G# >= 1 | Node:CACNA1H# >= 1 | Node:CACNA1I# >= 1", "Ca_ec", "Ca_c", 1.0));
        // Ca_ec
        Ca_ec.getRules().add(ruleFactory.createMetabolicRule("Node:SLC8A1# >= 1 | Node:SLC8A2# >= 1 | Node:SLC8A2# >= 1", "Ca_c", "Ca_ec", 1.0));
        Ca_ec.getRules().add(ruleFactory.createMetabolicRule("Node:SLC24A1# >= 1 | Node:SLC24A2# >= 1", "Ca_c", "Ca_ec", 1.0));
        Ca_ec.getRules().add(ruleFactory.createMetabolicRule("Node:ATP2B1# >= 2 | Node:ATP2B2# >= 2 | Node:ATP2B3# >= 2 | Node:ATP2B4# >= 2", "Ca_c", "Ca_ec", 2.0));
        Ca_ec.getRules().add(ruleFactory.createMetabolicRule("Node:ATP2B1# == 1 | Node:ATP2B2# == 1 | Node:ATP2B3# == 1 | Node:ATP2B4# == 1", "Ca_c", "Ca_ec", 1.0));
        // Ca_er
        Ca_er.getRules().add(ruleFactory.createMetabolicRule("Node:ATP2A1# >= 1 | Node:ATP2A2# >= 1", "Ca_c", "Ca_er", 1.0));
        Ca_er.getRules().add(ruleFactory.createMetabolicRule("Node:SLC8A1_n# >= 1 | Node:SLC8A2_n# >= 1 | Node:SLC8A3_n# >= 1", "Ca_n", "Ca_er", 1.0));
        // Ca_g
        Ca_g.getRules().add(ruleFactory.createMetabolicRule("Node:ATP2C1# >= 1 | Node:ATP2C2# >= 1", "Ca_c", "Ca_g", 1.0));
        // Ca_m
        Ca_m.getRules().add(ruleFactory.createMetabolicRule("Node:MCU# >= 1", "Ca_c", "Ca_m", 1.0));
        // Ca_n
        Ca_n.getRules().add(ruleFactory.createMetabolicRule("Node:RYR1# >= 1 | Node:RYR2# >= 1 | Node:RYR3# >= 1", "Ca_er", "Ca_n", 1.0));
        // Ceramide
        Ceramide.getRules().add(ruleFactory.createMetabolicRule("Node:CERS1# >= 1", "DAG", "Ceramide", 1.0));
        Ceramide.getRules().add(ruleFactory.createMetabolicRule("Node:SMPD1# >= 1", "DAG", "Ceramide", 1.0));
        // DAG
        DAG.getRules().add(ruleFactory.createMetabolicRule("Node:PLCB2# >= 1", "PI45P", "DAG", 1.0));
        DAG.getRules().add(ruleFactory.createMetabolicRule("Node:PLCG1# >= 1", "PI45P", "DAG", 1.0));
        DAG.getRules().add(ruleFactory.createMetabolicRule("Node:PLCG2# >= 1", "PI45P", "DAG", 1.0));
        DAG.getRules().add(ruleFactory.createMetabolicRule("Node:SGMS1# >= 1", "Ceramide", "DAG", 1.0));
        // Fumarate
        Fumarate.getRules().add(ruleFactory.createMetabolicRule("Node:ComplexII# >= 1", "Succinate", "Fumarate", 1.0));
        // GSH
        GSH.getRules().add(ruleFactory.createMetabolicRule("Node:GSR# >= 1", "GSSG", "GSH", 1.0));
        // H2O
        H2O.getRules().add(ruleFactory.createMetabolicRule("Node:ComplexIV# >= 1", "Oxygen", "H2O", 1.0));
        H2O.getRules().add(ruleFactory.createMetabolicRule("Node:CAT# >= 1", "H2O2", "H2O", 0.5));
        H2O.getRules().add(ruleFactory.createMetabolicRule("Node:CAT# >= 1", "H2O2", "Oxygen", 0.5));
        H2O.getRules().add(ruleFactory.createMetabolicRule("Node:GPX1# >= 1", "H2O2", "H2O", 0.5));
        H2O.getRules().add(ruleFactory.createMetabolicRule("Node:GPX1# >= 1", "H2O2", "Oxygen", 0.5));
        H2O.getRules().add(ruleFactory.createMetabolicRule("Node:GPX1# >= 1", "GSH", "GSSG", 1.0));
        H2O.getRules().add(ruleFactory.createMetabolicRule("Node:DSF# >= 1", "OH", "H2O", 1.0));
        // H2O2
        H2O2.getRules().add(ruleFactory.createMetabolicRule("Node:SOD1# >= 1", "Superoxide", "H2O2", 0.25));
        H2O2.getRules().add(ruleFactory.createMetabolicRule("Node:SOD1# >= 1", "Superoxide", "Oxygen", 0.25));
        // HOCl
        HOCl.getRules().add(ruleFactory.createMetabolicRule("Node:MPO# >= 1", "H2O2", "HOCl", 1.0));
        // IP3
        IP3.getRules().add(ruleFactory.createMetabolicRule("Node:PLCB2# >= 1", "PI45P", "IP3", 0.5));
        IP3.getRules().add(ruleFactory.createMetabolicRule("Node:PLCG1# >= 1", "PI45P", "IP3", 0.5));
        IP3.getRules().add(ruleFactory.createMetabolicRule("Node:PLCG2# >= 1", "PI45P", "IP3", 0.5));
        // NAD
        NAD.getRules().add(ruleFactory.createMetabolicRule("Node:ComplexI# >= 1", "NADH", "NAD", 1.0));
        // NADP
        NADP.getRules().add(ruleFactory.createMetabolicRule("Node:CYBB# >= 1", "NADPH", "NADP", 1.0));
        NADP.getRules().add(ruleFactory.createMetabolicRule("Node:CYBB# >= 1", "Oxygen", "Superoxide", 1.0));
        // PI345P             
        PI345P.getRules().add(ruleFactory.createMetabolicRule("Node:PI3K# >= 1", "PI45P", "PI345P", 0.5));
        // PI34P
        PI34P.getRules().add(ruleFactory.createMetabolicRule("Node:PI3K# >= 1", "PI3P", "PI34P", 0.5));
        PI34P.getRules().add(ruleFactory.createMetabolicRule("Node:INPP5D# >= 1", "PI345P", "PI34P", 0.5));
        PI34P.getRules().add(ruleFactory.createMetabolicRule("Node:INPPL1# >= 1", "PI345P", "PI34P", 0.5));
        // PI35P
        PI35P.getRules().add(ruleFactory.createMetabolicRule("Node:PIKFYVE# >= 1", "PI3P", "PI35P", 0.5));
        // PI3P
        PI3P.getRules().add(ruleFactory.createMetabolicRule("Node:PI3K# >= 1", "PtdIns", "PI3P", 0.5));
        PI3P.getRules().add(ruleFactory.createMetabolicRule("Node:INPP4B# >= 1", "PI34P", "PI3P", 0.5));
        PI3P.getRules().add(ruleFactory.createMetabolicRule("Node:FIG4# >= 1", "PI35P", "PI3P", 0.5));
        // PI45P
        PI45P.getRules().add(ruleFactory.createMetabolicRule("Node:PTEN# >= 1", "PI345P", "PI45P", 0.5));
        // PI5P
        PI5P.getRules().add(ruleFactory.createMetabolicRule("Node:PIKFYVE# >= 1", "PtdIns", "PI5P", 0.5));
        PI5P.getRules().add(ruleFactory.createMetabolicRule("Node:MTM1# >= 1", "PI35P", "PI5P", 0.5));
        PI5P.getRules().add(ruleFactory.createMetabolicRule("Node:MTMR2# >= 1", "PI35P", "PI5P", 0.5));
        PI5P.getRules().add(ruleFactory.createMetabolicRule("Node:MTMR3# >= 1", "PI35P", "PI5P", 0.5));
        // Peroxynitrite
        Peroxynitrite.getRules().add(ruleFactory.createMetabolicRule("Node:NitricOxide# >= 1 & Node:Superoxide# >= 1", "NitricOxide", "Peroxynitrite", 0.25));
        Peroxynitrite.getRules().add(ruleFactory.createMetabolicRule("Node:NitricOxide# >= 1 & Node:Superoxide# >= 1", "Superoxide", "Peroxynitrite", 0.25));
        // PtdIns
        PtdIns.getRules().add(ruleFactory.createMetabolicRule("Node:MTM1# >= 1", "PI3P", "PtdIns", 0.5));
        PtdIns.getRules().add(ruleFactory.createMetabolicRule("Node:MTMR1# >= 1", "PI3P", "PtdIns", 0.5));
        PtdIns.getRules().add(ruleFactory.createMetabolicRule("Node:MTMR2# >= 1", "PI3P", "PtdIns", 0.5));
        PtdIns.getRules().add(ruleFactory.createMetabolicRule("Node:MTMR3# >= 1", "PI3P", "PtdIns", 0.5));
        PtdIns.getRules().add(ruleFactory.createMetabolicRule("Node:MTMR6# >= 1", "PI3P", "PtdIns", 0.5));
        // Ubiquinol
        Ubiquinol.getRules().add(ruleFactory.createMetabolicRule("Node:ComplexI# >= 1 | Node:ComplexII# >= 1", "Ubiquinone", "Ubiquinol", 1.0));
        // Ubiquinone
        Ubiquinone.getRules().add(ruleFactory.createMetabolicRule("Node:Ubisemiquinone# >= 1", "Ubisemiquinone", "Ubiquinone", 1.0));
        Ubiquinone.getRules().add(ruleFactory.createMetabolicRule("Node:Ubisemiquinone# >= 1", "Oxygen", "Superoxide", 1.0));
        // Ubisemiquinone
        Ubisemiquinone.getRules().add(ruleFactory.createMetabolicRule("Node:ComplexIII# >= 1", "Ubiquinol", "Ubisemiquinone", 1.0));
        Ubisemiquinone.getRules().add(ruleFactory.createMetabolicRule("Node:Ubiquinol# >= 2", "Ubiquinol", "Ubisemiquinone", 1.0));
        Ubisemiquinone.getRules().add(ruleFactory.createMetabolicRule("Node:Ubiquinol# >= 2", "Oxygen", "Superoxide", 1.0));
        // G1_Phase
        G1_Phase.getRules().add(ruleFactory.createMetabolicRule("Node:Mitosis# >= 1", "Mitosis", "G1_Phase", 1.0));
        // S_Phase
        S_Phase.getRules().add(ruleFactory.createMetabolicRule("Node:CDK2# >= 1 & Node:CCNE# >= 1 & Node:G1_Phase# >= 1", "G1_Phase", "S_Phase", 1.0));
        // G2_Phase
        G2_Phase.getRules().add(ruleFactory.createMetabolicRule("Node:DNAReplication# >= 1 & Node:S_Phase# >= 1", "S_Phase", "G2_Phase", 1.0));
        // Mitosis
        Mitosis.getRules().add(ruleFactory.createMetabolicRule("Node:CDK1# >= 1 & Node:G2_Phase# >= 1", "G2_Phase", "Mitosis", 1.0));
        

        defaultNodes.add(AMP);
        defaultNodes.add(Ca_c);
        defaultNodes.add(Ca_ec);
        defaultNodes.add(Ca_er);
        defaultNodes.add(Ca_g);
        defaultNodes.add(Ca_m);
        defaultNodes.add(Ca_n);
        defaultNodes.add(Ceramide);
        defaultNodes.add(DAG);
        defaultNodes.add(Fumarate);
        defaultNodes.add(GM1);
        defaultNodes.add(GSH);
        defaultNodes.add(GSSG);
        defaultNodes.add(H2O);
        defaultNodes.add(H2O2);
        defaultNodes.add(HOCl);
        defaultNodes.add(IP3);
        defaultNodes.add(MDP);
        defaultNodes.add(NAD);
        defaultNodes.add(NADH);
        defaultNodes.add(NADP);
        defaultNodes.add(NADPH);
        defaultNodes.add(NitricOxide);
        defaultNodes.add(OH);
        defaultNodes.add(Oxygen);
        defaultNodes.add(PI345P);
        defaultNodes.add(PI34P);
        defaultNodes.add(PI35P);
        defaultNodes.add(PI3P);
        defaultNodes.add(PI45P);
        defaultNodes.add(PI5P);
        defaultNodes.add(Peroxynitrite);
        defaultNodes.add(PtdIns);
        defaultNodes.add(Succinate);
        defaultNodes.add(Superoxide);
        defaultNodes.add(Ubiquinol);
        defaultNodes.add(Ubiquinone);
        defaultNodes.add(Ubisemiquinone);
        defaultNodes.add(cAMP);
        defaultNodes.add(G1_Phase);
        defaultNodes.add(S_Phase);
        defaultNodes.add(G2_Phase);
        defaultNodes.add(Mitosis);
        defaultNodes.add(MitosisStimule);
        defaultNodes.add(AGE);
        
        /* New Addition */
        // FRAT1
        Node FRAT1 = nodeFactory.createNode("FRAT1");

        defaultNodes.add(FRAT1);
        // TP53RK
        Node TP53RK = nodeFactory.createNode("TP53RK");
        TP53RK.getRules().add(ruleFactory.createRule("Node:AKT1# >= 1", 1.0));
        defaultNodes.add(TP53RK);
        // Rapamycin
        Node Rapamycin = nodeFactory.createDrug("Rapamycin");
        
        defaultNodes.add(Rapamycin);
        // EIF4EBP1 (4EBP1)
        Node EIF4EBP1 = nodeFactory.createNode("EIF4EBP1");
        EIF4EBP1.setRestingStatus(1.0);
        EIF4EBP1.getRules().add(ruleFactory.createRule("Node:mTORC1# >= 1", 0.0));
        defaultNodes.add(EIF4EBP1);
        // EIF4F
        Node EIF4F = nodeFactory.createNode("EIF4F");
        EIF4F.setRestingStatus(1.0);
        EIF4F.getRules().add(ruleFactory.createRule("Node:EIF4EBP1# >= 1", 0.0));
        defaultNodes.add(EIF4F);
        // RHEB
        Node RHEB = nodeFactory.createNode("RHEB");
        
        defaultNodes.add(RHEB);
        // STK11 (LKB1)
        Node STK11 = nodeFactory.createNode("STK11");
        STK11.getRules().add(ruleFactory.createRule("Node:GlucoseDeprivation# >= 1 | (Node:TP53# >= 1 & "
                + "(Mod:TP53#Ser15; == 1.0 | Mod:TP53#Ser20; == 1.0 | Mod:TP53#Ser37; == 1.0))", 1.0));
        defaultNodes.add(STK11);
        // TSC1
        Node TSC1 = nodeFactory.createNode("TSC1");
        TSC1.setRestingStatus(1.0);
        TSC1.getRules().add(ruleFactory.createRule("(Node:ERK1# >= 1 | Node:ERK2# >= 1) & Node:AMPK# == 0 & Node:DDIT4# == 0", 0.0));
        defaultNodes.add(TSC1);
        // RSK (RPS6KA1)
        Node RSK = nodeFactory.createNode("RSK");
        RSK.getRules().add(ruleFactory.createRule("Node:ERK1# >= 1 | Node:ERK2# >= 1", 1.0));
        defaultNodes.add(RSK);
        // NF1
        Node NF1 = nodeFactory.createNode("NF1");
        NF1.getRules().add(ruleFactory.createRule("Node:AKT1# >= 1", 1.0));
        defaultNodes.add(NF1);
        // NFKBIA
        Node NFKBIA = nodeFactory.createNode("NFKBIA");
        NFKBIA.setRestingStatus(1.0);
        NFKBIA.getRules().add(ruleFactory.createRule("Node:IKK# >= 1", 0.0));
        defaultNodes.add(NFKBIA);
        // IKK (Complex NEMO/IKKa/IKKb)
        Node IKK = nodeFactory.createNode("IKK");
        IKK.getRules().add(ruleFactory.createRule("Node:MAP3K7# >= 1 & Node:CYLD# == 0", 1.0));
        defaultNodes.add(IKK);
        // NonCanonical_NFKB (Complex p52/RELB)
        Node NonCanonical_NFKB = nodeFactory.createNode("NonCanonical_NFKB");
        NonCanonical_NFKB.setRestingStatus(1.0);
        NonCanonical_NFKB.getRules().add(ruleFactory.createRule("Node:P100# >= 1", 0.0));
        defaultNodes.add(NonCanonical_NFKB);
        // P100 (NFKB2 p100 form - precursor of p52)
        Node P100 = nodeFactory.createNode("P100");
        P100.setRestingStatus(1.0);
        P100.getRules().add(ruleFactory.createRule("Node:NIK# >= 1", 0.0));
        defaultNodes.add(P100);
        // NIK (Complex NIK/IKKa/IKKb)
        Node NIK = nodeFactory.createNode("NIK");
        NIK.setRestingStatus(1.0);
        NIK.getRules().add(ruleFactory.createRule("Node:TRAF3# >= 1", 0.0));
        defaultNodes.add(NIK);
        // TRAF3
        Node TRAF3 = nodeFactory.createNode("TRAF3");
        TRAF3.setRestingStatus(1.0);
        TRAF3.getRules().add(ruleFactory.createRule("Node:TRAF2# >= 1", 0.0));
        defaultNodes.add(TRAF3);
        // LTBR
        Node LTBR = nodeFactory.createNode("LTBR");
        LTBR.getRules().add(ruleFactory.createRule("Node:LTA# >= 1 | Node:LTB# >= 1", 1.0));
        defaultNodes.add(LTBR);
        // LTA (TNF-B)
        Node LTA = nodeFactory.createNode("LTA");
        
        defaultNodes.add(LTA);
        // LTB
        Node LTB = nodeFactory.createNode("LTB");
        
        defaultNodes.add(LTB);
        // PTGS2 (COX2)
        Node PTGS2 = nodeFactory.createNode("PTGS2");
        PTGS2.getRules().add(ruleFactory.createRule("Node:Canonical_NFKB# >= 1", 1.0));
        defaultNodes.add(PTGS2);
        // IGF1
        Node IGF1 = nodeFactory.createNode("IGF1");
        
        defaultNodes.add(IGF1);
        // GlucoseDeprivation
        Node GlucoseDeprivation = nodeFactory.createGeneralNode("GlucoseDeprivation");
        
        defaultNodes.add(GlucoseDeprivation);
        // Hypoxia
        Node Hypoxia = nodeFactory.createGeneralNode("Hypoxia");
        
        defaultNodes.add(Hypoxia);
        // DDIT4 (REDD1)
        Node DDIT4 = nodeFactory.createGeneralNode("DDIT4");
        DDIT4.getRules().add(ruleFactory.createRule("Node:HIF1# >= 1 | (Node:TP53# >= 1 & "
                + "(Mod:TP53#Ser15; == 1.0 | Mod:TP53#Ser20; == 1.0 | Mod:TP53#Ser37; == 1.0))", 1.0));
        defaultNodes.add(DDIT4);
        // GRB10
        Node GRB10 = nodeFactory.createGeneralNode("GRB10");
        GRB10.getRules().add(ruleFactory.createRule("Node:mTORC1# >= 1", 1.0));
        defaultNodes.add(GRB10);
        // SESN1
        Node SESN1 = nodeFactory.createGeneralNode("SESN1");
        SESN1.getRules().add(ruleFactory.createRule("(Node:TP53# >= 1 & "
                + "(Mod:TP53#Ser15; == 1.0 | Mod:TP53#Ser20; == 1.0 | Mod:TP53#Ser37; == 1.0))", 1.0));
        defaultNodes.add(SESN1);
        // SESN2
        Node SESN2 = nodeFactory.createGeneralNode("SESN2");
        SESN2.getRules().add(ruleFactory.createRule("(Node:TP53# >= 1 & "
                + "(Mod:TP53#Ser15; == 1.0 | Mod:TP53#Ser20; == 1.0 | Mod:TP53#Ser37; == 1.0))", 1.0));
        defaultNodes.add(SESN2);
        // ULK1
        Node ULK1 = nodeFactory.createGeneralNode("ULK1");
        ULK1.getRules().add(ruleFactory.createRule("(Node:AMPK# >= 1) & Node:mTORC1# == 0", 1.0));
        defaultNodes.add(ULK1);
        // PRDM1
        Node PRDM1 = nodeFactory.createGeneralNode("PRDM1");
        PRDM1.getRules().add(ruleFactory.createRule("Node:Canonical_NFKB# >= 1", 1.0));
        defaultNodes.add(PRDM1);
        // Shortenedtelomeres
        Node Shortenedtelomeres = nodeFactory.createGeneralNode("Shortenedtelomeres");
        Shortenedtelomeres.getRules().add(ruleFactory.createRule("Node:DSB# >= 2", 1.0));
        defaultNodes.add(Shortenedtelomeres);
        // IL13
        Node IL13 = nodeFactory.createGeneralNode("IL13");
        
        defaultNodes.add(IL13);
      
        return defaultNodes;

    }
}
