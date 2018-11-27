
#include "Date.h"
#include "Time.h"

/**
 * This is just a Feeler into Serializing object, Don't pay attention to this
 */
struct AppointmentSerObject{
	char type[40];
	Date date;
	Time time;
};

