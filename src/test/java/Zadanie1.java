import java.sql.Array;
import java.util.*;
import java.util.stream.IntStream;

public class Zadanie1 {

    public static String tokenGenerator(int tokensSize, List asciiList){
        String token="";
        for (int i = 0; i<tokensSize; i++){
            Random rn = new Random();
            //random is number from 0 to number of available chars
            int random = rn.nextInt(asciiList.size());
            //chr is one specific char from ascii table
            int chr = (int) asciiList.get(random);
            //token is a string of chr's
            token += (char)chr;
        }
        return token;
    }

    public static List asciiNumberListGenerator(){
        //ascii list is a List of ascii chars that will be used to create token
        List<Integer> asciiList = new ArrayList<>();
        //skiplist represents chars from ascii table, between 34 and 122 that not going to be used example: "/"
        List<Integer> skipList = Arrays.asList(34,39,43,44,45,46,47,58,59,60,61,62,63,91,92,93,95,96);
        for (int i=33; i<=122; i++){
            if (skipList.contains(i)) {
                continue;
            }else{
                asciiList.add(i);
            }
        }
        return asciiList;
    }


    public static void main(String[] args) {
        /*
                Zaimplementuj metodę Java - tokenGenerator().
                1. Liczba parametrów - dowolne
                2. Nazwa - tokenGenerator()
                3. Return - zwraca token
                4. token - to ciąg randomowych znaków [a-z][A-Z][0-9][!@#$%^&*()] - o dowolnej długości
                3  Metoda generuje 3 różne wersje tokenów w zależności od potrzeby usera:  5-znakowy, 10-znakowy oraz 15-znakowy

                Przykład tokena 5 znakowego - g4#2%
                Przykład tokena 10 znakowego - g4#2%hQQ5^
                Przykład tokena 15 znakowego - g4#2%hQQ5^YY5!2
         */
        //available number of chars in token
        int[] availableTokenSize = {5, 10, 15};
        List asciiList = asciiNumberListGenerator();
        String token;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Choose token size: 5, 10 or 15 chars");
            int tokensSize = scanner.nextInt();
            if (IntStream.of(availableTokenSize).anyMatch(x -> x == tokensSize)) {
                token = tokenGenerator(tokensSize, asciiList);
                System.out.println(token);
            } else {
                System.out.println("Wrong token size entered");
            }
        }catch(InputMismatchException e){
            System.out.println("Given number is not intiger. GAME OVER");
        }
    }
}

//O co chodzi z definiowaniem zmiennych? Nie przepuszcza mnie intelij dopoki nie dodam ="", wyrzuca błąd: java: variable token might not have been initialized
