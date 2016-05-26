package br.com.ufpb.nowpersonal.database;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.List;

import br.com.ufpb.nowpersonal.model.Personal;

/**
 * Created by ruanm on 25/05/2016.
 */
public class PersonalDAO extends BaseDaoImpl<Personal, Integer> {
    public PersonalDAO(ConnectionSource source) throws SQLException {
        super(source, Personal.class);
        initialize();
    }

    @Override
    public QueryBuilder<Personal, Integer> queryBuilder() {
        return super.queryBuilder();
    }
    //Com este método, você pode fazer os selects específicos utilizando as clausulas construídas
    //utilizando o queryBuilder
    @Override
    public List<Personal> query(PreparedQuery<Personal> preparedQuery) throws SQLException {
        return super.query(preparedQuery);
    }
}
