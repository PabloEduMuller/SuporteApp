package com.example.suporteapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    // Nome do banco de dados
    private static final String DATABASE_NAME = "suporteapp.db";
    private static final int DATABASE_VERSION = 1;

    // Nome da tabela
    public static final String TABLE_CHAMADOS = "chamados";

    // Colunas da tabela
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_DEPARTAMENTO = "departamento";
    public static final String COLUMN_NOME_SOLICITANTE = "nome_solicitante";
    public static final String COLUMN_OCORRENCIA = "ocorrencia";
    public static final String COLUMN_URGENCIA = "urgencia";
    public static final String COLUMN_NOME_FUNCIONARIO = "nome_funcionario";
    public static final String COLUMN_TELEFONE_FUNCIONARIO = "telefone_funcionario";

    // SQL de criação da tabela
    private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_CHAMADOS + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_DEPARTAMENTO + " TEXT, " +
                    COLUMN_NOME_SOLICITANTE + " TEXT, " +
                    COLUMN_OCORRENCIA + " TEXT, " +
                    COLUMN_URGENCIA + " TEXT, " +
                    COLUMN_NOME_FUNCIONARIO + " TEXT, " +
                    COLUMN_TELEFONE_FUNCIONARIO + " TEXT" +
                    ");";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Criação da tabela no banco de dados
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Não implementado, caso precise de versões posteriores
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CHAMADOS);
        onCreate(db);
    }
}
