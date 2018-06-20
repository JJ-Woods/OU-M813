package com.m813.training;

import com.m813.membership.*;

import java.util.List;

public class Course
{
    private Member LeadInstructor;

    private List<Member> Students;

    private Programme Programme;

    public Member getLeadInstructor()
    {
        return this.LeadInstructor;
    }

    public void setLeadInstructor(Member leadInstructor)
    {
        this.LeadInstructor = leadInstructor;
    }

    public List<Member> getStudents()
    {
        return this.Students;
    }

    public void setStudents(List<Member> students)
    {
        this.Students = students;
    }

    public void addStudent(Member student)
    {
        this.Students.add(student);
    }

    public com.m813.training.Programme getProgramme()
    {
        return this.Programme;
    }

    public void setProgramme(com.m813.training.Programme programme)
    {
        this.Programme = programme;
    }
}