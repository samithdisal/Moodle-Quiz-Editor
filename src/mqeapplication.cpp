/*
    Moodle Quiz Editor - An offline editor with online features.
    Copyright (C) 2013  Samith Sandanayake sam.the.devel@gmail.com

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License along
    with this program; if not, write to the Free Software Foundation, Inc.,
    51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
*/


#include "mqeapplication.h"

// Let us declare the extern singleton global instance of MQEApplication
MQEApplication g_mqe;

MQEApplication::MQEApplication()
{

}

MQEApplication::~MQEApplication()
{

}

int MQEApplication::run(int* , char*** )
{
  return 0;
}

