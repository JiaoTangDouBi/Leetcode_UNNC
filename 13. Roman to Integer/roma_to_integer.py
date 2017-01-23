def roma_to_integer(string):
    mapping = {
        'I': 1,
        'V': 5,
        'X': 10,
        'L': 50,
        'C': 100,
        'D': 500,
        'M': 1000
    }
    result = 0
    for i in range(len(string)):
        val = mapping[string[i]]
        if i < len(string) - 1: 
            next_val = mapping[string[i+1]]
            if val < next_val:
                val = -val
        result += val
    return result


print(roma_to_integer('DCXXI'))