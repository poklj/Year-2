/*
 * Queue.cpp
 *
 *  Created on: Sep 13, 2018
 *      Author: zach
 */

#include "Queue.h"
#include "Plane.h"
Queue::Queue() :
		tail_ { 0 }, head_ { 0 }, cnt_ { 0 } {
	//head is for Removal, Tail for adding
}

Queue::~Queue() {
	// TODO Auto-generated destructor stub
}

bool Queue::enqueue(Plane * p) {
	bool result = false;
	if (cnt_ == MAXSIZE) {
		return result;
	}
	if (tail_ == MAXSIZE) {
		tail_ = 0;
	}
	q_[tail_++] = p; // Add into queue, move index forward
	cnt_++;
	result = true;
	return result;
}
;

Plane * Queue::dequeue() { // Return Null pointer if unable to remove
	if (cnt_ != 0) {
		Plane * p = q_[head_];
		q_[head_++] = {0}; //Remove from head, move head forward
		if (head_ == MAXSIZE + 1){ // If head is out of range, move it back in before exiting.
			head_ = 0;
		}
		cnt_--;
		return p;
	} else {
		return nullptr;
	}
}
;

Plane * Queue::inspect() const {
	if (cnt_ != 0) {
		return q_[head_];
	} else {
		return nullptr;
	}
}
;

