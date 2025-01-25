# ASK-Projekt-1
ASK zadanie semestralne 1 
#Wstęp
Program napisany w języku Java spełniający następujące założenia:
  1.	Drukuje postać bajtową danych INT, FLOAT, DOUBLE
  2.	Drukuje postać binarną dla liczb jak w p 1
  3.	Prezentuje zasadę wykonywania odejmowania w U2
  4.	Prezentuje konwersję FLOAT -> DEC i DEC -> FLOAT

# Opis działania programu

## 1. Wyświetlenie reprezentacji bajtowej

Program prosi użytkownika o wprowadzenie:
- liczby całkowitej (int),
- liczby zmiennoprzecinkowej pojedynczej (float),
- liczby podwójnej precyzji (double).

Następnie funkcja `printByteArray()` wyświetla podane liczby w postaci bajtowej (Big-endian), czyli od najstarszego do najmłodszego bajtu. Używa do tego metody `printHexArray()`, która wypisuje kolejne bajty liczby w postaci szesnastkowej (np. `0xFF`). Końcowy wynik jest wyświetlany jako tablica bajtów.

> **Big-endian** i **small-endian** to sposoby zapisu bajtów w pamięci komputera.  
W big-endian najbardziej znaczący bajt znajduje się na początku, a w small-endian na końcu.

---

## 2. Wyświetlenie reprezentacji binarnej liczb

Program konwertuje wczytane wcześniej liczby na postać binarną za pomocą metod:
- `toBinary(int)`,
- `toBinary(float)`,
- `toBinary(double)`.

Przeciążona metoda `toBinary` konwertuje liczby różnych typów na ich reprezentację binarną w postaci łańcucha znaków. Łańcuch znaków zostaje uzupełniany zerami do:
- 32 bitów dla `int` i `float`,
- 64 bitów dla typu `double`.

Dla dodatkowej czytelności zastosowana jest funkcja `addSpaces(String)`, która dodaje spację co oktet bitów. 

---

## 3. Operacja odejmowania w kodzie U2 (Uzupełnienie do dwóch)

Program prosi o wprowadzenie dwóch liczb całkowitych do operacji odejmowania.  
Następnie funkcja `subtractU2()` pobiera te dwie liczby. Wynik odejmowania jest obliczany w systemie dziesiętnym i przedstawiany w formacie binarnym z uzupełnieniem do dwóch.

### Jak działa odejmowanie w U2:
Odejmowanie w systemie U2 odbywa się na kodzie binarnym.  
W kodzie liczby przedstawiane są za pomocą ich dopełnienia do dwóch:
1. Liczba ujemna uzyskiwana jest poprzez zanegowanie jej i dodanie 1.
2. Odejmowanie dwóch liczb w U2 sprowadza się do dodawania. Wyrażenie `a - b` jest równoważne `a + (~b + 1)`.

Kod U2 umożliwia realizację tej operacji w prosty sposób na poziomie sprzętowym, co eliminuje konieczność stosowania dodatkowych jednostek odejmujących w procesorach.

---

## 4. Konwersja liczb dziesiętnych na zmiennoprzecinkowe i odwrotnie

Program prosi o podanie liczby całkowitej (`int`) i za pośrednictwem metody `DecToFloat()` przekształca ją na liczbę zmiennoprzecinkową (`float`).  

Następnie następuje działanie odwrotne:
Program prosi o podanie liczby zmiennoprzecinkowej i konwertuje ją na całkowitą za pomocą metody `FloatToDec()`.

# Opis wybranych funkcji programu

## Drukowanie tablicy bajtów
```java
    private static void printByteArray(int value) {
        byte[] bytes = new byte[4]; //tworzenie tablicy 4 bajtów
        for (int i = 0; i < 4; i++) { //iteracja przez wszystkie bajty tablicy od najmniej znaczącego
            bytes[3-i] = (byte) (value >>> (i * 8)); //wyodrębnienie bajtów poprzez
            //przesunięcie bitowe i zapis do tablicy w kolejności big-endian
        }
        System.out.print("INT: ");
        printHexArray(bytes);// Wyświetlanie tablicy w formacie HEX
```

## Drukowanie tablicy 
Funkcja pomocnicza drukująca tablicę bajtów w formacie `HEX`

```java
 private static void printHexArray(byte[] bytes) {
        System.out.print("[");
        for (int i = 0; i < bytes.length; i++) {//iteracja przez wszystkie bajty tablicy
            System.out.printf("0x%02X", bytes[i]);//wypisanie każdego bajtu
            //w formacie szesnastkowym z wiodącymi zerami
            if (i < bytes.length - 1) {
                System.out.print(", ");//dodanie przecinka pomiędzy bajtami
            }
        }
        System.out.println("]");
    }
```
# Przykładowy wynik programu

![](/results.png)
