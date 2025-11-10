Bank.class: Bank.java
	javac -g Bank.java

Admin.class: Admin.java User.class
	javac -g Admin.java

Customer.class: Customer.java User.class CheckingAccount.class SavingsAccount.class
	javac -g Customer.java

User.class: User.java HasMenu.class
	javac -g User.java

CheckingAccount.class: CheckingAccount.java HasMenu.class
	javac -g CheckingAccount.java

SavingsAccount.class: SavingsAccount.java CheckingAccount.class
	javac -g SavingsAccount.java

HasMenu.class: HasMenu.java
	javac -g HasMenu.java

testAdmin: Admin.class
	java Admin

testCustomer: Customer.class
	java Customer

testChecking: CheckingAccount.class
	java CheckingAccount

testSavings: SavingsAccount.class
	java SavingsAccount

simple-bld:
	make HasMenu.class
	make CheckingAccount.class
	make SavingsAccount.class
	make User.class
	make Customer.class
	make Admin.class
	make Bank.class

br:
	make simple-bld
	java Bank

clean:
	rm *.dat
	rm *.class

git-update:
	git add -A
	git commit -m main
	git push
