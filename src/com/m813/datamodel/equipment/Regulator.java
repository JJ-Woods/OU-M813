package com.m813.datamodel.equipment;

import java.util.Calendar;
import java.util.Date;

public class Regulator extends Equipment
{
    private final int SerivceInterval = 12; //12 month service interval

    Regulator(String name, EquipmentBrand brand, Date purchased, Date lastServiced)
    {
        super(name, brand, purchased, lastServiced);
    }

    @Override
    public Date nextServiceDate()
    {
        Date lastServiced = getLastServiced();

        if(lastServiced == null)
        {
            return null;
        }
        else
        {
            Calendar cal = Calendar.getInstance();
            cal.setTime(lastServiced);

            cal.add(Calendar.MONTH, SerivceInterval);
            return cal.getTime();
        }
    }
}
