/*
 * Plane.h
 *
 *  Created on: Sep 13, 2018
 *      Author: zach
 */

#ifndef PLANE_H_
#define PLANE_H_

class Plane {
public:
	Plane();
	virtual ~Plane();
	int get_serial () const;

private:
	static int number_source_;
	int serial_no_;
};

#endif /* PLANE_H_ */
