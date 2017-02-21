#include <stdlib.h>
#include <iostream>
using namespace std;

extern "C"{
void swap(int *p1,int *p2);

 void swap(int *p1,int *p2){
		cout << "p1="<< *p1 << ",p2=" << *p2 <<endl;
		cout << "swap"<<endl;
		int temp;
		temp = *p1;
		*p1 = *p2;
		*p2 = temp;
		cout << "p1="<< *p1 << ",p2=" << *p2 <<endl;
	}
}
