package com.m813.repositories;

import com.m813.datamodel.equipment.*;

import java.util.Date;
import java.util.HashMap;

public class EquipmentRepository extends RepositoryBase<Equipment>
{
    /*
    * @Identifier = SO1
    * @Invariant = True
    * @Precondition:
    *     --purchased must be on or before the date the function is executed
    *     --category, name, brand, description, purchased must not be null or empty string
    * @Postcondition:
    *     --return an object of the new EquipmentRecord
    *     --which exists in the repository
    *     --who main attributes are initialized and not null
    *     --or return null
    *     --with error messages in the error dictionary
    */
    public Equipment createEquipment(Class<? extends Equipment> type, String name, EquipmentBrand brand,
                                     Date purchased, Date lastService, HashMap<String, String> errors)
    {
        HashMap<String, String> localErrors = new HashMap<>();
        String methodKey = "Equipment_CreateEquipment";

        if(name == null)
        {
            localErrors.put(methodKey, "Please supply an name for this equipment");
        }

        if(brand == null)
        {
            localErrors.put(methodKey, "Please supply a brand for this equipment");
        }

        if(purchased == null)
        {
            localErrors.put(methodKey, "Please specify when this equipment was purchased");
        }
        else
        {
            Date today = new Date();
            if(purchased.before(today))
            {
                localErrors.put(methodKey, "Please enter a valid date for when this equipment was purchased");
            }
        }

        if(localErrors.size() > 0)
        {
            errors.putAll(localErrors);
            return null;
        }
        else
        {
            Equipment newEquipment = EquipmentFactory.newEquipment(type, name, brand, purchased, lastService);
            _allEntities.add(newEquipment);
            return newEquipment;
        }
    }
}
