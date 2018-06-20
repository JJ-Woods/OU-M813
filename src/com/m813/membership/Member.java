package com.m813.membership;

import com.m813.certification.*;

import java.util.List;

public class Member
{
    private int MemberId;

    private String MemberName;

    private String MemberEmail;

    private MemberRole MemberRole;

    private MemberCategory MemberCategory;

    private List<Certification> Qualifications;

    public int getMemberId()
    {
        return this.MemberId;
    }

    public void setMemberId(int memberId)
    {
        this.MemberId = memberId;
    }

    public String getMemberName()
    {
        return this.MemberName;
    }

    public void setMemberName(String memberName)
    {
        this.MemberName = memberName;
    }

    public String getMemberEmail()
    {
        return this.MemberEmail;
    }

    public void setMemberEmail(String memberEmail)
    {
        this.MemberEmail = memberEmail;
    }

    public com.m813.membership.MemberRole getMemberRole()
    {
        return this.MemberRole;
    }

    public void setMemberRole(com.m813.membership.MemberRole memberRole)
    {
        this.MemberRole = memberRole;
    }

    public com.m813.membership.MemberCategory getMemberCategory()
    {
        return this.MemberCategory;
    }

    public void setMemberCategory(com.m813.membership.MemberCategory memberCategory)
    {
        this.MemberCategory = memberCategory;
    }

    public List<Certification> getQualifications()
    {
        return this.Qualifications;
    }

    public void setQualifications(List<Certification> qualifications)
    {
        this.Qualifications = qualifications;
    }

    public void addQualification(Certification cert)
    {
        this.Qualifications.add(cert);
    }
}
