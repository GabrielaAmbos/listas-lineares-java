public class Main {
    public static void main(String [] args) {
        Exercicios e = new Exercicios();

        List<Integer> num1 = new StaticList<>(10);
        num1.insert(2, 0);
        num1.insert(3, 1);
        num1.insert(4, 2);

        Integer[] array = e.evenNumbers(num1);
        int x = 0;

    }
}
