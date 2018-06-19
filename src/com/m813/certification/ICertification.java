package com.m813.certification;

public interface ICertification
{
    CertificationAgency getCertificationAgency();
    void setCertificationAgency(CertificationAgency agency);

    CertificationLevel getCertificationLevel();
    void setCertificationLevel(CertificationLevel level);
}
