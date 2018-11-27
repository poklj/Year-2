/*
 * Queue.h
 *
 *  Created on: Sep 13, 2018
 *      Author: zach
 */

#ifndef QUEUE_H_
#define QUEUE_H_

class Plane;

class Queue final {
public:
	Queue();
	virtual ~Queue();
	Queue(const Queue&) = delete;
	Queue(Queue&&) = delete;
	Queue& operator=(const Queue&) = delete;
	Queue& operator=(Queue&&) = delete;

	bool enqueue(Plane *);
	Plane * dequeue();
	Plane * inspect() const;
	bool isEmpty() const { return cnt_ == 0; }
	bool isFull() const { return cnt_ == MAXSIZE;}

	bool operator<< (Plane * p) {
		return enqueue(p);
	}


private:
	static const int MAXSIZE { 6 };
	/* or more "classic:
	 enum { MAXSIZE = 20 };  */
	Plane * q_[MAXSIZE] {0}; // Allocate Queue Array, Initialize with cleared memory
// Or, better, an array to be allocated dynamically: Plane * * q_
// - although, if I were you, I would try the fixed-sized array first
	int tail_;
	int head_;
	int cnt_;   // ? do we need this ?`

};

#endif /* QUEUE_H_ */
