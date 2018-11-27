/*
 * AppointmentBook.h
 *
 *  Created on: Nov 5, 2018
 *      Author: zach
 *
 *      NOTE: Remember reinterpret_cast<>()
 */

#ifndef SRC_APPOINTMENTBOOK_H_
#define SRC_APPOINTMENTBOOK_H_

#include <FactoryC++11.h>
#include "Appointment.h"
#include <vector>
#include "ApptType.h"

class AppointmentBook {
public:
	AppointmentBook();
	virtual ~AppointmentBook();

	Appointment* createAppointment(ApptType);

	std::vector<Appointment*> findOnDate(Date);

private:
	// It requires and Can Contain
	Factory<Appointment, ApptType> * ABfactory{Factory<Appointment,ApptType>::Instance()};
	std::vector<Appointment*> Appointmentlist;
};


#endif /* SRC_APPOINTMENTBOOK_H_ */
