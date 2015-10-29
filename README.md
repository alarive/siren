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

Spatial complexity is again dependent of sort and uniq, so probably O(N).

### java-sorted
A java version which assumes its input is sorted.

This assumption allows it to run in O(N) with a spatial complexity of O(1).
