package com.m813.membership;

import com.m813.certification.ICertification;

import java.util.List;

public class Member
{
    private int MemberId;

    private String MemberName;

    private String MemberEmail;

    private MemberRole MemberRole;

    private MemberCategory MemberCategory;

    private List<ICertification> Qualifications;
}
