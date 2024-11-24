package com.example.suporteapp.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.suporteapp.R;
import com.example.suporteapp.controller.ChamadoController;
import com.example.suporteapp.model.Chamado;

public class ChamadoActivity extends AppCompatActivity {
    private EditText edNomeSolicitante, edDepartamento, edOcorrencia;
    private RadioGroup rgUrgencia;
    private Button btEnviarChamado;

    private ChamadoController chamadoController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chamado);

        chamadoController = new ChamadoController(this);

        edNomeSolicitante = findViewById(R.id.edNomeSolicitante);
        edDepartamento = findViewById(R.id.edDepartamento);
        edOcorrencia = findViewById(R.id.edOcorrencia);
        rgUrgencia = findViewById(R.id.rgUrgencia);
        btEnviarChamado = findViewById(R.id.btEnviarChamado);

        btEnviarChamado.setOnClickListener(view -> {
            // Captura os dados inseridos no formulário
            String nome = edNomeSolicitante.getText().toString().trim();
            String departamento = edDepartamento.getText().toString().trim();
            String ocorrencia = edOcorrencia.getText().toString().trim();
            String urgencia = getUrgenciaSelecionada();

            // Verificar se algum campo está vazio ou não selecionado
            if (nome.isEmpty() || departamento.isEmpty() || ocorrencia.isEmpty() || urgencia.isEmpty()) {
                Toast.makeText(this, "Por favor, preencha todos os campos obrigatórios!", Toast.LENGTH_SHORT).show();
                return; // Não prosseguir se algum campo não estiver preenchido
            }

            // Criação do objeto Chamado e envio para o controlador
            Chamado chamado = new Chamado(departamento, nome, ocorrencia, urgencia, "João Carlos", "(45) 99999-9999");
            chamadoController.salvarChamado(chamado);

            // Feedback para o usuário
            Toast.makeText(this, "Chamado enviado com sucesso!", Toast.LENGTH_SHORT).show();

            // Navegar para a próxima tela (dados)
            Intent intent = new Intent(ChamadoActivity.this, DadosActivity.class);
            // Passar dados para a tela de dados (se necessário)
            intent.putExtra("nome", nome); // Passando o nome
            intent.putExtra("departamento", departamento); // Passando o departamento
            intent.putExtra("ocorrencia", ocorrencia); // Passando a ocorrência
            intent.putExtra("urgencia", urgencia); // Passando a urgência
            startActivity(intent);

            // Finaliza a ChamadoActivity para evitar que o usuário volte para ela com o botão "voltar"
            finish();
        });
    }

    private String getUrgenciaSelecionada() {
        int selectedId = rgUrgencia.getCheckedRadioButtonId();
        if (selectedId == -1) { // Verifica se nenhuma opção foi selecionada
            return ""; // Retorna vazio para indicar que não foi selecionado
        }
        RadioButton radioButton = findViewById(selectedId);
        return radioButton.getText().toString();
    }
}
