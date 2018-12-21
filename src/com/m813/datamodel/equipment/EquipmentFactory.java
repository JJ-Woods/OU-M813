package com.m813.datamodel.equipment;

import com.m813.NotSupportedException;

import java.util.Date;

public class EquipmentFactory
{
    public static Equipment newEquipment(Class<? extends Equipment> type, String name,
        EquipmentBrand brand, Date purchased, Date lastServiced)
    {
        if(type == Cylinder.class)
        {
            return new Cylinder(name, brand, purchased, lastServiced);
        }
        else if(type == Regulator.class)
        {
            return new Regulator(name, brand, purchased, lastServiced);
        }
        else if(type == OtherEquipment.class)
        {
            return new OtherEquipment(name, brand, purchased);
        }
        else
        {
            throw new NotSupportedException();
        }
    }
}
