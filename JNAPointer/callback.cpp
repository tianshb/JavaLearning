#include <stdlib.h>
#include <iostream>

using namespace std;

extern "C"
{
	typedef void (*OpenFunc) (const char*, int);
	
	OpenFunc openfunc=NULL;

	void init(OpenFunc func){
		cout << "init called" <<endl;
		openfunc = func;
	}

	void test(){
		if(openfunc == NULL){
			cout << "openfunc is NULL" << endl;
		}
		(*openfunc)("test", 0);
	}
}
