#!/bin/bash

if [ ! -d build ]
then
	mkdir build
	cd build
	cmake --GENERATOR = "Unix Makefiles" ..
else
	cd build
	cmake .
fi
