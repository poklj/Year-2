/*
 * Runnable.h
 *
 *  Created on: 29-Oct-2008
 *      Author: piotr
 */

#ifndef RUNNABLE_H_
#define RUNNABLE_H_

class Runnable {
public:
	Runnable();
	virtual ~Runnable();
	virtual void operator() () = 0;
};

#endif /* RUNNABLE_H_ */
