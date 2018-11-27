/*
 * QueryAppt.h
 *
 *  Created on: Nov 25, 2018
 *      Author: zach
 */

#ifndef SRC_QUERYAPPT_H_
#define SRC_QUERYAPPT_H_

#include "ManyMenus/Menu5/Runnable.h"
#include "AppointmentBook.h"
#include "Date.h"
#include <regex>
#include <iostream>
class QueryAppt : public Runnable {
public:
	QueryAppt(AppointmentBook*);
	virtual ~QueryAppt();
	void operator()();

private:
	AppointmentBook* apb_;
	Date queryUser_();
};

#endif /* SRC_QUERYAPPT_H_ */
