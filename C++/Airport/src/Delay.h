/*
 * Random delay computed using the Rand class object (a singleton)
 *
 * Used in: PROG 2100 Assignment#2.
 * by PWP 
 */

#ifndef DELAY_H_
#define DELAY_H_

#include "Rand.h" 

class Delay
{
public:
	Delay(int = 1);
	virtual ~Delay();
	int getDelay();
private:
	int mean_; 
	Rand * r_; 
};

#endif /*DELAY_H_*/
