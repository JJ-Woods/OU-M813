package com.m813.datamodel.equipment;

import java.util.Date;

public class Equipment
{
    private String EquipmentName;

    private EquipmentBrand Brand;

    private Date Purchased;

    public String getEquipmentName()
    {
        return this.EquipmentName;
    }

    public EquipmentBrand getBrand()
    {
        return this.Brand;
    }

    public void setBrand(EquipmentBrand brand)
    {
        this.Brand = brand;
    }

    public Date getPurchased()
    {
        return this.Purchased;
    }

    public void setPurchased(Date date)
    {
        this.Purchased = date;
    }
}
