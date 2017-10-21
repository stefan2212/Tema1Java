package com.dao.repository;

import com.dao.Entities.Data;
import org.hibernate.query.Query;
import org.postgresql.util.PSQLException;

import java.util.List;
public class DataDao extends Connection  {

    public Data addData(Data data) throws PSQLException {
        beginTransaction();
        session.save(data);
        endTransaction();
        return data;
    }

    public List<Data> getAllData(){
        String hql = "SELECT c FROM Data c";
        beginTransaction();
        Query query = session.createQuery(hql);
        List results = query.list();
        endTransaction();
        return results;
    }

}
