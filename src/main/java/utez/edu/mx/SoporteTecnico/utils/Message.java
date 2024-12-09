package utez.edu.mx.SoporteTecnico.utils;

public class Message {
    private String text;
    private TypesResponse type;
    private Object result;

    public Message(String text, TypesResponse type) {
        this.text = text;
        this.type = type;
    }

    /*public Message(Object result,String text, TypesResponse type) {
        this.text = text;
        this.type = type;
        this.result = result;
    }*/
    public Message(Object result, String text, TypesResponse type) {
        this.result = result;
        this.text = text;
        this.type = type;
    }

    public Message(String inicioDeSesiónExitoso, TypesResponse typesResponse, String token) {

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public TypesResponse getType() {
        return type;
    }

    public void setType(TypesResponse type) {
        this.type = type;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
