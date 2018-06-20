package com.m813.certification;

public class Certification
{
    private String CertificationName;

    private CertificationAgency CertificationAgency;

    private CertificationLevel CertificationLevel;

    public String getCertificationName()
    {
        return this.CertificationName;
    }

    public void setCertificationName(String certificationName)
    {
        this.CertificationName = certificationName;
    }

    public CertificationAgency getCertificationAgency()
    {
        return this.CertificationAgency;
    }

    public void setCertificationAgency(CertificationAgency certificationAgency)
    {
        this.CertificationAgency = certificationAgency;
    }

    public CertificationLevel getCertificationLevel()
    {
        return this.CertificationLevel;
    }

    public void setCertificationLevel(CertificationLevel certificationLevel)
    {
        this.CertificationLevel = certificationLevel;
    }
}