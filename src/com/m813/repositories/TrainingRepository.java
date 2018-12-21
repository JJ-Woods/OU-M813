package com.m813.repositories;

import com.m813.NotImplementedException;
import com.m813.datamodel.membership.*;
import com.m813.datamodel.training.*;

import java.util.List;

public class TrainingRepository extends RepositoryBase
{
    private List<Course> allCourses;

    public Course[] getAllCourses()
    {
        throw new NotImplementedException();
    }

    public Course[] getCourseByInstructor(Member instructor)
    {
        throw new NotImplementedException();
    }

    public Course[] getCourseByStudent(Member student)
    {
        throw new NotImplementedException();
    }

    public Course[] getCourseByProgramme(Programme prog)
    {
        throw new NotImplementedException();
    }

    public Boolean updateCourseInstructor(Course course, Member instructor)
    {
        throw new NotImplementedException();
    }

    public Boolean updateCourseStudents(Course course, Member[] students)
    {
        throw new NotImplementedException();
    }

    public Boolean addCourseStudent(Course course, Member newStudent)
    {
        throw new NotImplementedException();
    }

    public Boolean removeStudentFromCourse(Course course, Member student)
    {
        throw new NotImplementedException();
    }

    public Course newCourse(Member instructor, Member[] students, Programme prog)
    {
        throw new NotImplementedException();
    }

    public Course newCourse(Member instructor, Programme prog)
    {
        return newCourse(instructor, new Member[]{}, prog);
    }
}
