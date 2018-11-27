//============================================================================
// Name        : Bighello.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <cmath>
using namespace std;

double Pi3{4*atan(1.0)};

#include "aux.h"
//void print(double[], int);
//void print(int[], int);

int main() {

	static double Pi2{4*atan(1.0)};
	double Pi{4*atan(1.0)};

	std::cout << "!!!Hello World!!!" << std::endl; // prints !!!Hello World!!!
	std::cout << "lololol" << std::endl;
	std::cout << "Pi = " << Pi << std::endl;

	std::cout << "Pi2 = " << Pi3 << std::endl;

	cout << "Address Pi : " << &Pi << endl;
	cout << "Address Pi2 :" << &Pi2 << endl;
	cout << "Address Pi3 :" << &Pi3 << endl;

	double *p1{&Pi}; // Pointer Assignment
	double *p2;


	*p1 = 7; // Assign Pi through a Pointer
	cout << "Pi = " << Pi << endl;

	double &&foobar{Pi3++}; // Get the OLD value of Pi3 and do something with it

	p2 = new double {88.8};

	double p3 [] = {8, 7, 6};
	int p4[] = {4, 5, 6};

	double &ref2Pi2{Pi2};

	cout << foobar << endl;
	cout << foobar << endl;

	cout << *p2 << " at " << p2 << endl;
	std::string x[] {"Lol", "bob", "wah"};

	print(x, 3);
	delete [] p3;

	return 0;
}
