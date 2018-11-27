/*
 * Dispatcher.cpp
 *
 *  Created on: Oct 12, 2018
 *      Author: zach
 */

#include "Dispatcher.h"
#include <iostream>

Dispatcher::Dispatcher(Runway& r, Queue& l, Queue & t)
:r_{r}, L_{l}, T_{t}{

}

Dispatcher::~Dispatcher() {
	// TODO Auto-generated destructor stub
}

void Dispatcher::doit(){
	//TODO do the whole thing
	int LWait;
	int TWait;

	if(!r_.isClear()){
		r_.doClear();
		return;
	}
	Plane * hold;
	//Check the landing Wait
	hold = L_.inspect();
	if (hold != nullptr){
		LWait = hold->get_wait();
	} else {
		LWait = -1;
	}
	//Check takeoff Wait
	hold = T_.inspect();
	if (hold != nullptr){
		TWait = hold->get_wait();
	} else {
		TWait = -1;
	}

	Plane * hol;
	if(LWait >= TWait){
		hol = L_.dequeue();
		if(hol != nullptr){
			sL_->tally(hol->get_wait());
			r_.use();
		}
	} else if(LWait < TWait){
		hol = T_.dequeue();
		if(hol != nullptr){
			sT_->tally(hol->get_wait());
			r_.use();
		}
	} else if(LWait == -1 && TWait == -1){}

}

void Dispatcher::Stats(){
	cout << "Stats for run" << endl;

	cout << "Amount Handled from Landing: " << sL_->count() << endl;
	cout << "Amount Handled from Takeoff: " << sT_->count() << endl;

	cout << "Average Landing waiting time: " << sL_->average() << endl;
	cout << "Average Takeoff waiting time: " << sT_->average() << endl;
}
