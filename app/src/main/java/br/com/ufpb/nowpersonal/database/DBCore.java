package br.com.ufpb.nowpersonal.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import br.com.ufpb.nowpersonal.model.Aluno;

/**
 * Created by ruanm on 25/05/2016.
 */
public class DBCore extends OrmLiteSqliteOpenHelper {

    private static final String DB_NAME = "NowPersonalDB";
    private static final int VERSION_DB = 1;

    public DBCore(Context context){
        super(context, DB_NAME, null, VERSION_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try{
            TableUtils.createTable(connectionSource, Aluno.class);
        }catch (SQLException e){
            e.getErrorCode();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {

    }
}
