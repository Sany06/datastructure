package selfpracticeproblems.java8;

import java.util.*;
import java.util.stream.Collectors;

public class Practice {
    static void main(String[] args) {
        countfrequencyOfNumbers();
        countfrequencyOfStringBasedOnLength();
        printfirstNonRepeatingCharacterInString();
        groupByWordlength();
        countOddAndEvenNums();


        getTotalPriceBycategory();
        getNamesGroupOnDept();
        getMaxSalaryDeptWise();

        findDuplicateElements();
        groupAnaGrams();
        sumOfAllElements();

    }

    private static void sumOfAllElements() {
        List<Integer> list = List.of(1,2,3,4,5);
        Integer reduce = list.stream().reduce(0, Integer::sum);
        System.out.println(reduce);
    }


    private static void groupAnaGrams() {
        List<String> list =
                Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat");

        Map<String, List<String>> collect = list.stream()
                .collect(Collectors.groupingBy(a -> {
                    char[] ch = a.toCharArray();
                    Arrays.sort(ch);
                    return new String(ch);
                }));
        System.out.println(collect);
    }


    private static void countfrequencyOfStringBasedOnLength() {
        List<String> list =
                Arrays.asList("hi", "hello", "cat", "dog", "java");
        list.stream().collect(Collectors.groupingBy(a-> a.length(),Collectors.counting()));
    }

    private static void countfrequencyOfNumbers() {
        List<Integer> list =
                Arrays.asList(1,2,3,1,2,1,4);
        list.stream()
                .collect(Collectors.groupingBy(
                        a -> a,
                        Collectors.counting()
                ));
    }



    private static void countOddAndEvenNums() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        numbers.stream().collect(Collectors.groupingBy(num-> num%2==0? "Even": "Odd", Collectors.counting()));
    }

    private static void groupByWordlength() {
        List<String> fruits = Arrays.asList("apple", "banana", "kiwi", "pear", "grape");
        Map<Integer, List<String>> result = fruits.stream()
                .collect(Collectors.groupingBy(String::length));
    }

    private static void printfirstNonRepeatingCharacterInString() {
        String s = "abbcc";
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        s.chars().mapToObj(a -> (char) a).forEach(c -> map.put(c, map.getOrDefault(c, 0) + 1));
        Character c = map.entrySet().stream().filter(entry -> entry.getValue() == 1).map(Map.Entry::getKey).findFirst().orElse(null);
        System.out.println(c);

        Character c1 = s.chars().mapToObj(a -> (char) a)
                .collect(Collectors.groupingBy(a -> a, LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(a -> a.getValue() == 1)
                .map(a -> a.getKey())
                .findFirst().orElse(null);
        System.out.println(c1);
    }

    private static void getTotalPriceBycategory() {
        List<Item> items = Arrays.asList(
                new Item("Electronics", 1000),
                new Item("Books", 15),
                new Item("Electronics", 200),
                new Item("Books", 30)
        );

        Map<String, Integer> sum = items.stream().collect(
                Collectors.groupingBy(
                        i -> i.getCategory(),
                        Collectors.summingInt(i -> i.getPrice()) // Crucial part: wraps the price in a summing collector
                )
        );

        Map<String, Double> avg = items.stream().collect(
                Collectors.groupingBy(
                        i -> i.getCategory(),
                        Collectors.averagingInt(i -> i.getPrice())
                )
        );
    }

    private static void getNamesGroupOnDept() {
        List<Employee> list = Arrays.asList(
                new Employee("Rahul", "IT",100),
                new Employee("Aman", "HR",100),
                new Employee("Priya", "IT",100),
                new Employee("Neha", "HR",100)
        );
        list.stream()
                .collect(Collectors.groupingBy(
                        emp -> emp.getDept(),
                        Collectors.mapping(
                                e -> e.getName(),
                                Collectors.toList()
                        )
                ));
    }

    private static void getAvgSalaryDeptWise() {
        List<Employee> list = Arrays.asList(
                new Employee("Rahul", "IT",100),
                new Employee("Aman", "HR",100),
                new Employee("Priya", "IT",100),
                new Employee("Neha", "HR",100)
        );
        list.stream()
                .collect(Collectors.groupingBy(
                        e -> e.getDept(),
                        Collectors.averagingDouble(i -> i.getSalary())
                ));
    }

    private static void getMaxSalaryDeptWise() {
        List<Employee> list = Arrays.asList(
                new Employee("Rahul", "IT",100),
                new Employee("Aman", "HR",100),
                new Employee("Priya", "IT",100),
                new Employee("Neha", "HR",100)
        );
        list.stream()
                .collect(Collectors.groupingBy(
                        e -> e.getDept(),
                        Collectors.maxBy(
                                Comparator.comparing(Employee::getSalary)
                        )
                ));
    }

    private static void groupBasedOnSalaryAndName() {
        List<Employee> list = Arrays.asList(
                new Employee("Rahul", "IT",100),
                new Employee("Aman", "HR",100),
                new Employee("Priya", "IT",100),
                new Employee("Neha", "HR",100)
        );
        list.stream()
                .sorted(
                        Comparator.comparingDouble(Employee::getSalary)
                                .reversed()
                                .thenComparing(Employee::getName)
                )
                .toList();
        //Sort based on name length and then salary  desc
        list.stream()
                .sorted(
                        Comparator.comparingInt((Employee e) -> e.getName().length())
                                .thenComparing(
                                        Comparator.comparingDouble(Employee::getSalary)
                                                .reversed()
                                )
                )
                .collect(Collectors.toList());
    }

    private static void findDuplicateElements() {
        List<Integer> list =
                Arrays.asList(1,2,3,1,2,4,5,3);
        list.stream()
                .collect(Collectors.groupingBy(
                        n -> n,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(a -> a.getKey())
                .toList();
    }
}
