JC  = javac

SRC = Game.java NumberGuessingGame.java Main.java
OUT = Main.class

all: $(OUT)

$(OUT): $(SRC)
	$(JC) $(SRC)

run: $(OUT)
	java Main

clean:
	rm -f *.class
