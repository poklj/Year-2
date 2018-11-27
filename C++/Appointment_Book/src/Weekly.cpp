/*
 * Weekly.cpp
 *
 *  Created on: Nov 6, 2018
 *      Author: zach
 */

#include "Weekly.h"
#include "ApptType.h"

namespace {
   Appointment * mCreate()
   {
        return new Weekly{};
   }

   const bool reg=Factory<Appointment,ApptType>::Instance()->Register(WEEKLY, mCreate);
}


Weekly::Weekly() {
	// TODO Auto-generated constructor stub

}

Weekly::~Weekly() {
	// TODO Auto-generated destructor stub
}

bool Weekly::chkOccurance(Date& Querydate){
	bool Occurs = false;
		Occurs = (0 == (this->getDate() - Querydate) % period);
	return Occurs;
}

