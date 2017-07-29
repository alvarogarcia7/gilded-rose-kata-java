#!/bin/bash

set -eu -o pipefail #do not enable 'f'. Actually interested in file glob expansion

for file in $(ls src/test/golden-master/case*); do
    "$file" "$1"
done

