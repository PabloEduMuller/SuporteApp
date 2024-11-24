package com.example.suporteapp.view.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.suporteapp.R;

public class OpcoesActivity extends AppCompatActivity {

    private Button btSair;
    private ImageButton ibHome;
    private Button btLigarSuporte;
    private Button btChatSuporte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_ou_ligar);

        // Inicializando os botões
        btSair = findViewById(R.id.btSair);
        ibHome = findViewById(R.id.ibHome);
        btLigarSuporte = findViewById(R.id.btLigarSuporte);
        btChatSuporte = findViewById(R.id.btChatSuporte);

        // Ação para o botão "Sair"
        btSair.setOnClickListener(v -> {
            Intent intent = new Intent(OpcoesActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });

        // Ação para o botão "Home"
        ibHome.setOnClickListener(v -> {
            Intent intent = new Intent(OpcoesActivity.this, ChamadoActivity.class);
            startActivity(intent);
        });

        // Ação para "Ligar para Suporte"
        btLigarSuporte.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:45999999999"));
            startActivity(intent);
        });

        // Ação para "Chat do Suporte"
        btChatSuporte.setOnClickListener(v -> {
            String url = "https://wa.me/45999999999?text=Ol%C3%A1%20suporte%2C%20preciso%20de%20ajuda";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        });
    }
}
