package com.m813.repositories;

import com.m813.NotImplementedException;
import com.m813.datamodel.certification.*;

import java.util.List;

public class QualificationRepository extends RepositoryBase
{
    private List<Certification> allQualifications;

    public Certification[] getAllQualifications()
    {
        throw new NotImplementedException();
    }

    public Certification[] getQualificationsByName(String name)
    {
        throw new NotImplementedException();
    }

    public Certification[] getQualificationByAgency(CertificationAgency agency)
    {
        throw new NotImplementedException();
    }

    public Certification[] getQualificationByLevel(CertificationLevel level)
    {
        throw new NotImplementedException();
    }

    public Boolean updateQualificationName(Certification qual, String name)
    {
        throw new NotImplementedException();
    }

    public Boolean updateQualificationAgency(Certification qual, CertificationAgency agency)
    {
        throw new NotImplementedException();
    }

    public Boolean updateQualificationLevel(Certification qual, CertificationLevel level)
    {
        throw new NotImplementedException();
    }
}
