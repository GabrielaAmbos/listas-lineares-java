
public class Exercicios {

    /**
     *1. Implemente um método, em uma classe qualquer, que receba como parâmetro uma lista
     * sequencial de números inteiros (objetos do tipo Integer) e retorne um vetor contendo
     * apenas os números pares desta lista.
     */
    public Integer [] evenNumbers(List<Integer> lista) {
        int cont = 0;
        for(int i = 0; i < lista.get(i); i++) {
            if(lista.get(i) % 2 == 0) {
                cont++;
            }
        }
        Integer [] array = new Integer[cont];
        for(int i = 0; i < lista.get(i); i++) {
            if(lista.get(i) % 2 == 0) {
                array[i] = lista.get(i);
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
        List<Character> t3;
        for(int i = 0; i < t1.get(i); i++) {
            if(t3.get(i) % 2 == 0){
                t3.insert(t1.get(i), i);
            }
        }
        for(int i = 0; i < t2.get(i); i++) {
            if(t3.get(i) % 2 != 0){
                t3.insert(t2.get(i), i);
            }
        }
        return t3;
    }

    /**
     * 3. Implemente um método que recebe duas listas t1 e t2 e copia os elementos da segunda
     * para o início da primeira.
     */
    public void prependList(List<Double> t1, List<Double> t2) {
        }
    }
}
