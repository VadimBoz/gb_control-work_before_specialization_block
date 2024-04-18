SRC_DIR := src
OUT_DIR := out
DOC_DIR := doc


JSRC := -sourcepath ./$(SRC_DIR)
JCLASS := -cp ./$(OUT_DIR)
JCDEST := -d $(OUT_DIR)
JDOCDEST := -d $(DOC_DIR)
MAIN_SOURCE := Main
MAIN_CLASS := Main

all:
	javac ${JSRC} ${JCDEST} ${SRC_DIR}/${MAIN_SOURCE}.java

clean:
	rm -R ${OUT_DIR}
	rm -R ${DOC_DIR}

run:
	cd out && java ${MAIN_CLASS}

docs:
	javadoc ${JDOCDEST} ${JSRC} ${JCLASS} -subpackages ""
