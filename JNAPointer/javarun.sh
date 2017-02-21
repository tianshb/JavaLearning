#/bin/sh

CURRENT=$(dirname "$0")
cd $CURRENT
HOMEDIR=`pwd`/../..

javac -cp jna-4.2.1.jar:. JNAPointer.java
java -cp jna-4.2.1.jar:. JNAPointer
