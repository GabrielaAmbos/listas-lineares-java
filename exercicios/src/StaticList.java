public class StaticList<E> implements List<E> {
    protected E[] elements;
    int numElements;

    /**
     * Constr�i uma lista com um tamanho m�ximo.
     *
     * @param maxSize O tamanho m�ximo da lista
     */
    public StaticList(int maxSize) {
        elements = (E[]) new Object[maxSize];
        numElements = 0;
    }

    /* (non-Javadoc)
     * @see br.unisinos.prog2lab2.List#numElements()
     */
    public int numElements() {
        return numElements;
    }

    /* (non-Javadoc)
     * @see br.unisinos.prog2lab2.List#isEmpty()
     */
    public boolean isEmpty() {
        return numElements == 0;
    }

    /* (non-Javadoc)
     * @see br.unisinos.prog2lab2.List#isFull()
     */
    public boolean isFull() {
        return numElements == elements.length;
    }

    /* (non-Javadoc)
     * @see br.unisinos.prog2lab2.List#insert(java.lang.Object, int)
     */
    public void insert(E element, int pos) {
        // verifica se h� espa�o na lista
        if (isFull())
            throw new OverflowException();

        // verifica se a posi��o � v�lida
        if (pos < 0 || pos > numElements)
            throw new IndexOutOfBoundsException();

        // desloca para a direita os elementos necess�rios,
        // abrindo espa�o para o novo
        for (int i = numElements - 1; i >= pos; i--)
            elements[i + 1] = elements[i];

        // armazena o novo elemento e ajusta o total
        elements[pos] = element;
        numElements++;
    }

    /* (non-Javadoc)
     * @see br.unisinos.prog2lab2.List#remove(int)
     */
    public E remove(int pos) {
        // verifica se a posi��o � v�lida
        if (pos < 0 || pos >= numElements)
            throw new IndexOutOfBoundsException();

        // guarda uma refer�ncia tempor�ria ao elemento removido
        E element = elements[pos];

        // desloca para a esquerda os elementos necess�rios,
        // sobrescrevendo a posi��o do que est� sendo removido
        for (int i = pos; i < numElements - 1; i++)
            elements[i] = elements[i + 1];

        // define para null a posi��o antes ocupada pelo �ltimo,
        // para que a coleta de lixo possa atuar, e ajusta o total
        elements[numElements - 1] = null;
        numElements--;

        return element;
    }

    /* (non-Javadoc)
     * @see br.unisinos.prog2lab2.List#get(int)
     */
    public E get(int pos) {
        // verifica se a posi��o � v�lida
        if (pos < 0 || pos >= numElements)
            throw new IndexOutOfBoundsException();

        return elements[pos];
    }

    /* (non-Javadoc)
     * @see br.unisinos.prog2lab2.List#search(java.lang.Object)
     */
    public int search(E element) {
        for (int i = 0; i < numElements; i++)
            if (element.equals(elements[i]))
                return i;

        // se chegar at� aqui, � porque n�o encontrou
        return -1;
    }

    /**
     * Retorna uma representa��o String da lista.
     *
     * @see java.lang.Object#toString()
     */
    public String toString() {
        String s = "";
        for (int i = 0; i < numElements; i++)
            s += elements[i] + " ";
        return s;
    }
}
