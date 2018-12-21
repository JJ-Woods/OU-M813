package com.m813.datamodel.membership;

import com.m813.datamodel.IEntity;

public class MemberCategory extends IEntity
{
    private String CategoryName;

    private int CategoryDuration;

    private float CategoryCost;

    public MemberCategory(String name, int duration, float cost)
    {
        CategoryName = name;
        CategoryDuration = duration;
        CategoryCost = cost;
    }

    public String getCategoryName()
    {
        return this.CategoryName;
    }

    public void setCategoryName(String categoryName)
    {
        this.CategoryName = categoryName;
    }

    public int getCategoryDuration() {
        return this.CategoryDuration;
    }

    public void setCategoryDuration(int categoryDuration)
    {
        this.CategoryDuration = categoryDuration;
    }

    public float getCategoryCost()
    {
        return this.CategoryCost;
    }

    public void setCategoryCost(float categoryCost)
    {
        this.CategoryCost = categoryCost;
    }
}
