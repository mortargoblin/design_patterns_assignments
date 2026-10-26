JC  = javac

FX_VERSION = 21
FX_REPO    = $(HOME)/.m2/repository/org/openjfx
FX_PATH    = $(FX_REPO)/javafx-base/$(FX_VERSION):$(FX_REPO)/javafx-graphics/$(FX_VERSION):$(FX_REPO)/javafx-controls/$(FX_VERSION)
FX_FLAGS   = --module-path $(FX_PATH) --add-modules javafx.controls

SRC = ColorBox.java Controller.java Gui.java IMemento.java Main.java Memento.java Model.java
OUT = out/memento/guistate/Main.class

all: $(OUT)

$(OUT): $(SRC)
	$(JC) $(FX_FLAGS) -d out $(SRC)

run: $(OUT)
	java $(FX_FLAGS) -cp out memento.guistate.Main

clean:
	rm -rf out
