package com.example.fileprocessor.dto;

import java.util.Arrays;
import java.util.List;

public enum IdType {

    NIN("NIN"),
    DRIVER_LICENSE("DRIVING_LICENSE"),
    VNIN("VNIN"),
    CLM("CLM"),
    VOTER_ID("VOTER_ID"),

    PASSPORT("PASSPORT"),
    VOTER_ID_NUMBER("Voter ID Number"),
    PASSPORT2("Passport"),
    BVN_DETAILS("Bvn Details"),
    CAC("CAC"),
    NATIONAL_ID("NATIONAL_ID"),
    NigeriaNIN("Nigeria Identification Number"),
    BVN("BVN"),
    CLM_TIER1("CLM ID FOR TIER1"),
    VIRUALNIN("Virual NIN"),
    EMP_ID("EMPLOYEE_ID");
    public String label;

    private IdType(String label) {
        this.label = label;
    }

    public static IdType getValue(String name) {
        List<IdType> clmTypes = List.of(CLM_TIER1, CLM);
        List<IdType> bvnTypes = List.of(BVN, BVN_DETAILS);

        IdType result = null;
        for(IdType idType: values()) {
            if(idType.label.equalsIgnoreCase(name)){
                result = idType;
                break;
            }
        }
        if(clmTypes.contains(result)) return CLM;
        else if (bvnTypes.contains(result)) return BVN;

        return result;
    }

//    public static void main(String[] args) {
//        IdType idType = IdType.getValue("Virual N");
//        IdType idType2 = IdType.getValue("Virual NIN");
//
//        int a = 1;
//    }
}
