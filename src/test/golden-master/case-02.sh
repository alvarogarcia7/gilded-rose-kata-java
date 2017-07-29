#!/bin/bash

set -eu -o pipefail #do not enable 'f'. Actually interested in file glob expansion

case "$1" in 
    record)
        java -jar target/*.jar 10 < src/test/resources/golden-master/2.input > src/test/resources/golden-master/2.expected
        ;;
    play)
        java -jar target/*.jar 10 < src/test/resources/golden-master/2.input > src/test/resources/golden-master/2.actual
        diff src/test/resources/golden-master/2.actual src/test/resources/golden-master/2.expected
        ;;
esac

