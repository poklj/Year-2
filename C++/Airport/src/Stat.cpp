/*
 * Project Airport: A sample solution using references.
 * by PWP 
 * The Stats computing class.
 */

#include "Stat.h"
#include <iostream>

Stat::Stat()
: cnt_{0}, total_{0.0}
{
}

Stat::~Stat()
{
}

void Stat::tally(int x)
{
	total_ += x;
	cnt_++;
} 

unsigned Stat::count() const
{
	return cnt_;
}
double Stat::average() const
{
	return cnt_?total_/cnt_:0;
}


