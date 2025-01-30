import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;


public class Main {

    public static void main(String[] args) {
        TreeSet<Person> candidates = new TreeSet<>(new SpacePersonComparator());
        candidates.add(new Person("Sonya Popova", 35, 15));
        candidates.add(new Person("Dazdraperma Sponzhova", 33, 15));
        candidates.add(new Person("Salavat Netologshvili", 23, 13));
        candidates.add(new Person("Sasha Sun", 31, 15));
        candidates.add(new Person("Svetlana Morkov", 38, 15));
        candidates.add(new Person("Sasha Sosnova", 38, 11));

        Iterator<Person> it = candidates.iterator();
        System.out.println(it.next());
        System.out.println(it.next());

    }
}


class Person {
    private String name;
    private int age;
    private int experience;

    public Person(String name, int age, int experience) {
        this.name = name;
        this.age = age;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return name;
    }
}


class SpacePersonComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        if (Integer.compare(o2.getExperience(), o1.getExperience()) != 0) {
            return Integer.compare(o2.getExperience(), o1.getExperience());
        }
        if (Integer.compare(countChar(o2.getName()), countChar(o1.getName())) != 0) {
            return Integer.compare(countChar(o2.getName()), countChar(o1.getName()));
        }
        return Integer.compare(o1.getName().length(), o2.getName().length());
    }

    public int countChar(String name) {
        int count = 0;

        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) == 's' || name.charAt(i) == 'S') {
                count++;
            }
        }
        return count;
    }
}