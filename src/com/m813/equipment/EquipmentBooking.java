package com.m813.equipment;

import com.m813.membership.*;
import com.m813.training.*;

import java.util.Date;

public class EquipmentBooking
{
    private Member Member;

    private Course Course;

    private IEquipment Equipment;

    private Date StartDate;

    private Date EndDate;

    public Member getMember()
    {
        return Member;
    }

    public void setMember(Member member)
    {
        Member = member;
    }

    public Course getCourse()
    {
        return Course;
    }

    public void setCourse(Course course)
    {
        Course = course;
    }

    public IEquipment getEquipment()
    {
        return Equipment;
    }

    public void setEquipment(IEquipment equipment)
    {
        Equipment = equipment;
    }

    public Date getStartDate()
    {
        return StartDate;
    }

    public void setStartDate(Date startDate)
    {
        StartDate = startDate;
    }

    public Date getEndDate()
    {
        return EndDate;
    }

    public void setEndDate(Date endDate)
    {
        EndDate = endDate;
    }
}
