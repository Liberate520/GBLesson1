package family_tree.iterator;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Descending_order implements Iterable<Map.Entry<Integer, String>> {

    private final HashMap<Integer, String> age = new HashMap<>();



    public void add(int key, String value) {

        age.put(key, value);

    }



    @NotNull
    @Override
    public Iterator<Map.Entry<Integer, String>> iterator() {
        List<Map.Entry<Integer, String>> sortedEntries = new ArrayList<>(age.entrySet());
        sortedEntries.sort(new Descending_order.AgeComparator());

        return sortedEntries.iterator();
    }


    class AgeComparator implements Comparator<Map.Entry<Integer, String>> {
        @Override
        public int compare(Map.Entry<Integer, String> entry1, Map.Entry<Integer, String> entry2) {
            return entry2.getKey().compareTo(entry1.getKey());
        }
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Iterator<Map.Entry<Integer, String>> it = iterator(); it.hasNext(); ) {
            Map.Entry<Integer, String> entry = it.next();
            Integer personId = entry.getKey(); // Получаем первый ключ (идентификатор)
            String personAge = entry.getValue(); // Получаем возраст по ключу
            sb.append(personId).append("  ").append(personAge).append("\n");
        }

        System.out.println(sb.toString());
        return sb.toString();
    }
}
