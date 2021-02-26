package simpleHashTableImplWithLPRemove;

public class Main {
    public static  void main(String args[]){
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        Employee billEnd = new Employee("Bill", "End", 77);

        SimpleHashTable ht = new SimpleHashTable();
        ht.put("Jones",janeJones);
        ht.put("Doe",johnDoe);
        ht.put("Wilson",mikeWilson);
        ht.put("Smith",marySmith);

        ht.printHashTable();
        System.out.println("Retrieve the value for key Wilson : "+ ht.get("Wilson"));
        System.out.println("Retrieve the value for key Smith : "+ ht.get("Smith"));

        ht.remove("Jones");
        ht.remove("Wilson");
        ht.printHashTable();
        //Below line creates problem because of the removal method impl, which sets the value in table to null, whereas
        // we drop out of the while loop while trying to findKey for matching key when we encouter null. Becasue it
        // assumes that the incoming employee will be put int the very next empty place hence a null means we have
        // reached end of our search the moment we hit null
        //SOLUTION - REHASHING which is defined in package - simpleHashTableImplWithLPRemoveWithRehashing
        System.out.println("Retrieve the value for key Smith : "+ ht.get("Smith"));
    }
}
