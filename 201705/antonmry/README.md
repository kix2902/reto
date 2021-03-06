# Second @vigojug challenge by @antonmry

Assuming you have jdk8 installed, execute the following commands:

```
javac -cp .:hamcrest-core-1.3.jar:junit-4.12.jar SubsetSum.java
java -cp .:hamcrest-core-1.3.jar:junit-4.12.jar org.junit.runner.JUnitCore SubsetSum
```

Without tunning, this is the performance in my laptop (i7):

```
Array with 1 records: elapsed time = 1ms
Array with 2 records: elapsed time = 10ms
Array with 3 records: elapsed time = 3ms
Array with 4 records: elapsed time = 5ms
Array with 5 records: elapsed time = 8ms
Array with 6 records: elapsed time = 15ms
Array with 7 records: elapsed time = 14ms
Array with 8 records: elapsed time = 31ms
Array with 9 records: elapsed time = 59ms
Array with 10 records: elapsed time = 36ms
Array with 11 records: elapsed time = 65ms
Array with 12 records: elapsed time = 97ms
Array with 13 records: elapsed time = 227ms
Array with 14 records: elapsed time = 542ms
Array with 15 records: elapsed time = 794ms
Array with 16 records: elapsed time = 1657ms
Array with 17 records: elapsed time = 3847ms
Array with 18 records: elapsed time = 8906ms
Array with 19 records: elapsed time = 20199ms
Array with 20 records: elapsed time = 48233ms
Array with 21 records: elapsed time = 110072ms
Array with 22 records: elapsed time = 253477ms
Array with 23 records: elapsed time = 541587ms
```

After tunning:

```
Array with 1 records: elapsed time = 1ms
Array with 2 records: elapsed time = 510ms
Array with 3 records: elapsed time = 506ms
Array with 4 records: elapsed time = 501ms
Array with 5 records: elapsed time = 501ms
Array with 6 records: elapsed time = 502ms
Array with 7 records: elapsed time = 503ms
Array with 8 records: elapsed time = 504ms
Array with 9 records: elapsed time = 510ms
Array with 10 records: elapsed time = 505ms
Array with 11 records: elapsed time = 511ms
Array with 12 records: elapsed time = 512ms
Array with 13 records: elapsed time = 508ms
Array with 14 records: elapsed time = 510ms
Array with 15 records: elapsed time = 510ms
Array with 16 records: elapsed time = 507ms
Array with 17 records: elapsed time = 506ms
Array with 18 records: elapsed time = 509ms
Array with 19 records: elapsed time = 513ms
Array with 20 records: elapsed time = 512ms
Array with 21 records: elapsed time = 529ms
Array with 22 records: elapsed time = 545ms
Array with 23 records: elapsed time = 578ms
Array with 24 records: elapsed time = 638ms
Array with 25 records: elapsed time = 634ms
Array with 26 records: elapsed time = 1005ms
Array with 27 records: elapsed time = 2006ms
Array with 28 records: elapsed time = 3191ms
Array with 29 records: elapsed time = 5683ms
Array with 30 records: elapsed time = 11197ms
Array with 31 records: elapsed time = 25225ms
Array with 32 records: elapsed time = 46282ms
Array with 33 records: elapsed time = 95739ms
Array with 34 records: elapsed time = 187309ms
Array with 35 records: elapsed time = 384352ms
```

TODO:

- [x] Improve calculation, using directly subarrays
- [x] Avoid calc with array of size 1 (really minor improvement, deleted)
- [x] Threads per subarray length
- [x] Increase the number of threads? -> No
- [x] Tune GC -> minor impact, there is no allocation of memory
- [x] Avoid repeated subarrays -> already done
- [x] Allocation / cast optimization / refactoring 
- [x] Use int[] instead of Integer[]



