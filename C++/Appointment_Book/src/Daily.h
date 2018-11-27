/*
 * Daily.h
 *
 *  Created on: Nov 5, 2018
 *      Author: zach
 */

#ifndef SRC_DAILY_H_
#define SRC_DAILY_H_

#include "Appointment.h"
#include "ApptType.h"
class Daily : public Appointment {
public:
	Daily();
	virtual ~Daily();
	bool chkOccurance(Date&);
private:
	std::string type = "Daily";
	int period = 1;
};


#endif /* SRC_DAILY_H_ */
