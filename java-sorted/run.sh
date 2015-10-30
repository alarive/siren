#!/bin/bash

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
java -cp $DIR/target/siren-1.0.0-SNAPSHOT.jar fr.imj.siren.Main
