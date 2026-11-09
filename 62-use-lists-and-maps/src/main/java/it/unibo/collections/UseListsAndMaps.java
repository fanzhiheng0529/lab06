package it.unibo.collections;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.Map;
import java.util.HashMap;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private UseListsAndMaps() {
    }

    /**
     * Program entry point.
     */
    public static void main(String[]args) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        final List<Integer> arrayList = new ArrayList<>(); 
        for(int i = 1000; i < 2000; i++){
            arrayList.add(i);
        }

        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        final List<Integer> linkedList = new LinkedList<>(arrayList);
        //ArrayList和LinkedList是因为它们都是 Collection 家族的亲戚
        //Java 规定了所有亲戚之间必须支持数据的互相倾倒

        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * 交换第一个和最后一个元素（针对 arrayList）
         * (Suggestion: use a temporary variable)
         */
        final int temp = arrayList.get(0);
        arrayList.set(0, arrayList.get(arrayList.size()-1));
        arrayList.set((arrayList.size()-1),temp);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for(int i : arrayList){
            System.out.println(i);
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         * 测量向集合头部添加 100,000 个元素所需的时间，作为ArrayList 和 LinkedList 的第一个元素
         */
        final int INSERTS = 100_000;

        // test  for insert performance of ArrayList
        long time = System.nanoTime();
        for(int i = 0; i < INSERTS; i++){
            arrayList.add(0,i);
        }
        long arrayListInsertTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime()-time);

        // test for insert performance of LinkedList
        time = System.nanoTime();
        for(int i = 0 ; i < INSERTS; i++){
            linkedList.add(0, i);
        }
        long linkedListInsertTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime()-time);

        System.out.println("insert of ArrayList costs: " + arrayListInsertTime + " ms");
        System.out.println("insert of LinkedList  costs: " + linkedListInsertTime + " ms");

        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        final int READS = 1000;

        // test  for read performance of ArrayList
        time = System.nanoTime();
        for(int i = 0 ; i < READS; i++){
            arrayList.get(arrayList.size()/2);
        }
        long arrayListReadTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime()-time);
        
        // test  for read performance of LinkedList
        time = System.nanoTime();
        for(int i = 0 ; i < READS; i++){
            linkedList.get(linkedList.size()/2);
        }
        long linkedListReadTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime()-time);
        System.out.println("read of ArrayList  costs: " + arrayListReadTime + " ms");
        System.out.println("read of LinkedList  costs: " + linkedListReadTime + " ms");

        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */

        final Map<String,Long> population = new HashMap<>();
        population.put("Africa", 1110635000L);
        population.put("Americas", 972005000L);
        population.put("Antarctica", 0L);
        population.put("Asia", 4298723000L);
        population.put("Europe", 742452000L);
        population.put("Oceania", 38304000L);
        /*
         * 8) Compute the population of the world
         */
        long worldPopulation = 0;
        for(final long p : population.values()){
            worldPopulation += p;
        }
        System.out.println("The population of the world is: " + worldPopulation);
    }
}
