/*
 * Dispatcher.h
 *
 *  Created on: Oct 12, 2018
 *      Author: zach
 */

#ifndef DISPATCHER_H_
#define DISPATCHER_H_

#include "Runway.h"
#include "Queue.h"
#include "Stat.h"
#include "Plane.h"

using namespace std;
class Dispatcher {
public:
	Dispatcher(Runway &, Queue&, Queue&);
	virtual ~Dispatcher();
	void doit();
	void Stats();
private:
	Queue& L_;
	Queue& T_;
	Runway& r_;
	Stat* sL_ = new Stat();
	Stat* sT_ = new Stat();
};

#endif /* DISPATCHER_H_ */
