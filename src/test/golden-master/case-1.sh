#!/bin/bash

set -eu -o pipefail #do not enable 'f'. Actually interested in file glob expansion

case "$1" in 
    record)
java -jar target/*.jar < src/test/resources/golden-master/1.input > src/test/resources/golden-master/1.expected
        ;;
    play)
java -jar target/*.jar < src/test/resources/golden-master/1.input > src/test/resources/golden-master/1.actual
diff src/test/resources/golden-master/1.actual src/test/resources/golden-master/1.expected
exit $?
        ;;
esac

