def get_length(string):
	return len(string)

def reverse(string):
	out=" "
	for char in reversed(string):
		out=out +char
	return out

	
def does_include(string,needle):
	return needle in string
