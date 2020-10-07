build:
	clj -Spom
	clj -M:jar trimax.jar

install:
	clj -M:install trimax.jar

deploy:
	clj -M:deploy trimax.jar
