package com.m813.datamodel.training;

import com.m813.datamodel.certification.CertificationLevel;

import java.util.List;

public abstract class Programme
{
    private String ProgrammeName;

    private CertificationLevel MinimumLevel;

    private List<Lesson> RequiredLessons;

    public String getProgrammeName()
    {
        return this.ProgrammeName;
    }

    public void setProgrammeName(String programmeName)
    {
        this.ProgrammeName = programmeName;
    }

    public CertificationLevel getMinimumLevel()
    {
        return this.MinimumLevel;
    }

    public void setMinimumLevel(CertificationLevel minimumLevel)
    {
        this.MinimumLevel = minimumLevel;
    }

    public List<Lesson> getRequiredLessons()
    {
        return this.RequiredLessons;
    }

    public void setRequiredLessons(List<Lesson> requiredLessons)
    {
        this.RequiredLessons = requiredLessons;
    }
}
