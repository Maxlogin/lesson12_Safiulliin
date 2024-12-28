import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PairGenerator {

    private static final Random rnd = new Random();

    /**
     * Разбивает список незнакомцев по парам.
     */
    public List<List<Stranger>> splitByPairs(List<Stranger> strangers) {
        List<List<Stranger>> pairs = new ArrayList<>();
        while (strangers.size() > 1) {
            List<Stranger> pair = getRandomPair(strangers);
            pairs.add(pair);
        }

        // Если остался один незнакомец, можно добавить его в отдельный список или игнорировать
        if (!strangers.isEmpty()) {
            pairs.add(new ArrayList<>(List.of(strangers.get(0))));
        }

        return pairs;
    }

    /**
     * Возвращает одну пару и удаляет её из списка strangers
     */
    private List<Stranger> getRandomPair(List<Stranger> strangers) {
        int p1Index = rnd.nextInt(strangers.size());
        int p2Index = rnd.nextInt(strangers.size());
        while (p2Index == p1Index) {
            p2Index = rnd.nextInt(strangers.size());
        }

        // Получаем элементы по сгенерированным индексам
        Stranger strangerOne = strangers.get(p1Index);
        Stranger strangerTwo = strangers.get(p2Index);

        // Удаляем найденных незнакомцев из списка
        strangers.remove(strangerOne);
        strangers.remove(strangerTwo);

        // Возвращаем пару
        return new ArrayList<>(List.of(strangerOne, strangerTwo));
    }
}
