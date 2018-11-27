/*
 * Random delay computed using the Rand class object (a singleton)
 *
 * Used in: PROG 2011 Assignment#2
 * by PWP 
 */

#include "Delay.h"

Delay::Delay(int m)
: mean_{m>0?m:0}, r_{Rand::Instance()}
{
}

Delay::~Delay()
{
}

/// This function (getDelay()) returns a sequence of exponentially distributed
/// random numbers:
int Delay::getDelay()
{
	double d {r_->drand()};

	return static_cast<int>(round(-mean_* log(d)));
}

