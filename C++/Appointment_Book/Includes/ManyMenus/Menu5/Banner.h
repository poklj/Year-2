/*
 * Banner.h
 *
 *  Created on: 29-Oct-2008
 *      Author: piotr
 */

#ifndef BANNER_H_
#define BANNER_H_

#include <cstdlib>
#include <string>
#include "Runnable.h"

using namespace std;

class Banner: public Runnable {
public:
	Banner(string = "Hello");
	virtual ~Banner();
	void operator() () { string s("banner "+what_);  system( s.c_str() ); }
private:
	string what_;
};

#endif /* BANNER_H_ */
