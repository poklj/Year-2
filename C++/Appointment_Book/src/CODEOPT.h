/*
 * CODEOPT.h
 *
 *  Created on: Nov 15, 2018
 *      Author: zach
 */

#ifndef SRC_CODEOPT_H_
#define SRC_CODEOPT_H_

//PURE: use Pure virtual methods, making Appointment Abstract or Overridable
// 1 = Pure, 0 = Not Pure
#define PURE 1

#if PURE
	#define OPT_PURE = 0
	#define OPT_PUREREG nullptr
#else
	#define OPT_PURE
	#define OPT_PUREREG new Appointment{}
#endif


#endif /* SRC_CODEOPT_H_ */
