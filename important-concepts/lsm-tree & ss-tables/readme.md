# LSM TREE ( Log-Structured-Merge Tree)  
![image](https://github.com/Ansu-s/active-tasks/assets/130679461/b91fafb1-c909-4942-9947-176f3f7ce683) 
- The Log-Structured Merge-tree (LSM tree) is a data structure used for storing and managing data efficiently
- LSM tree is mostly used by the data storage engines
- It is optimized for write-heavy workload, it can porvide efficient data insertion and retrival using ranging queries
- LSM Tree is mostly used in case of NoSQL databases where as B Tree is used  for SQL databases

## Memtable 
![Screenshot (122)](https://github.com/Ansu-s/active-tasks/assets/130679461/7e6d52d4-9c2d-47de-9c99-f3e964828925)  
- The Memtable is an in-memory structure that buffers incoming data from clients before flushing them to disk
- Every read or write request comes to the memtable first and gets stored there
- The memtable flushes the data when the it reaches a certain size threshold
- Memtable internally maintains a efficient data structure like balanced binary trees such as AVL Trees or Red Black Trees or a Skiplist 
- All the contents of a memtable are sorted and immutable in nature
- Since the Memtalble uses RAM for data storage data can be lost in case of power failures to solve this issue a WAL (Write Ahead Log) file is mentained, any failures occur we can read the WAL and recreate the memtable
- Memtables are stored in fast non-persistant volatile storages it has a certain size threshold, if the memtable reaches this limit it flushes the data to persistant storage in the form of files. These persisted files are known as SSTables

![sstables](https://github.com/Ansu-s/active-tasks/assets/130679461/971bd6fc-8d8e-4400-8bb2-19cb1df964d8)

## SSTables (sorted string table)
![image](https://github.com/Ansu-s/active-tasks/assets/130679461/258037a4-fa8a-41ee-9602-64d0108dbb90)

- An SSTable file is created when the Memtable reaches its capacity or when compaction happens
- The data in SSTable is persistant, sorted and immutable to facilitate efficient read performance
- SSTables typically store key-value pairs, where each key is associated with a corresponding value
- The contents of a sstable can't be changed or updated and updation of table data leads to creation of new table and the old one is marked as a tombstone
- When the number of sstables increases and the number of tombstones increses to maintain efficiecy compaction happens 
- SSTables generally maintains Bloomfilters to speedup data read process of LSM Tree
- The SSTables are continuosly re-organized and compacted into different levels which are usually namespaced as Level 0 to Level N 
- The level right below the Memtable is Level 0, and can contain SSTables with overlapping keys as we go down the compactions levels data duplication is reduced and data stored in more efficient manner  
![Lsm tree merge](https://github.com/Ansu-s/active-tasks/assets/130679461/07645591-72df-4125-835f-9bacf65514ed)

## I/O Operations on LSM Tree 
- For any read operation following steps are done:
  - Find in active memtable
  - If there is no active memtable, search in immutable memtable
  - If the immutable memtable is not available, search in the L0 SSTable , generally SSTables maintains Bloom filters to enchance the speed of data searching
  - If the data is not found search the remaining SSTables

- For any write operation following steps are done:
  - Write data to the active memtable in memory
  - Write the Write-Ahead Log (WAL) file first to ensure data integrity and persistance
  - Once the memetable size limit is reached table data flushed into the disk in the form of sstable file
  - The sstabls then get compacted to get stored in efficient manner   

 ![lsm](https://github.com/Ansu-s/active-tasks/assets/130679461/352720c3-ef34-442d-9b67-e639a5719779) 

 ## Compaction Strategies in LSM Tree
 A compaction strategy is useful when the number of SSTables increases dramatically and we need to efficienly arrange them so the I/O oprations doesn't get affected
 - Size-tiered compaction strategy:
   - Prioritizes minimizing write amplification by compacting data based on the size of SSTables
   - Write-optimized compaction strategy used as the default in ScyllaDB and Cassandra
- Leveled Compaction Strategy:
  - Organizes SSTables into different levels, each level containing progressively larger SSTables
  - Provides more predictable and uniform read performance by ensuring that each SSTable covers a similar range of data
- ime Windowed Compaction Strategy:
  - Specifically designed for time series databases where data has a natural time ordering
  - Triggers compaction based on time intervals or time windows rather than size or level

## Advantages of LSM Tree
- Optimized for write-heavy workloads, making them suitable for applications with frequent write operations
- Utilizes sequential writes for initial data storage, improving write performance by minimizing random disk accesses
- Sorted storage structure enables efficient range queries by organizing data in sorted order, reducing disk seeks for read operations
- Scales well with data volume and write throughput, making LSM Trees suitable for large-scale distributed systems and databases
## Disadvantages of LSM Tree
- Compaction processes may lead to read amplification by necessitating multiple disk reads during query execution, impacting read performance
- Compaction may result in space amplification by generating multiple versions of data files, increasing storage space requirements
- Overwrites and deletions of data may lead to write amplification, especially in write-heavy workloads, impacting write performance

## Sources
 <details>
  <summary>LSM Tree Resources</summary>
  
  - [LSM Tree Research Paper](https://www.cs.umb.edu/~poneil/lsmtree.pdf)
  - [Video Explanation](https://www.youtube.com/watch?v=I6jB0nM9SKU)
  - [LSM Tree Blog (DEV Community)](https://dev.to/creativcoder/what-is-a-lsm-tree-3d75)
  - [LSM Tree Blog](https://segmentfault.com/a/1190000041198407/en)
</details>
