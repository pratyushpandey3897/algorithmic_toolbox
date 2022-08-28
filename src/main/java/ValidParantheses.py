class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        for i in s:
            if i =='(' or i== '{' or i == '[':
                stack.append(i)
            elif len(stack)>0:
                element = stack.pop()
                if element == '(' and i != ')':
                    return False
                elif element == '{' and i != '}':
                    return False
                elif element == '[' and i!= ']':
                    return False
                
            else:
                return False
            
        if len(stack) == 0:
            return True
        else:
            return False
                
                
