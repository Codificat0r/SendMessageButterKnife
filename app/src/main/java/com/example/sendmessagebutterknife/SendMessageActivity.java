package com.example.sendmessagebutterknife;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.sendmessagebutterknife.pojo.Message;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Esta clase envía un mensaje de un usuario a otro.
 * @author Carlos Cruz Domínguez
 */

public class SendMessageActivity extends AppCompatActivity{

    @BindView(R.id.edtMessage)
    EditText edtMessage;
    @BindView(R.id.edtUser)
    EditText edtUser;
    @BindView(R.id.btnOk)
    Button btnOk;
    private Message message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);

        //Enlaza ahora todas las vistas de esta activity con lo dicho arriba con BindView.
        ButterKnife.bind(this);

        //Clear esa clase anonima es lo mismo que crear una class que implemente la interfaz View.OnClickListener:
        //class MyListener implements View.OnClickListener. Si nos pieden, por ejemplo, una app con 5 botones ya si
        //usamos una clase normal y le ponemos un new MyListener a cada boton.
        Log.d("com.example.sendmessage", "SendMessage: onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("com.example.sendmessage", "SendMessage: onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("com.example.sendmessage", "SendMessage: onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("com.example.sendmessage", "SendMessage: onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("com.example.sendmessage", "SendMessage: onPause");
    }

    //Podemos directamente vincular un metodo a un evento
    @OnClick(R.id.btnOk)
    public void getOnClick(View view)
    {
        switch (view.getId())
        {
            case R.id.btnOk:
                //1. Recoger el mensaje
                message = new Message(edtMessage.getText().toString(), edtUser.getText().toString());
                //2. Crear un objeto Bundle y añadir el mensaje, con un conjunto de clave valor.
                Bundle bundle = new Bundle();
                bundle.putSerializable("message", message);
                //3. Crear un objeto Intent. Tenemos que poner el contexto y la clase destinataria.
                //Por nomenclatura usamos el nombre de la clase tambien en el this. Accedemos al contexto
                //de la activity, aprobechando que las Activity's heredan de Context. Le hemos mandado
                //parte de nuestro contexto de esta Activity a la otra. Usamos la clase, porque todavía no esta en memoria
                //entonces accedemos a la clase compilada.
                Intent intent = new Intent(SendMessageActivity.this,ViewMessageActivity.class);
                //4. Añadir el Bundle al Intent
                intent.putExtras(bundle);
                //5. Iniciar la Activity ViewMessage. Sabe que activity debe iniciar porque este metodo
                //iniciará la activity a la que se mande el intent.
                startActivity(intent);
                //Break del switch
                break;
        }
    }
}
