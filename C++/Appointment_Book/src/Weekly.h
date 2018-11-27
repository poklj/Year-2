/*
 * Weekly.h
 *
 *  Created on: Nov 6, 2018
 *      Author: zach
 */

#ifndef SRC_WEEKLY_H_
#define SRC_WEEKLY_H_

#include "Appointment.h"

class Weekly : public Appointment {
public:
	Weekly();
	virtual ~Weekly();

	bool chkOccurance(Date&);
private:
	std::string type = "Weekly";
	int period = 7;
};

/* namespace std */

#endif /* SRC_WEEKLY_H_ */
