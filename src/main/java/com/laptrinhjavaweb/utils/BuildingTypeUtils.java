package com.laptrinhjavaweb.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.laptrinhjavaweb.constant.BuildingTypeConstant;
import com.laptrinhjavaweb.enums.BuildingTypeEnums;

public class BuildingTypeUtils {

    public static String getType(String oldType) {
        List<String> newTypes = new ArrayList<>();
        if (oldType != null) {
            for (String item : oldType.split(",")) {
                /*Map<String, String> mapType = initBuildingType();
                String code = mapType.get(item);
                newTypes.add(code);*/
                newTypes.add(BuildingTypeEnums.valueOf(item).getValue());
            }
            return String.join(",", newTypes);
        }
        return null;
    }

    /*public static Map<String, String> initBuildingType() {
        Map<String, String> results = new HashMap<>();
        results.put(BuildingTypeConstant.TANG_TRET_CODE, BuildingTypeConstant.TANG_TRET_NAME);
        results.put(BuildingTypeConstant.NGUYEN_CAN_CODE, BuildingTypeConstant.NGUYEN_CAN_NAME);
        results.put(BuildingTypeConstant.NOI_THAT_CODE, BuildingTypeConstant.NOI_THAT_NAME);
        return results;
    }*/
}
