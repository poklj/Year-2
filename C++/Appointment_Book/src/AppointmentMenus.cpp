/*
 * Menus.cpp
 *
 *  Created on: Nov 22, 2018
 *      Author: zach
 */

#include "AppointmentMenus.h"

namespace CLI{
	AppointmentMenus::AppointmentMenus() {

		this->mainM_->addItem("Add Appointment", this->createAppointment_);
		this->mainM_->addItem("Check Appointment", new QueryAppt(this->apb));
		for(int i = 0; i != ENUMEND; i++){
			ApptType aptT = static_cast<ApptType>(i);
			this->createAppointment_->addItem(ToString(aptT), new CreateAppointment(aptT, this->apb));
		}
		/*
		 * Start the first menu
		 */
		(*this->mainM_)();
	}

	AppointmentMenus::~AppointmentMenus() {
		delete this->mainM_;
		delete this->apb;
	}
}
