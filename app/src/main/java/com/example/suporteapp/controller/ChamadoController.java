package com.example.suporteapp.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.suporteapp.DatabaseHelper;
import com.example.suporteapp.model.Chamado;

import java.util.ArrayList;
import java.util.List;

public class ChamadoController {
    private DatabaseHelper databaseHelper;

    public ChamadoController(Context context) {
        databaseHelper = new DatabaseHelper(context);
    }

    // Método para salvar chamado
    public void salvarChamado(Chamado chamado) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_DEPARTAMENTO, chamado.getDepartamento());
        values.put(DatabaseHelper.COLUMN_NOME_SOLICITANTE, chamado.getNomeSolicitante());
        values.put(DatabaseHelper.COLUMN_OCORRENCIA, chamado.getOcorrencia());
        values.put(DatabaseHelper.COLUMN_URGENCIA, chamado.getUrgencia());
        values.put(DatabaseHelper.COLUMN_NOME_FUNCIONARIO, chamado.getNomeFuncionario());
        values.put(DatabaseHelper.COLUMN_TELEFONE_FUNCIONARIO, chamado.getTelefoneFuncionario());

        db.insert(DatabaseHelper.TABLE_CHAMADOS, null, values);
        db.close();
    }

    // Método para buscar todos os chamados
    public List<Chamado> getTodosChamados() {
        List<Chamado> chamados = new ArrayList<>();
        SQLiteDatabase db = databaseHelper.getReadableDatabase();

        Cursor cursor = db.query(DatabaseHelper.TABLE_CHAMADOS, null, null, null, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                String departamento = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_DEPARTAMENTO));
                String nomeSolicitante = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NOME_SOLICITANTE));
                String ocorrencia = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_OCORRENCIA));
                String urgencia = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_URGENCIA));
                String nomeFuncionario = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NOME_FUNCIONARIO));
                String telefoneFuncionario = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_TELEFONE_FUNCIONARIO));

                Chamado chamado = new Chamado(departamento, nomeSolicitante, ocorrencia, urgencia, nomeFuncionario, telefoneFuncionario);
                chamados.add(chamado);
            } while (cursor.moveToNext());

            cursor.close();
        }
        return chamados;
    }
}
