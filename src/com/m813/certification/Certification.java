package com.m813.certification;

public abstract class Certification implements ICertification
{
    private CertificationAgency CertificationAgency;

    private CertificationLevel CertificationLevel;

    @Override
    public CertificationAgency getCertificationAgency()
    {
        return CertificationAgency;
    }

    @Override
    public void setCertificationAgency(CertificationAgency certificationAgency)
    {
        CertificationAgency = certificationAgency;
    }

    @Override
    public CertificationLevel getCertificationLevel()
    {
        return CertificationLevel;
    }

    @Override
    public void setCertificationLevel(CertificationLevel certificationLevel)
    {
        CertificationLevel = certificationLevel;
    }
}
