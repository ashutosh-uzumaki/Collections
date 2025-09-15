package org.example.array_list;

import java.util.*;

class Student{
    Long id;
    String name;

    Student(Long id, String name){
        this.id = id;
        this.name = name;
    }

//    @Override
//    public boolean equals(Object o){
//        if(this == o) return true;
//        if(!(o instanceof Student)) return false;
//        Student s = (Student)(o);
//        return Objects.equals(name, s.name) && Objects.equals(id, s.id);
//
//    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
//        if(!(o instanceof Student)) return false;
        if(o == null || o.getClass() != getClass()) return false;
        Student s = (Student) o;
        if(name == null){
            if(s.name != null){
                return false;
            }
        }else if(!(name.equals(s.name))){
            return false;
        }
        return id == s.id && name == s.name;
    }

    @Override
    public int hashCode(){
//        return Objects.hash(id, name);
        int hashCode = 20;
        hashCode = hashCode * 31 + (name == null ? 0 : name.hashCode())
                + (id == null ? 0 : id.hashCode());
        return hashCode;
    }

    @Override
    public String toString(){
        return "id: "+id+" name: "+name;
    }
}

public class ContainsManual {
    public static void main(String[] args){
//        List list = new ArrayList<>(Arrays.asList("A", "B", "C", "D"));
//        System.out.println(containsManual(list, "B"));
//        System.out.println(containsManual(Arrays.asList(10, 20, 30, 40), 20));
//        System.out.println(containsManual(Arrays.asList(new Student(1, "Ashutosh"), new Student(2, "Pandey")), new Student(1, "Ashutosh")));
//        List list2 = new ArrayList<>(Arrays.asList("A", null, "C", "D"));
//        System.out.println(containsManual(list2, null));
//        System.out.println(containsManual(Arrays.asList(new Student(1, "Ashutosh"), new Student(2, "Pandey")), null));
//        String a = null;
//        String b = "hello";
//        System.out.println(Objects.equals(a, b));
    }

    private static <T> boolean containsManual(List<T> list, T key) {
        for(T val: list){
            if(val.equals(key)){
                return true;
            }
        }
        return false;
    }

}

/*

<T> IT'S A GENERIC TYPE PARAMETER. THIS MEANS THE METHOD WILL WORK FOR ANY TYPE (INTEGER, STRING, CUSTOM CLASS OBJECTS, POJO)
GENERIC TYPE MEANS - OUR CODE WILL WORK FOR ANY DATA TYPE. THAT MEANS IT'S A TYPE SAFE OF WRITING THE CODE.
IT MEANS WITHOUT REWRITING THE SAME LOGIC FOR EVERY TYPE THE CODE IS REUSABLE.
PROBLEM WILL COME IF WE NOT DEFINE THE TYPE -> CLASS CAST EXCEPTION AT RUNTIME.

<E> - ELEMENTS
<T> - TYPE

DIFFERENCE BETWEEN java.lang.Object vs java.util.Objects
java.lang.Object - this package is default package in java Object is superclass of all the classes.
It means if we create any object by default it will extend all the methods of the Object class
equals, hashCode, toString(), etc.

To avoid the import it became default package.

java.util.Objects - We need to import it. Because it's an utility class and all the methods are static and it
provides helper method feature that we can use with objects safely.
Objects.equals(a, b) -> it means it gives null safe equality check
Objects.hash(a, b, c, d, ....) -> Means hashcode will be generated based on all the fields provided.
To generate Objects.requireNoneNull(obj) -> if this obj is null it will throw null pointer exception
Objects.toString(obj, default) -> This is safe because it will fallback to toString() method.
Objects.compare(a, b, comparator) -> Null safe compare
 */
