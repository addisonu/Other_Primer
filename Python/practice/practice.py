#!/usr/local/bin/python3

def list_benefits():
    benefits = ["More organized code", "More readable code", "Easier code reuse", "Allowing programmers to share and connect code together"]
    return benefits

def build_sentence(benefit):
    benefit_sent = benefit + " is a benefit of functions!"
    return benefit_sent

def name_the_benefits_of_functions():
    list_of_benefits = list_benefits()
    for benefit in list_of_benefits:
        print (build_sentence(benefit))

name_the_benefits_of_functions()

class Vehicle:
    name = ""
    kind = "car"
    color = ""
    value = 100.00

# Define the Vehicle class

    def description(self):
        desc_str = "{:s} is a {:s} {:s} worth ${:.2f}.".format(self.name, self.color, self.kind, self.value)
        return desc_str

# My code
car1 = Vehicle()
car1.name = "Fer"
car1.kind = "Convertible"
car1.color = "red"
car1.value = 60000

car2 = Vehicle()
car2.name = "Jump"
car2.kind = "Van"
car2.color = "blue"
car2.value = 10000

# Test code
print(car1.description())
print(car2.description())
