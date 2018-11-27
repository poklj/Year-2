/*
 * CreateAppointment.cpp
 *
 *  Created on: Nov 22, 2018
 *      Author: zach
 */

#include "CreateAppointment.h"

namespace CLI {

CreateAppointment::CreateAppointment(ApptType type, AppointmentBook* apb): type_(type), book_(apb), dA_{nullptr}
{}
CreateAppointment::~CreateAppointment() {
}

void CreateAppointment::operator() (){
	Appointment* a;
	a = this->book_->createAppointment(type_);
	dA_ = *(new CLI::DefineAppointment(a));
	dA_();
}

} /* namespace CLI */
