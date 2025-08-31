package tp01.ejercicio4;

public class Main {
    public static void main(String[] args) {
        TestBalanceo testBalanceo = new TestBalanceo();

        String palabra1 = "{( ) [ ( ) ] }";
        String palabra2 = "";

        System.out.println("test primer string: ");
        boolean res = testBalanceo.estaBalanceado(palabra1);
        if (res) {
            System.out.println("Esta balanceado");
        } else {
            System.out.println("No esta balanceado");
        }

        System.out.println("test segundo string: ");
        boolean res2 = testBalanceo.estaBalanceado(palabra2);
        if (res2) {
            System.out.println("Esta balanceado");
        } else {
            System.out.println("No esta balanceado");
        }

    }
}
