/*
 * Runway.cpp
 *
 *  Created on: Sep 27, 2018
 *      Author: zach
 */

#include "Runway.h"

Runway::Runway(int D)
: clear_{true}, d_{new Delay(D)}, filledAt_{0}, delayBy_{0}
{
	// TODO Auto-generated constructor stub

}

Runway::~Runway() {
	// TODO Auto-generated destructor stub
}

void Runway::use(){
	clear_= false;
	filledAt_ = t.time();
	delayBy_ = d_->getDelay();
}

void Runway::doClear(){
	if(t.time() >= filledAt_ +delayBy_){
		clear_ = true;
	}
}


