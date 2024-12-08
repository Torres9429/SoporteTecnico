package utez.edu.mx.SoporteTecnico.estructuras;


public class Node<E>{

    //Estos son los atributos que definen la LinkedList
    public E data;
    public Node<E> next;

    //Constructor del nodo
    public Node(E data){
        this.data = data;
        this.next = null;
    }

    //getter del dato
    public E getData(){
        return this.data;
    }
}
