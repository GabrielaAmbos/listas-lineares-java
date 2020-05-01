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

    /**
     * 4. Implemente um método que remove da lista um elemento passado como parâmetro.
     * Esse método retorna true quando o elemento é achado e removido, false caso contrário.
     * Será removida apenas a primeira ocorrência do elemento.
     */
    public boolean remove(E element) {
        if(isEmpty()) {
            throw new IndexOutOfBoundsException();
        } else {
            for (int i = 0; i < numElements; i++) {
                if (element.equals(elements[i])) {
                    elements[i] = null;
                    for (int j = i; j < numElements - 1; j++) {
                        elements[j] = elements[j + 1];
                    }
                    elements[numElements - 1] = null;
                    numElements--;
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * 5. Implemente o método insertAfter, abaixo, que insere o elemento obj2 uma posição
     * após o elemento obj1. Considere a primeira ocorrência de obj1. Se obj1 não for
     * encontrado, gere uma exceção apropriada.
     */
    public void insertAfter(E obj1, E obj2) {
        if (isFull()) {
            throw new OverflowException();
        } else {
            for (int i = 0; i < numElements; i++) {
                if (obj1.equals(elements[i])) {
                    for (int j = numElements - 1; j >= i; j--) {
                        elements[j + 1] = elements[j];
                    }
                    elements[i] = obj2;
                    numElements++;
                    return;
                }
            }
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * 6. Implemente um método que troca de lugar os objetos localizados nas posições
     * passadas como parâmetro. Se alguma das posições for inválida, deve ser gerada a
     * exceção do Java IndexOutOfBoundsException.
     */
    public void swap(int pos1, int pos2) {
        if ((pos1 < 0 || pos1 >= numElements) && (pos2 < 0 || pos2 >= numElements)) {
            throw new IndexOutOfBoundsException();
        } else {
            E aux = elements[pos2];
            elements[pos2] = elements[pos1];
            elements[pos1] = aux;
        }
    }

    /**
     * 7. Implemente um método que inverte a ordem dos elementos da lista.
     */
    public void flip(){
        int ultimaPosicao = numElements() - 1;
        for(int i = 0; i < numElements() / 2; i++) {
            int primeiraPosicao = i;
            E aux = elements[primeiraPosicao];
            elements[primeiraPosicao] = elements[ultimaPosicao];
            elements[ultimaPosicao] = aux;
            ultimaPosicao--;
        }
    }

    /**
     * 8. Implemente uma sobrecarga do método insert que recebe como parâmetro uma lista,
     * em vez de um elemento. Esse método deve adicionar à lista corrente os elementos
     * daquela passada como parâmetro, a partir da posição indicada.
     */
    public void insert(List<E> list, int pos) {
        for(int i = 0; i < list.numElements(); i++) {
            this.insert(list.get(i), pos);
            pos++;
        }
    }

    /**
     * 9. Implemente um método que remove ocorrências múltiplas de elementos na lista. Para
     * cada elemento contido na lista, somente a primeira ocorrência deve ser mantida.
     */
    public void dedup() {
        for(int i = 0; i < numElements; i++) {
            for(int j = numElements; j >= i + 1; j--) {
                if(this.get(i).equals(this.get(j))){
                    remove(j);
                }
            }
        }
    }

    /**
     * 10. Implemente um método equals para a lista. Uma lista será igual a outra se
     * contiver os mesmos elementos, dispostos na mesma ordem. Para comparar os
     * elementos, use também o método equals. Pesquise como desenvolver o método
     * de um objeto no Java.
     */
    public boolean equals(List<E> lista) {
        for(int i = 0; i < numElements; i++) {
            if(!lista.get(i).equals(this.get(i))) {
                return false;
            }
        }
        return true;
    }

     /**
     * 11. Implemente um método clone para a lista. Esse método deve retornar uma nova lista
     * contendo os mesmos elementos da atual. Os elementos em si não devem ser
     * duplicados.
      * */
     public List<E> copy() {
         List<E> copia = new StaticList<>(numElements());
         for(int i = 0; i < numElements; i++) {
             copia.insert(this.get(i), i);
         }
         return copia;
     }

     /**
     * 12. Implemente um método que remove da lista os elementos compreendidos entre as
     * posições ini e fim (inclusive). Ele deve retornar a quantidade de elementos removidos.
      **/
     public int remove(int ini, int fim) {
         if ((ini < 0 || ini >= numElements) && (fim < 0 || fim >= numElements) && (fim <= ini)) {
             throw new IndexOutOfBoundsException();
         } else {
             int cont = 0;
         for (int j = fim; j >= ini; j--) {
             remove(j);
             cont++;
         }
         return cont;
        }
     }

      /**
       * 13. Implemente um método split que divide a lista em duas partes. A lista corrente
       * deve ficar somente com os elementos do início até uma posição antes da indicada,
       * e o método deve retornar uma nova lista contendo o elementos da posição indicada
       * até o final.
       */
      public List<E> split(int pos) {
          List<E> aux = new StaticList<>(numElements);
          int count = 0;
          for(int i = pos; i < numElements; i++) {
              aux.insert(this.get(i), count);
              count++;
          }
          remove(pos, numElements);
          return aux;
      }
}
