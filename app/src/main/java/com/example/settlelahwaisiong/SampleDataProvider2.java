package com.example.settlelahwaisiong;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SampleDataProvider2 {

    public static List<CityDataItem2> cityDataItemList;
    public static Map<String, CityDataItem2> dataItemMap;

    static {
        cityDataItemList =new ArrayList<>();
        dataItemMap = new HashMap<>();

        addItem(new com.example.settlelahwaisiong.CityDataItem2(
                null,"Autogate Repair",1,"Maintenance Services",110,"When an autogate starts to act up, the problem could be with either the motor, transmitter or the wiring. Before you go out of your way and spend a good amount of money on repairs, it could help to get acquainted with autogates and how they operate.",
                "image 86.png"));

        addItem(new com.example.settlelahwaisiong.CityDataItem2(
                null,"Tiles Repair",2,"Maintenance Services",111,"Tile defects occur because of improper installation techniques or materials are unsuitable for tile surface. Tile defects also arise due to reasons like uneven floor, improper cleaning, uneven grout joints, poor adhesion, poor quality adhesive, etc. These defects give a bad look to your house. ",
                "group_3.png"));

        addItem(new com.example.settlelahwaisiong.CityDataItem2(
                null,"Wall Repair",3,"Maintenance Service",112,"Hairline cracks over doors and windows are likely due to settling. Houses of any age move and shift subtly over time, and the weakest area in a wall is the most likely to crack. A wall is constructed with vertical studs that extend from floor to ceiling.",
                "image 88.png"));

        addItem(new com.example.settlelahwaisiong.CityDataItem2(
                null,"Window Repair",4,"Maintenance Service",113,"All window openings and window frames have parts and components that break down over time with normal use. Most window openings and window frames will be made up of the following parts and fittings, the window frame itselt, the window opening, triple, double or single glazing, handles, locking mechanism, vent openings, hinges, child safety catches, weepholes and draught seal. ",
                "image_4.png"));

        addItem(new com.example.settlelahwaisiong.CityDataItem2(
                null,"Paint Defects",5,"Maintenance Service",114,"A defect in which the appearance of a paint finish is marred by small particles of extraneous material, typically dust, grit, broken paint skin and fragments of bristle from brushes. ",
                "image 100.png"));

        addItem(new com.example.settlelahwaisiong.CityDataItem2(
                null,"Ceiling Damage",6,"Maintenance Service",115,"If a home’s exterior walls or roof is damaged water can seep in and cause a variety of problems from mold to rot and more. Identifying the signs of water damage can help to save you a world of problems more than just money, so take a look at these signs of roof and ceiling water damage to watch out for.",
                "image 101.png"));

        addItem(new com.example.settlelahwaisiong.CityDataItem2(
                null,"Doorknob Replacement",7,"Maintenance Service",116,"With your door lock stuck in unlocked the position, your home can be made vulnerable. The solutions and severity of this issue will differ depending on what type of lock it is. The most pressing will be when your deadbolt door lock is stuck in the open position because your deadbolt provides the real security for a building.",
                "image 102.png"));
    }

    private static void addItem(com.example.settlelahwaisiong.CityDataItem2 cityDataItem){
        cityDataItemList.add(cityDataItem);
        dataItemMap.put(cityDataItem.getCityId(), cityDataItem);
    }

}
