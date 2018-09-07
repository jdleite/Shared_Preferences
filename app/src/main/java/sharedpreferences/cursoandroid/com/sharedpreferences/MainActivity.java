package sharedpreferences.cursoandroid.com.sharedpreferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private EditText entrada;
    private TextView texto;
    private Button   botao;


    private static  final String ARQUIVO_PREFERENCIA = "ArquivoPreferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    entrada = (EditText) findViewById(R.id.edtId);
    texto = (TextView) findViewById(R.id.txtResId);
    botao = (Button) findViewById(R.id.btnId);



    botao.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0);
            SharedPreferences.Editor editor = sharedPreferences.edit();

            if(entrada.getText().toString().equals("")){


                Toast.makeText(MainActivity.this,"Digite o nome",Toast.LENGTH_SHORT).show();


            }else{
                editor.putString("nome",entrada.getText().toString());
                editor.commit();
                texto.setText("Olá " +  entrada.getText().toString());
            }

        }
    });

            SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0);
            if(sharedPreferences.contains("nome")){

                String nomeUsuario = sharedPreferences.getString("nome","usuario não encontrado");
                texto.setText("Olá," + nomeUsuario);

            }else{

                texto.setText("Usuario não definido");
            }



    }
}
