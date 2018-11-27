/*
 * Runway.h
 *
 *  Created on: Sep 27, 2018
 *      Author: zach
 */

#ifndef RUNWAY_H_
#define RUNWAY_H_

#include "Delay.h"
#include "Timer.h"
class Runway {
public:
	Runway(int);
	virtual ~Runway();
	void use();
	void doClear();
	bool isClear() {return clear_;};
private:
	bool clear_;
	Delay* d_;
	Timer t;
	int filledAt_;
	int delayBy_;
};

#endif /* RUNWAY_H_ */
