package simpleHashTableImplWithLinearProbing;

public class SimpleHashTable {

    private StoredEmployee[] hashtable;

    public SimpleHashTable() {
        hashtable = new StoredEmployee[10];
    }

    public void put(String key, Employee employee) {
        int hashedKey = hashKey(key);
        //Linear probing to check if index position is occupied or not
        //Then creating PROBE index
        if (occupied(hashedKey)) {
            int stopIndex = hashedKey;
            //Wrap the hashedKey if reached the end of hashtable
            if (hashedKey == hashtable.length - 1) {
                hashedKey = 0;
            } else {
                hashedKey++;
            }
            //Keep probing for next index after the collision index adn till we reach stopIndex from we started our search for vacant position
            while (occupied(hashedKey) && hashedKey != stopIndex) {
                hashedKey++;
            }

        }

        if (hashtable[hashedKey] != null) {
            System.out.println("Sorry, the position is already occupied!!. Position = " + hashedKey);
        } else {
            hashtable[hashedKey] = new StoredEmployee(key, employee);
        }
    }

    //Hashtables backed with array are good for retrieval as you can get the hahsed key in constant time from the String key
    public Employee get(String key) {
        //int hashedKey = hashKey(key);
        int hashedKey = findKey(key);
        if(hashedKey == -1) {
            return null;
        }
        else
            return hashtable[hashedKey].employee;
    }

    //Updated for returning the collided values at given hash key
    private int findKey(String key) {
        int hashedKey = hashKey(key);
        if (hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key)) {
            return hashedKey;
        }
        //Begin Linear Probing to get the matching key in hashtable
        int stopIndex = hashedKey;
        //Wrap the hashedKey if reached the end of hashtable
        if (hashedKey == hashtable.length - 1) {
            hashedKey = 0;
        } else {
            hashedKey++;
        }
        //Keep probing for next index after the collision index
        while (hashedKey != stopIndex && hashtable[hashedKey]!=null && !hashtable[hashedKey].key.equals(key)) {
            hashedKey= (hashedKey+1)%hashtable.length;
        }
        if(stopIndex == hashedKey){
            return -1;
        }
        else{
            return hashedKey;
        }
    }

    public boolean occupied(int index) {
        return hashtable[index] != null;
    }

    public void printHashTable() {
        for (int i = 0; i < hashtable.length; i++) {
            if(hashtable[i]==null){
                System.out.println("empty");
            }
            else {
                System.out.println(hashtable[i].employee);
            }
        }
    }

    private int hashKey(String key) {
        return key.length() % hashtable.length;
    }

}
