/*
 * Systime.h
 *
 *  Created on: 29-Oct-2008
 *      Author: piotr
 */

#ifndef SYSTIME_H_
#define SYSTIME_H_

#include <cstdlib>
#include "Runnable.h"

class Systime: public Runnable {
public:
	Systime();
	virtual ~Systime();
	void operator() () { system( "date" ); }
};

#endif /* SYSTIME_H_ */
