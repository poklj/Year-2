/*
 * Random number generator producing double numbers
 * distributed uniformly over [0,1]
 * A singleton class.
 * Used in: PROG 2100 Assignment#2
 * by PWP 
 */

#include "Rand.h"

Rand * Rand::theInstance_ = NULL; 

Rand::Rand(unsigned int s)
{
	 srand(s);  // A part of rand() suite of routines generating
	 	    // pseudo-random numbers. 
		    // Use "man srand" to learn more... 
}


// A call to Instance() returns pointer to either the newly created or to 
// already existing Rand object. 
// Note that Instance is a static method and as such it can be called
// even when no instance of Rand exists... (but you will not use Rand directly)
// How to do it is demonstrated in Delay's constructor initalization list 
// The Delay class is the one you will use. 

Rand * Rand::Instance()
{
  if ( theInstance_ == NULL )
  	   //theInstance_ = new Rand(1);    
  	   theInstance_ = new Rand(time(0));  // Using system time as seed 
	   				      // make is "more" random
  	   return theInstance_; 
}

// A double random number x, 0 < x <= 1, is returned:
double Rand::drand()
{
	  return  (double(rand())+1.0)/(double(RAND_MAX)+1.0);
}

// A double random number x, 0 <= x <= 1, is returned:
double Rand::drand0()
{
	  return  double(rand())/double(RAND_MAX);
}
