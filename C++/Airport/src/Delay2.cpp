/*
 * Delay2.cpp
 *
 *  Created on: Aug 19, 2017
 *      Author: piotr
 */

#include "Delay2.h"

#include <iostream>

Delay2::Delay2(int m)
: generator_{rdevice_()}, mean_{m>0?m:1}, expDist_{double(1.0/mean_)}
{}

Delay2::~Delay2() {
}

int Delay2::getDelay()
{
	double x{expDist_(generator_)};
	// std::cout << x << std::endl;
	return static_cast<int>(round(x));
}
