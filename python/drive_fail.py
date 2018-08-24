#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @author PDT

import ev3dev.ev3 as ev3
from time import sleep
import odometry_new
from math import sqrt, pi , degrees

########################### global variables ##################################

current_position_mm = (0, 0)
current_position_gatter = (0, 0)
current_rotation = 0
start_position = current_position_mm
start_rotation = current_rotation
blocked = 1
weight = 0

counter_odometry = 0

red_value = [169, 64, 19]
blue_value = [43, 136, 75]
white_value = [252, 420, 174]
black_value = [39, 52, 20]

motor_right = ev3.LargeMotor('outC') # set port
motor_left = ev3.LargeMotor('outB') # set port
motor_left.stop_action = 'brake'
motor_right.stop_action = 'brake'
light_sensor = ev3.ColorSensor()
light_sensor.mode = 'RGB-RAW'
touch_sensor = ev3.TouchSensor()

offset = 150
standart_distance = 70
right_angle_degrees = 173
miss_tries = 0

############################### definitions ###################################

# haupt 'Follow the Line' Methode
def drive():
    global offset, miss_tries
    global current_position_mm, current_rotation
    global start_position
    global counter_odometry
    global current_position_gatter
    blocked = 1

    correction_proportional = 16 #8
    correction_integral = 0.05 #0.003
    correction_derivate = 0.1 # 0.025
    speed = 30 #17

    integral = 0
    last_error = 0
    derivate = 0
    motorReset()
    motorInit()
    odometry_new.print_finish_value()
    odometry_new.reset_angle(current_rotation)

    motor_left.duty_cycle_sp = speed
    motor_right.duty_cycle_sp = speed

    while miss_tries < 10000 and getNode() == False:
        # geht mit einem evtl Hindernis um
        if handleObstacle():
            return
        # berechnung der Graustufe und des PID
        light_value = light_sensor.bin_data("hhh")
        light_value = light_value[0] + light_value[1] + light_value[2]
        light_value = light_value / 3
        error = light_value - offset
        integral = integral + error
        derivate = error - last_error
        turn = correction_proportional * error + correction_integral * integral + correction_derivate * derivate
        turn = turn / 100
        turn = round(turn, 0)
        turn = int(turn)
        motorSetSpeed(speed - turn, speed + turn)
        last_error = error

        # Odometrie
        if (counter_odometry > 10):
            odometry_return = odometry_new.update(motor_left.position, motor_right.position)
            current_position_mm = odometry_return[0]
            current_position_gatter = odometry_return[1]
            current_rotation = round((odometry_return[2] * 2 / pi), 0)
            motorPosReset()
            counter_odometry = 0
        counter_odometry += 1
    # bewegt den Roboter AUF den Knoten
    goToNode()

    current_rotation = int(current_rotation)
    # alle Attribute der Motoren werden zurückgesetzt
    # Motoren stoppen
    motorReset()
    return

# bewegt den Roboter AUF den Knoten
def goToNode():
    global standart_distance
    motorReset()
    motor_left.run_to_rel_pos(position_sp = standart_distance, speed_sp = 80)
    motor_right.run_to_rel_pos(position_sp = standart_distance, speed_sp = 80)
    while(motor_left.position < standart_distance):
        continue
    return

# Scannt die an einem Knoten verfügbaren Pfade
def scanNode():
    global rotation_degrees
    global current_rotation
    node_data = []
    motorPosReset()
    ev3.Sound.beep()
    motor_left.run_to_rel_pos(position_sp = 4 * right_angle_degrees, speed_sp=60)
    motor_right.run_to_rel_pos(position_sp = -(4 * right_angle_degrees), speed_sp=60)
    while(motor_left.position <= 4 * right_angle_degrees):
        if(getPath()):
            if motor_left.position in range(right_angle_degrees - 45,
                                            right_angle_degrees + 45):
                if((current_rotation + 1) % 4) not in node_data:
                    node_data = node_data + [int((current_rotation + 1) % 4)]
            if motor_left.position in range( 2 * right_angle_degrees - 4,
                                            2 * right_angle_degrees + 45):
                if((current_rotation + 2) % 4) not in node_data:
                    node_data = node_data + [int((current_rotation + 2) % 4)]
            if motor_left.position in range( 3 * right_angle_degrees - 45,
                                            3 * right_angle_degrees + 45):
                if((current_rotation + 3) % 4) not in node_data:
                    node_data = node_data + [int((current_rotation + 3) % 4)]
            if motor_left.position in range( 4 * right_angle_degrees - 45,
                                            4 * right_angle_degrees + 45):
                if((current_rotation + 4) % 4) not in node_data:
                    node_data = node_data + [int((current_rotation + 4) % 4)]
            if motor_left.position in range(-45, 45):
                if((current_rotation + 4) % 4) not in node_data:
                    node_data = node_data + [int((current_rotation + 4) % 4)]
    print(node_data)
    return node_data

# 'Reaktionsmethode' für Hindernisse
def handleObstacle():
    global weight, blocked
    global touch_sensor
    global right_angle_degrees
    global motor_left, motor_right
    if touch_sensor.value() == 1:
        motorStop()
        blocked = -1
        weight = -1
        ev3.Sound.speak('Obstacle! Go Back to the last Checkpoint.')
        sleep(5)
        motorPosReset()
        motor_left.run_to_rel_pos(position_sp = -110, speed_sp = 80)
        motor_right.run_to_rel_pos(position_sp = -110, speed_sp = 80)
        sleep(5)
        motorPosReset()
        motor_left.run_to_rel_pos(position_sp = 2 * right_angle_degrees, speed_sp = 80)
        motor_right.run_to_rel_pos(position_sp = -2 * right_angle_degrees, speed_sp = 80)
        sleep(5)
        drive()
        return True
    return False

# helper
def motorReset():
    motor_left.reset()
    motor_right.reset()
    motorPosReset()
    return

#helper
def motorPosReset():
    motor_left.position = 0
    motor_right.position = 0
    return

# helper
def motorInit():
    global motor_left, motor_right
    motor_left.command = 'run-direct'
    motor_right.command = 'run-direct'
    return

# helper
def motorStop():
    global motor_left, motor_right
    motor_left.stop()
    motor_right.stop()
    return

# helper
def motorSetSpeed(left, right):
    try:
        motor_left.duty_cycle_sp = left
        motor_right.duty_cycle_sp = right
    except:
        miss_tries += 1
        print('left: ' + str(left) + ' right: ' + str(right) + 'invalid speed')
    return

# Prüft ob der Roboter einen Knoten erreicht hat
def getNode():
    global red_value, blue_value
    light_data = light_sensor.bin_data("hhh")
    if(light_data[0] in range(red_value[0] - 30, red_value[0] + 30)
        and light_data[1] in range(red_value[1] - 30, red_value[1] + 30)
        and light_data[2] in range(red_value[2] - 30, red_value[2] + 30)):
        ev3.Sound.speak('Checkpoint!')
        print('RED')
        odometry_new.print_finish_value()
        odometry_new.reset_angle(current_rotation)
        odometry_new.reset_position(current_position_gatter) #todo einfuegen nach communication
        return True
    elif(light_data[0] in range(blue_value[0] - 30, blue_value[0] + 30)
        and light_data[1] in range(blue_value[1] - 30, blue_value[1] + 30)
        and light_data[2] in range(blue_value[2] - 30, blue_value[2] + 30)):
        ev3.Sound.speak('Checkpoint!')
        odometry_new.print_finish_value()
        odometry_new.reset_angle(current_rotation)
        odometry_new.reset_position(current_position_gatter)

        print('BLUE')
        return True
    return False

# helper für scanNode
# prüft ob ein Weg unter dem Lichtsensor ist
def getPath():
    global black_value
    light_data = light_sensor.bin_data("hhh")

    if(light_data[0] in range(black_value[0] - 30, black_value[0] + 55)
        and light_data[1] in range(black_value[1] - 30, blue_value[1] + 55)
        and light_data[2] in range(blue_value[2] - 30, black_value[2] + 55)):
        return True
    return False


# Config Methode für den Lichtsensor
def lightConfigure():
    global white_value, black_value, red_value, green_value
    print('please place the robot on a red field')
    while(touch_sensor.value() == 0):
        continue
    red_value = light_sensor.bin_data("hhh")
    sleep(1)
    print('red: ' + str(red_value))
    print('please place the robot on a blue field')
    while(touch_sensor.value() == 0):
        continue
    green_value = light_sensor.bin_data("hhh")
    sleep(1)
    print('blue: ' + str(green_value))
    print('please place the robot on white')
    while(touch_sensor.value() == 0):
        continue
    white_value = light_sensor.bin_data("hhh")
    sleep(1)
    print('white: {}'.format(white_value))
    print('please place the robot on a black line')
    while(touch_sensor.value() == 0):
        continue
    black_value = light_sensor.bin_data("hhh")
    print('black: ' + str(black_value))
    print('configuration completed')
    input('press enter to start the exploration!')
    return

def getPosition():
    global current_position_gatter
    return (current_position_gatter[0], current_position_gatter[1])

# dreht den Robter in die Richtung relativ zur alten Position
def turn(supposed_rotation):
    global current_rotation
    global right_angle_degrees
    global motor_left, motor_right
    rot_value = sqrt((current_rotation - supposed_rotation)**2) * right_angle_degrees
    motorPosReset()
    current_rotation = supposed_rotation
    odometry_new.reset_angle(current_rotation * pi / 2) #set angle in odometry to actual turning angle

    print(motor_left.position, motor_right.position, rot_value)
    motor_left.run_to_rel_pos(position_sp = rot_value, speed_sp = 150)
    motor_right.run_to_rel_pos(position_sp = -rot_value, speed_sp = 150)
    return
