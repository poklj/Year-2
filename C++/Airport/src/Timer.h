/*
 * A simulated time source. 
 * A monostate class.
 * Used in: PROG 2100 Assignment#2
 * by PWP 
 */

#ifndef TIMER_H_
#define TIMER_H_

class Timer
{
public:
	Timer();
	virtual ~Timer();
	int tic();
	int time()const;
private: 
	static int time_; 
};

#endif /*TIMER_H_*/
