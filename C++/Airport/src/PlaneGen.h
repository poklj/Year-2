/*
 * PlaneGen.h
 *
 *  Created on: Sep 27, 2018
 *      Author: zach
 */

#ifndef PLANEGEN_H_
#define PLANEGEN_H_

#include "Plane.h"
#include "Queue.h"
#include "Delay.h"
class PlaneGen {
public:
	PlaneGen(Queue&, int);
	virtual ~PlaneGen();
	void nextPlane();
private:
	Queue& q_;
	Delay d_;
	int nextArrival_;
	Timer watch;
};

#endif /* PLANEGEN_H_ */
