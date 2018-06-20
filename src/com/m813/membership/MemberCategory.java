package com.m813.membership;

public class MemberCategory
{
    private String CategoryName;

    private int CategoryDuration;

    private float CategoryCost;

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
