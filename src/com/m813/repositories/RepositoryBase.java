package com.m813.repositories;

import com.m813.datamodel.IEntity;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

abstract class RepositoryBase<T extends IEntity>
{
    RepositoryBase()
    {
        _allEntities = new LinkedList<>();
    }

    List<T> _allEntities;

    public List<T> getAll()
    {
        return _allEntities;
    }

    public void removeSelected(T entity)
    {
        _allEntities.remove(entity);
    }

    public void removeSelected(List<T> entities)
    {
        for(T entity : entities)
        {
            removeSelected(entity);
        }
    }

    List<T> filterEntities(Predicate<T> filter)
    {
        List<T> filtered = new LinkedList<>();

        for(T entity : _allEntities)
        {
            if(filter.test(entity))
            {
                filtered.add(entity);
            }
        }

        return filtered;
    }

    T getSingle(Predicate<T> filter) throws Exception
    {
        List<T> filteredEntities = filterEntities(filter);

        if(filteredEntities.size() == 1)
        {
            return filteredEntities.get(0);
        }
        else if(filteredEntities.size() == 0)
        {
            return null;
        }
        else
        {
            throw new Exception("Found many of <T>, expected 1");
        }
    }
}
