/*
 * Menus.h
 *
 *  Created on: Nov 22, 2018
 *      Author: zach
 */

#ifndef SRC_APPOINTMENTMENUS_H_
#define SRC_APPOINTMENTMENUS_H_

#include "ManyMenus/Menu5/Menu.h"
#include "ManyMenus/Menu5/Runnable.h"
#include "AppointmentBook.h"
#include "ApptType.h"
#include "CreateAppointment.h"
#include "QueryAppt.h"

namespace CLI {
class AppointmentMenus {
public:
	AppointmentMenus();
	virtual ~AppointmentMenus();
protected:
	Menu * mainM_{new Menu("Appointment Book")};
	Menu * createAppointment_{new Menu("Create Appointment")};



	AppointmentBook* apb{new AppointmentBook()};
};
}

#endif /* SRC_APPOINTMENTMENUS_H_ */
