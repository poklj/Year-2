/*
 * A simulated time source. 
 * A monostate class.
 * Used in: PROG 2011 Assignment#2
 * by PWP 
 */

#include "Timer.h"

int Timer::time_{0};

Timer::Timer()
{
}

Timer::~Timer()
{
}
int Timer::tic()
{
	return ++time_;
}
int Timer::time()const
{
	return time_ ;
}
