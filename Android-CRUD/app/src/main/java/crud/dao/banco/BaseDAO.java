package crud.dao.banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDAO extends SQLiteOpenHelper {
	
	public static final String TABLE_USUARIO = "usuarioCRUD";
	public static final String USUARIO_ID = "_id";
	public static final String USUARIO_NOME = "nome";
	public static final String USUARIO_CPF = "cpf";
	public static final String USUARIO_TELEFONE = "telefone";
	public static final String USUARIO_EMAIL = "email";
	
	public static final String DATABASE_NAME = "usuario.db";
	public static final int DATABASE_VERSION = 1;
	
	public static final String CREATE_USUARIO = "create table " + TABLE_USUARIO + " ( " +
								USUARIO_ID			+ " integer primary key autoincrement, " +
								USUARIO_NOME		+ " text not null, " +
								USUARIO_CPF			+ " text not null, " +
								USUARIO_TELEFONE	+ " text not null, " +
								USUARIO_EMAIL		+ " text not null);";

	public BaseDAO(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase database) {
		System.out.println("passou no " + this.toString());
		database.execSQL(CREATE_USUARIO);
	}

	@Override
	public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
		database.execSQL("DROP TABLE IF EXISTS " + TABLE_USUARIO);
		onCreate(database);
	}

}
