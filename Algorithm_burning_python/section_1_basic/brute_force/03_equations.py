A, B, C, D, E, F = map(int, input().split())

found = False
for x in range(-100, 101):
	if (found == True):
		break
	for y in range(-100, 101):
		if ((A * x) + (B * y) == C):
			if ((D * x) + (E * y) == F):
				print(x, y)
				found = True
				break



'''
1 3 -1 4 1 7
= 2 -1
'''
