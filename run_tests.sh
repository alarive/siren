#!/bin/bash

#This script will test if all run.sh outputs match test/expected_output.txt
#run.sh contract is simply to accept a siren list as its input and to output
#in the same format as test/expected_output.txt
TO_TEST="bash java-sorted"

for t in $TO_TEST; do
  echo "Testing \"$t...\""
  $t/run.sh < test/sirens_fxt.txt > test_output.txt
  diff -u test_output.txt test/expected_output.txt
  if [ $? -eq 0 ]; then
    echo -e "\e[32m$t succeeded\e[0m"
  else
    echo -e "\e[31m$t failed\e[0m"
  fi
  echo
  rm test_output.txt
done
