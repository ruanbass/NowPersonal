package br.com.ufpb.nowpersonal;

import android.app.Application;

import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.List;

import br.com.ufpb.nowpersonal.database.AlunoDAO;
import br.com.ufpb.nowpersonal.database.DBCore;
import br.com.ufpb.nowpersonal.database.PersonalDAO;
import br.com.ufpb.nowpersonal.model.Aluno;
import br.com.ufpb.nowpersonal.model.Personal;

public class NowPersonalApplication extends Application {

    private DBCore dbCore;
    private AlunoDAO alunoDAO;
    private PersonalDAO personalDAO;
    @Override
    public void onCreate() {
        super.onCreate();
        dbCore = new DBCore(getBaseContext());
        try {
            alunoDAO = new AlunoDAO(dbCore.getConnectionSource());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public void addAluno(Aluno aluno) throws SQLException {
        alunoDAO.createOrUpdate(aluno);
    }
    public void addPersonal(Personal personal) throws SQLException {
        personalDAO.createOrUpdate(personal);
    }

    public List<Aluno> getAlunos() throws SQLException {
        return alunoDAO.queryForAll();
    }
    public List<Personal> getPersonal() throws SQLException {
        return personalDAO.queryForAll();
    }

    public Aluno getAlunoPorId(int id) throws SQLException {
        Aluno aluno = alunoDAO.queryForId(id);//SELECT ESPECÍFICO
        return aluno;
    }
    public List<Personal> getPerosnalBairro(String localAdendimento) throws SQLException {
        // get our query builder from the DAO
        QueryBuilder<Personal, Integer> queryBuilder =
                personalDAO.queryBuilder();
        // the 'password' field must be equal to "qwerty"
        queryBuilder.where().like("(localAdendimento)", "%"+localAdendimento+"%");
        // prepare our sql statement
        PreparedQuery<Personal> preparedQuery = queryBuilder.prepare();
        // query for all accounts that have "qwerty" as a password
        List<Personal> personais = personalDAO.query(preparedQuery);

        return personais;
    }


}
