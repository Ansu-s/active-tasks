# Redis (Remote Dictionary Server)  
![image](https://github.com/learning-project-01/bookstore-app/assets/130679461/527ea960-5f29-4cf1-ac4b-8f7a89e03f94)  

Redis is an open-source in-memory storage, used as a distributed, in-memory key–value database, cache and message broker, with optional durability.  
It is often referred to as a data structure server because it supports various data structures such as strings, hashes, lists, sets, and sorted sets.     
Redis saves data in memory. And they have two data persistence options, Redis Database and Append Only File (AOF). Append-only file logs every write action received by the server and while RDB creates point-in-time snapshots of the datasets at regular intervals. Having TTL on keys is one of the key features of Redis. It has an LRU eviction strategy by default, if the cache is full it would be evicting the Key.
It can also work as a no-sql database as it stores data in the form of key-value pairs
  
Features of Redis:   
- In-Memory Data Storage
- Data Structures
- Persistence
- Replication and High Availability
- Pub/Sub Messaging
- Lua Scripting
- Atomic Operations
- Partitioning

Disadvantages of Redis:  
- Limited storage capacity compared to disk-based databases.
- Persistence mechanisms may introduce overhead and complexity.
- No built-in support for complex querying and indexing.
- Data must fit entirely into memory, which can be costly for large datasets.
- Replication lag may occur in some scenarios.
- Complexity increases in distributed setups like Redis Cluster.
- Lack of built-in authentication and access control features.
- Limited support for data durability compared to disk-based databases.


The three main types of Redis Architecture are

- Redis Standalone
- Redis Sentinel
- Redis Cluster  

### Redis Standalone Architecture:
The Redis standalone architecture typically consists of a single Redis server instance operating independently.  
Redis standalone architecture is straightforward, with a single Redis server instance handling client requests, managing data storage, and providing various features and functionalities through its rich set of data structures and configurable options.  
It is suitable for use cases where a single instance can meet the performance and scalability requirements of the application.
![image](https://github.com/learning-project-01/bookstore-app/assets/130679461/73ae4fd7-9f46-4430-90f5-a6b674eb9795)
Cons -
- Standalone architecture is not suitable for data reliability requirements.
- Redis is a single-threaded engine, so its performance is also significantly impacted as it has a single-core processor.
### Redis Sentinel:
Redis Sentinel is a high availability solution for Redis. It is a distributed system that monitors Redis instances and automatically handles failover in case of master node failure.  
It has the below features:     

- Monitoring: Redis Sentinel continuously monitors Redis instances, including both master and replica nodes. It checks their health and availability by sending periodic PING commands.

- Automatic Failover: If Redis Sentinel detects that a master node is unreachable or has failed, it initiates an automatic failover process. During failover, Redis Sentinel promotes one of the replica nodes to be the new master. Clients are then redirected to the new master to ensure uninterrupted service.

- Quorum-Based Decision-Making: Redis Sentinel uses a quorum-based approach to make decisions regarding failover. It requires a majority agreement among Sentinel instances before initiating failover. This ensures that failover decisions are made reliably and prevent split-brain scenarios.

- Configuration Management: Redis Sentinel manages the configuration of Redis instances, including monitoring intervals, failover parameters, and promotion rules. Administrators can configure Sentinel instances through a configuration file or using the Redis CLI.

- Notification: Redis Sentinel provides notification mechanisms to alert administrators about changes in the Redis cluster, such as failover events or instances being added or removed. Notifications can be sent via email, SMS, or other channels.

- Multiple Sentinels: Redis Sentinel operates in a distributed manner, with multiple Sentinel instances running across different nodes in the network. This ensures fault tolerance and high availability of the Sentinel system itself.

- Integration with Redis Clients: Redis clients can be configured to automatically discover and connect to Redis Sentinel for failover support. Clients receive information about the current master node and are redirected to the new master during failover.

- ![image](https://github.com/learning-project-01/bookstore-app/assets/130679461/b781e291-00e9-4c88-b2d6-4218e10d8c45)

### Redis Cluster:
Redis Cluster is a distributed implementation of Redis that allows horizontal scaling and high availability.  
It has the below features:     

- Sharding: Redis Cluster automatically partitions data across multiple nodes using sharding. Each key is hash-distributed to a specific shard based on a consistent hashing algorithm. This allows Redis to distribute data evenly across the cluster and enables horizontal scaling.

- Master-Slave Replication: Each shard in Redis Cluster consists of multiple nodes, with one node serving as the master and one or more nodes serving as replicas. The master node is responsible for handling read and write operations, while replica nodes asynchronously replicate data from the master for redundancy and failover purposes.

- Automatic Failover: Redis Cluster supports automatic failover in case of master node failure. When a master node becomes unreachable, the cluster automatically promotes one of its replica nodes to be the new master, ensuring continuous operation and data availability.

- Cluster Configuration: Redis Cluster nodes communicate with each other using a gossip protocol to exchange cluster topology information and maintain consistency. Nodes periodically share information about themselves and other nodes in the cluster, such as their IP addresses, ports, and slots distribution.

- Partitioning: Redis Cluster divides the key space into 16,384 hash slots (from 0 to 16383). Each key is mapped to one of these slots using a consistent hashing algorithm. Each node in the cluster is responsible for handling a subset of these slots, allowing for distributed data storage and efficient data retrieval.

- Redis Cluster Client: Redis clients can connect to a Redis Cluster using special client libraries that support cluster mode. These client libraries handle the routing of commands to the appropriate cluster nodes based on the hash slot of the keys being operated on. Clients are also aware of the cluster topology and can automatically handle node failures and cluster reconfigurations.

- Resharding: Redis Cluster supports dynamic resharding, allowing administrators to add or remove nodes from the cluster without downtime. During resharding, Redis automatically moves hash slots between nodes to re-balance the data distribution and maintain cluster performance.

![image](https://github.com/learning-project-01/bookstore-app/assets/130679461/48f868bb-63f7-4350-8757-162d9c209849)

### Redis Cluster vs Redis Sentinel

- Redis Cluster: It is designed for horizontal scaling and partitioning of data across multiple nodes to handle large datasets and high request loads. Redis Cluster achieves this through automatic sharding and data distribution across multiple master and replica nodes.  
- Redis Sentinel: It is designed specifically for providing high availability and automatic failover in a Redis master-slave replication setup. Sentinel monitors Redis instances and triggers failover when the master node becomes unavailable.

![image](https://github.com/learning-project-01/bookstore-app/assets/130679461/f258bf6c-fe5a-4038-95a1-35078eceef7d)
