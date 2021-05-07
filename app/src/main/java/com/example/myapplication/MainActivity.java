package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button zero, um, dois, tres, quatro, cinco, seis, sete, oito, nove, subtracao, adicao,
            divisao, multiplicacao, limpar, ponto, igual;

    private TextView calculo, resultado;

    private ImageView apagar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciar();
        getSupportActionBar().hide();

        zero.setOnClickListener(this);
        um.setOnClickListener(this);
        dois.setOnClickListener(this);
        tres.setOnClickListener(this);
        quatro.setOnClickListener(this);
        cinco.setOnClickListener(this);
        seis.setOnClickListener(this);
        sete.setOnClickListener(this);
        oito.setOnClickListener(this);
        nove.setOnClickListener(this);
        ponto.setOnClickListener(this);
        multiplicacao.setOnClickListener(this);
        adicao.setOnClickListener(this);
        subtracao.setOnClickListener(this);
        divisao.setOnClickListener(this);

        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultado.setText("");
                calculo.setText("");
            }
        });

//        Evento para apagar somente um numero do calculo, NÃO apaga o resultado
        apagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView t_calculo = findViewById(R.id.texto_calculo);
                String string = t_calculo.getText().toString();

                if (string.isEmpty()){
                    byte var0 = 0;
                    int var1 = string.length()-1;
                    String calculoapagar = string.substring(var0, var1);
                    t_calculo.setText("");
                }
                calculo.setText("");
            }
        });

//        Gerar o calculo e o resultado ao Clicar. Utilizei uma biblioteca ('net.objecthunter:exp4j:0.4.8').
        igual.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Expression t_calculo = new ExpressionBuilder(calculo.getText().toString()).build();
                double t_resultado = t_calculo.evaluate();
                long longResult = (long) t_resultado;

                if(t_resultado == (double)longResult){
                    resultado.setText((CharSequence) String.valueOf(longResult));//pasando o valor já para string
                }else{
                    resultado.setText((CharSequence) String.valueOf(t_resultado));
                }
            }
        }));
    }

    private void iniciar(){

        //inicando as variaveis recebendo a ação do clique do botões
        zero = findViewById(R.id.n_zero);
        um = findViewById(R.id.n_um);
        dois = findViewById(R.id.n_dois);
        tres = findViewById(R.id.n_tres);
        quatro = findViewById(R.id.n_quatro);
        cinco = findViewById(R.id.n_cinco);
        seis = findViewById(R.id.n_seis);
        sete = findViewById(R.id.n_sete);
        oito = findViewById(R.id.n_oito);
        nove = findViewById(R.id.n_nove);
        ponto = findViewById(R.id.n_ponto);
        apagar = findViewById(R.id.n_apagar);
        limpar = findViewById(R.id.btn_limpar);
        multiplicacao = findViewById(R.id.btn_multiplicacao);
        adicao = findViewById(R.id.btn_adicao);
        subtracao = findViewById(R.id.btn_subtracao);
        divisao = findViewById(R.id.btn_divisao);
        resultado = findViewById(R.id.texto_resultado);
        calculo = findViewById(R.id.texto_calculo);
        igual = findViewById(R.id.btn_igual);
    }

    public void IniciarUmCalculo(String string, boolean limpar){

//        Inicia a expressão.
        if(resultado.getText().equals("")){
            calculo.setText(" ");
        }
//    Verificação para limpeza
        if(limpar){
            resultado.setText(" ");
            calculo.append(string);
        }else{
            calculo.append(resultado.getText());
            calculo.append(string);
            resultado.setText(" ");
        }
    }

    @Override
    public void onClick(View view) {
        //Recebendos os valores em string;
        switch (view.getId()){
            case R.id.n_zero:
                IniciarUmCalculo("0", true);
                break;
            case R.id.n_um:
                IniciarUmCalculo("1",  true);
                break;
            case R.id.n_dois:
                IniciarUmCalculo("2", true);
                break;
            case R.id.n_tres:
                IniciarUmCalculo("3", true);
                break;
            case R.id.n_quatro:
                IniciarUmCalculo("4",  true);
                break;
            case R.id.n_cinco:
                IniciarUmCalculo("5", true);
                break;
            case R.id.n_seis:
                IniciarUmCalculo("6", true);
                break;
            case R.id.n_sete:
                IniciarUmCalculo("7", true);
                break;
            case R.id.n_oito:
                IniciarUmCalculo("8", true);
                break;
            case R.id.n_nove:
                IniciarUmCalculo( "9", true);
                break;
            case R.id.n_ponto:
                IniciarUmCalculo( ".", true);
                break;
            case R.id.btn_multiplicacao:
                IniciarUmCalculo( "*", false);
                break;
            case R.id.btn_adicao:
                IniciarUmCalculo("+", false);
                break;
            case R.id.btn_subtracao:
                IniciarUmCalculo("-", false);
                break;
            case R.id.btn_divisao:
                IniciarUmCalculo("/", false);
                break;
        }
    }
}