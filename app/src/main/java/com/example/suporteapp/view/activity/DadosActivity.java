package com.example.suporteapp.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.suporteapp.R;

public class DadosActivity extends AppCompatActivity {
    private TextView tvNome, tvDepartamento, tvOcorrencia, tvUrgencia;
    private Button btnAvancar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_de_dados);

        // Inicializando os TextViews
        tvNome = findViewById(R.id.tvNomeSolicitante);
        tvDepartamento = findViewById(R.id.tvDepartamento);
        tvOcorrencia = findViewById(R.id.tvOcorrencia);
        tvUrgencia = findViewById(R.id.tvUrgencia);

        // Inicializando o botão Avançar
        btnAvancar = findViewById(R.id.btAvancar);

        // Recebendo os dados passados pela ChamadoActivity
        Intent intent = getIntent();
        String nome = intent.getStringExtra("nome");
        String departamento = intent.getStringExtra("departamento");
        String ocorrencia = intent.getStringExtra("ocorrencia");
        String urgencia = intent.getStringExtra("urgencia");

        // Exibindo os dados nas TextViews com título e valor
        tvNome.setText(nome != null && !nome.isEmpty() ? "Nome: " + nome : "Nome não disponível");
        tvDepartamento.setText(departamento != null && !departamento.isEmpty() ? "Departamento: " + departamento : "Departamento não disponível");
        tvOcorrencia.setText(ocorrencia != null && !ocorrencia.isEmpty() ? "Ocorrência: " + ocorrencia : "Ocorrência não disponível");
        tvUrgencia.setText(urgencia != null && !urgencia.isEmpty() ? "Urgência: " + urgencia : "Urgência não disponível");

        // Configurando o clique do botão Avançar
        btnAvancar.setOnClickListener(view -> {
            // Criando a Intent para navegar para a OpcoesActivity
            Intent opcoesIntent = new Intent(DadosActivity.this, OpcoesActivity.class);
            startActivity(opcoesIntent); // Inicia a nova Activity
        });
    }
}
