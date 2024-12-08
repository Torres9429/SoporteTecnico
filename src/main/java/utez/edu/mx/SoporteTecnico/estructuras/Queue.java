package utez.edu.mx.SoporteTecnico.estructuras;

public class Queue<T> {

    private Node<T> front;  // Primer elemento (cabeza de la cola)
    private Node<T> rear;   // Último elemento (final de la cola)
    private int size;       // Tamaño de la cola

    public Queue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    // Añade un elemento al final de la cola
    public boolean offer(T element) {
        Node<T> newNode = new Node<>(element);
        if (rear != null) {
            rear.next = newNode;
        }
        rear = newNode;
        if (front == null) { // Si la cola estaba vacía
            front = rear;
        }
        size++;
        return true;
    }

    // Añade un elemento al final de la cola, lanza una excepción si falla
    public void add(T element) {
        if (!offer(element)) {
            throw new IllegalStateException("No se pudo añadir el elemento");
        }
    }

    // Obtiene el primer elemento sin eliminarlo, o null si está vacía
    public T peek() {
        return (front != null) ? front.data : null;
    }

    // Obtiene el primer elemento sin eliminarlo, lanza excepción si está vacía
    public T element() {
        if (isEmpty()) {
            throw new IllegalStateException("La cola está vacía");
        }
        return front.data;
    }

    // Elimina y devuelve el primer elemento de la cola, o null si está vacía
    public T poll() {
        if (isEmpty()) {
            return null;
        }
        T data = front.data;
        front = front.next;
        if (front == null) { // Si la cola queda vacía
            rear = null;
        }
        size--;
        return data;
    }

    // Elimina y devuelve el primer elemento de la cola, lanza excepción si está vacía
    public T remove() {
        if (isEmpty()) {
            throw new IllegalStateException("La cola está vacía");
        }
        return poll();
    }

    // Verifica si la cola está vacía
    public boolean isEmpty() {
        return size == 0;
    }

    // Obtiene el tamaño de la cola
    public int size() {
        return size;
    }

    // Vacía la cola
    public void clear() {
        front = null;
        rear = null;
        size = 0;
    }

    // Método toString para representar la cola
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = front;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    // Ejemplo de uso
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();

        queue.offer(10);
        queue.add(20);
        queue.add(30);

        System.out.println("Contenido de la cola: " + queue);

        System.out.println("Primer elemento (peek): " + queue.peek());
        System.out.println("Primer elemento (poll): " + queue.poll());
        System.out.println("Contenido de la cola después de poll: " + queue);

        queue.add(40);
        System.out.println("Primer elemento (remove): " + queue.remove());
        System.out.println("Contenido de la cola después de remove: " + queue);

        System.out.println("¿La cola está vacía?: " + queue.isEmpty());
        System.out.println("Tamaño de la cola: " + queue.size());

        queue.clear();
        System.out.println("Contenido de la cola después de clear: " + queue);
    }
}
