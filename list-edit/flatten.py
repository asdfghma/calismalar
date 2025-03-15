def flatten(lst):
    result = []

    def flatten_helper(item):
        if isinstance(item, list):
            for sub_item in item:
                flatten_helper(sub_item)
        else:
            result.append(item)

    flatten_helper(lst)
    return result

test_list = [[1,'a',['cat'],2],[[[3]],'dog'],4,5]
print(flatten(test_list))