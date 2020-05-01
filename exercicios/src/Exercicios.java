
public class Exercicios {

    /**
     *1. Implemente um método, em uma classe qualquer, que receba como parâmetro uma lista
     * sequencial de números inteiros (objetos do tipo Integer) e retorne um vetor contendo
     * apenas os números pares desta lista.
     */
    public Integer [] evenNumbers(List<Integer> lista) {
        int cont = 0;
        for(int i = 0; i < lista.numElements(); i++) {
            if(lista.get(i) % 2 == 0) {
                cont++;
            }
        }
        Integer [] array = new Integer[cont];
        cont = 0;
        for(int i = 0; i < lista.numElements(); i++) {
            if(lista.get(i) % 2 == 0) {
                array[cont] = lista.get(i);
                cont++;
            }
        }
        return array;
    }

    /**
     * 2. Implemente um método que recebe duas listas e retorna uma terceira, contendo a
     * intercalação das duas iniciais. Por exemplo, dadas as listas t1 = (A, B, C) e
     * t2 = (D, E,F), a intercalação das duas deve produzir (A, D, B, E, C, F). As listas
     * originais não devem ser alteradas.
     */
    public List<Character> mergeLists(List<Character> t1, List<Character> t2) {
        int max = t1.numElements() + t2.numElements();
        List<Character> t3 = new StaticList<>(max);
        int contT1 = 0;
        int contT2 = 0;
        for(int i = 0; i < max; i++) {
            if(i % 2 == 0){
                t3.insert(t1.get(contT1), i);
                contT1++;
            } else {
                t3.insert(t2.get(contT2), i);
                contT2++;
            }
        }
        return t3;
    }

    /**
     * 3. Implemente um método que recebe duas listas t1 e t2 e copia os elementos da segunda
     * para o início da primeira.
     */
    public void prependList(List<Double> t1, List<Double> t2) {
        for(int i = 0; i < t2.numElements(); i++) {
            t1.insert(t2.get(i), i);
        }
    }
}
