# SIRENs

Various programs to report duplicates in a list of SIREN numbers.

A SIREN number is an administrative code that is used to identify french
companies.

Run the tests with:

```
./run-tests.sh
```

Run an indivudal program by doing:
```
cd [program]
./run.sh < ../test/sirens_fxt.txt
```

For example:
cd bash
./run.sh < ../test/sirens_fxt.txt

## PROGRAMS

### bash
A bash script which uses sort, uniq and awk to do the job.

You can remove the call to sort if the input is already sorted.

Runtime complexity is the complexity of sort and uniq, i.e probably O(N log(N))
on average.

Spatial complexity is again dependent of sort and uniq, so probably O(N). In
real life it should be the fastest version in most cases since it does not 
suffer from the JVM startup costs.

### java-sorted
A java version which assumes its input is sorted.

This assumption allows it to run in O(N) with a spatial complexity of O(1).

Use this version if you don't want to use a shell script or for very very 
large files (millions of entries) where the JVM startup cost would be offset
by the faster algorithm.

### java-hashmap
A java version which works even if its input is not sorted.

It runs in O(N) with a spatial complexity of O(N)

### java-array
A java version which takes advantadge of the fact that SIREN numbers always
have 9 digits. It runs in 0(N) with a spatial complexity of O(1).

Prefer this version over the java-hashmap version only for very very large inputs
as the spatial complexity hides the fact that the constant is very large
(it uses a 10^10 byte array)
