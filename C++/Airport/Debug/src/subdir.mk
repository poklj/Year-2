################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
../src/Delay.cpp \
../src/Delay2.cpp \
../src/Dispatcher.cpp \
../src/Plane.cpp \
../src/PlaneGen.cpp \
../src/PlaneQueue.cpp \
../src/Queue.cpp \
../src/Rand.cpp \
../src/Runway.cpp \
../src/Stat.cpp \
../src/Stats.cpp \
../src/Timer.cpp 

OBJS += \
./src/Delay.o \
./src/Delay2.o \
./src/Dispatcher.o \
./src/Plane.o \
./src/PlaneGen.o \
./src/PlaneQueue.o \
./src/Queue.o \
./src/Rand.o \
./src/Runway.o \
./src/Stat.o \
./src/Stats.o \
./src/Timer.o 

CPP_DEPS += \
./src/Delay.d \
./src/Delay2.d \
./src/Dispatcher.d \
./src/Plane.d \
./src/PlaneGen.d \
./src/PlaneQueue.d \
./src/Queue.d \
./src/Rand.d \
./src/Runway.d \
./src/Stat.d \
./src/Stats.d \
./src/Timer.d 


# Each subdirectory must supply rules for building sources it contributes
src/%.o: ../src/%.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


