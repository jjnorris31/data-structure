public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        int[] numeros;
        numeros = new int[20];

        String[] strings = new String[10];
        strings[0] = "hola";

        for (int i = 0; i < numeros.length; i++){
            numeros[i] = i;
        }

        System.out.println(strings[0]);


    }
}
