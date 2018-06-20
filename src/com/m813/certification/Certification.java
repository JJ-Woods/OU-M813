package com.m813.certification;

public abstract class Certification
{
    private CertificationAgency CertificationAgency;

    private CertificationLevel CertificationLevel;

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