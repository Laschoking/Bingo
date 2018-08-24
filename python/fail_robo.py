#!/usr/                                                           bin/env python
# -*- coding: utf-8 -*-
# @author Hans Hanson

from math import pi, sin, cos

############################# global variables ##############################

current_position_mm = (0, 0)
current_position_gatter = (0, 0) #in 500 mm * 500 mm
range_wheel = pi * 56  # in mm
total_driven_distance = 0
distance_btw_wheels = 150
original_angle = 1 * pi / 2  #radians
factor = 1

'''http://www.informatik.uni-leipzig.de/~pantec/khepera/diffeq/ fuer ueberpruefung der Formeln'''
#winkel ändert nicht beim turn()
#print winkel
#keinkorrektes zusammenspiel von einzelnen positionen (vorherige pos werden nich verwertet

# Hauptodometrie methode wird in der drive aufgerufen
def update(motor_left_ticks, motor_right_ticks):
    global current_position_mm
    global current_position_gatter
    global range_wheel
    global total_driven_distance
    global distance_btw_wheels
    global original_angle

    distance_per_wheel = [
        (motor_left_ticks * range_wheel * factor / 360),
        (motor_right_ticks * range_wheel * factor / 360)]

    actual_angle = ((distance_per_wheel[1] - distance_per_wheel[0]) / distance_btw_wheels)
    driven_distance = (distance_per_wheel[0] + distance_per_wheel[1]) / 2

    if (motor_left_ticks == motor_right_ticks):  # original winkel
        x_diff = distance_per_wheel[1] * cos(original_angle)  # abweichung
        y_diff = distance_per_wheel[0] * sin(original_angle)
    else:
        x_diff = (driven_distance / actual_angle) * \
                 (cos((pi / 2) + original_angle - actual_angle)
                  + cos(original_angle - (pi / 2)))

        y_diff = (driven_distance / actual_angle) * \
                 (sin((pi / 2) + original_angle - actual_angle)
                  + sin(original_angle - (pi / 2)))

    total_driven_distance += driven_distance
    total_driven_distance = int(round(total_driven_distance, 4))

    if (original_angle + actual_angle) > (2 * pi):
        original_angle = (original_angle + actual_angle) % (2 * pi)
    else:
        original_angle = original_angle + actual_angle
    print("x " + str(x_diff))
    print("y " + str(y_diff))
    current_position_mm = (
        round((current_position_mm[0] + y_diff), 4),  #cast and round to gatter
        round((current_position_mm[1] + x_diff), 4))

    current_position_gatter =(
        int(round((current_position_mm[0] / 500), 0)),
        int(round((current_position_mm[1] / 500), 0)))

    total_driven_distance = round(total_driven_distance, 0)
    print("cur pos " + str(current_position_mm))
    return current_position_mm, current_position_gatter, original_angle

# print important data , befrore reset
def print_finish_value():
    global current_position_mm
    global current_position_gatter
    global total_driven_distance
    global original_angle

    total_driven_distance = round(total_driven_distance, 0)
    original_angle = round(original_angle, 0)
    print("aktuelle Position in mm" + str(current_position_mm))
    print("aktuelle Position im Raster" + str(current_position_gatter))
    print("zurückgelegte Distanz " + str(total_driven_distance))

# helper
def reset_angle(angle_from_mothership):     #reset angle after turn
    global total_driven_distance
    global original_angle
    original_angle = angle_from_mothership
    total_driven_distance = 0       #always reset distance

def reset_position(position_from_mothership_gatter):   #reset when getting contact to mothership(this is in gatter measure)
    global current_position_mm                     #todo tomorrow, tuesday
    global current_position_gatter
    global total_driven_distance

    total_driven_distance = 0
    current_position_gatter = position_from_mothership_gatter
    current_position_mm = (current_position_gatter[0] * 500,
                           current_position_gatter[1] * 500)
    print("pos mm " + str(current_position_mm))


