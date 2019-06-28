package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
    }

    //seleciona parâmeto view quando o evento click é referente a uma imagem.
    public void selecionarPedra(View view) {
        this.opcaoSelecionada(1);
    }

    public void selecionarPapel(View view){
        this.opcaoSelecionada(2);
    }

    public void selecionarTesoura(View view){
        this.opcaoSelecionada(3);
    }

    public void opcaoSelecionada(int escolhaUsuario){
        ImageView ImagemEscolhaApp = findViewById(R.id.ImagemEcolhaApp);
        TextView textResultado = findViewById(R.id.textResultado);

        //gerar número aleatório para escolha do App de 0 à 2
        int[] opcoes = {1, 2, 3};
        int numero = new Random().nextInt(3);
        int escolhadoApp = opcoes[numero];

        //Definir imagem da escolha
        switch (escolhadoApp){
            case 1:
                ImagemEscolhaApp.setImageResource(R.drawable.pedra);
                break;
            case 2:
                ImagemEscolhaApp.setImageResource(R.drawable.papel);
                break;
            case 3:
                ImagemEscolhaApp.setImageResource(R.drawable.tesoura);
                break;
        }

        //Apresenta mensagem na tela
        if(
                (escolhadoApp==1 && escolhaUsuario==3) ||
                        (escolhadoApp==2 && escolhaUsuario==1) ||
                        (escolhadoApp==3 && escolhaUsuario==2))
        {
            textResultado.setText("Você perdeu!");

        }else if((escolhaUsuario==1 && escolhadoApp==3) ||
        (escolhaUsuario==2 && escolhadoApp==1) ||
                (escolhaUsuario==3 && escolhadoApp==2))
        {
            textResultado.setText("Você ganhou!");

        }else {
            textResultado.setText("Empatamos!");
        }
    }
}
