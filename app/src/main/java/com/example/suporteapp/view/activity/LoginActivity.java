package com.example.suporteapp.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.suporteapp.R;

public class LoginActivity extends AppCompatActivity {

    private EditText edEmail, edSenha;
    private Button btLogar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login); // Use o layout correspondente (activity_login.xml)

        // Inicializando os campos
        edEmail = findViewById(R.id.edEmail);
        edSenha = findViewById(R.id.edSenha);
        btLogar = findViewById(R.id.btLogar);

        // Definindo o listener do botão de login
        btLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Captura os dados dos campos
                String email = edEmail.getText().toString();
                String senha = edSenha.getText().toString();

                // Verifica se os campos não estão vazios
                if (email.isEmpty() || senha.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Por favor, preencha todos os campos!", Toast.LENGTH_SHORT).show();
                    return;
                }


                if (email.equals("suporte@tech.com") && senha.equals("123456")) {
                    Intent intent = new Intent(LoginActivity.this, ChamadoActivity.class); // Mude para a sua próxima Activity
                    startActivity(intent);
                    finish();
                } else {
                    // Senha ou email incorretos
                    Toast.makeText(LoginActivity.this, "Email ou senha incorretos!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
