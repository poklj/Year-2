/*
 * CreateAppointment.h
 *
 *  Created on: Nov 22, 2018
 *      Author: zach
 */

#ifndef SRC_CREATEAPPOINTMENT_H_
#define SRC_CREATEAPPOINTMENT_H_

#include <string>
#include <iostream>
#include "ManyMenus/Menu5/Runnable.h"
#include "ApptType.h"
#include "AppointmentBook.h"
#include "Appointment.h"
#include "DefineAppointment.h"
namespace CLI {
	class CreateAppointment : public Runnable {
	public:
		CreateAppointment(ApptType, AppointmentBook*);
		virtual ~CreateAppointment();
		void operator() ();

	private:
		ApptType type_;
		AppointmentBook* book_;
		DefineAppointment dA_;
};

} /* namespace CLI */

#endif /* SRC_CREATEAPPOINTMENT_H_ */
