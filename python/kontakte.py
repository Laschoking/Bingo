class Kontakte:
	def  __init__(self, name, birth, phone, mail):
		self.info= [name,birth,phone,mail]
			
	def __str__(self):
		return str(self.info)
	
	def newMail(self):
		inputMail= input("Neue Mail:\n")
		self.mail=inputMail
				
def main():
	myContacts=[
		Kontakte("Fred", "05.02.1997","021344","fre@d.de"),
		Kontakte("Hans"," 5.5.1955"," 12345123324","hansi@cacoa.de")
	]
	#myContacts[] andere möglichkeit
	#Fred=Kontakte("...")
	#myContacts.append(Fred)
	#print(Fred.info)
	#print(Hans.info)
	
	for i in myContacts: #durchlauf von myContacts
		print(i)
main()
