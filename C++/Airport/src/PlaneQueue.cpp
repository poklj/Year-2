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
#include "PlaneGen.h"
#include "Dispatcher.h"
#include "Runway.h"
using namespace std;

int main() {
	/*
	 Plane * p = new Plane;
	 */

	/*Plane * q = new Plane;
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
	return 0; */

	int K = 1; // Number of Runways
	int mland = 8; // Mean Land time
	int mtakeoff = 7; // Mean takeoff delay
	int mclear = 5; //Mean Runway clear time
	int simTime = 720;
	Timer b;

	Queue Landing;
	Queue Takeoff;
	PlaneGen LPG(Landing, mland);
	PlaneGen TPG(Takeoff, mtakeoff);
	Runway runway(mclear);
	Dispatcher dispatch(runway, Landing, Takeoff);

	while (b.tic() < simTime){
		LPG.nextPlane();
		TPG.nextPlane();
		dispatch.doit();
	}

	while(!Landing.isEmpty() || !Takeoff.isEmpty()){
		dispatch.doit();
		b.tic();
	}
	dispatch.Stats();
	cout << "Time given: " << simTime << endl;
	cout << "Time taken: " << b.time() << endl;



}
