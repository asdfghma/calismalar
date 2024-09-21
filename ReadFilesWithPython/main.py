# Python reading files (.txt, .json, .csv)
import json
import csv

file_path = "C:/Users/bisol/Desktop/YENİ/Python/WriteFilesWithPython/output.csv"

try:
    with open(file_path, "r") as file:
        content = csv.reader(file)
        for line in content:
            print(line)
            #print(line[0])


        #content = json.load(file)
        #print(content)
        #print(content["name"])

        #content = file.read()
        #print(content)

except FileNotFoundError:
    print("That file was not found")
except PermissionError:
    print("You do not have permission to read that file")