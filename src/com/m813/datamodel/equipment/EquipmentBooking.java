package com.m813.datamodel.equipment;

import com.m813.datamodel.IEntity;
import com.m813.datamodel.membership.*;
import com.m813.datamodel.training.*;

import java.util.Date;

public class EquipmentBooking extends IEntity
{
    private Member Member;

    private Course Course;

    private Equipment Equipment;

    private Date StartDate;

    private Date EndDate;

    public EquipmentBooking(Member member, Course course, Equipment equipment, Date startDate, Date endDate)
    {
        Member = member;
        Course = course;
        Equipment = equipment;
        StartDate = startDate;
        EndDate = endDate;
    }

    public Member getMember()
    {
        return this.Member;
    }

    public void setMember(Member member)
    {
        this.Member = member;
    }

    public Course getCourse()
    {
        return this.Course;
    }

    public void setCourse(Course course)
    {
        this.Course = course;
    }

    public Equipment getEquipment()
    {
        return this.Equipment;
    }

    public void setEquipment(Equipment equipment)
    {
        this.Equipment = equipment;
    }

    public Date getStartDate()
    {
        return this.StartDate;
    }

    public void setStartDate(Date startDate)
    {
        this.StartDate = startDate;
    }

    public Date getEndDate()
    {
        return this.EndDate;
    }

    public void setEndDate(Date endDate)
    {
        this.EndDate = endDate;
    }
}
