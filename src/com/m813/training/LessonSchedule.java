package com.m813.training;

import com.m813.membership.Member;

import java.util.Date;
import java.util.List;

public class LessonSchedule
{
    private List<Member> Students;

    private Date LessonDate;

    private String LessonNotes;

    private Lesson Lesson;

    private Course Course;
    
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

    public Date getLessonDate()
    {
        return this.LessonDate;
    }

    public void setLessonDate(Date lessonDate)
    {
        this.LessonDate = lessonDate;
    }

    public String getLessonNotes()
    {
        return this.LessonNotes;
    }

    public void setLessonNotes(String lessonNotes)
    {
        this.LessonNotes = lessonNotes;
    }

    public com.m813.training.Lesson getLesson()
    {
        return this.Lesson;
    }

    public void setLesson(com.m813.training.Lesson lesson)
    {
        this.Lesson = lesson;
    }

    public com.m813.training.Course getCourse()
    {
        return this.Course;
    }

    public void setCourse(com.m813.training.Course course)
    {
        this.Course = course;
    }
}
