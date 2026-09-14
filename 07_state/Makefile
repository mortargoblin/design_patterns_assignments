JC  = javac

SRC = CharacterState.java GameCharacter.java NoviceState.java IntermediateState.java ExpertState.java MasterState.java Main.java
OUT = Main.class

all: $(OUT)

$(OUT): $(SRC)
	$(JC) $(SRC)

run: $(OUT)
	java Main

clean:
	rm -f *.class
