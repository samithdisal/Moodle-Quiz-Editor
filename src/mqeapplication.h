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


#ifndef MQEAPPLICATION_H
#define MQEAPPLICATION_H

/**
 * @brief MQE Main Application Class
 **/

class MQEApplication
{

public:
  
  /**
   * @brief Construct a new MQEApplication instance
   *
   **/
  MQEApplication();
  
  /**
   * @brief Destruct MQEApplication instance
   *
   **/
  virtual ~MQEApplication();
  
  
  /**
   * @brief Run MQE Application
   *
   * @param  argc Pointer to argc
   * @param  argv pointer to argv
   * @return int
   **/
  int run(int*, char***);
};


/**
 * @brief MQEApplication singleton global instance
 **/
extern MQEApplication g_mqe;

#endif // MQEAPPLICATION_H
