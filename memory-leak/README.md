# Memory Leak

## Override equals() and hashCode() methods
Write proper overridden methods for equals() and hashCode() methods as the HashSet and HashMap use these methods in many operations.

If they're not overridden correctly, then they can become a source for potential memory leak problems.

1. Run PersonTest with VisualVM.
   - Notice the memory leak and high CPU usage by the Garbage Collector.
   - Remember that a Map cannot contain duplicate keys.
   - Inserting duplicate Person objects in a Map should result in one entry. But since we haven't defined proper equals() and hashCode() methods, the map does not consider the objects as equals and we start creating duplicate objects that pile up and increase the memory.


2. Fix the Person class by overriding the equals() and hashCode() methods properly. 
   
3. Run PersonTest with VisualVM with the first test ignored. And the second test unignored. 
   - Notice there is no memory leak and the CPU usage sits around 10%.
   - Inserting duplicate Person objects into the Map results in one entry. 

## Static Field Holding On to the Object Reference

1. Run StaticFieldTest with VisualVM.
   - Notice the memory is constantly high as the object is never deallocated.
   - A heavy object is referenced with a static field. This will never be collected by the JVM Garbage Collector during the lifetime of the JVM process, even after the calculations it was used for are done.


2. Fix the StaticField class by using a local variable.

3. Run StaticFieldTest with VisualVM.
   - Notice the memory is drops down as the object is deallocated.
   - The heavy object is referenced as a local variable that gets created, used and then discarded. 