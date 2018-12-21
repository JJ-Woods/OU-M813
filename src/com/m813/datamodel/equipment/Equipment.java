package com.m813.datamodel.equipment;

import com.m813.datamodel.IEntity;

import java.util.Date;

public abstract class Equipment extends IEntity
{
    private String EquipmentName;

    private EquipmentBrand Brand;

    private Date Purchased;

    private Date LastServiced;

    private String Notes;

    Equipment(String name, EquipmentBrand brand, Date purchased)
    {
        EquipmentName = name;
        Brand = brand;
        Purchased = purchased;
    }

    Equipment(String id, String name, EquipmentBrand brand, Date purchased)
    {
        this(name, brand, purchased);
        Id = id;
    }

    Equipment(String name, EquipmentBrand brand, Date purchased, Date lastServiced)
    {
        this(name, brand, purchased);
        LastServiced = lastServiced;
    }

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

    public Date getLastServiced()
    {
        return this.LastServiced;
    }

    public void setLastServiced(Date lastServiced)
    {
        this.LastServiced = lastServiced;
    }

    public String getNotes()
    {
        return this.Notes;
    }

    public void setNotes(String notes)
    {
        this.Notes = notes;
    }

    public abstract Date nextServiceDate();

    public Boolean inService()
    {
        Date today = new Date();
        Date nextServiceDate = nextServiceDate();

        if(nextServiceDate != null)
        {
            return today.before(nextServiceDate);
        }
        else
        {
            return false;
        }
    }
}
