package com.m813.repositories;

import com.m813.NotImplementedException;
import com.m813.datamodel.membership.*;

import java.util.List;

public class MembershipRepository extends RepositoryBase
{
    private List<Member> allMembers;

    private List<MemberCategory> allCategories;

    public Member[] getAllMembers() throws NotImplementedException
    {
        throw new NotImplementedException();
    }

    public Member[] getMembersByName(String name) throws NotImplementedException
    {
        throw new NotImplementedException();
    }

    public Member[] getMembersByEmail(String email) throws NotImplementedException
    {
        throw new NotImplementedException();
    }

    public Member[] getMembersByRole(MemberRole role) throws NotImplementedException
    {
        throw new NotImplementedException();
    }

    public Member[] getMembersByQualification(QualificationRepository cert) throws NotImplementedException
    {
        throw new NotImplementedException();
    }

    public Boolean updateMemberName(Member mem, String newName) throws NotImplementedException
    {
        throw new NotImplementedException();
    }

    public Boolean updateMemberEmail(Member mem, String newEmail) throws NotImplementedException
    {
        throw new NotImplementedException();
    }

    public Boolean updateMemberRole(Member mem, MemberRole role) throws NotImplementedException
    {
        throw new NotImplementedException();
    }

    public Boolean updateMemberQualification(Member mem, QualificationRepository cert) throws NotImplementedException
    {
        throw new NotImplementedException();
    }

    public Member createMember(String name, String email, MemberRole role, QualificationRepository[] quals) throws NotImplementedException
    {
        throw new NotImplementedException();
    }

    public Member createMember(String name, String email)  throws NotImplementedException
    {
        return createMember(name, email, MemberRole.MEMBER, new QualificationRepository[]{});
    }

    public Member createMember(String name, String email, MemberRole role)  throws NotImplementedException
    {
        return createMember(name, email, role, null);
    }

    public Member createMember(String name, String email, QualificationRepository[] quals)  throws NotImplementedException
    {
        return createMember(name, email, MemberRole.MEMBER, quals);
    }

    public MemberCategory[] getAllCategories() throws NotImplementedException
    {
        throw new NotImplementedException();
    }

    public MemberCategory[] getCategorieByName(String name) throws NotImplementedException
    {
        throw new NotImplementedException();
    }

    public Boolean updateCategoryName(MemberCategory cat, String name) throws NotImplementedException
    {
        throw new NotImplementedException();
    }

    public Boolean updateCategoryDuration(MemberCategory cat, int duration) throws NotImplementedException
    {
        throw new NotImplementedException();
    }

    public Boolean updateCategoryCost(MemberCategory cat, float cost) throws NotImplementedException
    {
        throw new NotImplementedException();
    }

    public MemberCategory createCatagory(String name, int duration, float cost) throws NotImplementedException
    {
        throw new NotImplementedException();
    }
}