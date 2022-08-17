import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static void wordsFrequent(String str) {
        String[] convertToArr = str.split(" ");
        Map<String, Long> tempInput = Arrays.stream(convertToArr)
                .map(x -> x.replaceAll("[^a-zA-Z0-9]", "").toLowerCase())
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));

        Map tempResult = tempInput.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder())
                        .thenComparing(Map.Entry::getKey))
                .limit(10)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        List<String> result = (List<String>) tempResult.keySet().stream()
                .collect(Collectors.toCollection(ArrayList::new));

        result.forEach(System.out::println);
    }

    public static void main(String[] args) {
        Scanner tempInput = new Scanner(System.in);
        String userInput = tempInput.nextLine();

        wordsFrequent(userInput);

    }
}
