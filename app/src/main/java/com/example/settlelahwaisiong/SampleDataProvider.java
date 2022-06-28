package com.example.settlelahwaisiong;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SampleDataProvider {

    public static List<CityDataItem> cityDataItemList;
    public static Map<String,CityDataItem> dataItemMap;

    static {
        cityDataItemList =new ArrayList<>();
        dataItemMap = new HashMap<>();

        addItem(new CityDataItem(
                null,"Pipe Defects",1,"Plumber Service",101,"Pipe Defects includes leakage of pipes and more problems related to pipe defects. Defects also occur during the manufacturing process used to roll the steel plate and transform steel billets into pipes. This includes “Hard spots” formed during cooling the plate material. Cracking can occur at hard spots eventually leading to pipe failure.",
                "image 81.png"));

        addItem(new CityDataItem(
                null,"Water Tank Defects",2,"Plumber Service",102,"Water tanks defects includes the leakage of pipes in water tank, clogged water tank and more. A bad or defective water pressure tank which has lost its air charge or which cannot keep its air charge will cause well pump short cycling - rapid turning on and off of the water pump.",
                "image 82.png"));

        addItem(new CityDataItem(
                null,"Toilet Clogged",3,"Plumber Service",103,"Toilet clogged will have professionals to clean and clear the clogged toilet. That is, flush water partially fills the bowl but doesn’t rush out and clean away the waste. The water level remains high, then usually drains down to normal height within a minute or two. ",
                "image 83.png"));

        addItem(new CityDataItem(
                null,"Faucets Failure",4,"Plumber Service",104,"Whether it’s your kitchen sink or your bathroom vanity, faucet leaks add up to a lot of wasted water, which can increase your utility bill. Over time, those leaks can cause damage to your cabinets and vanity, or stain your sink basin. ",
                "image 84.png"));

        addItem(new CityDataItem(
                null,"Pressure Regulator Malfunction",5,"Plumber Service",105,"A malfunctioning water pressure regulator will cause a change in the pressure of water when you turn on the faucet. Fluctuations in water pressure usually means you have a bad regulator. ",
                "image 85.png"));

        addItem(new CityDataItem(
                null,"Basin Defect",6,"Plumber Service",106,"Under-sink leaks can do a lot of damage, but they're usually fairly easy to pinpoint and repair. The water that is damaging the cabinet or the floor may be coming from the drainpipes, the supply hoses or even the faucet itself. ",
                "image 98.png"));

        addItem(new CityDataItem(
                null,"Shower Drain Clogged",7,"Plumber Service",107,"A clogged drain, typically caused by a backup of hair and soap scum that has been accumulating for some time.  Hair is the biggest enemy of the shower drain, so chances are good that hair is at the root of your shower drain problem.",
                "image 99.png"));

    }

    private static void addItem(CityDataItem cityDataItem){
        cityDataItemList.add(cityDataItem);
        dataItemMap.put(cityDataItem.getCityId(), cityDataItem);
    }

}
