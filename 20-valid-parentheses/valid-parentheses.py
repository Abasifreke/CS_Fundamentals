class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        pairs = {
            ')' : '(',
            '}' : '{',
            ']' : '['
        }

        for char in s:
            if char == '(' or char == '{' or char =='[':
                stack.append(char)
            else:
                if len(stack) == 0 or stack[-1] != pairs[char]:
                    return False
                stack.pop()
        return len(stack) == 0



        