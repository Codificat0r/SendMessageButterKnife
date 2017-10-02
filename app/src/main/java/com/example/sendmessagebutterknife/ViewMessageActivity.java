package com.example.sendmessagebutterknife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.example.sendmessagebutterknife.pojo.Message;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Esta clase recibe el mensaje de un usuario y lo muestra en pantalla.
 *
 * @author Carlos Cruz Domínguez
 *         <u>Conceptos aprendidos:</u>
 *         <ul>
 *         <li>Concepto Context</li>
 *         <li>Paso de parámetros mediante el objeto Bundle</li>
 *         <li>Paso de mensajes entre dos actividades mediante la clase <a href="https://developer.android.com/reference/android/content/Intent.html">Intent</a></li>
 *         </ul>
 */

public class ViewMessageActivity extends AppCompatActivity {

    @BindView(R.id.txvViewMessage)
    TextView txvViewMessage;
    @BindView(R.id.txvViewUser)
    TextView txvViewUser;
    //Podemos poner el nombre de la activity o su espacio de nombre completo. Luego podemos filtrar los mensajes por su tag
    //en el Android Monitor.
    private static final String TAG = "com.example.viewmessage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_message);

        ButterKnife.bind(this);

        //1. Recoger el intent que se ha enviado
        //getIntent();
        //2. Recoger el mensaje del Bundle
        //Bundle bundle = new Bundle();
        //3. Mostrar mensaje. Como ya esta en memoria, y el contexto de esta activity tiene parte
        //del otro porque lo hemos compartido en el intent, pero los contextos son diferentes de una
        //Activity a otra no volvemos a crear los objetos. Cogemos el intent, cogemos el bundle con
        //getExtras, y accedemos al string con su key.
        //txvViewMessage.setText(getIntent().getExtras().getString("message"));
        //Obtenemos la clase serializable que habiamos introducido en el bundle.
        txvViewMessage.setText(((Message)(getIntent().getExtras().getSerializable("message"))).get_message());
        //Recogemos el string de R, ya no es un layout o un elemento gráfico, ya no es id. Al ser una referencia
        //el R.string.txvViewUser, pues tenemos que recoger la cadena con getResources().getString().
        String viewUser = String.format(getResources().getString(R.string.txvViewUser), (((Message)(getIntent().getExtras().getSerializable("message"))).get_user()));
        txvViewUser.setText(viewUser);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "ViewMessage: onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "ViewMessage: onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "ViewMessage: onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "ViewMessage: onPause");
    }
}
