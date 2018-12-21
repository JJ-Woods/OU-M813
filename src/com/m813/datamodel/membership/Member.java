package com.m813.datamodel.membership;

import com.m813.datamodel.IEntity;
import com.m813.datamodel.certification.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Member extends IEntity
{
    private String MemberName;

    private String MemberEmail;

    private MemberRole MemberRole;

    private MemberCategory MemberCategory;

    private List<Certification> Qualifications;

    private Date MembershipStart;

    public Member(String id, String name, String email, MemberRole role, MemberCategory category, Date membershipStart)
    {
        Id = id;
        MemberName = name;
        MemberEmail = email;
        MemberRole = role;
        MemberCategory = category;
        MembershipStart = membershipStart;
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

    public MemberRole getMemberRole()
    {
        return this.MemberRole;
    }

    public void setMemberRole(MemberRole memberRole)
    {
        this.MemberRole = memberRole;
    }

    public com.m813.datamodel.membership.MemberCategory getMemberCategory()
    {
        return this.MemberCategory;
    }

    public void setMemberCategory(com.m813.datamodel.membership.MemberCategory memberCategory)
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

    public Date getMembershipStart()
    {
        return this.MembershipStart;
    }

    public void setMembershipStart(Date date)
    {
        this.MembershipStart = date;
    }

    public Date getMembershipEnd()
    {
        //could get properties direct, but time formatting may occur in getters
        Calendar cal = Calendar.getInstance();
        cal.setTime(getMembershipStart());
        int memDuration = getMemberCategory().getCategoryDuration();

        cal.add(Calendar.MONTH, memDuration);

        return cal.getTime();
    }

    public Boolean isCurrentMember()
    {
        Date today = new Date();
        Date membershipEnd = getMembershipEnd();

        return today.before(membershipEnd);
    }
}
