/*
 * Delay2.h
 *
 *  Created on: Aug 19, 2017
 *      Author: piotr
 */

#ifndef CONTRIBUTED_DELAY2_H_
#define CONTRIBUTED_DELAY2_H_

#include <random>

class Delay2 {
public:
	Delay2(int = 1);
	virtual ~Delay2();
	int getDelay();
private:
	std::random_device rdevice_;
	std::mt19937 generator_;
	//std::linear_congruential_engine<std::uint_fast32_t, 48271, 0, 2147483647> generator_;
	int mean_;
	std::exponential_distribution<> expDist_;
};

#endif /* CONTRIBUTED_DELAY2_H_ */
