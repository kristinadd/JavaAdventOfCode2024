package Day_3.AdvancedVersion;

public class Instruction {
  private int firstNumber;
  private int secondNumber;

  public Instruction(int firstNumber, int secondNumber) {
    this.firstNumber = firstNumber;
    this.secondNumber = secondNumber;
  }

  public int getFirstNumber() {
    return firstNumber;
  }

  public int getSecondNumber() {
    return secondNumber;
  }

  @Override
  public String toString() {
    return "[ " + firstNumber + ", " + secondNumber + " ]";
  }
}

// Memory Overhead
// Each Instruction object introduces a small memory overhead compared to primitive arrays.
// For very large datasets, this might become a concern.

// Performance
// Accessing and processing primitive arrays (int[][]) is faster than iterating over objects in a List<Instruction>, especially in performance-critical applications.
// If operations are very frequent, this could lead to slightly slower execution times.

// Code Overhead
// Introducing a new class (like Instruction) requires more boilerplate code compared to using primitive types directly.


// What Is Object Overhead?
// Object overhead refers to the extra memory and processing costs associated with managing objects in Java, beyond the memory required 
// to store the actual data they represent. Every object in Java includes some additional metadata and structural elements that enable 
// features like inheritance, garbage collection, synchronization, and runtime type information.


// Components of Object Overhead
// Object Header:

// Each object in Java has a fixed-size header that includes:
// Class Metadata: Information about the object's type (class) to facilitate features like instanceof checks and method dispatch.
// Synchronization Data: Information required to support thread synchronization (e.g., a lock or monitor).
// Garbage Collection (GC) Information: Metadata for garbage collection, such as reference counts or generation information.
// Typical Size:

// For most JVMs, the object header is 12 bytes (32-bit JVM) or 16 bytes (64-bit JVM with compressed pointers).
// Padding:

// To align objects in memory, padding bytes may be added so the total object size is a multiple of the word size (e.g., 8 bytes on a 64-bit JVM).
// References:

// Fields that reference other objects (e.g., a String or ArrayList) store the memory address (reference) to those objects, not the objects themselves.
// Each reference typically takes 4 bytes (32-bit JVM) or 8 bytes (64-bit JVM with compressed pointers).
// Fields/Data:

// The actual data fields of the object (e.g., int, double, or boolean) contribute to the object’s size.

// Object Overhead in List<Instruction>
// When you use a List<Instruction>, each Instruction object includes both:

// Its data fields (e.g., two integers).
// Object overhead (metadata, padding, etc.).

// Object Overhead in Comparison to Arrays
// If you were to use a 2D int[][] array instead of a List<Instruction>, the memory footprint would be smaller because:

// Arrays do not have an object header for each element (only for the array itself).
// Arrays store primitives directly, avoiding reference overhead.

// No per-object overhead for each row, only for the array itself.
// Total size is simply the size of the integers in the array.


// Summary
// Object overhead is the memory used for an object’s metadata, synchronization, and alignment, beyond the memory for its actual data.
// In cases like List<Instruction>, each object has a fixed overhead (e.g., 16 bytes for the header) in addition to its fields.
// While objects provide flexibility, maintainability, and extensibility, they consume more memory and are slightly slower compared to primitive arrays.
// Choose objects when you need encapsulation or complex behaviors and arrays when performance and memory efficiency are critical.

