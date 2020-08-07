package br.com.silver.jokenp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


  //

 //

    private String pedra = "pedra";
    private String papel = "papel";
    private String tesoura = "tesoura";
    public int pontuacaoJoagdor=0;
    public int pontuacaoMaquina=0;

    public void pedra(View view) {
    jogada(pedra);

    }
    public void papel(View view) {
    jogada(papel);
    }
    public void tesoura(View view) {
       jogada(tesoura);
    }


    public void jogada(String jogada){
        ImageView respostaPcView = findViewById(R.id.activity_main__view_resposta_da_maquina);
        TextView msgJogadorPontos = findViewById(R.id.activity_main_pontuacao_jogador);
        TextView msgMaquinaPontos  = findViewById(R.id.activity_main_pontucao_maquina);
     //   TextView msgResultado = findViewById(R.id.activity_main_txtview_resultado);
        TextView msgResultado = findViewById(R.id.acticity_main_txt_fim_partida);
      //  zerarStatus();
        int jogadaPc = new Random().nextInt(3);
        ArrayList jokeipo = new ArrayList(Arrays.asList(pedra,papel,tesoura));

        switch (jogadaPc){
            case 0: respostaPcView.setImageResource(R.drawable.pedra);
            break;
            case 1: respostaPcView.setImageResource(R.drawable.papel);
            break;
            case 2: respostaPcView.setImageResource(R.drawable.tesoura);
        }


        if (jokeipo.get(jogadaPc).equals(pedra) && jogada.equals(tesoura)  ||
                jokeipo.get(jogadaPc).equals(papel) && jogada.equals(pedra) ||
                jokeipo.get(jogadaPc).equals(tesoura) && jogada.equals(papel)){
            //acompanhar===============================================================================
            pontuacaoMaquina++;
            msgMaquinaPontos.setText(Integer.toString(pontuacaoMaquina));
            msgResultado.setText("\n" +
                    "Less a point!");
            fimJogo(msgResultado,msgJogadorPontos,msgMaquinaPontos);

        }else if(jokeipo.get(jogadaPc).equals(jogada)){
           // msgResultado.setText("Tente novamente!");
            msgResultado.setText("Draw!");
        }else{

            pontuacaoJoagdor++;
            msgJogadorPontos.setText(Integer.toString(pontuacaoJoagdor));
            msgResultado.setText("Point!");
            fimJogo(msgResultado,msgJogadorPontos,msgMaquinaPontos);
           // pontuacaoJoagdor ++;
         //  msgJogadorPontos.setText(pontuacaoJoagdor);
        }
      //  fimJogo();
    }
public void fimJogo(TextView msgResultado,TextView msgJogadorPontos, TextView msgMaquinaPontos){
        if(pontuacaoJoagdor == 10){
            pontuacaoJoagdor = 0;
            pontuacaoMaquina =0;
            msgResultado.setText("End Game. Vitoria! ");
            msgMaquinaPontos.setText(Integer.toString(pontuacaoMaquina));
            msgJogadorPontos.setText(Integer.toString(pontuacaoJoagdor));
        }if(pontuacaoMaquina == 10){
        pontuacaoMaquina =0;
        pontuacaoJoagdor = 0;
        msgResultado.setText("End Game. Derrota! ");
        msgMaquinaPontos.setText(Integer.toString(pontuacaoMaquina));
        msgJogadorPontos.setText(Integer.toString(pontuacaoJoagdor));
    }

}
  /*  public void zerarStatus(){
        if(pontuacaoJoagdor == 10){
            pontuacaoJoagdor = 0;
            PontuacaoMaquina = 0;
            msgResultado.setText("Jogando!");
        }
        if(PontuacaoMaquina == 10){
            PontuacaoMaquina = 0;
            pontuacaoJoagdor = 0;
            msgResultado.setText("Jogando!");
        }
    }

    public void fimJogo(){
        if(pontuacaoJoagdor == 10){
            msgResultado.setText("Vitoria!");
        }
        if(PontuacaoMaquina == 10){
            msgResultado.setText("Derrota!");
        }
    }*/



}
