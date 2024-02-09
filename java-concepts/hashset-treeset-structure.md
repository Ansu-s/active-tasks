## HashSet 
The working of a HashSet is based on a hash table, which is a data structure that uses a hash function to map keys (in this case, the elements being stored) to values (in this case, their positions in the table). The hash function takes an input (the element) and returns a hash code, which is an integer value. This hash code is used as an index to store the element in an array-like structure, often referred to as a bucket.  
HashSet internally uses HashMap to store it’s elements. Whenever you create a HashSet object, one HashMap object associated with it is also created. This HashMap object is used to store the elements you enter in the HashSet. The elements you add into HashSet are stored as keys of this HashMap object. The value associated with those keys will be a constant  
![image](https://github.com/Ansu-s/Java8-features/assets/130679461/0934e3ea-c29a-4add-aaef-95877d366dc5)
![image](https://github.com/Ansu-s/Java8-features/assets/130679461/51830e1a-ad29-40fe-9563-6fe32fc02d18)

## Linked HashSet
It combines the features of a HashSet and a LinkedList. It maintains a doubly-linked list of elements in addition to using a hash table for fast element lookup, insertion, and deletion. The order of elements in a LinkedHashSet is based on the insertion order, meaning that elements are stored in the order they were added.  
LinkedHashSet is an extended version of HashSet. HashSet doesn’t follow any order where as LinkedHashSet maintains insertion order. HashSet uses HashMap object internally to store it’s elements where as LinkedHashSet uses LinkedHashMap object internally to store and process it’s elements.  
![image](https://github.com/Ansu-s/Java8-features/assets/130679461/2ca5dbb5-cd5f-4c69-8ebb-821a3c85f081)

## TreeSet  
It implements the Set interface and stores its elements in a sorted order. Unlike HashSet and LinkedHashSet, which use hashing to store elements, TreeSet uses a red-black tree structure to maintain the ordering of elements.  
TreeSet provides an implementation of the SortedSet Interface and SortedSet extends Set Interface. It behaves like simple set with the exception that it stores elements in sorted format.  
The data structure for the TreeSet is TreeMap; it contains a SortedSet & NavigableSet interface to keep the elements sorted in ascending order and navigated through the tree.

As soon as we create a TreeSet, the JVM creates a TreeMap to store the elements in it and performs all the operations on it. It's working is similar to HashSet.

