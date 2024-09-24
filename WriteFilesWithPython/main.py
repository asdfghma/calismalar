# Python writing files (.txt, .json, .csv)
import json
import csv

# for txt employees = ["Eugene", "Squidward", "Spongebob", "Patrick"]

#employee = {
#   "name": "Spongebob",
#    "age": 30,
#    "job": "cook"
#}

employees = [["Name", "Age", "Job"],
             ["Spongebob", "30", "Cook"],
             ["Patrick", 37, "Unemployed"],
             ["Sandy", 27, "Scientist"]]

file_path = "output.csv"

try:
    with open(file_path, "w", newline="") as file:
        writer = csv.writer(file)
        for row in employees:
            writer.writerow(row)
        print(f"csv file '{file_path}' was created")

        #json.dump(employee, file, indent=4)
        #print(f"json file '{file_path}' was created")


       # for employee in employees:
            #file.write(employee + " ")
        #print(f"txt file '{file_path}' was created")


except FileExistsError:
    print("That file already exists!")