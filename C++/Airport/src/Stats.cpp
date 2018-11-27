/*
 * Stats.cpp
 *
 *  Created on: Sep 21, 2015
 *      Author: piotr
 */

#include "Stats.h"

Stats::Stats()
:cnt_{0}, sum_{0}, ssq_{0}
{
	// sum_=0;
	// ... there is a better way, see above
}

// This non-default constructor is purposely weird...
Stats::Stats(int x[], int size)
:cnt_{size}, sum_{0}    // I use "{ }" instead of "( )" to initialize my data members.
						// This is C++11 "uniform" way to initialize anything (see main() )
{
	double xv{};
	while (size--) { 	  // "for" or "while"... still adding "size" values
		sum_+=(xv=*x++);  // Note that in expression *x++ the "++" is binding more strongly
	    ssq_+=xv*xv;	  // than "*"; anyway, we are advancing the pointer x, and when we
	}					  // are done the value of x become useless... BUT:
						  // as x is passed by value, this change/destruction does not
						  // affect the pointer in the calling context.
}

Stats::~Stats() {
	// TODO Auto-generated destructor stub
}

void Stats::add(int val) {
	cnt_++;
	sum_+=val;
	ssq_+=val*val;
}

// Very similar to the 3rd constructor....
void Stats::add(int x[], int size) {
	cnt_+=size;
	double xv{};
	while (size--) {
			sum_+=(xv=*x++);
			ssq_+=xv*xv;
	}
}

double Stats::average() const {
	return cnt_==0 ? 0 : static_cast<double>(sum_) / cnt_;

}

double Stats::stdDev() const{
	if ( cnt_ == 0 ) return 0;
	double ex {static_cast<double>(sum_) / (cnt_)};
	double ex2{static_cast<double>(ssq_) / (cnt_)};
	return sqrt(ex2 - ex*ex);
}

// And this could be (like the count() method) defined in-line:
double Stats::sum() const{
	return sum_;
}

