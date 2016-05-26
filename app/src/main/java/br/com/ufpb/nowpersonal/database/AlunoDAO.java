package br.com.ufpb.nowpersonal.database;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.List;

import br.com.ufpb.nowpersonal.model.Aluno;

/**
 * Created by ruanm on 25/05/2016.
 */
public class AlunoDAO extends BaseDaoImpl<Aluno, Integer> {

    public AlunoDAO(ConnectionSource source) throws SQLException {
        super(source, Aluno.class);
        initialize();
    }

    @Override
    public QueryBuilder<Aluno, Integer> queryBuilder() {
        return super.queryBuilder();
    }
    //Com este método, você pode fazer os selects específicos utilizando as clausulas construídas
    //utilizando o queryBuilder
    @Override
    public List<Aluno> query(PreparedQuery<Aluno> preparedQuery) throws SQLException {
        return super.query(preparedQuery);
    }

}
