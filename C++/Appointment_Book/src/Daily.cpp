/*
 * Daily.cpp
 *
 *  Created on: Nov 5, 2018
 *      Author: zach
 */

#include "Daily.h"


namespace {
   Appointment * mCreate()
   {
        return new Daily{};
   }

   const bool reg=Factory<Appointment,ApptType>::Instance()->Register(DAILY, mCreate);
}
Daily::Daily() {
	// TODO Auto-generated constructor stub

}

Daily::~Daily() {
	// TODO Auto-generated destructor stub
}

//Good lord I can just put this in the baseclass and just have a virtual integer
bool Daily::chkOccurance(Date& Querydate){
	bool Occurs = false;
		Occurs = (0 == (this->getDate() - Querydate) % period);
	return Occurs;
}


