package simpleHashTableImpl;

public class SimpleHashTable {

    private Employee[] hashtable;

    public SimpleHashTable(){
        hashtable = new Employee[10];
    }

    public void put(String key, Employee employee){
       int hashedKey = hashKey(key);
       if(hashtable[hashedKey]!= null){
           System.out.println("Sorry, the position is already occupied!!. Position = "+hashedKey);
       }
       else{
           hashtable[hashedKey]=employee;
       }
    }
//Hashtables backed with array are good for retrieval as you can get the hahsed key in constant time from the String key
    public Employee get(String key){
       int hashedKey = hashKey(key);
       return hashtable[hashedKey];
    }

    public void printHashTable(){
        for(int i=0;i<hashtable.length;i++){
            System.out.println(hashtable[i]);
        }
    }
    private int hashKey(String key){
        return key.length() % hashtable.length;
    }

}
