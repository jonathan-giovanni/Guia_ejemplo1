package org.dev4u.hv.guia2_ejemplo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //declaracion de variables
    private RadioButton rbn30,rbn60,rbn100;
    private ProgressBar progressBar;
    private Button btnCargar;
    private TextView lblValor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //inicializacion de los controles
        rbn30       = (RadioButton) findViewById(R.id.rbn30);
        rbn60       = (RadioButton) findViewById(R.id.rbn60);
        rbn100      = (RadioButton) findViewById(R.id.rbn100);
        progressBar = (ProgressBar) findViewById(R.id.progressPorcentaje);
        lblValor    = (TextView)    findViewById(R.id.lblPorcentaje);
        btnCargar   = (Button)      findViewById(R.id.btnCargar);
        //evento onClick
        btnCargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(estaChequeado()){
                    new Cargar(MainActivity.this,progressBar,lblValor).execute(getValor());
                }else{
                    Toast.makeText(MainActivity.this,"Selecciona una opcion",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //obtener el valor
    private int getValor(){
        if(rbn30.isChecked()){
            return 30;
        }
        if (rbn60.isChecked()){
            return 60;
        }
        if (rbn100.isChecked()){
            return 100;
        }
        //default
        return 0;
    }
    //verificar si esta chequeado
    boolean estaChequeado(){
        if(rbn30.isChecked() ||rbn60.isChecked() || rbn100.isChecked()) return true;
        else return false;
    }
}
