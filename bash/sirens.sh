#!/bin/bash

# Usage: ./sirens.sh [file]
#   if no [file] parameter is given, reads from stdin

if [ $# -gt 0 ]; then
  if [ $1 = "-h" -o $1 "=" "--help" ]; then 
    echo "Usage: ./sirens.sh [file]"
    echo "  if no [file] parameter is given, reads from stdin"
    exit 0
  fi
fi

#Assumes input is not sorted. If input is indeed sorted, sort $1 can be removed. 
sort $1 | uniq -c | awk '
BEGIN {
  unique=0; duplicated=0 
}
{ $1 == "1"?unique++:duplicated++ } 
END { 
  print "Uniques: "unique
  print "Doublonnés: " duplicated
}'

