#/bin/sh

CURRENT=$(dirname "$0")
cd $CURRENT
HOMEDIR=`pwd`/../..

g++ callback.cpp -fPIC -shared -o libJNALib.so
g++ swap.cpp -fPIC -shared -o libswap.so 
