import java.util.Scanner;

public class AskProjekt1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nPodaj liczbę int ");
        int Int = sc.nextInt();
        System.out.print("\nPodaj liczbę float ");
        float Float = sc.nextFloat();
        System.out.print("\nPodaj liczbę double ");
        double Double = sc.nextDouble();

        System.out.println("\n1. Postać bajtowa:");
        printByteArray(Int);
        printByteArray(Float);
        printByteArray(Double);

        System.out.println("\n2. Postać binarna:");
        System.out.println("INT: "+toBinary(Int));
        System.out.println("FLOAT: "+toBinary(Float));
        System.out.println("DOUBLE: "+toBinary(Double));

        System.out.println("\n3. Odejmowanie w U2:");
        System.out.println("\nPodaj pierwszą liczbę do odejmowania: ");
        int a = sc.nextInt();
        System.out.println("\nPodaj drugą liczbę do odejmowania: ");
        int b = sc.nextInt();
        subtractU2(a, b);
        sc.close();

        System.out.println("\n4. Konwersja DEC <-> FLOAT:");
    }

    private static void printByteArray(int value) {
        byte[] bytes = new byte[4];
        for (int i = 0; i < 4; i++) {
            bytes[i] = (byte) (value >>> (i * 8));
        }
        System.out.print("INT: ");
        printHexArray(bytes);
        System.out.println();
    }

    private static void printByteArray(float value) {
        int intBits = Float.floatToIntBits(value);
        byte[] bytes = new byte[4];
        for (int i = 0; i < 4; i++) {
            bytes[i] = (byte) (intBits >>> (i * 8));
        }
        System.out.print("FLOAT: ");
        printHexArray(bytes);
        System.out.println();
    }

    private static void printByteArray(double value) {
        long longBits = Double.doubleToLongBits(value);
        byte[] bytes = new byte[8];
        for (int i = 0; i < 8; i++) {
            bytes[i] = (byte) (longBits >>> (i * 8));
        }
        System.out.print("DOUBLE: ");
        printHexArray(bytes);
        System.out.println();
    }

    private static void printHexArray(byte[] bytes) {
        System.out.print("[");
        for (int i = 0; i < bytes.length; i++) {
            System.out.printf("0x%02X", bytes[i]);
            if (i < bytes.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static String toBinary(int number) {
        String binary = Integer.toBinaryString(number);
        binary = String.format("%32s", binary).replace(' ', '0');
        return addSpaces(binary);
    }

    public static String toBinary(float number) {
        int bits = Float.floatToIntBits(number);
        String binary = Integer.toBinaryString(bits);
        binary = String.format("%32s", binary).replace(' ', '0');
        return addSpaces(binary);
    }

    public static String toBinary(double number) {
        long bits = Double.doubleToLongBits(number);
        String binary = Long.toBinaryString(bits);
        binary = String.format("%64s", binary).replace(' ', '0');
        return addSpaces(binary);
    }

    private static String addSpaces(String binary) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < binary.length(); i++) {
            sb.append(binary.charAt(i));
            if ((i + 1) % 8 == 0 && i < binary.length() - 1) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    private static void subtractU2(int a, int b) {
        int result = a -b;
        System.out.println("\nwynik odejmowania: "+a + " - " + b + " (U2) = " + result);
        System.out.println("\nWynik odejmowania (U2) binarnie = " + toBinary(result));
    }
}