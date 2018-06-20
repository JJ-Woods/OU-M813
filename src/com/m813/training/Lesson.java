package com.m813.training;

public abstract class Lesson
{
    private String LessonCode;

    private String LessonName;

    public String getLessonCode()
    {
        return this.LessonCode;
    }

    public void setLessonCode(String lessonCode)
    {
        this.LessonCode = lessonCode;
    }

    public String getLessonName()
    {
        return this.LessonName;
    }

    public void setLessonName(String lessonName)
    {
        this.LessonName = lessonName;
    }
}
