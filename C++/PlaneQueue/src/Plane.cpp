/*
 * Plane.cpp
 *
 *  Created on: Sep 13, 2018
 *      Author: zach
 */

#include "Plane.h"

int Plane::number_source_{1000};

Plane::Plane() {
	Plane::serial_no_ = Plane::number_source_++;

}

Plane::~Plane() {
	// TODO Auto-generated destructor stub
}

int Plane::get_serial() const {

	return Plane::serial_no_;
}

