import time

def time_teller(func):
	
	def print_it():
		ourTime=func()
		return "Its is {date}.Since{hour} and minutes{minutes}".format(
				date=ourTime[0],
				hour=ourTime[1],
				minutes=ourTime[2]
			)
		
	return print_it
		
@time_teller		
def get_time():
	day=time.strftime("%Y/%m/%d")
	hour=time.strftime("%H")
	minute=time.strftime("%M")
	return (day,hour,minute)
     
     
print(get_time())
	#print(time.strftime("%Y/%m/%d %H:%M")
