.PHONY: build
build:
	mvn package
	mv target/*jar target/executable.jar

.PHONY: clean
clean:
	mvn clean

.PHONY: register-golden-master
register-golden-master: clean build
	./src/test/golden-master/all.sh record

.PHONY: test
test: clean build
	./src/test/golden-master/all.sh play
	echo "GOLDEN MASTER TESTS ARE OK"


