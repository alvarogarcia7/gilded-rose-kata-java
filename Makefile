.PHONY: build
build:
	mvn package
	mv target/*jar target/executable.jar

.PHONY: clean
clean:
	mvn clean

.PHONY: register-golden-master
register-golden-master: clean build
	java -jar target/*.jar > src/test/resources/golden-master/1.expected

.PHONY: test
test: clean build
	java -jar target/*.jar > src/test/resources/golden-master/1.actual
	diff src/test/resources/golden-master/1.actual src/test/resources/golden-master/1.expected
	echo "GOLDEN MASTER TESTS ARE OK"


