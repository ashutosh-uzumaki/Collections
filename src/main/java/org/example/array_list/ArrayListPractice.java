package org.example.array_list;

import java.util.*;

public class ArrayListPractice {
    public void practice(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(7);

        System.out.println(Collections.max(list));
        System.out.println(Collections.min(list));

        ArrayList<Integer> copyList = (ArrayList<Integer>) list.clone();

        Collections.reverse(copyList);
        copyList.add(2);
        copyList.add(8);

        System.out.println("Orginal List Order: "+list);
        System.out.println("Reverse On Copy List: "+copyList);

        List<Integer> distinctList = new ArrayList<>(new LinkedHashSet<>(copyList));
        System.out.println("Unique List: "+distinctList);

        System.out.println("To find Common Elements Between two Lists");
        list.retainAll(copyList);
        System.out.println("Common Elements: "+list);

        copyList.retainAll(list);
        System.out.println("Common elements in copy list: "+copyList);

        List<Integer> mergeList = new ArrayList<>(list);
        mergeList.addAll(copyList);
        System.out.println("Merged list and copy list: "+mergeList);

        System.out.println(list.isEmpty());
        list.clear();
        System.out.println(list.isEmpty());

        System.out.println(list.remove("A"));

        System.out.println(list.contains(7));

        System.out.println(list);

        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i)+" ");
        }

        int multipliedVal = 1;
        for(Integer x: list){
            if(x % 2 == 0){
                continue;
            }
            multipliedVal *= x;
        }
        System.out.println(multipliedVal);

        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        multipliedVal = 1;
        for(Integer num: list1){
            if(num % 2 == 0){
                continue;
            }
            multipliedVal *= num;
        }
        System.out.println(multipliedVal);

        list1.set(2, 5);
        Collections.sort(list1);
        System.out.println(list1);

        Integer[] converted = list1.toArray(new Integer[0]);
        for(Integer x: converted){
            System.out.print(x+" ");
        }
        System.out.println();

        LinkedList<String> students = new LinkedList<>();
        students.add("Ashutosh");
        students.add("Pandey");
        students.add("Max");
        students.add("Verstappen");
        System.out.println(students.get(0));
        System.out.println(students.get(students.size() - 1));
        String[] studentArr = students.toArray(new String[0]);
        students.remove("Max");
        students.remove(1);
        System.out.println(students.indexOf("Ashutosh"));

        String[] games = {"Cricket", "F1", "F2", "F3"};
        List<String> gamesList = new ArrayList<>(Arrays.asList(games));
        gamesList.add("Karting");
//        Collections.sort(gamesList, Collections.reverseOrder());
        Iterator<String> itr = gamesList.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

        List<Integer> sourceList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> destList = new ArrayList<>(Arrays.asList(6, 7, 8, 9, 10));
        System.out.println("Original Destination List: "+destList);
        Collections.copy(destList, sourceList);
        System.out.println("Copied Destination List: "+destList);

        destList.add(5);
        destList.add(2);
        destList.add(1);
        //FREQUENCY OF EACH ELEMENT
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(Integer num: destList){
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entrySet: freqMap.entrySet()){
            System.out.println(entrySet.getKey()+" "+entrySet.getValue());
        }

        List<Integer> palindromicList = new ArrayList<>(Arrays.asList(3, 2, 1, 1, 2, 3));
        int i = 0;
        int j = palindromicList.size() - 1;

        boolean isPalindromic = true;
        while(i <= j){
            if(palindromicList.get(i) != palindromicList.get(j)){
                isPalindromic = false;
                break;
            }
            i++;
            j--;
        }

        if(isPalindromic){
            System.out.println("Palindromic List");
        }else{
            System.out.println("Not Palindromic List");
        }

        //rotate arraylist by k steps
        List<Integer> numList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("Not Rotated List: "+numList);
        int k = 2;
        Collections.rotate(numList, k);
        System.out.println("Rotated List: "+numList);

        Collections.sort(numList, Collections.reverseOrder());
        System.out.println("Second largest element: "+numList.get(1));
        System.out.println("Remove Odd Elements");
        numList.removeIf((x->x%2!=0));
        System.out.println(numList);
        //WHERE TO USE SHUFFLE -> for random
//        Collections.shuffle(list);
        List<String> card = new ArrayList<>(Arrays.asList("A", "Q", "K", "J"));
        System.out.println("Original card: "+card);
        Collections.shuffle(card);
        System.out.println("Shuffled Cards: "+card);
        Collections.shuffle(card, new Random(2));
        System.out.println("Shuffled with seed random: "+card);

        List<Integer> numList2 = new ArrayList<>(new LinkedHashSet<>(Arrays.asList(1, 1, 2, 5, 6, 8, 2)));
        System.out.println(numList2);

        //HW
        //REMOVE DUPLCIATES WHILE PRESERVING INSERTION ORDER WITHOUT LINKEDHASHSET
        //REMOVE DUPLICATES USING SET - WITHOUT PRESERVING INSERTION ORDER
        //UNIQUE REPEATERS - RETURN A LIST OF ELEMENTS THAT APPEAR MORE THAN ONCE -> DO USING ARRAYLIST
        //GIVEN TWO LISTS FIND THE INTERSECTIONS -> WITH DUPLICATE AND WITHOUT DUPLICATE
        //GIVEN TWO LISTS FIND THE UNION - ALL ELEMENTS
        //FIND MEDIAN OF LIST -> ODD/EVEN CASES (ODD -> MEDIAN, EVEN - BOTH / 2.0)
        //CUSTOM SORT ARRAYLIST

        //REMOVE DUPLCIATES WHILE PRESERVING INSERTION ORDER WITHOUT LINKEDHASHSET
        List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 4, 6, 5, 2, 4));
        System.out.println("With Duplicates: "+nums);
        HashMap<Integer, Integer> freq = new LinkedHashMap<>();
        List<Integer> uniqueNums = new ArrayList<>();
        for(i=0; i<nums.size(); i++){
            if(!freq.containsKey(nums.get(i))){
                uniqueNums.add(nums.get(i));
            }
            freq.put(nums.get(i), i);
        }
        System.out.println("Removed Duplicate Nums: "+uniqueNums);

        //REMOVE DUPLICATES WITHOUT INSERTION ORDER
        List<Integer> noOrder = new ArrayList<>(new HashSet<>(nums));
        System.out.println("With no insertion order: "+noOrder);


        //UNIQUE REPEATERS - RETURN A LIST OF ELEMENTS THAT APPEAR MORE THAN ONCE -> DO USING ARRAYLIST
        List<Integer> repeaterElement = new ArrayList<>();

        for(i=0; i<nums.size(); i++){
            int count = 0;
            for(j=0; j<nums.size(); j++){
                if(nums.get(i) == nums.get(j)){
                    count++;
                }
            }
            if(count > 1 && (!repeaterElement.contains(nums.get(i)))){
                repeaterElement.add(nums.get(i));
            }
        }
        System.out.println("Repeater Elements: "+repeaterElement);

    }
}
