package com.m813.repositories;

import com.m813.datamodel.membership.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public class MembershipRepository
{
    private List<Member> allMembers;

    private List<MemberCategory> allCategories;

    public Member[] getAllMembers()
    {
        throw new NotImplementedException();
    }

    public Member[] getMembersByName(String name)
    {
        throw new NotImplementedException();
    }

    public Member[] getMembersByEmail(String email)
    {
        throw new NotImplementedException();
    }

    public Member[] getMembersByRole(MemberRole role)
    {
        throw new NotImplementedException();
    }

    public Member[] getMembersByQualification(QualificationRepository cert)
    {
        throw new NotImplementedException();
    }

    public Boolean updateMemberName(Member mem, String newName)
    {
        throw new NotImplementedException();
    }

    public Boolean updateMemberEmail(Member mem, String newEmail)
    {
        throw new NotImplementedException();
    }

    public Boolean updateMemberRole(Member mem, MemberRole role)
    {
        throw new NotImplementedException();
    }

    public Boolean updateMemberQualification(Member mem, QualificationRepository cert)
    {
        throw new NotImplementedException();
    }

    public Member createMember(String name, String email, MemberRole role, QualificationRepository[] quals)
    {
        throw new NotImplementedException();
    }

    public Member createMember(String name, String email)
    {
        return createMember(name, email, MemberRole.MEMBER, new QualificationRepository[]{});
    }

    public Member createMember(String name, String email, MemberRole role)
    {
        return createMember(name, email, role, null);
    }

    public Member createMember(String name, String email, QualificationRepository[] quals)
    {
        return createMember(name, email, MemberRole.MEMBER, quals);
    }

    public MemberCategory[] getAllCategories()
    {
        throw new NotImplementedException();
    }

    public MemberCategory[] getCategorieByName(String name)
    {
        throw new NotImplementedException();
    }

    public Boolean updateCategoryName(MemberCategory cat, String name)
    {
        throw new NotImplementedException();
    }

    public Boolean updateCategoryDuration(MemberCategory cat, int duration)
    {
        throw new NotImplementedException();
    }

    public Boolean updateCategoryCost(MemberCategory cat, float cost)
    {
        throw new NotImplementedException();
    }

    public MemberCategory createCatagory(String name, int duration, float cost)
    {
        throw new NotImplementedException();
    }
}