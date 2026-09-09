JC  = javac

IN  = Main.java Logger.java
OUT = Main.class

all: $(OUT)

$(OUT): $(IN)
	$(JC) $(IN)

run: $(OUT)
	java Main

clean:
	rm -f *.class *.txt
