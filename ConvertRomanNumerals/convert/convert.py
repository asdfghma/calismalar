def rome_to_int(roman):
    roman_to_int_map = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}
    total = 0 
    prev_value = 0


    for char in reversed(roman):
        value = roman_to_int_map[char]
        if value >= prev_value:
            total += value
        else:
            total -= value
        prev_value = value
    return total

def is_valid_roman(roman):
    roman_to_int_map = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}
    valid_chars = set(roman_to_int_map.keys())

    if not all(char in valid_chars for char in roman):
        return False
    
    valid_patterns = {'I', 'IV', 'V', 'IX', 'X', 'XL', 'L', 'XC', 'C', 'CD', 'D', 'CM', 'M'}


    i = 0
    while i < len(roman):
        if i + 1 < len(roman) and roman[i:i+2] in valid_patterns:
            i += 2
        elif roman[i] in valid_patterns:
            i += 1
        else:
            return False
        

    counts = {'I': 0, 'V': 0, 'X': 0, 'L': 0, 'C': 0, 'D': 0, 'M': 0}
    for char in roman:
        counts[char] += 1
        if counts['I'] > 3 or counts['V'] > 1 or counts['X'] > 3 or counts['L'] > 1 or counts['C'] > 3 or counts['D'] > 1 or counts['M'] > 3:
            return False
        
    return True

roman_numeral = input("Roma rakamını (1'den 4999'a kadar): ").upper()

if is_valid_roman(roman_numeral):
    try:
        result = rome_to_int(roman_numeral)
        if 1 <= result <= 4999:
            print(f"Roma rakamı {roman_numeral} sayısı: {result}")
        else:
            print("Girilen roman rakamı 1 ile 4999 arasında olmalıdır.")
    except KeyError:
        print("Geçersiz bir roma rakamı girdiniz.")
else:
    print("Geçersiz bir roma rakamı girdiniz.")
