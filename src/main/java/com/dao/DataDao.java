package com.dao;

import com.dao.Entities.Data;
import org.hibernate.PropertyNotFoundException;
import org.postgresql.util.PSQLException;

import javax.persistence.PersistenceException;

public class DataDao extends Connection  {

    public Data addData(Data data) throws PSQLException {
        beginTransaction();
        session.save(data);
        endTransaction();
        return data;
    }

}
