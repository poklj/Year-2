/*
 * Single.h
 *
 *  Created on: Nov 15, 2018
 *      Author: zach
 */

#ifndef SRC_SINGLE_H_
#define SRC_SINGLE_H_

#include "Appointment.h"
#include "ApptType.h"


class Single: public Appointment {
public:
	Single();
	virtual ~Single();

	bool chkOccurance(Date&);
private:
	std::string type = "Single";
};

#endif /* SRC_SINGLE_H_ */
