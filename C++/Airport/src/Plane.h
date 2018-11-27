/*
 * Plane.h
 *
 *  Created on: Sep 13, 2018
 *      Author: zach
 */

#ifndef PLANE_H_
#define PLANE_H_

#include "Timer.h"
class Plane {
public:
	Plane();
	virtual ~Plane();
	int get_serial () const;
	int get_wait();

private:
	static int number_source_;
	int serial_no_;
	Timer time_;
	int timeArrived = time_.time();

};

#endif /* PLANE_H_ */
