/*
 * DefineAppointment.h
 *
 *  Created on: Nov 22, 2018
 *      Author: zach
 */

#ifndef SRC_DEFINEAPPOINTMENT_H_
#define SRC_DEFINEAPPOINTMENT_H_

#include "ManyMenus/Menu5/Runnable.h"
#include "Appointment.h"
#include <iostream>
#include <regex>
namespace CLI {

class DefineAppointment : public Runnable {
public:
	DefineAppointment(Appointment*);
	virtual ~DefineAppointment();
	void operator() ();
	void defineDate();
	void defineTime();
	void defineLocation();
	void defineDescription();
private:
	Appointment* appt_;
};

} /* namespace CLI */

#endif /* SRC_DEFINEAPPOINTMENT_H_ */
