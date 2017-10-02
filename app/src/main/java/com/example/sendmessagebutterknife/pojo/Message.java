package com.example.sendmessagebutterknife.pojo;

import java.io.Serializable;

/**
 * Clase que contiene mensaje y usuario. Implementa la interfaz Serializable para que se pueda pasar en el Bundle de una
 * activity a otra.
 * @author Carlos Cruz Domínguez
 */

//Ponemos la clase como serializable para poder pasarla con "putSerializable" en el bundle.
public class Message implements Serializable{
    private String _message;
    private String _user;

    public Message (String message, String user) {
        _message = message;
        _user = user;
    }

    public String get_message() {
        return _message;
    }

    public void set_message(String _message) {
        this._message = _message;
    }

    public String get_user() {
        return _user;
    }

    public void set_user(String _user) {
        this._user = _user;
    }

    @Override
    public boolean equals(Object o) {
        boolean result;
        //comprueba si son el mismo objeto, si apuntan a la misma direccion de memoria, no compara contenido, por ahora.
        if (this == o) return true;
        //Aqui comprueba si son del mismo tipo las clase o si o es null para que al hacer el casting luego
        //para comprobar si el contenido de las clases es el mismo o no.
        if (o == null || getClass() != o.getClass()) return false;

        //guardamos la direccion de memoria de o para poder comprobar su contenido.
        Message message1 = (Message) o;

        //se comprueba el contenido. Refactorizamos.
        //if (_message != null ? !_message.equals(message1._message) : message1._message != null)
        //    return false;
        //return _user != null ? _user.equals(message1._user) : message1._user == null;
        //Si las dos condiciones son verdaderas pues dara verdadero.
        result = _message.equals(message1._message) && _user.equals(message1._user);
        return result;

    }

    @Override
    public String toString() {
        return "Message{" +
                "_message='" + _message + '\'' +
                ", _user='" + _user + '\'' +
                '}';

    }
}
