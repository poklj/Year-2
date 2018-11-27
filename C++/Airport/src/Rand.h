/*
 * Random number generator producing double numbers
 * distributed uniformly over [0,1]
 *
 * A singleton class.
 * Used in: PROG 2100 Assignment#2
 * by PWP 
 */

#ifndef RAND_H_
#define RAND_H_

#include <cmath>
#include <cstdlib>
#include <ctime>

class Rand 
{
public:
	
	Rand(const Rand&) = delete;     	 	// No copying!
	Rand& operator=(const Rand&) = delete;  // (ibid)
	~Rand() = delete;
	// All that to insure that Rand object cannot be replicated or destroyed.
	// If I was using older standard (before C++11),
	// then all the above would have to be made private.
				      		
	static Rand * Instance();
	double drand();  /* (0,1] */
	double drand0(); /* [0,1] */
	
private: 
	static Rand * theInstance_;
	
	Rand(unsigned int=1);  // This constructor is private! 
	// All that to insure that Rand object is created only once.

};


#endif /*RAND_H_*/

