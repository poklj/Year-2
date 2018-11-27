/*
 * Stats.h
 *
 *  Created on: Sep 21, 2015
 *      Author: piotr
 */

#ifndef STATS_H_
#define STATS_H_

#include <cmath>

// Computes sum & average of a "bunch" of integers
// THIS IS AN EXTENDED VERSION computing also so-called biased standard deviation
// (not needed in the Airport 2015 assignment)

class Stats {
public:
	Stats();
	Stats(int [], int);
	virtual ~Stats();
	void add(int) ;
	void add(int [], int);
	int count() const { return cnt_; }
	double average() const;
	double sum() const;
	double stdDev() const;
private:
	int cnt_;
	double sum_;
	double ssq_;
};

#endif /* STATS_H_ */
