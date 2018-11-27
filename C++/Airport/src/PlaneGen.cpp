/*
 * PlaneGen.cpp
 *
 *  Created on: Sep 27, 2018
 *      Author: zach
 */

#include "PlaneGen.h"

PlaneGen::PlaneGen(Queue& q, int m)
: q_{q}, d_{m}, nextArrival_{watch.time() + d_.getDelay()}
{
	// TODO Auto-generated constructor stub
}

PlaneGen::~PlaneGen() {
	// TODO Auto-generated destructor stub
}

void PlaneGen::nextPlane(){
	if (watch.time() >= nextArrival_){
		if (q_.enqueue(new Plane))
		nextArrival_ = watch.time() + d_.getDelay();
	}
}

