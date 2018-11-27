/*
 * Single.cpp
 *
 *  Created on: Nov 15, 2018
 *      Author: zach
 */

#include "Single.h"

namespace {
 	 Appointment * Create(){
 		 return new Single{};
 	 }

 	 const bool reg = Factory<Appointment, ApptType>::Instance()->Register(SINGLE, Create);
}

Single::Single() {
	// TODO Auto-generated constructor stub

}

Single::~Single() {
	// TODO Auto-generated destructor stub
}

bool Single::chkOccurance(Date& Querydate) {
	bool Occurs;
	Occurs = this->getDate() == Querydate;
	return Occurs;
}
/* namespace std */
