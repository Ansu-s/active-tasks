# Java Garbage Collection 

![image](https://github.com/learning-project-01/bookstore-app/assets/130679461/8bcfd919-2e78-46ec-b2d9-1c5fe054c6d0)

Java garbage collectors are responsible for reclaiming memory occupied by objects that are no longer in use by the 
Java application. The primary role of garbage collectors is to manage the heap memory efficiently and prevent memory leaks by identifying and freeing memory occupied by unreachable objects

## Different Types of Java Collection Strategies 
- There are basically two types of collections techniques such as Basic Garbage Collection and Generational Garbage Collection
- Basic garbage collection operates on the entire heap, while generational garbage collection focuses on managing short-lived and long-lived objects differently on different regions to optimize memory usage and performance

### Basic Garbage Collection: Mark, Sweep, Compact

1. **Mark Phase**:
    - Garbage collector scans the heap memory segment and marks all live objects
    - Live objects are those to which the application holds references
    - Objects without any references are eligible for removal

2. **Sweep Phase**:
    - Garbage collector recycles memory occupied by unreferenced objects
    - Unreferenced objects are removed from the heap

3. **Compact Phase**:
    - Following the sweep phase, compacting rearranges objects into contiguous blocks
    - This helps in reducing memory fragmentation and improves memory locality
    - Objects are arranged at the start of the heap to facilitate sequential allocation

### Generational Garbage Collection
![Screenshot (138)](https://github.com/learning-project-01/bookstore-app/assets/130679461/a1c43f6f-dddf-4cb2-b21e-aca8f3c2f925)
1. **Young Objects**:
    - All new objects initially allocated to the young generation, divided into Eden and survivor spaces (S0 and S1)
    - Eden holds new objects, survivor spaces hold objects surviving minor collections
    - Objects surviving minor collections are moved between survivor spaces

2. **Promotion to Old Generation**:
    - Long-lived objects in the young generation become eligible for promotion to the old generation
    - Promoted during minor collections when they survive a certain number of garbage collection cycles

3. **Old Objects**:
    - Garbage collections in the old generation termed as major garbage collections
    - Mark and sweep phases performed to reclaim memory occupied by unreferenced old objects

4. **Full Garbage Collection**:
    - Cleans both young and old generations
    - Promotes live objects from young to old generation and compacts the old generation
    - Involves a stop-the-world pause to ensure no new allocations or references occur during the process

### Most Popular Java Garbage Collectors
![image](https://github.com/learning-project-01/bookstore-app/assets/130679461/2baf4e39-56ca-4adf-98cd-44947554ca0f)

1. **Serial GC:** A simple, single-threaded GC algorithm suitable for small applications or systems with low memory requirements.
 
2. **Parallel GC:** Uses multiple threads to speed up garbage collection, making it more efficient for applications that generate a large amount of garbage.

3. **CMS (Concurrent Mark-Sweep) GC:** Provides low-latency garbage collection by performing most of the collection work concurrently with the application’s execution.

4. **G1 (Garbage-First) GC:** A server-style GC that divides the heap into regions and performs garbage collection on smaller subsets of the heap to minimize pauses and improve throughput.

5. **ZGC:** Designed for applications requiring ultra-low pause times, ZGC performs concurrent garbage collection without significant interruption to the application.

6. **Shenandoah GC:** Another concurrent GC algorithm, Shenandoah aims to reduce pause times by performing garbage collection concurrently with the application.

7. **Epsilon GC:** A no-op GC algorithm useful for testing and scenarios where the application handles memory management independently.

8. **Azul C4 GC:** Designed for high-performance and low-latency requirements, C4 GC utilizes pauseless, concurrent collection techniques.

9. **IBM Metronome GC:** An experimental real-time GC algorithm that focuses on predictable and consistent pause times.

10. **SAP Garbage Collector:** A concurrent GC algorithm optimized for large heap sizes and low-latency requirements.

### Serial Garbage Collector

**How it Works:**
- Operates in a stop-the-world manner, pausing application execution during garbage collection.
- Steps include Initial Mark, Marking, Remark, Sweep and Compact, and Free Memory.
- Performs garbage collection using a single thread.

**Advantages:**
- Simplicity in implementation and understanding.
- Low CPU and memory overhead, suitable for resource-constrained environments.
- Predictable pause times, aiding in application control.
- Deterministic behavior due to single-threaded execution.

**Disadvantages:**
- Longer pause times for larger heaps, affecting application responsiveness.
- Limited scalability on multi-core processors, leading to potential performance degradation.
- Not ideal for large-scale applications with high memory requirements.

### Parallel Garbage Collector:

**How it Works:**
- Similar to Serial GC but introduces parallelism to expedite garbage collection.
- Utilizes multiple threads for concurrent marking, sweeping, and compaction phases.
- Operates in a stop-the-world manner, briefly pausing application execution during garbage collection.

**Advantages:**
- Improved throughput by leveraging multi-threading for garbage collection tasks.
- Reduced pause times compared to Serial GC, enhancing application responsiveness.
- Scalable, capable of handling larger heaps and memory-intensive applications efficiently.
- Enhanced performance for scenarios with significant garbage generation.

**Disadvantages:**
- Higher CPU utilization due to multi-threaded nature, potentially impacting overall system performance.
- Longer individual pause times compared to other algorithms, affecting time-sensitive applications.
- Less suitable for small-scale systems with limited resources or single-core processors.

### Garbage First (G1) 
It is a generational, incremental, parallel, mostly concurrent, stop-the-world, and evacuating garbage collector. It divides the heap into young and old generations, utilizes remembered sets and write barriers for efficient memory management, and evacuates reachable objects to reclaim memory
1. **Generational Approach**:
    - G1 divides the heap into two main regions: the Young Generation and the Old Generation.
    - Objects are initially allocated in the Young Generation, where most short-lived objects reside.
    - Surviving objects are eventually promoted to the Old Generation if they survive multiple garbage collection cycles.

2. **Regionalized Memory Management**:
    - G1 further divides the heap into uniformly sized regions, which can be configured by the user but typically range from 1 to 32 MB in size.
    - Regions can be categorized as Young Regions or Old Regions based on their usage and allocation patterns.
    - Young generation is further divided into two parts such as the eden and survivor region.
    - Eden is the region where newly allocated objects are initially placed. Objects that survive garbage collection in Eden are promoted to the Survivor regions
    - Survivor regions are used to hold objects that have survived one or more garbage collection cycles in the Eden space. There are typically two Survivor regions, often referred to as "From" (S0) and "To"(S1). Objects that survive multiple garbage collection cycles in the Survivor regions are eventually promoted to the old generation
   
3. **Evacuation of Objects**:
    - During garbage collection, G1 identifies regions with a high proportion of unreachable objects, known as garbage.
    - It then selects these regions for evacuation, which involves copying live objects to new, empty regions.
    - Evacuation is performed using a technique called "copying collection," where live objects are copied from one region to another, leaving behind only garbage in the original region.
      ![Screenshot (140)](https://github.com/learning-project-01/bookstore-app/assets/130679461/590d2bb9-edb6-4327-9930-4ba3998d2566)
4. **Handling Humongous Objects**:
    - Humongous objects, which are larger than half the size of a region, are treated differently.
    - They are allocated in separate regions that are specifically sized to accommodate them.
    - G1 may not evacuate humongous objects during every garbage collection cycle, depending on their usage and availability of suitable regions.

5. **Remembered Sets and Write Barriers**:
    - G1 uses remembered sets to track references between objects in different regions, ensuring that references remain valid after evacuation.
    - Write barriers are inserted into application code to update remembered sets whenever object references are modified.
    - These mechanisms help maintain consistency and integrity during garbage collection, especially in the presence of cross-region references.
 ![Screenshot (139)](https://github.com/learning-project-01/bookstore-app/assets/130679461/9d54f92a-0629-41b7-ac3d-d1d2010f0bfd)

6. **Concurrent Phases**:
    - G1 includes concurrent phases, where garbage collection work is performed concurrently with application execution.
    - During these phases, G1 marks live objects, updates remembered sets, and prepares for subsequent evacuation and reclaiming of memory.
    - Concurrent phases help minimize pause times and improve application responsiveness.

7. **Space Reclamation**:
    - After identifying and evacuating unreachable objects, G1 reclaims memory by marking evacuated regions as available for reuse.
    - It may compact memory regions to reduce fragmentation and optimize memory utilization.
    - Space reclamation is an ongoing process, ensuring that memory is efficiently managed throughout the application's lifecycle.

**Advantages:**

- Improved Pause Times: Aims for more predictable and shorter pause times, especially for large heaps.
- Adaptive Behavior: Adjusts heap partitioning and collection strategies based on application workload.
- Better Resource Utilization: Utilizes multiple threads for parallel garbage collection, enhancing CPU resource utilization.
- Reduced Fragmentation: Compacting algorithm reduces memory fragmentation by reclaiming memory from heavily garbage-filled regions.

**Disadvantages:**

- Increased Overhead: May introduce slightly higher CPU overhead due to complex heap management and concurrent marking algorithms.
- Longer Application Warm-Up: Exhibits longer warm-up times as it gathers statistics and adapts behavior for optimized garbage collection performance.