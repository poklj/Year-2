//============================================================================
// Name        : PlaneQueue.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include "Queue.h"
#include "Plane.h"
using namespace std;

int main() {
	/*
	 Plane * p = new Plane;
	 */
	Plane * q = new Plane;
	Plane * a;
	Queue TestQ;

	for (int i = 0; i != 7; i++) {
		Plane * p = new Plane;
		if (TestQ << p) {
			cout << "Queued:" << p->get_serial() << endl;
			cout << TestQ.isFull();
		} else {
			cout << "Failed to Queue:" << p->get_serial() << " | Queue Full"
					<< endl;
			cout << TestQ.isFull();
		}

	}
	for (int i = 0; i != 3; i++) {
		a = TestQ.dequeue();
		cout << "Dequeued:" << a->get_serial() << endl;
		delete a;
		cout << TestQ.isFull();
	}
	for (int i = 0; i != 2; i++) {
		Plane * p = new Plane;
		if (TestQ << p) {
			cout << "Queued:" << p->get_serial() << endl;
			cout << TestQ.isFull();
		} else {
			cout << "Failed to Queue:" << p->get_serial() << " | Queue Full"
					<< endl;
			cout << TestQ.isFull();
		}
	}

	cout << TestQ.inspect()->get_serial() << endl;
	cout << TestQ.isFull();
	cout << "Done" << endl;
	return 0;
}
