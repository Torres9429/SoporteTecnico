package utez.edu.mx.SoporteTecnico.estructuras;

public class ArrayList<T> {
    // Atributos que definen al ArrayList
    private T[] array;
    private int size;
    private int capacity;

    // Constructor de la lista
    @SuppressWarnings("unchecked")
    public ArrayList() {
        this.capacity = 10; // Iniciamos con 10 espacios
        this.array = (T[]) new Object[this.capacity];
        this.size = 0;
    }

    // Redimensionar el array si es necesario
    @SuppressWarnings("unchecked")
    private void resize() {
        this.capacity *= 2;
        T[] newArray = (T[]) new Object[this.capacity];
        // Copiar el array viejo en el nuevo
        System.arraycopy(
                this.array,
                0,
                newArray,
                0,
                size);
        this.array = newArray;
    }

    // Método para añadir un elemento al final del ArrayList
    public boolean add(T elemento) {
        if (this.size == this.capacity) {
            resize();
        }
        this.array[this.size++] = elemento;
        return true;
    }

    // Método para obtener un elemento por índice
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "El índice está fuera de los límites del array"
            );
        }
        return this.array[index];
    }

    // Método para remover un elemento por índice
    public boolean remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "El índice está fuera de los límites del array"
            );
        }

        // Mover los elementos después del índice hacia la izquierda
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }

        array[size - 1] = null; // Opcional: limpiar el último elemento
        size--;

        return true;
    }

    // Método para obtener el tamaño del ArrayList
    public int size() {
        return this.size;
    }

    // Método para verificar si el ArrayList está vacío
    public boolean isEmpty() {
        return this.size == 0;
    }

    // Método para limpiar todo el ArrayList
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    // Método para buscar si un elemento está en el ArrayList
    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                return true;
            }
        }
        return false;
    }
}
