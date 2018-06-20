package com.m813.controllers;

import com.m813.certification.*;
import com.m813.membership.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public class Membership
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

    public Member[] getMembersByQualification(Certification cert)
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

    public Boolean updateMemberQualification(Member mem, Certification cert)
    {
        throw new NotImplementedException();
    }

    public Member createMember(String name, String email, MemberRole role, Certification[] quals)
    {
        throw new NotImplementedException();
    }

    public Member createMember(String name, String email)
    {
        return createMember(name, email, MemberRole.MEMBER, new Certification[]{});
    }

    public Member createMember(String name, String email, MemberRole role)
    {
        return createMember(name, email, role, null);
    }

    public Member createMember(String name, String email, Certification[] quals)
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

    public MemberCategory createCatagory(String name, int duration, float cost)
    {
        throw new NotImplementedException();
    }
}