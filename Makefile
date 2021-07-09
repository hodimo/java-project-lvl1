clean:
	./gradlew clean

install: clean
	./gradlew install

run-dist:
	./build/install/app/bin/app

check-updates:
	./gradlew dependencyUpdates

lint:
	./gradlew checkstyleMain

build: lint
	./gradlew clean build