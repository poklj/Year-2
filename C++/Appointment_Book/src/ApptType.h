/*
 * apptType.h
 *
 *  Created on: Nov 7, 2018
 *      Author: zach
 */

#ifndef SRC_APPTTYPE_H_
#define SRC_APPTTYPE_H_


enum ApptType {
	SINGLE, DAILY, WEEKLY, ENUMEND
};

inline const char* ToString(ApptType a){

	switch(a){
	case SINGLE: return "SINGLE";
	case DAILY: return "DAILY";
	case WEEKLY: return "WEEKLY";
	case ENUMEND: return "ENUMEND";
	default: return "NULLAPPTTYPE";
	}
}


#endif /* SRC_APPTTYPE_H_ */
