JC  = javac

SRC = Printer.java BasicPrinter.java PrinterDecorator.java EncryptedPrinter.java XMLPrinter.java Main.java
OUT = Main.class

all: $(OUT)

$(OUT): $(SRC)
	$(JC) $(SRC)

run: $(OUT)
	java Main

clean:
	rm -f *.class
