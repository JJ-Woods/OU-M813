package com.m813.datamodel.equipment;

import java.util.Date;

public class OtherEquipment extends Equipment
{
    public OtherEquipment(String id, String name, EquipmentBrand brand, Date purchased)
    {
        super(id, name, brand, purchased);
    }

    public OtherEquipment(String name, EquipmentBrand brand, Date purchased)
    {
        super(name, brand, purchased);
    }

    @Override
    public Date nextServiceDate()
    {
        return null;
    }
}
